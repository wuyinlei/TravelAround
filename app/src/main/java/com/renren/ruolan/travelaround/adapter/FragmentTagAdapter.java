package com.renren.ruolan.travelaround.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.renren.ruolan.travelaround.R;
import com.renren.ruolan.travelaround.entity.Disvocery;

import java.util.List;

/**
 * Created by wuyinlei on 2016/11/19.
 */

public class FragmentTagAdapter extends RecyclerView.Adapter<FragmentTagAdapter.TagViewHolder> {


    private List<Disvocery> mDisvoceries;
    private Context mContext;

    public void setDisvoceries(List<Disvocery> disvoceries) {
        mDisvoceries = disvoceries;
        notifyDataSetChanged();
    }

    public FragmentTagAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public TagViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.discovery_fragment_tag_item_layout,
                        parent,false);

        return new TagViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TagViewHolder holder, int position) {
        Disvocery disvocery = mDisvoceries.get(position);
        holder.mTv.setText(disvocery.getTag().getTitle());
        holder.mImg.setImageResource(disvocery.getImgurl());
    }

    @Override
    public int getItemCount() {
        return mDisvoceries == null ? 0 : mDisvoceries.size();
    }

    class TagViewHolder extends RecyclerView.ViewHolder {

        private ImageView mImg;
        private TextView mTv;

        public TagViewHolder(View itemView) {
            super(itemView);
            mImg = (ImageView) itemView.findViewById(R.id.img);
            mTv = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }
}
