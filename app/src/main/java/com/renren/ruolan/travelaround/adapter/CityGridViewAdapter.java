package com.renren.ruolan.travelaround.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.renren.ruolan.travelaround.R;
import com.renren.ruolan.travelaround.entity.RegionInfo;

import java.util.List;




/**
 * 头部热门城市的适配器
 */

public class CityGridViewAdapter extends CityBaseAdapter<RegionInfo, GridView> {
    private LayoutInflater inflater;
    private List<RegionInfo> list;

    public CityGridViewAdapter(Context ct, List<RegionInfo> list) {
        super(ct, list);
        inflater = LayoutInflater.from(ct);
        this.list=list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_hot_city, null);
            holder.cityname = (TextView) convertView.findViewById(R.id.cityname);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        RegionInfo info = list.get(position);
        holder.cityname.setText(info.getName());
        return convertView;
    }

    class ViewHolder {
        TextView cityname;
    }
}