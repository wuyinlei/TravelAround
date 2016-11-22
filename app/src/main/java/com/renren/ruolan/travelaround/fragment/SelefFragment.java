package com.renren.ruolan.travelaround.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.renren.ruolan.travelaround.R;
import com.renren.ruolan.travelaround.adapter.SelefHotelAdapter;
import com.renren.ruolan.travelaround.constant.Contants;
import com.renren.ruolan.travelaround.constant.HttpUrlPath;
import com.renren.ruolan.travelaround.entity.SelefHotelData;
import com.renren.ruolan.travelaround.entity.SelefHotelData.ResultEntity.ProductListEntity;
import com.renren.ruolan.travelaround.event.CityIdEvent;
import com.renren.ruolan.travelaround.ui.ProductDetailActivity;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class SelefFragment extends Fragment {


    private SelefHotelAdapter mHotelAdapter;

    public SelefFragment() {
        // Required empty public constructor
    }

    private String cityID = "18";
    private String cityName;
    private RecyclerView mRecyclerView;
    private int currentPage  = 1;
    private int totalPage ;

    private List<ProductListEntity> mProductListEntities = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ranking, container, false);
        cityName = getActivity().getResources().getString(R.string.beijing);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        OkGo.post(HttpUrlPath.GET_HOTEL_INFO)
                .params("CityID", cityID)
                .params("CurrentPage",currentPage)
                .execute(new StringCallback(){

                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Type type = new TypeToken<SelefHotelData>() {
                        }.getType();
                        SelefHotelData data = new Gson().fromJson(s, type);
                        mProductListEntities = data.getResult().getProductList();
                        if (mProductListEntities.size() > 0) {
                            totalPage = data.getResult().getTotalPage();
                            mHotelAdapter.setResultsBeen(mProductListEntities);
                        }
                    }
                });
    }

    private void initView(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layout);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mHotelAdapter = new SelefHotelAdapter(mProductListEntities, getActivity());
        mRecyclerView.setAdapter(mHotelAdapter);

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                int lastVisiableItemPosition = layout.findLastVisibleItemPosition();
                if (lastVisiableItemPosition + 1 == mHotelAdapter.getItemCount()) {
//                    CustomPrograss.show(getActivity(),
//                            getResources().getString(R.string.loading),
//                            false, null);
                    new Handler().postDelayed(() -> {getLoadMoreData();
                    mHotelAdapter.notifyItemRemoved(mHotelAdapter.getItemCount());}, 1500);
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });

        mHotelAdapter.setOnItemClick((view1, position, bean) -> {
            String Platform = "1";
            String ProductID = mProductListEntities.get(position).getProductID();
            Intent intent = new Intent(getActivity(), ProductDetailActivity.class);
            intent.putExtra(Contants.PLATFORM, Platform);
            intent.putExtra(Contants.PRODUCT_ID, ProductID);
            intent.putExtra(Contants.CITY_NAME, cityName);
            startActivity(intent);
        });
    }

    private void getLoadMoreData() {
        currentPage ++;
        if (currentPage>totalPage){
            Toast.makeText(getActivity(),
                    getActivity().getResources()
                            .getString(R.string.loading_finish),
                    Toast.LENGTH_SHORT).show();
            return;
        }

        OkGo.get(HttpUrlPath.GET_HOTEL_INFO)
                .params("CityID", cityID)
                .params("CurrentPage",currentPage)
                .execute(new StringCallback(){
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Type type = new TypeToken<SelefHotelData>() {
                        }.getType();
                        SelefHotelData data = new Gson().fromJson(s, type);
                        // mProductListEntities.clear();
                        List<ProductListEntity> productList = data.getResult().getProductList();
                        mProductListEntities.addAll(productList);
                        if (mProductListEntities.size() > 0) {
                            mHotelAdapter.setResultsBeen(mProductListEntities);
                        }
                    }


                });



    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void CityEvent(CityIdEvent event) {
        if (event != null) {
            cityID = event.cityID;
            cityName = event.cityName;
            initData(cityID, cityName);
        }
    }

    /**
     * 重新请求数据
     *
     * @param cityID
     * @param cityName
     */
    private void initData(String cityID, String cityName) {
        currentPage = 1;
        OkGo.get(HttpUrlPath.GET_HOTEL_INFO)
                .params("CityID", cityID)
                .params("CurrentPage",currentPage)
                .execute(new StringCallback(){

                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Type type = new TypeToken<SelefHotelData>() {
                        }.getType();
                        SelefHotelData data = new Gson().fromJson(s, type);
                        mProductListEntities.clear();
                        mProductListEntities = data.getResult().getProductList();
                        if (mProductListEntities.size() > 0) {
                            mHotelAdapter.setResultsBeen(mProductListEntities);
                        }
                    }
                });
    }

}
