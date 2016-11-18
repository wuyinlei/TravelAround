package com.renren.ruolan.travelaround.adapter;

import android.content.Context;

import com.renren.ruolan.travelaround.R;
import com.renren.ruolan.travelaround.base.BaseViewHolder;
import com.renren.ruolan.travelaround.base.SimpleAdapter;
import com.renren.ruolan.travelaround.entity.DiscoveryTagData.ResultEntity.TagListEntity;

import java.util.List;

/**
 * Created by Administrator on 2016/11/18.
 */

public class DiscoveryTagAdapter extends SimpleAdapter<TagListEntity>{
    public DiscoveryTagAdapter(Context context, int layoutResId, List<TagListEntity> datas) {
        super(context, R.layout.discovery_fragment_tag_item_layout, datas);
    }

    @Override
    protected void convert(BaseViewHolder viewHoder, TagListEntity item) {

        viewHoder.getTextView(R.id.tv_title).setText(item.getTitle());

    }
}
