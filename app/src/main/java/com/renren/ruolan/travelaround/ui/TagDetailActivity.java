package com.renren.ruolan.travelaround.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.renren.ruolan.travelaround.BaseActivity;
import com.renren.ruolan.travelaround.R;
import com.renren.ruolan.travelaround.adapter.TagDetailAdapter;
import com.renren.ruolan.travelaround.constant.Contants;
import com.renren.ruolan.travelaround.constant.HttpUrlPath;
import com.renren.ruolan.travelaround.entity.TagData;
import com.renren.ruolan.travelaround.entity.TagData.ResultEntity.ProductListEntity;
import com.renren.ruolan.travelaround.widget.dialog.CustomPrograss;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

public class TagDetailActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener {

    private RelativeLayout mActivityTag;
    private TextView mTvTitle;
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mRefreshLayout;

    private String CityName;
    private String ProvinceID;
    private String ClassID;
    private String title;

    private int CurrentPage = 1;
    private int totalPage;

    private List<ProductListEntity> mTagDatas = new ArrayList<>();
    private LinearLayoutManager mLayoutManager;
    private TagDetailAdapter mDetailAdapter;


    @Override
    protected int getResultId() {
        return R.layout.activity_tag_detail;
    }

    @Override
    protected void initListener() {

    }

    @Override
    public void initData() {
        super.initData();

        refreshData();
    }

    @Override
    public void initView() {

        ClassID = getIntent().getStringExtra("ClassID");
        ProvinceID = getIntent().getStringExtra("ProvinceID");
        CityName = getIntent().getStringExtra("CityName");
        title = getIntent().getStringExtra("title");

        mRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        mRefreshLayout.setColorSchemeColors(Color.YELLOW, Color.RED, Color.BLUE, Color.GREEN);
        //能够模拟进入就刷新
       // mRefreshLayout.post(() -> mRefreshLayout.setRefreshing(true));
        mRefreshLayout.setOnRefreshListener(this);
        mTvTitle = (TextView) findViewById(R.id.tv_title);
        if (!TextUtils.isEmpty(title)){
            mTvTitle.setText(title);
        }
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mDetailAdapter = new TagDetailAdapter(this, mTagDatas);
        mDetailAdapter.setOnItemClickListener((view, position) -> {
            String Platform = "1";
            String ProductID = mTagDatas.get(position).getProductID();
            Intent intent = new Intent(TagDetailActivity.this, ProductDetailActivity.class);
            intent.putExtra(Contants.PLATFORM,Platform);
            intent.putExtra(Contants.PRODUCT_ID,ProductID);
            intent.putExtra(Contants.CITY_NAME,CityName);
            startActivity(intent);
        });
        mRecyclerView.setAdapter(mDetailAdapter);
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                int lastVisiableItemPosition = mLayoutManager.findLastVisibleItemPosition();
                if (lastVisiableItemPosition + 1 == mDetailAdapter.getItemCount()) {
                    CustomPrograss.show(TagDetailActivity.this,
                            getResources().getString(R.string.loading),
                            false, null);
                    new Handler().postDelayed(() -> getLoadMoreData(), 1500);
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });



    }

    private void getLoadMoreData() {
        CurrentPage++;
        if (CurrentPage >totalPage){
            Toast.makeText(this, getResources()
                    .getString(R.string.loading_finish),
                    Toast.LENGTH_SHORT).show();
            return;
        }
        OkGo.post(HttpUrlPath.GET_TAG_DETAIL_INFO)
                .params("Platform", "1")
                .params("CurrentPage", CurrentPage)
                .params("CityName", CityName)
                .params("ProvinceID", ProvinceID)
                .params("ClassID", ClassID)
                .execute(new StringCallback(){

                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Type type = new TypeToken<TagData>() {
                        }.getType();
                        TagData tagData = new Gson().fromJson(s, type);
                        List<ProductListEntity> productList = tagData.getResult().getProductList();
                        CustomPrograss.disMiss();
                        if (productList.size() > 0 && productList != null) {
                            //mRefreshLayout.setRefreshing(false);


                            // totalPage = tagData.getResult().getTotalPage();
                            mTagDatas.addAll(productList);
                            mDetailAdapter.setDatas(mTagDatas);
                        }
                    }
                });

    }


    @Override
    public void onRefresh() {
        refreshData();
    }

    private void refreshData() {
        mTagDatas.clear();
        CurrentPage = 1;
        OkGo.post(HttpUrlPath.GET_TAG_DETAIL_INFO)
                .params("Platform", "1")
                .params("CurrentPage", CurrentPage)
                .params("CityName", CityName)
                .params("ProvinceID", ProvinceID)
                .params("ClassID", ClassID)
                .execute(new StringCallback(){

                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Type type = new TypeToken<TagData>() {
                        }.getType();
                        TagData tagData = new Gson().fromJson(s, type);
                        mTagDatas = tagData.getResult().getProductList();
                        if (mTagDatas.size() > 0 && mTagDatas != null) {
                            mRefreshLayout.setRefreshing(false);
                            totalPage = tagData.getResult().getTotalPage();
                            mDetailAdapter.setDatas(mTagDatas);
                        }
                    }
                });

    }
}
