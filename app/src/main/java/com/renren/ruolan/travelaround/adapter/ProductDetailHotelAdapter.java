package com.renren.ruolan.travelaround.adapter;

import android.content.Context;

import com.renren.ruolan.travelaround.R;
import com.renren.ruolan.travelaround.base.BaseViewHolder;
import com.renren.ruolan.travelaround.base.SimpleAdapter;
import com.renren.ruolan.travelaround.entity.DetailBean;
import com.renren.ruolan.travelaround.entity.DetailBean.ResultEntity.OptionListEntity;

import java.util.List;

/**
 * Created by Administrator on 2016/11/18.
 */

public class ProductDetailHotelAdapter extends SimpleAdapter<OptionListEntity> {
    public ProductDetailHotelAdapter(Context context, List<OptionListEntity> datas) {
        super(context, R.layout.product_detail_hotel_item_layout, datas);
    }

    @Override
    protected void convert(BaseViewHolder viewHoder, OptionListEntity item) {
        viewHoder.getTextView(R.id.tv_title).setText(item.getOptionName());
        viewHoder.getTextView(R.id.tv_price).setText(item.getMiniPrice());
        viewHoder.getTextView(R.id.is_coupon).setText(item.getBookingToday().equals("False") ?
                context.getResources().getString(R.string.available_coupons) :
                context.getResources().getString(R.string.no_available_coupons));
    }
}
