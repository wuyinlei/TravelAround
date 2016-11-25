package com.renren.ruolan.travelaround.constant;

/**
 * Created by Administrator on 2016/11/16.
 */

public class HttpUrlPath {

    public static String BASE_URL = "http://api.hifangjia.com/";

    //CityName
    public static String HOME_DATA = BASE_URL + "Home/V20/V2101Index1.aspx";

    public static String HOME_TAB_URL = BASE_URL + "Home/V20/V2101Index2.aspx";

    //首页详情界面 Platform  ProductID   CityName
    public static String HOME_DETAIL_URL = BASE_URL + "Detail/Single/V1903GetSingleDetail.aspx";

    //获取到所有城市
    public static String GET_CITY_CITYID =BASE_URL +  "City/V1602GetCityList.aspx";

    //继续滑动得到更多信息  ProductID
    public static String  GET_CITY_MORE_INFO= BASE_URL + "Detail/Single/V1903GetDetailInfo.aspx";

    //城市列表id  获取酒店信息    CurrentPage
    public static String GET_HOTEL_INFO = BASE_URL + "Home/V18/V1801GetProListByCityID.aspx";

    //获取评论详情界面
    public static String GET_CMT_INFO = BASE_URL + "Comment/V1103GetCmtListByProID.aspx";

    //http://api.hifangjia.com/Home/V18/V1901Ticket1.aspx   发现界面   SelectCity 北京  CityName  北京

    public static String GET_HOME_TAG = BASE_URL + "Home/V18/V1901Ticket1.aspx";

    //http://api.hifangjia.com/Article/V1902GetArticleList.aspx    currentPage  1   CityName  发现界面  下面数据

    public static String GET_HOME_ARTICLE_LIST = BASE_URL + "Article/V1902GetArticleList.aspx";

    //http://fjapi.chufadian.com/Html5/AticleDetail.aspx?id=60  发现下面数据详情
    public static String GET_ARTICLE_INFO = "http://fjapi.chufadian.com/Html5/AticleDetail.aspx?id=";

    //参数Platform    CurrentPage   CityName   ProvinceID   (Latitude   Longitude)   ClassID
    //http://api.hifangjia.com/Home/V18/V1801GetProListByClassID.aspx   tab详情
    public static String GET_TAG_DETAIL_INFO =BASE_URL +  "Home/V18/V1801GetProListByClassID.aspx";

    //点击搜索界面跳转 Platform = 1 CityName = 北京
    public static String GET_SEARCH_KEY_INTO =BASE_URL +  "Search/V20101GetKeyList.aspx";

    //点击搜索之后的结果详情 Platform = 1    currentPage = 1   Key = 北京
    public static String GET_SEARCH_DETAIL = BASE_URL+"Search/V1403GetResultList.aspx";
}
