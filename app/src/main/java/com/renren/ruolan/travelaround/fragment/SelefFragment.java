package com.renren.ruolan.travelaround.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.convert.StringConvert;
import com.lzy.okrx.RxAdapter;
import com.renren.ruolan.travelaround.R;
import com.renren.ruolan.travelaround.adapter.SelefHotelAdapter;
import com.renren.ruolan.travelaround.constant.HttpUrlPath;
import com.renren.ruolan.travelaround.entity.CityId;
import com.renren.ruolan.travelaround.entity.SelefHotelData;
import com.renren.ruolan.travelaround.entity.SelefHotelData.ResultEntity.ProductListEntity;
import com.renren.ruolan.travelaround.event.CityIdEvent;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import rx.android.schedulers.AndroidSchedulers;

import static com.baidu.location.b.g.d;
import static com.baidu.location.b.g.s;


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
        OkGo.get(HttpUrlPath.GET_HOTEL_INFO)
                .params("CityID",cityID)
                .getCall(StringConvert.create(), RxAdapter.<String>create())
                .doOnSubscribe(()->{})
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s->{
                    Type type = new TypeToken<SelefHotelData>(){}.getType();
                    SelefHotelData data = new Gson().fromJson(s,type);
                    mProductListEntities = data.getResult().getProductList();
                    if (mProductListEntities.size()>0){
                        mHotelAdapter.setResultsBeen(mProductListEntities);
                    }
                },throwable -> {});
    }

    private void initView(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mHotelAdapter = new SelefHotelAdapter(mProductListEntities, getActivity());
        mRecyclerView.setAdapter(mHotelAdapter);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void CityEvent(CityIdEvent event) {
        if (event != null) {
            cityID = event.cityID;
            cityName = event.cityName;
        }
    }

}
