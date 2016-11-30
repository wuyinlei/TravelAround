package com.renren.ruolan.travelaround.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.convert.StringConvert;
import com.lzy.okrx.RxAdapter;
import com.renren.ruolan.travelaround.BaseActivity;
import com.renren.ruolan.travelaround.R;
import com.renren.ruolan.travelaround.adapter.SearchDetailAdapter;
import com.renren.ruolan.travelaround.base.BaseAdapter;
import com.renren.ruolan.travelaround.constant.Contants;
import com.renren.ruolan.travelaround.constant.HttpUrlPath;
import com.renren.ruolan.travelaround.entity.SearchDetailInfo;
import com.renren.ruolan.travelaround.entity.SearchDetailInfo.ResultEntity.ProductListEntity;
import com.renren.ruolan.travelaround.widget.FullyLinearLayoutManager;
import com.renren.ruolan.travelaround.widget.dialog.CustomPrograss;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import rx.android.schedulers.AndroidSchedulers;

public class SearchResultActivity extends BaseActivity {

    private ImageView mImgBack;
    private RecyclerView mRecyclerView;
    private TextView mTvSearchCount;
    private TextView mTvCityName;
    private String key;

    private List<ProductListEntity> mProductListEntities = new ArrayList<>();
    private int currentPage = 1;
    private SearchDetailAdapter mSearchDetailAdapter;

    private int totalPage;
    private String totalSize;
    private LinearLayoutManager mLayoutManager;


    @Override
    protected int getResultId() {
        return R.layout.activity_search_result;
    }

    @Override
    protected void initListener() {

    }

    @Override
    public void initData() {
        super.initData();
        // TODO: 2016/11/25 在这里去请求数据
        OkGo.post(HttpUrlPath.GET_SEARCH_DETAIL)
                .params("Platform", 1)
                .params("Key", key)
                .params("currentPage", currentPage)
                .getCall(StringConvert.create(), RxAdapter.<String>create())
                .doOnSubscribe(() -> {
//                    CustomPrograss.show(SearchResultActivity.this,
//                            getResources().getString(R.string.loading),
//                            true, null);
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    CustomPrograss.disMiss();
                    Type type = new TypeToken<SearchDetailInfo>() {
                    }.getType();
                    SearchDetailInfo detailInfo = new Gson().fromJson(s, type);
                    totalPage = Integer.parseInt(detailInfo.getResult().getTotalPage());
                    totalSize = detailInfo.getResult().getTotalRecord();
                    mProductListEntities = detailInfo.getResult().getProductList();
                    if (mProductListEntities.size() > 0) {
                        mTvCityName.setText(key);
                        mTvSearchCount.setText(totalSize);
                        mSearchDetailAdapter.setDatas(mProductListEntities);
                    }
                }, throwable -> {
                    CustomPrograss.disMiss();
                });

    }

    @Override
    public void initView() {
        key = getIntent().getStringExtra("key");
        mImgBack = (ImageView) findViewById(R.id.img_back);
        mImgBack.setOnClickListener(view -> finish());
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mTvSearchCount = (TextView) findViewById(R.id.tv_search_count);
        mTvCityName = (TextView) findViewById(R.id.tv_city_name);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mSearchDetailAdapter = new SearchDetailAdapter(this, mProductListEntities);
        mRecyclerView.setAdapter(mSearchDetailAdapter);

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                int lastVisiableItemPosition = mLayoutManager.findLastVisibleItemPosition();
                if (isHasMoreData && lastVisiableItemPosition + 1 == mSearchDetailAdapter.getItemCount()) {
//                    CustomPrograss.show(SearchResultActivity.this,
//                            getResources().getString(R.string.loading),
//                            true, null);
                    if (!isLoading) {
                        isLoading = true;
                        new Handler().postDelayed(() -> {
                            getLoadMoreData();
                            isLoading = false;
                            mSearchDetailAdapter.notifyItemRemoved(mSearchDetailAdapter.getItemCount());
                        }, 1500);
                    }
                }

            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });

        mSearchDetailAdapter.setOnItemClickListener((view, position) -> {
            String Platform = "1";
            String ProductID = mProductListEntities.get(position).getProductID();
            Intent intent = new Intent(this, ProductDetailActivity.class);
            intent.putExtra(Contants.PLATFORM, Platform);
            intent.putExtra(Contants.PRODUCT_ID, ProductID);
            intent.putExtra(Contants.CITY_NAME, key);
            startActivity(intent);
        });
    }

    private boolean isHasMoreData = true;

    private boolean isLoading;

    /**
     * 加载更多数据
     */
    private void getLoadMoreData() {

        currentPage++;
        if (currentPage > totalPage) {
            // CustomPrograss.disMiss();

            Toast.makeText(this,
                    getResources().getString(R.string.loading_finish),
                    Toast.LENGTH_SHORT).show();
            isHasMoreData = false;
            return;
        }
        OkGo.post(HttpUrlPath.GET_SEARCH_DETAIL)
                .params("Platform", 1)
                .params("Key", key)
                .params("currentPage", currentPage)
                .getCall(StringConvert.create(), RxAdapter.<String>create())
                .doOnSubscribe(() -> {

                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    Type type = new TypeToken<SearchDetailInfo>() {
                    }.getType();
                    SearchDetailInfo detailInfo = new Gson().fromJson(s, type);
                    totalPage = Integer.parseInt(detailInfo.getResult().getTotalPage());
                    List<ProductListEntity> productList = detailInfo.getResult().getProductList();
                    if (productList.size() > 0) {
                        //mTvCityName.setText(key);
                        //CustomPrograss.disMiss();
                        mProductListEntities.addAll(productList);
                        mSearchDetailAdapter.setDatas(mProductListEntities);
                    }
                }, throwable -> {
                    //CustomPrograss.disMiss();
                });
    }
}
