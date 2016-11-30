package com.renren.ruolan.travelaround.adapter;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.renren.ruolan.travelaround.R;
import com.renren.ruolan.travelaround.base.BaseMoreViewHolder;
import com.renren.ruolan.travelaround.base.BaseViewHolder;
import com.renren.ruolan.travelaround.base.SimpleAdapter;
import com.renren.ruolan.travelaround.base.SimpleMoreAdapter;
import com.renren.ruolan.travelaround.entity.DiscoveryArticleData;

import java.util.List;

/**
 * Created by wuyinlei on 2016/11/19.
 */

public class FragmentArticleAdapter extends SimpleMoreAdapter<DiscoveryArticleData.ResultBean.ArticleListBean> {
    public FragmentArticleAdapter(Context context,  List<DiscoveryArticleData.ResultBean.ArticleListBean> datas) {
        super(context, R.layout.discovery_fragment_article_item_layout, datas);
    }

    @Override
    protected void convert(BaseMoreViewHolder viewHoder, DiscoveryArticleData.ResultBean.ArticleListBean item) {
       // viewHoder.getTextView(R.id.tv_title).setText(item.getTitle());
        Glide.with(context)
                .load(item.getImageUrl())
                .asBitmap()
                .placeholder(R.drawable.user_nologin)
                .into(viewHoder.getImageView(R.id.img));
    }
}
