package com.renren.ruolan.travelaround.adapter;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.renren.ruolan.travelaround.R;
import com.renren.ruolan.travelaround.base.BaseViewHolder;
import com.renren.ruolan.travelaround.base.SimpleAdapter;
import com.renren.ruolan.travelaround.entity.MoreDataDetail.ResultEntity.DetailListEntity;

import java.util.List;

/**
 * Created by Administrator on 2016/11/18.
 */

public class ProductDetailMoreDataAdapter extends SimpleAdapter<DetailListEntity> {
    public ProductDetailMoreDataAdapter(Context context, List<DetailListEntity> datas) {
        super(context, R.layout.product_detail_more_item_layout, datas);
    }

    @Override
    protected void convert(BaseViewHolder viewHoder, DetailListEntity item) {
        viewHoder.getTextView(R.id.tv_content).setText(item.getContent());
        List<String> images = item.getImgList();
        if (images.size() > 0) {
            Glide.with(context)
                    .load(images.get(0))
                    .asBitmap()
                    .into(viewHoder.getImageView(R.id.nineGrid));
        }

    }


}
