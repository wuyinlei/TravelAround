package com.renren.ruolan.travelaround.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.renren.ruolan.travelaround.BaseActivity;
import com.renren.ruolan.travelaround.R;
import com.renren.ruolan.travelaround.adapter.ProductDetailHotelAdapter;
import com.renren.ruolan.travelaround.entity.DetailBean;
import com.renren.ruolan.travelaround.entity.DetailBean.ResultEntity.OptionListEntity;

import java.util.ArrayList;
import java.util.List;

import static com.baidu.location.b.g.v;

public class ProductMoreActivity extends BaseActivity {

    private LinearLayout mActivityProductMore;
    private ImageView mImgBack;
    private TextView mTvTitle;
    private RecyclerView mRecyclerView;

    //旅馆
    private List<OptionListEntity> mOptionListEntities = new ArrayList<>();
    private String mTitle;
    private ProductDetailHotelAdapter mHotelAdapter;



    @Override
    protected int getResultId() {
        return R.layout.activity_product_more;
    }

    @Override
    protected void initListener() {

    }

    @Override
    public void initView() {
        mActivityProductMore = (LinearLayout) findViewById(R.id.activity_product_more);
        mImgBack = (ImageView) findViewById(R.id.img_back);
        mImgBack.setOnClickListener(v->finish());
        mTvTitle = (TextView) findViewById(R.id.tv_title);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mOptionListEntities = (List<OptionListEntity>) getIntent().getSerializableExtra("product");
        mTitle = getIntent().getStringExtra("title");
        if (!TextUtils.isEmpty(mTitle)){
            mTvTitle.setText(mTitle);
        }

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mHotelAdapter = new ProductDetailHotelAdapter(this,mOptionListEntities);
        mRecyclerView.setAdapter(mHotelAdapter);

        if (mOptionListEntities!=null && mOptionListEntities.size()>0){
            mHotelAdapter.setDatas(mOptionListEntities);
        }
    }
}
