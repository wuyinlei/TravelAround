package com.renren.ruolan.travelaround.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.NullDecoder;
import com.renren.ruolan.travelaround.R;
import com.renren.ruolan.travelaround.base.BaseAdapter;
import com.renren.ruolan.travelaround.base.BaseViewHolder;
import com.renren.ruolan.travelaround.base.SimpleAdapter;
import com.renren.ruolan.travelaround.entity.CollectData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/21.
 */

public class CollectAdapter extends RecyclerView.Adapter<CollectAdapter.MyViewHolder> {
//    public CollectAdapter(Context context, List<CollectData> datas) {
//        super(context, R.layout.collect_activity_item_layout, datas);
//    }
//
//    @Override
//    protected void convert(BaseViewHolder viewHoder, CollectData item) {
//        viewHoder.getTextView(R.id.tv_title).setText(item.getTitle());
//        Glide.with(context)
//                .load(item.getImgurl())
//                .asBitmap()
//                .placeholder(R.drawable.user_nologin)
//                .into(viewHoder.getImageView(R.id.img));
//    }

    private List<CollectData> mCollectDatas = new ArrayList<>();

    public void setCollectDatas(List<CollectData> collectDatas) {
        mCollectDatas = collectDatas;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.collect_activity_item_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        CollectData collectData = mCollectDatas.get(position);
        holder.mTvTitle.setText(collectData.getTitle());
        Glide.with(holder.itemView.getContext())
                .load(collectData.getImgurl())
                .asBitmap()
                .into(holder.mImg);
    }


    @Override
    public int getItemCount() {
        return mCollectDatas==null  ? 0 : mCollectDatas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView mTvTitle;
        private ImageView mImg;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            mImg = (ImageView) itemView.findViewById(R.id.img);
            if (mOnItemClick!=null){
                mImg.setOnClickListener(view ->
                        mOnItemClick.onItemClickListener(view,getLayoutPosition(),
                                mCollectDatas.get(getLayoutPosition())));
            }
            if (mOnLongItemClick !=null){
                mImg.setOnLongClickListener(view -> {

                    mOnLongItemClick.onLongItemClickListener(view,
                            getLayoutPosition(),mCollectDatas.get(getLayoutPosition()));
                    return true;
                });
            }
        }
    }

    private OnItemClick mOnItemClick;

    public void setOnItemClick(OnItemClick onItemClick) {
        mOnItemClick = onItemClick;
    }

    public interface  OnItemClick{
        void onItemClickListener(View view,int position,CollectData data);
    }

    private OnLongItemClick mOnLongItemClick;

    public void setOnLongItemClick(OnLongItemClick onLongItemClick) {
        mOnLongItemClick = onLongItemClick;
    }

    public interface  OnLongItemClick{
        void onLongItemClickListener(View view,int position,CollectData data);
    }
}
