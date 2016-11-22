package com.renren.ruolan.travelaround.adapter;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.renren.ruolan.travelaround.R;
import com.renren.ruolan.travelaround.base.BaseViewHolder;
import com.renren.ruolan.travelaround.base.SimpleAdapter;
import com.renren.ruolan.travelaround.entity.DetailBean;
import com.renren.ruolan.travelaround.widget.transform.GlideCircleTransform;

import java.util.List;

/**
 * Created by Administrator on 2016/11/22.
 */

public class ProductCmtAdapter extends SimpleAdapter<DetailBean.ResultEntity.CmtListEntity> {
    public ProductCmtAdapter(Context context,  List<DetailBean.ResultEntity.CmtListEntity> datas) {
        super(context, R.layout.product_cmt_layout_item, datas);
    }

    @Override
    protected void convert(BaseViewHolder viewHoder, DetailBean.ResultEntity.CmtListEntity item) {
        viewHoder.getTextView(R.id.tv_time).setText(item.getCommentDate());
        viewHoder.getTextView(R.id.tv_content).setText(item.getContent());
        if (item.getUserName() != null){
            viewHoder.getTextView(R.id.tv_name).setText(item.getUserName());
        }
        Glide.with(context)
                .load(item.getUserImage())
                .asBitmap().transform(new GlideCircleTransform(context)).into(viewHoder.getImageView(R.id.img_user));
    }
}
