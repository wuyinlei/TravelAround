package com.renren.ruolan.travelaround.tabfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.convert.StringConvert;
import com.lzy.okrx.RxAdapter;
import com.renren.ruolan.travelaround.ui.ProductDetailActivity;
import com.renren.ruolan.travelaround.R;
import com.renren.ruolan.travelaround.adapter.TabFragmentAdapter;
import com.renren.ruolan.travelaround.constant.Contants;
import com.renren.ruolan.travelaround.constant.HttpUrlPath;
import com.renren.ruolan.travelaround.entity.HomeTicketBean;
import com.renren.ruolan.travelaround.entity.HomeTicketBean.ResultEntity.ProductListEntity;
import com.renren.ruolan.travelaround.event.HomeEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import rx.android.schedulers.AndroidSchedulers;

public class RecommentFragment extends Fragment {
    public static final String TITLE = "title";
    private int index;
    private RecyclerView mRecyclerView;
    // private TextView mTextView;
    private List<String> mDatas = new ArrayList<String>();

    public String cityName;
    public double mLatitude;
    public double mLongitude;

    private List<ProductListEntity> mProductListEntities = new ArrayList<>();

    private String[] urls = new String[]{"V2101Index2.aspx",
            "V2101HotList.aspx", "V2101TicketList.aspx", "V2101HotelTicketList.aspx"
    };
    private TabFragmentAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            index = getArguments().getInt(TITLE);
        }
        EventBus.getDefault().register(this);
    }

    String requestUrl = HttpUrlPath.BASE_URL+"V2101Index2.aspx";

    public static RecommentFragment newInstance(int title) {
        RecommentFragment tabFragment = new RecommentFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(TITLE, title);
        tabFragment.setArguments(bundle);
        return tabFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab, container, false);

        requestUrl = HttpUrlPath.BASE_URL + urls[index];
        Log.d("RecommentFragment", requestUrl);
        cityName = getActivity().getResources().getString(R.string.beijing);
        mLatitude = 39.961256; //后期可以在开始的时候获取到经纬度  然后传递
        mLongitude = 116.461873;
        initView(view);
        initData();

//        mRecyclerView.setAdapter(new CommonAdapter<String>(getActivity(), R.layout.item, mDatas)
//        {
//            @Override
//            public void convert(ViewHolder holder, String o)
//            {
//                holder.setText(R.id.id_info, o);
//            }
//        });

        return view;

    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void LocationEvent(HomeEvent event) {
        if (event != null) {

            mLatitude = event.mLatitude;
            mLongitude = event.mLongitude;
            cityName = event.cityName;
            initData(event.cityName,event.mLatitude,event.mLongitude);
//            Toast.makeText(getActivity(), "tvAddress:" + event.cityName +
//                    "  mLatitude:" + event.mLatitude
//                    + "  mLongitude:" + event.mLongitude, Toast.LENGTH_SHORT).show();
         //   EventBus.getDefault().post(event);


        }
    }

    private void initData(String cityName, double latitude, double longitude) {
        OkGo.post(requestUrl)
                .params("CityName", cityName)
                .params("Latitude",latitude)
                .params("Longitude",longitude)
                .getCall(StringConvert.create(), RxAdapter.<String>create())
                .doOnSubscribe(() -> {
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    Type type = new TypeToken<HomeTicketBean>() {
                    }.getType();
                    HomeTicketBean bean = new Gson().fromJson(s, type);
                    if (bean.getStatus().equals("0")) {
                        mProductListEntities.clear();
                        mProductListEntities = bean.getResult().getProductList();
                        if (mProductListEntities.size() > 0) {
                            mAdapter.setDatas(mProductListEntities);
                        }
                    }

                }, throwable -> {
                });
    }



    private void initData() {
        OkGo.post(requestUrl)
                .params("CityName", cityName)
                .params("Latitude",mLatitude)
                .params("Longitude",mLongitude)
                .getCall(StringConvert.create(), RxAdapter.<String>create())
                .doOnSubscribe(() -> {
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    Type type = new TypeToken<HomeTicketBean>() {
                    }.getType();
                    HomeTicketBean bean = new Gson().fromJson(s, type);
                    if (bean.getStatus().equals("0")) {
                        mProductListEntities = bean.getResult().getProductList();
                        if (mProductListEntities.size() > 0) {
                            mAdapter.setDatas(mProductListEntities);
                        }
                    }

                }, throwable -> {
                });
    }

    private void initView(View view) {
        mRecyclerView = (RecyclerView) view
                .findViewById(R.id.id_stickynavlayout_innerscrollview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new TabFragmentAdapter(getActivity(), mProductListEntities);
        mAdapter.setOnItemClickListener((view1, position) -> {
            String Platform = "1";
            String ProductID = mProductListEntities.get(position).getProductID();
            Intent intent = new Intent(getActivity(), ProductDetailActivity.class);
            intent.putExtra(Contants.PLATFORM,Platform);
            intent.putExtra(Contants.PRODUCT_ID,ProductID);
            intent.putExtra(Contants.CITY_NAME,cityName);
            startActivity(intent);
        });
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
