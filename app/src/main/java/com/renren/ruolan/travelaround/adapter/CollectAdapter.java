package com.renren.ruolan.travelaround.adapter;

import android.content.Context;
import android.view.View;

import com.bumptech.glide.Glide;
import com.renren.ruolan.travelaround.R;
import com.renren.ruolan.travelaround.base.BaseAdapter;
import com.renren.ruolan.travelaround.base.BaseViewHolder;
import com.renren.ruolan.travelaround.base.SimpleAdapter;
import com.renren.ruolan.travelaround.entity.CollectData;

import java.util.List;

/**
 * Created by Administrator on 2016/11/21.
 */

public class CollectAdapter extends SimpleAdapter<CollectData> {
    public CollectAdapter(Context context,  List<CollectData> datas) {
        super(context, R.layout.collect_activity_item_layout, datas);
    }

    @Override
    protected void convert(BaseViewHolder viewHoder, CollectData item) {
        viewHoder.getTextView(R.id.tv_title).setText(item.getTitle());
        Glide.with(context)
                .load(item.getImgurl())
                .asBitmap()
                .placeholder(R.drawable.user_nologin)
                .into(viewHoder.getImageView(R.id.img));
    }

}
