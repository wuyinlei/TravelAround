package com.renren.ruolan.travelaround.fragment;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.StringCallback;
import com.renren.ruolan.travelaround.event.HomeLocationEvent;
import com.renren.ruolan.travelaround.ui.CityActivity;
import com.renren.ruolan.travelaround.ui.MainActivity;
import com.renren.ruolan.travelaround.ui.ProductDetailActivity;
import com.renren.ruolan.travelaround.R;
import com.renren.ruolan.travelaround.constant.Contants;
import com.renren.ruolan.travelaround.entity.CityId;
import com.renren.ruolan.travelaround.event.CityIdEvent;
import com.renren.ruolan.travelaround.event.HomeEvent;
import com.renren.ruolan.travelaround.event.LocationEvent;
import com.renren.ruolan.travelaround.tabfragment.RecommentFragment;
import com.renren.ruolan.travelaround.adapter.HomeRecommentCityAdapter;
import com.renren.ruolan.travelaround.constant.HttpUrlPath;
import com.renren.ruolan.travelaround.entity.HomeData;
import com.renren.ruolan.travelaround.entity.HomeData.ResultEntity.BannerListEntity;
import com.renren.ruolan.travelaround.entity.HomeData.ResultEntity.CityListEntity;
import com.renren.ruolan.travelaround.widget.CustomPrograss;
import com.renren.ruolan.travelaround.widget.SimpleViewPagerIndicator;
import com.renren.ruolan.travelaround.widget.StickyNavLayout;
import com.renren.ruolan.travelaround.widget.carousel.FlyBanner;

import org.greenrobot.eventbus.EventBus;
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
public class HomeFragment extends Fragment implements View.OnClickListener {


    private List<BannerListEntity> mBannerListEntities = new ArrayList<>();
    private List<CityListEntity> mCityListEntities = new ArrayList<>();
    private LinearLayout idStickynavlayoutTopview;
    private FlyBanner flyBanner;
    private RecyclerView recyclerView;
    private SimpleViewPagerIndicator indicator;
    private ViewPager viewpager;
    private StickyNavLayout mStickyNavLayout;

    private ImageView ivAddress;
    private TextView tvAddress;

    private String[] mTitles;
    private List<Fragment> mFragments = new ArrayList<>();

    private FragmentPagerAdapter mAdapter;
    private HomeRecommentCityAdapter mCityAdapter;

    private List<CityId.ResultEntity.CityListEntity> mCityId = new ArrayList<>();

    public double mLatitude;
    public double mLongitude;
    private String cityName;

    private MainActivity mFragmentCallback;


    private String[] urls = new String[]{"V2101Index2.aspx",
            "V2101HotList.aspx", "V2101TicketList.aspx", "V2101HotelTicketList.aspx"
    };


    //返回码
    private final int RESULT_CODE = 100;
    //请求码
    private final int REQUEST_CODE = 101;

    private final int REQUEST_DES_CODE = 102;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mFragmentCallback = (MainActivity) activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        EventBus.getDefault().register(this);
        cityName = getActivity().getResources().getString(R.string.beijing);
        initView(view);
        initListener();
        initTitles();
        initDatas();
        initData();
        initEvents();
        return view;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void HomeLocationEvent(HomeLocationEvent event) {
        if (event != null) {
            if (!TextUtils.isEmpty(event.cityName)) {
                tvAddress.setText(event.cityName);
            }
            if (event.mLatitude != -1) {
                mLatitude = event.mLatitude;
            }
            if (event.mLongitude != -1) {
                mLongitude = event.mLongitude;
            }
        }
    }

    private void initView(View view) {
        mStickyNavLayout = (StickyNavLayout) view.findViewById(R.id.stick_nav_layout);
        mStickyNavLayout.setVisibility(View.INVISIBLE);
        idStickynavlayoutTopview = (LinearLayout) view.findViewById(R.id.id_stickynavlayout_topview);
        flyBanner = (FlyBanner) view.findViewById(R.id.fly_banner);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        indicator = (SimpleViewPagerIndicator) view.findViewById(R.id.id_stickynavlayout_indicator);
        viewpager = (ViewPager) view.findViewById(R.id.id_stickynavlayout_viewpager);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        mCityAdapter = new HomeRecommentCityAdapter(getActivity(), mCityListEntities);
        mCityAdapter.setOnItemClickListener((view1, position) -> {
                    EventBus.getDefault().post(new
                            CityIdEvent(mCityListEntities.get(position).getCityId(),
                            mCityListEntities.get(position).getCityName()));
                    mFragmentCallback.changeTabHost(1);
                    //  EventBus.getDefault().post();
                }
        );
        recyclerView.setAdapter(mCityAdapter);

        ivAddress = (ImageView) view.findViewById(R.id.img_address);
        tvAddress = (TextView) view.findViewById(R.id.tv_address);

        // TODO: 2016/11/17 定位城市
        EventBus.getDefault().post(new HomeEvent(getActivity()
                .getResources().getString(R.string.beijing), 39.961256, 116.461873));
    }


    private void initListener() {
        ivAddress.setOnClickListener(this);
        tvAddress.setOnClickListener(this);
    }


    private void initEvents() {
        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrolled(int position, float positionOffset,
                                       int positionOffsetPixels) {
                indicator.scroll(position, positionOffset);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }


    private void initTitles() {
        mTitles = new String[]{
                getActivity().getResources().getString(R.string.recomment),
                getActivity().getResources().getString(R.string.hot),
                getActivity().getResources().getString(R.string.scenic),
                getActivity().getResources().getString(R.string.wine_scenic)
        };

        //  mFragments = new RecommentFragment[mTitles.length];
    }

    private void initData() {

        CustomPrograss.show(getActivity(),
                getActivity().getResources().getString(R.string.loading),false,null);

        OkGo.post(HttpUrlPath.HOME_DATA)
                .tag(this)
                .params("CityName", getActivity().getResources().getString(R.string.beijing))
                .cacheMode(CacheMode.DEFAULT)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Type type = new TypeToken<HomeData>() {
                        }.getType();
                        HomeData homeData = new Gson().fromJson(s, type);
                        if (homeData.getStatus().equals("0")) {

                            mStickyNavLayout.setVisibility(View.VISIBLE);
                            CustomPrograss.disMiss();


                            mBannerListEntities = homeData.getResult().getBannerList();
                            mCityListEntities = homeData.getResult().getCityList();
                            if (mCityListEntities.size() > 0) {
                                mCityAdapter.setDatas(mCityListEntities);
                            }
                            if (mBannerListEntities.size() > 0) {
                                List<String> imgBanner = new ArrayList<>();
                                for (BannerListEntity bannerListEntity : mBannerListEntities) {
                                    imgBanner.add(bannerListEntity.getImageUrl());
                                }
                                flyBanner.setImagesUrl(imgBanner);
                                flyBanner.setOnItemClickListener(position -> {
                                    String Platform = "1";
                                    String ProductID = mBannerListEntities.get(position).getProductID();
                                    Intent intent = new Intent(getActivity(), ProductDetailActivity.class);
                                    intent.putExtra(Contants.PLATFORM, Platform);
                                    intent.putExtra(Contants.PRODUCT_ID, ProductID);
                                    intent.putExtra(Contants.CITY_NAME, cityName);
                                    startActivity(intent);
                                });
                            }
                        }
                    }
                });

//        OkGo.get(HttpUrlPath.GET_CITY_CITYID)
//                .getCall(StringConvert.create(), RxAdapter.<String>create())
//                .doOnSubscribe(()->{})
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(s->{
//                Type type = new TypeToken<CityId>(){}.getType();
//                    CityId cityId = new Gson().fromJson(s,type);
//                    mCityId = cityId.getResult().getCityList();
//                },throwable -> {});


    }

    int i = 1;


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void LocationEventReceiver(LocationEvent event) {
        if (event != null) {
            cityName = event.cityName;
            tvAddress.setText(event.cityName);
            mLatitude = event.mLatitude;
            mLongitude = event.mLongitude;
            i++;
            Log.d("HomeFragment", "i:" + i);
            HomeEvent homeEvent = new HomeEvent(event.cityName, event.mLatitude, event.mLongitude);
            EventBus.getDefault().post(homeEvent);
            initData(event.cityName, event.mLatitude, event.mLongitude);
//            Toast.makeText(getActivity(), "tvAddress:" + event.cityName +
//                    "  mLatitude:" + event.mLatitude
//                    + "  mLongitude:" + event.mLongitude, Toast.LENGTH_SHORT).show();

        }
    }

    private void initData(String cityName, double latitude, double longitude) {

        OkGo.post(HttpUrlPath.HOME_DATA)
                .tag(this)
                .params("CityName", cityName)
                .params("Latitude", latitude)
                .params("Longitude", longitude)
                .cacheMode(CacheMode.DEFAULT)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Type type = new TypeToken<HomeData>() {
                        }.getType();
                        HomeData homeData = new Gson().fromJson(s, type);
                        if (homeData.getStatus().equals("0")) {
                            mStickyNavLayout.setVisibility(View.VISIBLE);
                            mBannerListEntities.clear();
                            mCityListEntities.clear();
                            mBannerListEntities = homeData.getResult().getBannerList();
                            mCityListEntities = homeData.getResult().getCityList();
                            if (mCityListEntities.size() > 0) {
                                mCityAdapter.setDatas(mCityListEntities);
                            }
                            if (mBannerListEntities.size() > 0) {
                                List<String> imgBanner = new ArrayList<>();
                                for (BannerListEntity bannerListEntity : mBannerListEntities) {
                                    imgBanner.add(bannerListEntity.getImageUrl());
                                }
                                flyBanner.setImagesUrl(imgBanner);
                                flyBanner.setOnItemClickListener(position -> {

                                });
                            }
                        }
                    }
                });
    }

    private void initDatas() {
        indicator.setTitles(mTitles);

//        mFragments.add( RecommentFragment.newInstance(urls[0]));
//        mFragments.add(HotFragment.newInstance(urls[1]));
//        mFragments.add( ScenicFragment.newInstance(urls[2]));
//        mFragments.add(WineScenicFragment.newInstance(urls[3]));

        for (int i = 0; i < mTitles.length; i++) {
            mFragments.add(RecommentFragment.newInstance(i));
        }

        mAdapter = new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public int getCount() {
                return mTitles.length;
            }

            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }

        };

        viewpager.setAdapter(mAdapter);
        viewpager.setCurrentItem(0);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_address:
            case R.id.tv_address:
                Intent intent = new Intent(getActivity(), CityActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
