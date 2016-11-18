package com.renren.ruolan.travelaround.event;

/**
 * Created by Administrator on 2016/11/17.
 */

public class LocationEvent {

    public String cityName;
    public double mLatitude;
    public double mLongitude;

    public LocationEvent(String cityName, Double latitude, Double longitude) {
        this.cityName = cityName;
        mLatitude = latitude;
        mLongitude = longitude;
    }
}
