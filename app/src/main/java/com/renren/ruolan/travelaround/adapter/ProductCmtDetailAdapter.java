package com.renren.ruolan.travelaround.adapter;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.renren.ruolan.travelaround.R;
import com.renren.ruolan.travelaround.base.BaseViewHolder;
import com.renren.ruolan.travelaround.base.SimpleAdapter;
import com.renren.ruolan.travelaround.entity.CmtInfo;
import com.renren.ruolan.travelaround.widget.transform.GlideCircleTransform;

import java.util.List;

/**
 * Created by Administrator on 2016/11/22.
 */

public class ProductCmtDetailAdapter extends SimpleAdapter<CmtInfo> {
    public ProductCmtDetailAdapter(Context context, List<CmtInfo> datas) {
        super(context, R.layout.product_cmt_detail_item_layout, datas);
    }

    @Override
    protected void convert(BaseViewHolder viewHoder, CmtInfo item) {
        Glide.with(context)
                .load(item.getUserImage())
                .asBitmap().transform(new GlideCircleTransform(context)).into(viewHoder.getImageView(R.id.img_user));
        viewHoder.getTextView(R.id.tv_time).setText(item.getCommentDate());
        viewHoder.getTextView(R.id.tv_content).setText(item.getContent());
        if (item.getUserName() != null){
            viewHoder.getTextView(R.id.tv_name).setText(item.getUserName());
        }
    }
}
