package com.renren.ruolan.travelaround.tabfragment;

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
import com.renren.ruolan.travelaround.R;
import com.renren.ruolan.travelaround.adapter.TabFragmentAdapter;
import com.renren.ruolan.travelaround.constant.HttpUrlPath;
import com.renren.ruolan.travelaround.entity.HomeTicketBean;
import com.renren.ruolan.travelaround.entity.HomeTicketBean.ResultEntity.ProductListEntity;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import rx.android.schedulers.AndroidSchedulers;

public class HotFragment extends Fragment {
    public static final String TITLE = "title";
    private String url;
    private RecyclerView mRecyclerView;
    // private TextView mTextView;
    private List<String> mDatas = new ArrayList<String>();

    private List<ProductListEntity> mProductListEntities = new ArrayList<>();

    private String[] urls = new String[]{"V2101Index2.aspx",
            "V2101HotList.aspx", "V2101TicketList.aspx", "V2101HotelTicketList.aspx"
    };
    private TabFragmentAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            url = getArguments().getString(TITLE);
        }
    }

    String requestUrl;

    public static HotFragment newInstance(String title) {
        HotFragment tabFragment = new HotFragment();
        Bundle bundle = new Bundle();
        bundle.putString(TITLE, title);
        tabFragment.setArguments(bundle);
        return tabFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab, container, false);

        requestUrl = HttpUrlPath.BASE_URL + url;
        Log.d("RecommentFragment", requestUrl);
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

    private void initData() {
        OkGo.post(requestUrl)
                .params("CityName", getActivity().getResources().getString(R.string.beijing))
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
        mRecyclerView.setAdapter(mAdapter);
    }


}
