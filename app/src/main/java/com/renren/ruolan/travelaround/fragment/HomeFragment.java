package com.renren.ruolan.travelaround.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.StringCallback;
import com.renren.ruolan.travelaround.R;
import com.renren.ruolan.travelaround.tabfragment.RecommentFragment;
import com.renren.ruolan.travelaround.adapter.HomeRecommentCityAdapter;
import com.renren.ruolan.travelaround.constant.HttpUrlPath;
import com.renren.ruolan.travelaround.entity.HomeData;
import com.renren.ruolan.travelaround.entity.HomeData.ResultEntity.BannerListEntity;
import com.renren.ruolan.travelaround.entity.HomeData.ResultEntity.CityListEntity;
import com.renren.ruolan.travelaround.widget.SimpleViewPagerIndicator;
import com.renren.ruolan.travelaround.widget.carousel.FlyBanner;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    private List<BannerListEntity> mBannerListEntities = new ArrayList<>();
    private List<CityListEntity> mCityListEntities = new ArrayList<>();
    private LinearLayout idStickynavlayoutTopview;
    private FlyBanner flyBanner;
    private RecyclerView recyclerView;
    private SimpleViewPagerIndicator indicator;
    private ViewPager viewpager;

    private String[] mTitles ;
    private List<Fragment> mFragments = new ArrayList<>();

    private FragmentPagerAdapter mAdapter;
    private HomeRecommentCityAdapter mCityAdapter;

    private String[] urls = new String[]{"V2101Index2.aspx",
            "V2101HotList.aspx", "V2101TicketList.aspx", "V2101HotelTicketList.aspx"
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);
        initTitles();
        initDatas();
        initData();
        initEvents();
        return view;
    }


    private void initEvents()
    {
        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {
            @Override
            public void onPageSelected(int position)
            {
            }

            @Override
            public void onPageScrolled(int position, float positionOffset,
                                       int positionOffsetPixels)
            {
                indicator.scroll(position, positionOffset);
            }

            @Override
            public void onPageScrollStateChanged(int state)
            {

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

    private void initView(View view) {
        idStickynavlayoutTopview = (LinearLayout) view.findViewById(R.id.id_stickynavlayout_topview);
        flyBanner = (FlyBanner) view.findViewById(R.id.fly_banner);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        indicator = (SimpleViewPagerIndicator) view.findViewById(R.id.id_stickynavlayout_indicator);
        viewpager = (ViewPager) view.findViewById(R.id.id_stickynavlayout_viewpager);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        mCityAdapter = new HomeRecommentCityAdapter(getActivity(), mCityListEntities);
        recyclerView.setAdapter(mCityAdapter);
    }
}
