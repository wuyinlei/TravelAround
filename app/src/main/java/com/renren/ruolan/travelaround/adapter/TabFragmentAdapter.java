package com.renren.ruolan.travelaround.adapter;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.renren.ruolan.travelaround.R;
import com.renren.ruolan.travelaround.base.BaseViewHolder;
import com.renren.ruolan.travelaround.base.SimpleAdapter;
import com.renren.ruolan.travelaround.entity.HomeTicketBean.ResultEntity.ProductListEntity;

import java.util.List;

/**
 * Created by Administrator on 2016/11/16.
 */

public class TabFragmentAdapter extends SimpleAdapter<ProductListEntity> {
    public TabFragmentAdapter(Context context, List<ProductListEntity> datas) {
        super(context, R.layout.home_fragment_ticket_item_layout, datas);
    }

    @Override
    protected void convert(BaseViewHolder viewHoder, ProductListEntity item) {
        Glide.with(context)
                .load(item.getImageUrl())
                .asBitmap()
                .placeholder(R.drawable.user_nologin)
                .into(viewHoder.getImageView(R.id.img));
        viewHoder.getTextView(R.id.tv_des).setText(item.getProName()+" "+item.getTitle());
        viewHoder.getTextView(R.id.tv_price).setText(item.getMiniPrice()+"$");
        viewHoder.getTextView(R.id.sell_count).setText(
                context.getResources().getString(R.string.sell_count)+item.getViewCount());

    }
}
