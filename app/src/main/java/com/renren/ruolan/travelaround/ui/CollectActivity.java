package com.renren.ruolan.travelaround.ui;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.renren.ruolan.travelaround.BaseActivity;
import com.renren.ruolan.travelaround.R;
import com.renren.ruolan.travelaround.adapter.CollectAdapter;
import com.renren.ruolan.travelaround.constant.Contants;
import com.renren.ruolan.travelaround.entity.CollectData;
import com.renren.ruolan.travelaround.entity.MyUser;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobQueryResult;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SQLQueryListener;
import cn.bmob.v3.listener.UpdateListener;



public class CollectActivity extends BaseActivity {

    private ImageView mImgBack;
    private RecyclerView mRecyclerView;
    private MyUser mMyUser;
    private List<CollectData> mCollectDatas = new ArrayList<>();
    private CollectAdapter mCollectAdapter;


    @Override
    protected int getResultId() {
        return R.layout.activity_collect;
    }

    @Override
    protected void initListener() {

    }

    @Override
    public void initData() {
        super.initData();
        BmobQuery<CollectData> query = new BmobQuery<CollectData>();
        String sql = "select * from CollectData where username=?";
        new BmobQuery<CollectData>().doSQLQuery(sql, new SQLQueryListener<CollectData>() {
            @Override
            public void done(BmobQueryResult<CollectData> bmobQueryResult, BmobException e) {
                if (e == null) {
                    List<CollectData> list = bmobQueryResult.getResults();
                    if (list != null && list.size() > 0) {
                        mCollectDatas = list;
                        mCollectAdapter.setCollectDatas(mCollectDatas);

                    } else {
                        Toast.makeText(CollectActivity.this,
                                getResources().getString(R.string.collect_null),
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }, mMyUser.getUsername());
    }

    @Override
    public void initView() {
        mImgBack = (ImageView) findViewById(R.id.img_back);
        mImgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mMyUser = BmobUser.getCurrentUser(MyUser.class);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mCollectAdapter = new CollectAdapter();
        mRecyclerView.setAdapter(mCollectAdapter);

        mCollectAdapter.setOnItemClick((view, position, data) -> {
            String Platform = "1";
            String ProductID = mCollectDatas.get(position).getProductID();
            Intent intent = new Intent(CollectActivity.this, ProductDetailActivity.class);
            intent.putExtra(Contants.PLATFORM, Platform);
            intent.putExtra(Contants.PRODUCT_ID, ProductID);
            intent.putExtra(Contants.CITY_NAME, data.getCityName());
            startActivity(intent);
        });

        //单击逻辑
        mCollectAdapter.setOnItemClick((view, position,m) -> {
            String Platform = "1";
            String ProductID = mCollectDatas.get(position).getProductID();
            Intent intent = new Intent(this, ProductDetailActivity.class);
            intent.putExtra(Contants.PLATFORM, Platform);
            intent.putExtra(Contants.PRODUCT_ID, ProductID);
            intent.putExtra(Contants.CITY_NAME, mCollectDatas.get(position).getCityName());
            startActivity(intent);
        });

        //长按删除逻辑
        mCollectAdapter.setOnLongItemClick(new CollectAdapter.OnLongItemClick() {
            @Override
            public void onLongItemClickListener(View view, int position, CollectData data) {
                new MaterialDialog.Builder(CollectActivity.this)
                        .title(R.string.tip)
                        .content(R.string.delete_is_or_not)
                        .positiveText(R.string.ok)
                        .negativeText(R.string.cancek)
                        .onPositive((dialog, which) -> {
                            CollectData collectData = mCollectDatas.get(position);
                            // TODO: 2016/11/27 删除收藏逻辑
                            String sql = "select * from CollectData where ProductID = ?";
                            new BmobQuery<CollectData>().doSQLQuery(sql,new SQLQueryListener<CollectData>() {
                                @Override
                                public void done(BmobQueryResult<CollectData> bmobQueryResult, BmobException e) {
                                    if (e == null) {
                                        List<CollectData> results = bmobQueryResult.getResults();
                                        if (results != null) {
                                            CollectData data = results.get(0);
                                            String objectId = data.getObjectId();
                                            CollectData data1 = new CollectData();
                                            data1.setObjectId(objectId);
                                            data1.delete(new UpdateListener() {
                                                @Override
                                                public void done(BmobException e) {
                                                    if (e == null){
                                                        initData();
                                                        // mCollectAdapter.removeItem(position);
                                                        //mCollectDatas.remove(position);
                                                        //mCollectAdapter.notifyItemRemoved(position);
                                                        //mCollectAdapter.notifyDataSetChanged();
                                                        dialog.dismiss();
                                                    } else {
                                                        dialog.dismiss();
                                                    }
                                                }
                                            });

                                        }
                                    }
                                }
                            },collectData.getProductID());


                        }).onNegative(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        dialog.dismiss();
                    }
                }).show();

                mMyUser = BmobUser.getCurrentUser(MyUser.class);
            }
        });


    }
}
