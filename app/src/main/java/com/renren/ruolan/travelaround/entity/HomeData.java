package com.renren.ruolan.travelaround.entity;

import java.util.List;

/**
 * Created by Administrator on 2016/11/16.
 *
 */

public class HomeData {


    /**
     * status : 0
     * result : {"bannerList":[{"bannerType":"1","bannerUrl":"http://fjapi.chufadian.com/Topic/Html/November.aspx?ProvinceID=2&SubjectID=79&Longitude=&Latitude=","bannerTitle":"双11狂欢会","bannerID":"183","catalogID":"","productID":"79","imageUrl":"http://img.hifangjia.com:8999/images/ori/group1/M01/1C/F0/eBif6Fghae-ANZtdAAEmJyQ3whI322.jpg"},{"bannerType":"0","bannerUrl":"http://fjapi.chufadian.com/Topic/Html/November.aspx?ProvinceID=2&SubjectID=79&Longitude=&Latitude=","bannerTitle":"北京杜莎夫人蜡像馆","bannerID":"177","catalogID":"1","productID":"21710","imageUrl":"http://img.hifangjia.com:8999/images/ori/group1/M01/1C/B1/eBif6FgPYReAA0VhAAEkGyIv_SQ570.jpg"},{"bannerType":"0","bannerUrl":"http://fjapi.chufadian.com/Topic/Html/November.aspx?ProvinceID=2&SubjectID=79&Longitude=&Latitude=","bannerTitle":"北京古北水镇","bannerID":"178","catalogID":"2","productID":"16931","imageUrl":"http://img.hifangjia.com:8999/images/ori/group1/M01/1C/B4/eBif6FgQXFGAcYrAAAFuJwnNQHE999.jpg"},{"bannerType":"0","bannerUrl":"http://fjapi.chufadian.com/Topic/Html/November.aspx?ProvinceID=2&SubjectID=79&Longitude=&Latitude=","bannerTitle":"北京顺景温泉","bannerID":"176","catalogID":"1","productID":"21918","imageUrl":"http://img.hifangjia.com:8999/images/ori/group1/M01/1C/B1/eBif6FgPYPCABE0gAAELffk1ado614.jpg"},{"bannerType":"0","bannerUrl":"http://fjapi.chufadian.com/Topic/Html/November.aspx?ProvinceID=2&SubjectID=79&Longitude=&Latitude=","bannerTitle":"北京稻香湖景酒店","bannerID":"131","catalogID":"2","productID":"31629","imageUrl":"http://img.hifangjia.com:8999/images/ori/group1/M01/1A/AD/eBif6FfqPhuAOFdJAAFBq7KLZao606.jpg"},{"bannerType":"0","bannerUrl":"http://fjapi.chufadian.com/Topic/Html/November.aspx?ProvinceID=2&SubjectID=79&Longitude=&Latitude=","bannerTitle":"北京 - 故宫","bannerID":"122","catalogID":"1","productID":"21704","imageUrl":"http://img.hifangjia.com:8999/images/ori/group1/M01/1A/A6/eBif6FfojWWASGsJAAEOP86J2eg149.jpg"}],"cityList":[{"cityId":"18","cityName":"北京","cityImg":"http://img.hifangjia.com:8999/images/ori/group1/M01/1C/EF/eBif6FggGviAGHs5AABF-9bQwqI479.jpg"},{"cityId":"112","cityName":"石家庄","cityImg":"http://img.hifangjia.com:8999/images/ori/group1/M01/1C/ED/eBif6FgX88yAJVZtAAA2vzjNf6k872.jpg"},{"cityId":"111","cityName":"秦皇岛","cityImg":"http://img.hifangjia.com:8999/images/ori/group1/M01/1C/ED/eBif6FgX89GAb9RTAAA4W83NK-8546.jpg"},{"cityId":"107","cityName":"承德","cityImg":"http://img.hifangjia.com:8999/images/ori/group1/M01/1C/ED/eBif6FgX89eAF3ZTAAAwuXK2ot0928.jpg"},{"cityId":"105","cityName":"保定","cityImg":"http://img.hifangjia.com:8999/images/ori/group1/M01/1C/EF/eBif6FggGxGAINcKAABAvOryhaI377.jpg"},{"cityId":"110","cityName":"廊坊","cityImg":"http://img.hifangjia.com:8999/images/ori/group1/M01/1C/EF/eBif6FggGwOAOxwlAAA5IMBkl74536.jpg"},{"cityId":"115","cityName":"张家口","cityImg":"http://img.hifangjia.com:8999/images/ori/group1/M01/1C/ED/eBif6FgX8-aARE0IAAA7ETNZmDs185.jpg"},{"cityId":"113","cityName":"唐山","cityImg":"http://img.hifangjia.com:8999/images/ori/group1/M01/1C/EF/eBif6FggGxaAKxgBAAAuFGnvv4o670.jpg"}],"keyList":[],"flashSale":{},"banner":{"desc":"立刻领取优惠券","imageUrl":"http://img.hifangjia.com:8999/images/ori/group1/M01/1C/F6/eBif6Fgr5BaAGc-qAAFSIy3SYBY073.jpg","isShow":"True"},"menuList":[{"classID":"79","classCode":"subject","className":"双11专题活动","url":"http://fjapi.chufadian.com/Topic/Html/November.aspx?ProvinceID=2&SubjectID=79&MemberID=&MacAddress=&IMEI=&Longitude=&Latitude=","isShow":"0"},{"classID":"46","classCode":"subject","className":"吃货寻味记","url":"http://fjapi.chufadian.com/Topic/Html/Foodie.aspx?ProvinceID=2&SubjectID=46&MemberID=&MacAddress=&IMEI=&Longitude=&Latitude=","isShow":"0"},{"classID":"51","classCode":"subject","className":"爱在路上","url":"http://fjapi.chufadian.com/Topic/Html/love-road.aspx?ProvinceID=2&SubjectID=51&MemberID=&MacAddress=&IMEI=&Longitude=&Latitude=","isShow":"0"},{"classID":"52","classCode":"subject","className":"精品自驾游","url":"http://fjapi.chufadian.com/Topic/Html/heart-lands.aspx?ProvinceID=2&SubjectID=52&MemberID=&MacAddress=&IMEI=&Longitude=&Latitude=","isShow":"0"}]}
     * message : 成功
     * errorcode :
     */

    private String status;
    private ResultEntity result;
    private String message;
    private String errorcode;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ResultEntity getResult() {
        return result;
    }

    public void setResult(ResultEntity result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(String errorcode) {
        this.errorcode = errorcode;
    }

    public static class ResultEntity {
        /**
         * bannerList : [{"bannerType":"1","bannerUrl":"http://fjapi.chufadian.com/Topic/Html/November.aspx?ProvinceID=2&SubjectID=79&Longitude=&Latitude=","bannerTitle":"双11狂欢会","bannerID":"183","catalogID":"","productID":"79","imageUrl":"http://img.hifangjia.com:8999/images/ori/group1/M01/1C/F0/eBif6Fghae-ANZtdAAEmJyQ3whI322.jpg"},{"bannerType":"0","bannerUrl":"http://fjapi.chufadian.com/Topic/Html/November.aspx?ProvinceID=2&SubjectID=79&Longitude=&Latitude=","bannerTitle":"北京杜莎夫人蜡像馆","bannerID":"177","catalogID":"1","productID":"21710","imageUrl":"http://img.hifangjia.com:8999/images/ori/group1/M01/1C/B1/eBif6FgPYReAA0VhAAEkGyIv_SQ570.jpg"},{"bannerType":"0","bannerUrl":"http://fjapi.chufadian.com/Topic/Html/November.aspx?ProvinceID=2&SubjectID=79&Longitude=&Latitude=","bannerTitle":"北京古北水镇","bannerID":"178","catalogID":"2","productID":"16931","imageUrl":"http://img.hifangjia.com:8999/images/ori/group1/M01/1C/B4/eBif6FgQXFGAcYrAAAFuJwnNQHE999.jpg"},{"bannerType":"0","bannerUrl":"http://fjapi.chufadian.com/Topic/Html/November.aspx?ProvinceID=2&SubjectID=79&Longitude=&Latitude=","bannerTitle":"北京顺景温泉","bannerID":"176","catalogID":"1","productID":"21918","imageUrl":"http://img.hifangjia.com:8999/images/ori/group1/M01/1C/B1/eBif6FgPYPCABE0gAAELffk1ado614.jpg"},{"bannerType":"0","bannerUrl":"http://fjapi.chufadian.com/Topic/Html/November.aspx?ProvinceID=2&SubjectID=79&Longitude=&Latitude=","bannerTitle":"北京稻香湖景酒店","bannerID":"131","catalogID":"2","productID":"31629","imageUrl":"http://img.hifangjia.com:8999/images/ori/group1/M01/1A/AD/eBif6FfqPhuAOFdJAAFBq7KLZao606.jpg"},{"bannerType":"0","bannerUrl":"http://fjapi.chufadian.com/Topic/Html/November.aspx?ProvinceID=2&SubjectID=79&Longitude=&Latitude=","bannerTitle":"北京 - 故宫","bannerID":"122","catalogID":"1","productID":"21704","imageUrl":"http://img.hifangjia.com:8999/images/ori/group1/M01/1A/A6/eBif6FfojWWASGsJAAEOP86J2eg149.jpg"}]
         * cityList : [{"cityId":"18","cityName":"北京","cityImg":"http://img.hifangjia.com:8999/images/ori/group1/M01/1C/EF/eBif6FggGviAGHs5AABF-9bQwqI479.jpg"},{"cityId":"112","cityName":"石家庄","cityImg":"http://img.hifangjia.com:8999/images/ori/group1/M01/1C/ED/eBif6FgX88yAJVZtAAA2vzjNf6k872.jpg"},{"cityId":"111","cityName":"秦皇岛","cityImg":"http://img.hifangjia.com:8999/images/ori/group1/M01/1C/ED/eBif6FgX89GAb9RTAAA4W83NK-8546.jpg"},{"cityId":"107","cityName":"承德","cityImg":"http://img.hifangjia.com:8999/images/ori/group1/M01/1C/ED/eBif6FgX89eAF3ZTAAAwuXK2ot0928.jpg"},{"cityId":"105","cityName":"保定","cityImg":"http://img.hifangjia.com:8999/images/ori/group1/M01/1C/EF/eBif6FggGxGAINcKAABAvOryhaI377.jpg"},{"cityId":"110","cityName":"廊坊","cityImg":"http://img.hifangjia.com:8999/images/ori/group1/M01/1C/EF/eBif6FggGwOAOxwlAAA5IMBkl74536.jpg"},{"cityId":"115","cityName":"张家口","cityImg":"http://img.hifangjia.com:8999/images/ori/group1/M01/1C/ED/eBif6FgX8-aARE0IAAA7ETNZmDs185.jpg"},{"cityId":"113","cityName":"唐山","cityImg":"http://img.hifangjia.com:8999/images/ori/group1/M01/1C/EF/eBif6FggGxaAKxgBAAAuFGnvv4o670.jpg"}]
         * keyList : []
         * flashSale : {}
         * banner : {"desc":"立刻领取优惠券","imageUrl":"http://img.hifangjia.com:8999/images/ori/group1/M01/1C/F6/eBif6Fgr5BaAGc-qAAFSIy3SYBY073.jpg","isShow":"True"}
         * menuList : [{"classID":"79","classCode":"subject","className":"双11专题活动","url":"http://fjapi.chufadian.com/Topic/Html/November.aspx?ProvinceID=2&SubjectID=79&MemberID=&MacAddress=&IMEI=&Longitude=&Latitude=","isShow":"0"},{"classID":"46","classCode":"subject","className":"吃货寻味记","url":"http://fjapi.chufadian.com/Topic/Html/Foodie.aspx?ProvinceID=2&SubjectID=46&MemberID=&MacAddress=&IMEI=&Longitude=&Latitude=","isShow":"0"},{"classID":"51","classCode":"subject","className":"爱在路上","url":"http://fjapi.chufadian.com/Topic/Html/love-road.aspx?ProvinceID=2&SubjectID=51&MemberID=&MacAddress=&IMEI=&Longitude=&Latitude=","isShow":"0"},{"classID":"52","classCode":"subject","className":"精品自驾游","url":"http://fjapi.chufadian.com/Topic/Html/heart-lands.aspx?ProvinceID=2&SubjectID=52&MemberID=&MacAddress=&IMEI=&Longitude=&Latitude=","isShow":"0"}]
         */

        private FlashSaleEntity flashSale;
        private BannerEntity banner;
        private List<BannerListEntity> bannerList;
        private List<CityListEntity> cityList;
        private List<?> keyList;
        private List<MenuListEntity> menuList;

        public FlashSaleEntity getFlashSale() {
            return flashSale;
        }

        public void setFlashSale(FlashSaleEntity flashSale) {
            this.flashSale = flashSale;
        }

        public BannerEntity getBanner() {
            return banner;
        }

        public void setBanner(BannerEntity banner) {
            this.banner = banner;
        }

        public List<BannerListEntity> getBannerList() {
            return bannerList;
        }

        public void setBannerList(List<BannerListEntity> bannerList) {
            this.bannerList = bannerList;
        }

        public List<CityListEntity> getCityList() {
            return cityList;
        }

        public void setCityList(List<CityListEntity> cityList) {
            this.cityList = cityList;
        }

        public List<?> getKeyList() {
            return keyList;
        }

        public void setKeyList(List<?> keyList) {
            this.keyList = keyList;
        }

        public List<MenuListEntity> getMenuList() {
            return menuList;
        }

        public void setMenuList(List<MenuListEntity> menuList) {
            this.menuList = menuList;
        }

        public static class FlashSaleEntity {
        }

        public static class BannerEntity {
            /**
             * desc : 立刻领取优惠券
             * imageUrl : http://img.hifangjia.com:8999/images/ori/group1/M01/1C/F6/eBif6Fgr5BaAGc-qAAFSIy3SYBY073.jpg
             * isShow : True
             */

            private String desc;
            private String imageUrl;
            private String isShow;

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public String getIsShow() {
                return isShow;
            }

            public void setIsShow(String isShow) {
                this.isShow = isShow;
            }
        }

        public static class BannerListEntity {
            /**
             * bannerType : 1
             * bannerUrl : http://fjapi.chufadian.com/Topic/Html/November.aspx?ProvinceID=2&SubjectID=79&Longitude=&Latitude=
             * bannerTitle : 双11狂欢会
             * bannerID : 183
             * catalogID :
             * productID : 79
             * imageUrl : http://img.hifangjia.com:8999/images/ori/group1/M01/1C/F0/eBif6Fghae-ANZtdAAEmJyQ3whI322.jpg
             */

            private String bannerType;
            private String bannerUrl;
            private String bannerTitle;
            private String bannerID;
            private String catalogID;
            private String productID;
            private String imageUrl;

            public String getBannerType() {
                return bannerType;
            }

            public void setBannerType(String bannerType) {
                this.bannerType = bannerType;
            }

            public String getBannerUrl() {
                return bannerUrl;
            }

            public void setBannerUrl(String bannerUrl) {
                this.bannerUrl = bannerUrl;
            }

            public String getBannerTitle() {
                return bannerTitle;
            }

            public void setBannerTitle(String bannerTitle) {
                this.bannerTitle = bannerTitle;
            }

            public String getBannerID() {
                return bannerID;
            }

            public void setBannerID(String bannerID) {
                this.bannerID = bannerID;
            }

            public String getCatalogID() {
                return catalogID;
            }

            public void setCatalogID(String catalogID) {
                this.catalogID = catalogID;
            }

            public String getProductID() {
                return productID;
            }

            public void setProductID(String productID) {
                this.productID = productID;
            }

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }
        }

        public static class CityListEntity {
            /**
             * cityId : 18
             * cityName : 北京
             * cityImg : http://img.hifangjia.com:8999/images/ori/group1/M01/1C/EF/eBif6FggGviAGHs5AABF-9bQwqI479.jpg
             */

            private String cityId;
            private String cityName;
            private String cityImg;

            public String getCityId() {
                return cityId;
            }

            public void setCityId(String cityId) {
                this.cityId = cityId;
            }

            public String getCityName() {
                return cityName;
            }

            public void setCityName(String cityName) {
                this.cityName = cityName;
            }

            public String getCityImg() {
                return cityImg;
            }

            public void setCityImg(String cityImg) {
                this.cityImg = cityImg;
            }
        }

        public static class MenuListEntity {
            /**
             * classID : 79
             * classCode : subject
             * className : 双11专题活动
             * url : http://fjapi.chufadian.com/Topic/Html/November.aspx?ProvinceID=2&SubjectID=79&MemberID=&MacAddress=&IMEI=&Longitude=&Latitude=
             * isShow : 0
             */

            private String classID;
            private String classCode;
            private String className;
            private String url;
            private String isShow;

            public String getClassID() {
                return classID;
            }

            public void setClassID(String classID) {
                this.classID = classID;
            }

            public String getClassCode() {
                return classCode;
            }

            public void setClassCode(String classCode) {
                this.classCode = classCode;
            }

            public String getClassName() {
                return className;
            }

            public void setClassName(String className) {
                this.className = className;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getIsShow() {
                return isShow;
            }

            public void setIsShow(String isShow) {
                this.isShow = isShow;
            }
        }
    }
}
