package com.renren.ruolan.travelaround.event;

/**
 * Created by Administrator on 2016/11/18.
 */

public class CityIdEvent {

    public String cityID;
    public String cityName;

    public CityIdEvent(String cityID,String cityName) {
        this.cityID = cityID;
        this.cityName = cityName;
    }
}
