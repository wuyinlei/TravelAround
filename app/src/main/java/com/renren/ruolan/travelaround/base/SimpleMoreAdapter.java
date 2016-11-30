package com.renren.ruolan.travelaround.base;


import android.content.Context;

import java.util.List;

/**
 * Created by Administrator on 2016/10/21.
 */

public abstract class SimpleMoreAdapter<T> extends BaseMoreAdapter<T,BaseMoreViewHolder> {

    public SimpleMoreAdapter(Context context, int layoutResId) {
        super(context, layoutResId);
    }

    public SimpleMoreAdapter(Context context, int layoutResId, List<T> datas) {
        super(context, layoutResId, datas);
    }

}