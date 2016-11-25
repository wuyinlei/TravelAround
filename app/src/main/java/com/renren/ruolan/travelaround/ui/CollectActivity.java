package com.renren.ruolan.travelaround.ui;

import android.content.Intent;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.renren.ruolan.travelaround.BaseActivity;
import com.renren.ruolan.travelaround.R;
import com.renren.ruolan.travelaround.adapter.CollectAdapter;
import com.renren.ruolan.travelaround.base.BaseAdapter;
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

import static com.baidu.location.f.mC;


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
                if (e == null){
                    List<CollectData> list = bmobQueryResult.getResults();
                    if (list != null &&  list.size() > 0){
                        mCollectDatas = list;
                        mCollectAdapter.setDatas(mCollectDatas);
                    } else {
                        Toast.makeText(CollectActivity.this,
                                getResources().getString(R.string.collect_null),
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
        },mMyUser.getUsername());
    }

    @Override
    public void initView() {
        mImgBack = (ImageView) findViewById(R.id.img_back);
        mImgBack.setOnClickListener(v->finish());
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mCollectAdapter = new CollectAdapter(this, mCollectDatas);
        mRecyclerView.setAdapter(mCollectAdapter);
        mCollectAdapter.setOnItemClickListener((view, position) -> {
            String Platform = "1";
            String ProductID = mCollectDatas.get(position).getProductID();
            Intent intent = new Intent(this, ProductDetailActivity.class);
            intent.putExtra(Contants.PLATFORM,Platform);
            intent.putExtra(Contants.PRODUCT_ID,ProductID);
            intent.putExtra(Contants.CITY_NAME,mCollectDatas.get(position).getCityName());
            startActivity(intent);
        });

        mMyUser = BmobUser.getCurrentUser(MyUser.class);
    }
}
