package com.renren.ruolan.travelaround.tabfragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
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
import com.renren.ruolan.travelaround.widget.dialog.CustomPrograss;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;
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

    private int currentPage = 1;
    private int totalPage;

    private List<ProductListEntity> mProductListEntities = new ArrayList<>();

    private String[] urls = new String[]{"V2101Index2.aspx",
            "V2101HotList.aspx", "V2101TicketList.aspx", "V2101HotelTicketList.aspx"
    };
    private TabFragmentAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            index = getArguments().getInt(TITLE);
        }
        EventBus.getDefault().register(this);
    }

    String requestUrl = HttpUrlPath.BASE_URL + "V2101Index2.aspx";

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

        requestUrl = HttpUrlPath.BASE_URL + "Home" + File.separator + "V20" + File.separator + urls[index];
        Log.d("RecommentFragment", requestUrl);

        initView(view);

        cityName = getActivity().getResources().getString(R.string.beijing);
        mLatitude = 39.961256; //后期可以在开始的时候获取到经纬度  然后传递
        mLongitude = 116.461873;
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
            initData(event.cityName, event.mLatitude, event.mLongitude);
//            Toast.makeText(getActivity(), "tvAddress:" + event.cityName +
//                    "  mLatitude:" + event.mLatitude
//                    + "  mLongitude:" + event.mLongitude, Toast.LENGTH_SHORT).show();
            //   EventBus.getDefault().post(event);


        }
    }

    private void initData(String cityName, double latitude, double longitude) {
        currentPage = 1;
        OkGo.post(requestUrl)
                .params("CityName", cityName)
                .params("Latitude", latitude)
                .params("Longitude", longitude)
                .params("currentPage", currentPage)
                .getCall(StringConvert.create(), RxAdapter.<String>create())
                .doOnSubscribe(() -> {
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    Type type = new TypeToken<HomeTicketBean>() {
                    }.getType();
                    HomeTicketBean bean = new Gson().fromJson(s, type);
                    if (bean.getStatus().equals("0")) {
                        totalPage = Integer.parseInt(bean.getResult().getTotalPage());
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
                .params("Latitude", mLatitude)
                .params("Longitude", mLongitude)
                .params("currentPage", currentPage)
                .execute(new StringCallback() {

                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Type type = new TypeToken<HomeTicketBean>() {
                        }.getType();
                        HomeTicketBean bean = new Gson().fromJson(s, type);
                        if (bean.getStatus().equals("0")) {
                            totalPage = Integer.parseInt(bean.getResult().getTotalPage());
                            mProductListEntities = bean.getResult().getProductList();
                            if (mProductListEntities.size() > 0) {
                                mAdapter.setDatas(mProductListEntities);
                            }
                        }
                    }
                });

    }

    private void initView(View view) {
        mRecyclerView = (RecyclerView) view
                .findViewById(R.id.id_stickynavlayout_innerscrollview);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new TabFragmentAdapter(getActivity(), mProductListEntities);
        mAdapter.setOnItemClickListener((view1, position) -> {
            String Platform = "1";
            String ProductID = mProductListEntities.get(position).getProductID();
            Intent intent = new Intent(getActivity(), ProductDetailActivity.class);
            intent.putExtra(Contants.PLATFORM, Platform);
            intent.putExtra(Contants.PRODUCT_ID, ProductID);
            intent.putExtra(Contants.CITY_NAME, cityName);
            startActivity(intent);
        });
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                int lastVisiableItemPosition = mLayoutManager.findLastVisibleItemPosition();
                if (lastVisiableItemPosition + 1 == mAdapter.getItemCount()) {
//                    CustomPrograss.show(getActivity(),
//                            getActivity().getResources().getString(R.string.loading),
//                            true, null);
                    if (!isLoading) {
                        isLoading = true;
                    }
                    new Handler().postDelayed(() -> {
                        getLoadMoreData();
                        isLoading = false;
                        mAdapter.notifyItemRemoved(mAdapter.getItemCount());
                    }, 1500);
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }

    boolean isLoading;

    private void getLoadMoreData() {
        currentPage++;
        if (currentPage > totalPage) {
            // CustomPrograss.disMiss();
            mAdapter.notifyItemRemoved(mAdapter.getItemCount());
            Toast.makeText(getActivity(),
                    getActivity().getResources().getString(R.string.loading_finish),
                    Toast.LENGTH_SHORT).show();
            return;
        }

        OkGo.post(requestUrl)
                .params("CityName", cityName)
                .params("Latitude", mLatitude)
                .params("Longitude", mLongitude)
                .params("currentPage", currentPage)
                .execute(new StringCallback() {

                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Type type = new TypeToken<HomeTicketBean>() {
                        }.getType();
                        CustomPrograss.disMiss();
                        HomeTicketBean bean = new Gson().fromJson(s, type);
                        if (bean.getStatus().equals("0")) {
                            List<ProductListEntity> productList = bean.getResult().getProductList();
                            if (productList.size() > 0) {
                                mProductListEntities.addAll(productList);
                                mAdapter.setDatas(mProductListEntities);
                            }
                        }
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        CustomPrograss.disMiss();
                    }
                });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
