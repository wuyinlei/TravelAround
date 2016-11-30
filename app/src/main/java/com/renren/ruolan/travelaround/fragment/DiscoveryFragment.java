package com.renren.ruolan.travelaround.fragment;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.renren.ruolan.travelaround.R;
import com.renren.ruolan.travelaround.adapter.FragmentArticleAdapter;
import com.renren.ruolan.travelaround.adapter.FragmentTagAdapter;
import com.renren.ruolan.travelaround.constant.HttpUrlPath;
import com.renren.ruolan.travelaround.entity.DiscoveryArticleData;
import com.renren.ruolan.travelaround.entity.DiscoveryArticleData.ResultBean.ArticleListBean;
import com.renren.ruolan.travelaround.entity.DiscoveryTagData;
import com.renren.ruolan.travelaround.entity.DiscoveryTagData.ResultEntity.TagListEntity;
import com.renren.ruolan.travelaround.entity.Disvocery;
import com.renren.ruolan.travelaround.ui.ArticleDetailActivity;
import com.renren.ruolan.travelaround.ui.MainActivity;
import com.renren.ruolan.travelaround.ui.TagDetailActivity;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class DiscoveryFragment extends Fragment {


    private RelativeLayout mReTitle;
    private RecyclerView mRecyclerViewOne;
    private RecyclerView mRecyclerViewDetail;
    private String cityName;
    private int index = 1;
    private int totalPage;

    private List<Integer> imgUrls = new ArrayList<>();
    private List<TagListEntity> mTagListEntities = new ArrayList<>();
    private List<Disvocery> mDisvoceries = new ArrayList<>();
    private FragmentTagAdapter mTagAdapter;
    private List<ArticleListBean> mArticleList;
    private FragmentArticleAdapter mArticleAdapter;
    private LinearLayoutManager mLinearLayoutManager;

    public DiscoveryFragment() {
        // Required empty public constructor
    }

    private MainActivity mActivity;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mActivity = (MainActivity) activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_discovery, container, false);

        cityName = mActivity.getCityName();
        if (cityName == null)
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
                .params("SelectCity", cityName)
                .params("CityName", cityName)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Type type = new TypeToken<DiscoveryTagData>() {
                        }.getType();
                        DiscoveryTagData tagData = new Gson().fromJson(s, type);
                        mTagListEntities = tagData.getResult().getTagList();
                        if (mTagListEntities != null && mTagListEntities.size() > 0) {
                            for (int i = 0; i < mTagListEntities.size(); i++) {
                                Disvocery disvocery = new Disvocery();
                                disvocery.setImgurl(imgUrls.get(i));
                                disvocery.setTag(mTagListEntities.get(i));
                                mDisvoceries.add(disvocery);
                            }

                            if (mDisvoceries.size() > 0) {
                                mTagAdapter.setDisvoceries(mDisvoceries);
                            }
                        }
                    }


                });


        OkGo.post(HttpUrlPath.GET_HOME_ARTICLE_LIST)
                .params("currentPage", index)
                .params("CityName", cityName)
                .execute(new StringCallback() {

                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Type type = new TypeToken<DiscoveryArticleData>() {
                        }.getType();
                        DiscoveryArticleData articleData =
                                new Gson().fromJson(s, type);
                        totalPage = Integer.parseInt(articleData.getResult().getTotalPage());
                        mArticleList = articleData.getResult().getArticleList();
                        if (mArticleList != null && mArticleList.size() > 0) {
                            mArticleAdapter.setDatas(mArticleList);
                        }
                    }
                });


    }

    private void initView(View view) {
        mReTitle = (RelativeLayout) view.findViewById(R.id.re_title);
        mRecyclerViewOne = (RecyclerView) view.findViewById(R.id.recycler_view_tag);
        mRecyclerViewOne.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        mRecyclerViewOne.setItemAnimator(new DefaultItemAnimator());
        mTagAdapter = new FragmentTagAdapter(getActivity());
        mRecyclerViewOne.setAdapter(mTagAdapter);
        mTagAdapter.setOnItemClick((v, position, disvocery) -> {
            Intent intent = new Intent(getActivity(), TagDetailActivity.class);
            intent.putExtra("ClassID", disvocery.tag.getClassID());
            intent.putExtra("ProvinceID", "1");
            intent.putExtra("CityName", cityName);
            intent.putExtra("title", disvocery.tag.getTitle());
            startActivity(intent);
        });
        mRecyclerViewDetail = (RecyclerView) view.findViewById(R.id.recycler_view_detail);
        mLinearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerViewDetail.setLayoutManager(mLinearLayoutManager);
        mRecyclerViewDetail.setItemAnimator(new DefaultItemAnimator());
        mArticleAdapter = new FragmentArticleAdapter(getActivity(), mArticleList);

        mRecyclerViewDetail.setAdapter(mArticleAdapter);
        mArticleAdapter.setOnItemClickListener((view1, position) -> {
            Intent intent = new Intent(getActivity(), ArticleDetailActivity.class);
            intent.putExtra("id", mArticleList.get(position).getArticleID());
            intent.putExtra("title", mArticleList.get(position).getTitle());
            startActivity(intent);
        });
        mRecyclerViewDetail.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                int lastVisiableItemPosition = mLinearLayoutManager.findLastVisibleItemPosition();
                if (lastVisiableItemPosition + 1 == mArticleAdapter.getItemCount()) {
//                    CustomPrograss.show(getActivity(),
//                            getActivity().getResources().getString(R.string.loading),
//                            true, null);
                    if (!isLoading) {
                        isLoading = true;
                        new Handler().postDelayed(() -> {
                            getLoadMoreData();
                            isLoading = false;
                            mArticleAdapter.notifyItemRemoved(mArticleAdapter.getItemCount());
                        }, 1500);
                    }
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });

    }

    private boolean isLoading;

    private void getLoadMoreData() {

        index++;
        if (index <= totalPage) {

            OkGo.post(HttpUrlPath.GET_HOME_ARTICLE_LIST)
                    .params("currentPage", index)
                    .params("CityName", cityName)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            Type type = new TypeToken<DiscoveryArticleData>() {
                            }.getType();
                           // CustomPrograss.disMiss();
                            DiscoveryArticleData articleData =
                                    new Gson().fromJson(s, type);
                            List<ArticleListBean> articleList = articleData.getResult().getArticleList();
                            mArticleList.addAll(articleList);
                            if (mArticleList != null && mArticleList.size() > 0) {
                                mArticleAdapter.setDatas(mArticleList);
                                mArticleAdapter.notifyItemRemoved(mArticleAdapter.getItemCount());
                            }
                        }

                        @Override
                        public void onError(Call call, Response response, Exception e) {
                            super.onError(call, response, e);
                            //CustomPrograss.disMiss();
                            mArticleAdapter.notifyItemRemoved(mArticleAdapter.getItemCount());
                        }
                    });
        } else {
            mArticleAdapter.notifyItemRemoved(mArticleAdapter.getItemCount());
            //CustomPrograss.disMiss();
            Toast.makeText(mActivity, getActivity()
                            .getResources().getString(R.string.loading_finish),
                    Toast.LENGTH_SHORT).show();
        }

    }
}
