package com.renren.ruolan.travelaround.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.renren.ruolan.travelaround.R;
import com.renren.ruolan.travelaround.entity.SelefHotelData.ResultEntity.ProductListEntity;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2016/11/16.
 */

public class SelefHotelAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    public static final int TYPE_NORMAL = 1;
    private static final int TYPE_FOOTER = 2;
    private List<ProductListEntity> mResultsBeen = new ArrayList<>();
    private Context mContext;

    public void setResultsBeen(List<ProductListEntity> resultsBeen) {
        mResultsBeen = resultsBeen;
        notifyDataSetChanged();
    }

    public SelefHotelAdapter(List<ProductListEntity> resultsBeen, Context context) {
        mResultsBeen = resultsBeen;
        mContext = context;
    }

    @Override
    public int getItemViewType(int position) {

        if (position + 1 == getItemCount()) {
            return TYPE_FOOTER;
        }
        return TYPE_NORMAL;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_FOOTER) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_foot, parent, false);
            return new FooterViewHolder(view);
        }
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.home_fragment_ticket_item_layout, parent, false);
        return new SelefViewHolder(view);
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            if (holder instanceof SelefViewHolder){
                SelefViewHolder viewHolder = (SelefViewHolder) holder;
                ProductListEntity item = mResultsBeen.get(position);
                viewHolder.mTvDes.setText(item.getProName()+" "+item.getTitle());
                viewHolder.mSellCount.setText(mContext.getResources().getString(R.string.sell_count)
                        +item.getViewCount());
                viewHolder.mTvPrice.setText(item.getMiniPrice()+"$");
                Glide.with(mContext)
                        .load(item.getImageUrl())
                        .asBitmap()
                        .placeholder(R.drawable.user_nologin)
                        .into(viewHolder.mImgDes);
            }
    }

    @Override
    public int getItemCount() {
        return mResultsBeen == null ? 0 : mResultsBeen.size() + 1;
    }


    class SelefViewHolder extends RecyclerView.ViewHolder {


        private TextView mTvDes, mTvPrice, mSellCount;
        private ImageView mImgDes;

        public SelefViewHolder(View itemView) {
            super(itemView);
            mTvDes = (TextView) itemView.findViewById(R.id.tv_des);
            mTvPrice = (TextView) itemView.findViewById(R.id.tv_price);
            mSellCount = (TextView) itemView.findViewById(R.id.sell_count);
            mImgDes = (ImageView) itemView.findViewById(R.id.img);

            mImgDes.setOnClickListener(view -> {
                if (mOnItemClick != null){
                    mOnItemClick.OnItemClickListener(view,getLayoutPosition(),
                            mResultsBeen.get(getLayoutPosition()));
                }
            });

        }
    }


    class FooterViewHolder extends RecyclerView.ViewHolder {

        public FooterViewHolder(View itemView) {
            super(itemView);
        }
    }

    private OnItemClick mOnItemClick;

    public void setOnItemClick(OnItemClick onItemClick) {
        mOnItemClick = onItemClick;
    }

    public interface OnItemClick{
        void OnItemClickListener(View view,int position,ProductListEntity bean);
    }
}
