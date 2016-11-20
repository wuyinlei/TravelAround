package com.renren.ruolan.travelaround.entity;

import java.io.Serializable;

/**
 * Created by wuyinlei on 2016/11/19.
 */

public class Disvocery implements Serializable{

    public DiscoveryTagData.ResultEntity.TagListEntity tag;

    public int imgurl;

    public DiscoveryTagData.ResultEntity.TagListEntity getTag() {
        return tag;
    }

    public void setTag(DiscoveryTagData.ResultEntity.TagListEntity tag) {
        this.tag = tag;
    }

    public int getImgurl() {
        return imgurl;
    }

    public void setImgurl(int imgurl) {
        this.imgurl = imgurl;
    }
}
