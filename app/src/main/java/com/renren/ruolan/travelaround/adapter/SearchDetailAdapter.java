package com.renren.ruolan.travelaround.adapter;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.renren.ruolan.travelaround.R;
import com.renren.ruolan.travelaround.base.BaseViewHolder;
import com.renren.ruolan.travelaround.base.SimpleAdapter;
import com.renren.ruolan.travelaround.entity.SearchDetailInfo;

import java.util.List;

/**
 * Created by Administrator on 2016/11/25.
 */

public class SearchDetailAdapter extends SimpleAdapter<SearchDetailInfo.ResultEntity.ProductListEntity> {
    public SearchDetailAdapter(Context context,  List<SearchDetailInfo.ResultEntity.ProductListEntity> datas) {
        super(context, R.layout.activity_search_detail_item_layout, datas);
    }

    @Override
    protected void convert(BaseViewHolder viewHoder, SearchDetailInfo.ResultEntity.ProductListEntity item) {
        Glide.with(context)
                .load(item.getImageUrl())
                .asBitmap()
                .into(viewHoder.getImageView(R.id.img));
        viewHoder.getTextView(R.id.tv_title).setText(item.getTitle());
        viewHoder.getTextView(R.id.tv_price).setText(item.getMiniPrice());
        viewHoder.getTextView(R.id.tv_count).setText(item.getCollectedCount());

    }
}
