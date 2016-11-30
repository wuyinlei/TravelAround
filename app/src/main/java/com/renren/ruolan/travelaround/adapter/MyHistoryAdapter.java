package com.renren.ruolan.travelaround.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.renren.ruolan.travelaround.R;
import com.renren.ruolan.travelaround.entity.SearchHistory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/30.
 */

public class MyHistoryAdapter extends RecyclerView.Adapter<MyHistoryAdapter.HistoryViewHolder> {

    private List<SearchHistory> mSearchHistories = new ArrayList<>();

    public void setSearchHistories(List<SearchHistory> searchHistories) {
        mSearchHistories = searchHistories;
        notifyDataSetChanged();
    }


    @Override
    public HistoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_search_history_item_layout, parent, false);
        return new HistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HistoryViewHolder holder, int position) {
        SearchHistory history = mSearchHistories.get(position);
        holder.mTextView.setText(history.searchKey);
    }

    @Override
    public int getItemCount() {
        return mSearchHistories == null ? 0 : mSearchHistories.size();
    }

    class HistoryViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextView;

        public HistoryViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.tv_history);
            if (mOnItemClick != null) {
                mTextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        mOnItemClick.onItemClickListener(view, getLayoutPosition(),
                                mSearchHistories.get(getLayoutPosition()));
                    }
                });
            }
        }


    }


    public OnItemClick mOnItemClick;

    public void setOnItemClick(OnItemClick onItemClick) {
        mOnItemClick = onItemClick;
    }

    public interface OnItemClick {
        void onItemClickListener(View view, int position, SearchHistory history);
    }


}
