package com.renren.ruolan.travelaround.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.convert.StringConvert;
import com.lzy.okrx.RxAdapter;
import com.renren.ruolan.travelaround.BaseActivity;
import com.renren.ruolan.travelaround.R;
import com.renren.ruolan.travelaround.adapter.CollectAdapter;
import com.renren.ruolan.travelaround.adapter.MyHistoryAdapter;
import com.renren.ruolan.travelaround.base.BaseViewHolder;
import com.renren.ruolan.travelaround.base.SimpleAdapter;
import com.renren.ruolan.travelaround.constant.HttpUrlPath;
import com.renren.ruolan.travelaround.entity.SearchHistory;
import com.renren.ruolan.travelaround.entity.SearchInfo;
import com.renren.ruolan.travelaround.entity.SearchInfo.ResultEntity.SearchListEntity;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BmobQueryResult;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SQLQueryListener;
import cn.bmob.v3.listener.SaveListener;
import rx.android.schedulers.AndroidSchedulers;

import static android.R.attr.data;
import static com.renren.ruolan.travelaround.R.id.et_search;
import static com.renren.ruolan.travelaround.R.id.view_offset_helper;


public class SearchActivity extends BaseActivity {

    private EditText mEtSearch;
    private ImageView mUserCenterOrderLeft;
    private TextView mTvTip;
    private TextView mTvClear;
    private RecyclerView mRecyclerViewSearch;
    private TextView mTvNone;
    private TagFlowLayout mIdFlowlayout;

    private RecyclerView mSearchResultRecyclerView;

    private String CityName;

    private List<SearchListEntity> mSearchListEntities = new ArrayList<>();
    private List<SearchHistory> serachHistorys = new ArrayList<>(); //搜索历史
    private MyHistoryAdapter mHistoryAdapter;




    @Override
    protected int getResultId() {
        return R.layout.activity_search;
    }

    @Override
    protected void initListener() {
        mEtSearch.setOnKeyListener((v, keyCode, event) -> {
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {// 修改回车键功能
                // 先隐藏键盘
                ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(
                        getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                // 按完搜索键后将当前查询的关键字保存起来,如果该关键字已经存在就不执行保存
                String trim = mEtSearch.getText().toString().trim();
                SearchHistory history = new SearchHistory();
                history.searchKey = trim;
                history.save(new SaveListener<String>() {
                    @Override
                    public void done(String s1, BmobException e) {


                    }
                });

                Intent intent = new Intent(SearchActivity.this,SearchResultActivity.class);
                intent.putExtra("key",trim);
                startActivity(intent);

            }
            return false;
        });

        mEtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().trim().length() == 0){
                    requestHistoryData();
                } else {
                }
            }
        });

        mTvClear.setOnClickListener(view -> {

        });
    }

    @Override
    public void initData() {
        super.initData();
        if (TextUtils.isEmpty(CityName))
            return;
        CityName = CityName.replace(getResources().getString(R.string.town),"");
        OkGo.post(HttpUrlPath.GET_SEARCH_KEY_INTO)
                .params("CityName", CityName)
                .params("Platform", 1)
                .getCall(StringConvert.create(), RxAdapter.<String>create())
                .doOnSubscribe(() -> {
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    Type type = new TypeToken<SearchInfo>() {
                    }.getType();
                    SearchInfo searchInfo = new Gson().fromJson(s, type);
                    mSearchListEntities = searchInfo.getResult().getSearchList();
                    if (mSearchListEntities.size() > 0 && mSearchListEntities != null) {

                        List<String> titles = new ArrayList<>();
                        for (SearchListEntity entity : mSearchListEntities) {
                            titles.add(entity.getKey());
                        }


                        mIdFlowlayout.setAdapter(new TagAdapter<String>(titles) {
                            @Override
                            public View getView(FlowLayout parent, int position, String title) {
                                TextView tv = (TextView) LayoutInflater.from(SearchActivity.this).inflate(R.layout.tv,
                                        mIdFlowlayout, false);
                                tv.setTextSize(16);
                                tv.setText(title);
                                return tv;
                            }
                        });

                        mIdFlowlayout.setOnTagClickListener((view, position, parent) -> {
                            String key = titles.get(position);
                            Intent intent = new Intent(SearchActivity.this,SearchResultActivity.class);
                            intent.putExtra("key",key);
                            startActivity(intent);
                            return true;
                        });

                    }
                }, throwable -> {
                });

        requestHistoryData();


    }

    /**
     * 请求历史数据
     */
    private void requestHistoryData() {
        String searchHistory = "select * from SearchHistory";
        new BmobQuery<SearchHistory>().doSQLQuery(searchHistory, new SQLQueryListener<SearchHistory>() {
            @Override
            public void done(BmobQueryResult<SearchHistory> bmobQueryResult, BmobException e) {
                if (e == null) {
                    List<SearchHistory> list = bmobQueryResult.getResults();
                    if (list != null && list.size() > 0) {
                        serachHistorys.clear();
                        for (SearchHistory history : list) {
                            serachHistorys.add(history);
                            mTvNone.setVisibility(View.GONE);
                            mHistoryAdapter.setSearchHistories(serachHistorys);
                        }
                    }
                }
            }
        });
    }

    @Override
    public void initView() {

        CityName = getIntent().getStringExtra("CityName");

        mEtSearch = (EditText) findViewById(et_search);
        mUserCenterOrderLeft = (ImageView) findViewById(R.id.user_center_order_left);
        mTvTip = (TextView) findViewById(R.id.tv_tip);
        mTvClear = (TextView) findViewById(R.id.tv_clear);
        mRecyclerViewSearch = (RecyclerView) findViewById(R.id.recycler_view_search);
        mRecyclerViewSearch.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerViewSearch.setItemAnimator(new DefaultItemAnimator());
        mHistoryAdapter = new MyHistoryAdapter();
        mRecyclerViewSearch.setAdapter(mHistoryAdapter);
        mHistoryAdapter.setOnItemClick((view, position,data) -> {
            String key = data.searchKey;
            Intent intent = new Intent(SearchActivity.this,SearchResultActivity.class);
            intent.putExtra("key",key);
            startActivity(intent);
        });

        mTvNone = (TextView) findViewById(R.id.tv_none);
        mIdFlowlayout = (TagFlowLayout) findViewById(R.id.id_flowlayout);

        //mSearchResultRecyclerView = (RecyclerView) findViewById(R.id.search_result_recycler_view);

    }



}
