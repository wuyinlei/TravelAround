package com.renren.ruolan.travelaround.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.renren.ruolan.travelaround.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class DiscoveryFragment extends Fragment {


    private RelativeLayout mReTitle;
    private RecyclerView mRecyclerViewOne;
    private RecyclerView mRecyclerViewDetail;

    public DiscoveryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recommend, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mReTitle = (RelativeLayout) view.findViewById(R.id.re_title);
        mRecyclerViewOne = (RecyclerView) view.findViewById(R.id.recycler_view_one);
        mRecyclerViewDetail = (RecyclerView) view.findViewById(R.id.recycler_view_detail);
    }
}
