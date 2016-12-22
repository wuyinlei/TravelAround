package com.renren.ruolan.travelaround.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.convert.StringConvert;
import com.lzy.okrx.RxAdapter;
import com.renren.ruolan.travelaround.BaseActivity;
import com.renren.ruolan.travelaround.R;
import com.renren.ruolan.travelaround.adapter.ProductCmtAdapter;
import com.renren.ruolan.travelaround.adapter.ProductCmtDetailAdapter;
import com.renren.ruolan.travelaround.constant.Contants;
import com.renren.ruolan.travelaround.constant.HttpUrlPath;
import com.renren.ruolan.travelaround.entity.CmtInfo;
import com.renren.ruolan.travelaround.entity.DetailBean;
import com.renren.ruolan.travelaround.entity.MyUser;
import com.renren.ruolan.travelaround.entity.ProductCmtData;
import com.renren.ruolan.travelaround.entity.ProductCmtData.ResultEntity.CommentListEntity;
import com.renren.ruolan.travelaround.widget.MyEditText;
import com.renren.ruolan.travelaround.widget.dialog.BottomDialog;
import com.renren.ruolan.travelaround.widget.dialog.EditTextDialog;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import cn.bmob.v3.BmobBatch;
import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BatchResult;
import cn.bmob.v3.datatype.BmobQueryResult;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListListener;
import cn.bmob.v3.listener.SQLQueryListener;
import cn.bmob.v3.listener.SaveListener;
import okhttp3.Call;
import okhttp3.Response;
import rx.android.schedulers.AndroidSchedulers;

import static android.R.attr.format;
import static com.baidu.location.b.g.e;
import static com.baidu.location.b.g.f;
import static com.baidu.location.b.g.v;


public class ProductCmtActivity extends BaseActivity implements View.OnClickListener {

    private LinearLayout mActivityProductCmt;
    private ImageView mImgBack;
    private RecyclerView mRecyclerView;

    private String Platform, ProductID, CityName;
    private int currentPage = 1;
    List<BmobObject> cmts = new ArrayList<>();

    private RelativeLayout mReAddComment;

    private List<CmtInfo> mCmtInfos = new ArrayList<>();
    private List<CommentListEntity> mCommentListEntities = new ArrayList<>();
    private ProductCmtDetailAdapter mCmtDetailAdapter;
    private BottomDialog mBottomDialog;

    @Override
    protected int getResultId() {
        return R.layout.activity_product_cmt;
    }

    @Override
    protected void initListener() {
        mReAddComment.setOnClickListener(this);
    }

    private boolean isHasData = false;
    private MyUser mMyUser;

    @Override
    public void initData() {
        super.initData();


        requestCmt();


        OkGo.post(HttpUrlPath.GET_CMT_INFO)
                .params("Platform", Platform)
                .params("ProductID", ProductID)
                .params("CityName", CityName)
                .params("currentPage", currentPage)
                .execute(new StringCallback() {

                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Type type = new TypeToken<ProductCmtData>() {
                        }.getType();
                        try {
                            ProductCmtData data = new Gson().fromJson(s, type);
                            mCommentListEntities = data.getResult().getCommentList();
                            if (mCommentListEntities != null && mCommentListEntities.size() > 0) {
                                for (CommentListEntity entity : mCommentListEntities) {
                                    CmtInfo cmtInfo = new CmtInfo(entity.getCommentID()
                                            , entity.getUserImage(),
                                            entity.getContent(),
                                            entity.getCommentDate(), ProductID);
                                    //mCmtInfos.add(cmtInfo);
                                    cmts.add(cmtInfo);
                                }

                                if (!isHasData) {
                                    mCmtDetailAdapter.setDatas(mCmtInfos);
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }


                        //插入数据
                        new BmobBatch().insertBatch(cmts).doBatch(new QueryListListener<BatchResult>() {
                            @Override
                            public void done(List<BatchResult> list, BmobException e) {
                                if (e == null) {
                                    for (int i = 0; i < list.size(); i++) {
                                        //可以查看哪个添加失败
                                        // mCmtInfos = list;
                                    }
                                }
                            }
                        });

                    }
                });

    }


    private void requestCmt() {
        String bql = "select * from CmtInfo where productID = ?"; //查询所有评论记录
        new BmobQuery<CmtInfo>().doSQLQuery(bql,
                new SQLQueryListener<CmtInfo>() {
                    @Override
                    public void done(BmobQueryResult<CmtInfo> bmobQueryResult, BmobException e) {
                        if (e == null) {
                            List<CmtInfo> results = bmobQueryResult.getResults();
                            if (results == null) { //首次查询，数据库中肯定没有数据，要显示接口中的数据
                                // mProductCmtAdapter.setDatas(mCmtListEntities);
                            } else if (results != null && results.size() > 0) {
                                //虽然很影响性能，，，，，但是别无他法，虽让我们没有后台数据
                                isHasData = true;
                                mCmtInfos.clear();
                                mCmtInfos = results;
                                mCmtDetailAdapter.setDatas(mCmtInfos);
                            }
                        }
                    }
                }, ProductID);
    }

    @Override
    public void initView() {

        mMyUser = BmobUser.getCurrentUser(MyUser.class);

        Platform = getIntent().getStringExtra(Contants.PLATFORM);
        ProductID = getIntent().getStringExtra(Contants.PRODUCT_ID);
        CityName = getIntent().getStringExtra(Contants.CITY_NAME);

        mImgBack = (ImageView) findViewById(R.id.img_back);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mCmtDetailAdapter = new ProductCmtDetailAdapter(this, mCmtInfos);
        mRecyclerView.setAdapter(mCmtDetailAdapter);
        mReAddComment = (RelativeLayout) findViewById(R.id.re_add_comment);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.re_add_comment:
                if (mMyUser != null) {
                    addComment(view);
                } else {
                    Toast.makeText(this, getResources()
                                    .getString(R.string.comment_login),
                            Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(ProductCmtActivity.this, LoginActivity.class));
                }
                break;
        }
    }

    /**
     * 添加评论
     *
     * @param view
     */
    private void addComment(View view) {
        mBottomDialog = BottomDialog.create(getSupportFragmentManager())
                .setViewListener(new BottomDialog.ViewListener() {
                    @Override
                    public void bindView(View v) {
                        initView(v);
                    }
                }).setLayoutRes(R.layout.dialog_edit_text)
                // .setViewListener(v1 -> ).setLayoutRes(R.layout.dialog_edit_text)
                .setDimAmount(0.5f)
                .setTag("BottomDialog");
        mBottomDialog.show();

    }
    

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (mBottomDialog != null) {
            if (event.getKeyCode() == KeyEvent.KEYCODE_BACK
                    && event.getAction() == KeyEvent.ACTION_DOWN) {  //有软键盘时: onBackPressed,onKeyDown都无效
                //do something.......
                if (mBottomDialog != null) {
                    mBottomDialog.dismiss();
                    mBottomDialog = null;
                }
                return true;
            }
        }
        return super.dispatchKeyEvent(event);
    }

    private TextView mBtnSend;
    private MyEditText mEditText;

    private void initView(View v) {
        mBtnSend = (TextView) v.findViewById(R.id.btn_reSend);
        mEditText = (MyEditText) v.findViewById(R.id.edit_text);
        mEditText.post(new Runnable() {
            @Override
            public void run() {
                InputMethodManager imm =
                        (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(mEditText, 0);
            }
        });


        mBtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = mEditText.getText().toString();
                if (!TextUtils.isEmpty(content)) {
                    //
                    Calendar c = Calendar.getInstance();
                    String hour = String.valueOf(c.get(Calendar.HOUR_OF_DAY));
                    String minute = String.valueOf(c.get(Calendar.MINUTE));
                    String second = String.valueOf(c.get(Calendar.SECOND));
                    String commentID = hour + minute + second;  //构造唯一标识
                    CmtInfo cmtInfo = new CmtInfo();
                    String imgurl = mMyUser.getImgurl();
                    String username = mMyUser.getUsername();
                    Date date = new Date();
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                    String time = format.format(date);
                    cmtInfo.setProductID(ProductID);
                    cmtInfo.setCommentDate(time);
                    cmtInfo.setCommentID(commentID);
                    cmtInfo.setContent(content);
                    cmtInfo.setUserImage(imgurl);
                    cmtInfo.setUserName(username);

                    cmtInfo.save(new SaveListener<String>() {
                        @Override
                        public void done(String s, BmobException e) {
                            if (e == null) {
                                mBottomDialog.dismiss();
                                Toast.makeText(ProductCmtActivity.this,
                                        getResources().getString(R.string.comment_success),
                                        Toast.LENGTH_SHORT).show();
                                // requestCmt();
                                mCmtInfos.add(mCmtInfos.size(), cmtInfo);
                                mCmtDetailAdapter.setDatas(mCmtInfos);
                                //mCmtDetailAdapter.notifyDataSetChanged();
                            }
                        }
                    });

                } else {
                    Toast.makeText(ProductCmtActivity.this, getResources()
                            .getString(R.string.comment_empty), Toast.LENGTH_SHORT).show();
                }
            }
        });
//        mBtnSend.setOnClickListener(view -> {
//
//        });
    }
}
