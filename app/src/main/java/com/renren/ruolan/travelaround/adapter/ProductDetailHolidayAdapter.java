package com.renren.ruolan.travelaround.adapter;

import android.content.Context;

import com.renren.ruolan.travelaround.R;
import com.renren.ruolan.travelaround.base.BaseViewHolder;
import com.renren.ruolan.travelaround.base.SimpleAdapter;
import com.renren.ruolan.travelaround.entity.DetailBean;
import com.renren.ruolan.travelaround.entity.DetailBean.ResultEntity.OtherInfoEntity;

import java.util.List;

/**
 * Created by Administrator on 2016/11/17.
 */

public class ProductDetailHolidayAdapter extends SimpleAdapter<OtherInfoEntity> {
    public ProductDetailHolidayAdapter(Context context,  List<OtherInfoEntity> datas) {
        super(context, R.layout.product_detail_tip_item_layout, datas);
    }

    @Override
    protected void convert(BaseViewHolder viewHoder, OtherInfoEntity item) {
        viewHoder.getTextView(R.id.tv_title).setText(item.getTitle());
        viewHoder.getTextView(R.id.tv_content).setText(item.getContent());
    }
}
