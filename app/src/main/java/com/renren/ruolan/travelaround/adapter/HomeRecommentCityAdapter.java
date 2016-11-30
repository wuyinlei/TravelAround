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
import com.renren.ruolan.travelaround.base.BaseViewHolder;
import com.renren.ruolan.travelaround.base.SimpleAdapter;
import com.renren.ruolan.travelaround.entity.HomeData;
import com.renren.ruolan.travelaround.entity.HomeData.ResultEntity.CityListEntity;

import java.util.ArrayList;
import java.util.List;

import static com.renren.ruolan.travelaround.R.layout.item;

/**
 * Created by Administrator on 2016/11/16.
 *
 */

public class HomeRecommentCityAdapter extends RecyclerView.Adapter<HomeRecommentCityAdapter.HomeRecommentCityViewHolder> {


    private List<CityListEntity> mCityListEntities = new ArrayList<>();

    public void setCityListEntities(List<CityListEntity> cityListEntities) {
        mCityListEntities = cityListEntities;
        notifyDataSetChanged();
    }

    @Override
    public HomeRecommentCityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_home_recomment_city_item_layout,parent,false);
        return new HomeRecommentCityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HomeRecommentCityViewHolder holder, int position) {
        CityListEntity entity = mCityListEntities.get(position);
        holder.mTvCity.setText(entity.getCityName());
        Glide.with(holder.itemView.getContext())
                .load(entity.getCityImg())
                .asBitmap()
                .placeholder(R.drawable.user_nologin)
                .into(holder.mImg);

    }

    @Override
    public int getItemCount() {
        return mCityListEntities == null ?0:mCityListEntities.size();
    }


    class HomeRecommentCityViewHolder extends RecyclerView.ViewHolder{

        TextView mTvCity;
        ImageView mImg;

        public HomeRecommentCityViewHolder(View itemView) {
            super(itemView);
            mTvCity = (TextView) itemView.findViewById(R.id.tv_city);
            mImg = (ImageView) itemView.findViewById(R.id.img);
            mImg.setOnClickListener(view -> {
                if (mOnClickListener !=null){
                    mOnClickListener.onClick(view,getLayoutPosition(),
                            mCityListEntities.get(getLayoutPosition()));
                }
            });
        }
    }

    private OnClickListener mOnClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        mOnClickListener = onClickListener;
    }

    public interface OnClickListener{
        void onClick(View view,int position,CityListEntity entity);
    }

}
