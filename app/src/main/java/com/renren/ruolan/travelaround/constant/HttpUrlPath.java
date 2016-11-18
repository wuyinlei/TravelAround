package com.renren.ruolan.travelaround.constant;

/**
 * Created by Administrator on 2016/11/16.
 */

public class HttpUrlPath {

    public static String BASE_URL = "http://api.hifangjia.com/Home/V20/";

    //CityName
    public static String HOME_DATA = BASE_URL + "V2101Index1.aspx";

    public static String HOME_TAB_URL = BASE_URL + "V2101Index2.aspx";

    //首页详情界面 Platform  ProductID   CityName
    public static String HOME_DETAIL_URL = "http://api.hifangjia.com/Detail/Single/V1903GetSingleDetail.aspx";

    //获取到所有城市
    public static String GET_CITY_CITYID = "http://api.hifangjia.com/City/V1602GetCityList.aspx";

    //继续滑动得到更多信息  ProductID
    public static String  GET_CITY_MORE_INFO= "http://api.hifangjia.com/Detail/Single/V1903GetDetailInfo.aspx";

    //城市列表id  获取酒店信息
    public static String GET_HOTEL_INFO = "http://api.hifangjia.com/Home/V18/V1801GetProListByCityID.aspx";
}
