package com.renren.ruolan.travelaround.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.convert.StringConvert;
import com.lzy.okrx.RxAdapter;
import com.renren.ruolan.travelaround.R;
import com.renren.ruolan.travelaround.adapter.FragmentArticleAdapter;
import com.renren.ruolan.travelaround.adapter.FragmentTagAdapter;
import com.renren.ruolan.travelaround.constant.HttpUrlPath;
import com.renren.ruolan.travelaround.entity.DiscoveryArticleData;
import com.renren.ruolan.travelaround.entity.DiscoveryTagData;
import com.renren.ruolan.travelaround.entity.DiscoveryTagData.ResultEntity.TagListEntity;
import com.renren.ruolan.travelaround.entity.Disvocery;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import rx.android.schedulers.AndroidSchedulers;


/**
 * A simple {@link Fragment} subclass.
 */
public class DiscoveryFragment extends Fragment {


    private RelativeLayout mReTitle;
    private RecyclerView mRecyclerViewOne;
    private RecyclerView mRecyclerViewDetail;
    private String cityName ;
    private int index = 1;

    private List<Integer> imgUrls = new ArrayList<>();
    private List<TagListEntity>  mTagListEntities = new ArrayList<>();
    private List<Disvocery> mDisvoceries = new ArrayList<>();
    private FragmentTagAdapter mTagAdapter;
    private List<DiscoveryArticleData.ResultBean.ArticleListBean> mArticleList;
    private FragmentArticleAdapter mArticleAdapter;

    public DiscoveryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recommend, container, false);
        cityName = getActivity().getResources().getString(R.string.beijing);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        imgUrls.add(R.drawable.index_in_gongyuan);
        imgUrls.add(R.drawable.index_in_qinzi);
        imgUrls.add(R.drawable.index_in_yousanshui);
        imgUrls.add(R.drawable.index_in_xiuxian);
        imgUrls.add(R.drawable.index_in_haibianwanshui);
        imgUrls.add(R.drawable.index_in_nongjiale);
        imgUrls.add(R.drawable.index_in_piaoliu);
        imgUrls.add(R.drawable.index_in_wenquan);

        OkGo.post(HttpUrlPath.GET_HOME_TAG)
                .params("SelectCity",cityName)
                .params("CityName",cityName)
                .getCall(StringConvert.create(), RxAdapter.<String>create())
                .doOnSubscribe(()->{})
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s->{
                    Type type = new TypeToken<DiscoveryTagData>(){}.getType();
                    DiscoveryTagData tagData = new Gson().fromJson(s,type);
                    mTagListEntities = tagData.getResult().getTagList();
                    if (mTagListEntities!=null && mTagListEntities.size()>0){
                        for (int i = 0; i < mTagListEntities.size(); i++) {
                            Disvocery disvocery = new Disvocery();
                            disvocery.setImgurl(imgUrls.get(i));
                            disvocery.setTag(mTagListEntities.get(i));
                            mDisvoceries.add(disvocery);
                        }

                        if (mDisvoceries.size()>0){
                            mTagAdapter.setDisvoceries(mDisvoceries);
                        }
                    }
                },throwable -> {});

        OkGo.post(HttpUrlPath.GET_HOME_ARTICLE_LIST)
                .params("currentPage",index)
                .params("CityName",cityName)
                .getCall(StringConvert.create(),RxAdapter.<String>create())
                .doOnSubscribe(()->{})
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s->{
                    Type type = new TypeToken<DiscoveryArticleData>(){}.getType();
                    DiscoveryArticleData articleData =
                            new Gson().fromJson(s,type);
                    mArticleList = articleData.getResult().getArticleList();
                    if (mArticleList!=null && mArticleList.size()>0){
                            mArticleAdapter.setDatas(mArticleList);
                    }
                },throwable -> {});

    }

    private void initView(View view) {
        mReTitle = (RelativeLayout) view.findViewById(R.id.re_title);
        mRecyclerViewOne = (RecyclerView) view.findViewById(R.id.recycler_view_tag);
        mRecyclerViewOne.setLayoutManager(new GridLayoutManager(getActivity(),4));
        mRecyclerViewOne.setItemAnimator(new DefaultItemAnimator());
        mTagAdapter = new FragmentTagAdapter(getActivity());
        mRecyclerViewOne.setAdapter(mTagAdapter);
        mRecyclerViewDetail = (RecyclerView) view.findViewById(R.id.recycler_view_detail);
        mRecyclerViewDetail.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerViewDetail.setItemAnimator(new DefaultItemAnimator());
        mArticleAdapter = new FragmentArticleAdapter(getActivity(), mArticleList);

        mRecyclerViewDetail.setAdapter(mArticleAdapter);
    }
}
