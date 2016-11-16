package com.renren.ruolan.travelaround.adapter;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.renren.ruolan.travelaround.R;
import com.renren.ruolan.travelaround.base.BaseViewHolder;
import com.renren.ruolan.travelaround.base.SimpleAdapter;
import com.renren.ruolan.travelaround.entity.HomeData;

import java.util.List;

/**
 * Created by Administrator on 2016/11/16.
 */

public class HomeRecommentCityAdapter extends SimpleAdapter<HomeData.ResultEntity.CityListEntity>{

    public HomeRecommentCityAdapter(Context context, List<HomeData.ResultEntity.CityListEntity> datas) {
        super(context, R.layout.fragment_home_recomment_city_item_layout, datas);
    }

    @Override
    protected void convert(BaseViewHolder viewHoder, HomeData.ResultEntity.CityListEntity item) {
        viewHoder.getTextView(R.id.tv_city).setText(item.getCityName());
        Glide.with(context)
                .load(item.getCityImg())
                .asBitmap()
                .placeholder(R.drawable.user_nologin)
                .into(viewHoder.getImageView(R.id.img));
    }
}
