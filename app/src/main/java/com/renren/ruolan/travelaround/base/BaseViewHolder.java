package com.renren.ruolan.travelaround.base;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/10/21.
 */

public class BaseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {


    private SparseArray<View> views;

    private BaseAdapter.OnItemClickListener mOnItemClickListener ;

    private BaseAdapter.OnLongItemClickListener mOnLongItemClickListener;

    public BaseViewHolder(View itemView,
                          BaseAdapter.OnItemClickListener onItemClickListener,
                          BaseAdapter.OnLongItemClickListener longItemClickListener){
        super(itemView);
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
        this.mOnItemClickListener =onItemClickListener;
        this.mOnLongItemClickListener = longItemClickListener;
        this.views = new SparseArray<>();
    }

    public TextView getTextView(int viewId) {
        return retrieveView(viewId);
    }

    public CheckBox getCheckBox(int viewId) {
        return retrieveView(viewId);
    }

    public Button getButton(int viewId) {
        return retrieveView(viewId);
    }

    public ImageView getImageView(int viewId) {
        return retrieveView(viewId);
    }

    public View getView(int viewId) {
        return retrieveView(viewId);
    }

    public RelativeLayout getRelativeLayout(int viewId){
        return retrieveView(viewId);
    }


    protected <T extends View> T retrieveView(int viewId) {
        View view = views.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            views.put(viewId, view);
        }
        return (T) view;
    }

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemClick(v,getLayoutPosition());
        }
    }

    @Override
    public boolean onLongClick(View view) {
        if (mOnLongItemClickListener !=null){
            mOnLongItemClickListener.onLongItemClick(view,getLayoutPosition());
        }
        return true;
    }
}
