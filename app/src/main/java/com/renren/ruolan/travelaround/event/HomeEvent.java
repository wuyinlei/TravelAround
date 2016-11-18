package com.renren.ruolan.travelaround.event;

/**
 * Created by Administrator on 2016/11/17.
 */

public class HomeEvent {


    public String cityName;
    public double mLatitude;
    public double mLongitude;

    public HomeEvent(String cityName, Double latitude, Double longitude) {
        this.cityName = cityName;
        mLatitude = latitude;
        mLongitude = longitude;
    }
}
