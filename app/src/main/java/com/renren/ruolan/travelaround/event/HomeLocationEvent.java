package com.renren.ruolan.travelaround.event;

/**
 * Created by Administrator on 2016/11/17.
 */

public class HomeLocationEvent {

    public String cityName;
    public double mLatitude;
    public double mLongitude;

    public HomeLocationEvent(String cityName, Double latitude, Double longitude) {
        this.cityName = cityName;
        mLatitude = latitude;
        mLongitude = longitude;
    }
}
