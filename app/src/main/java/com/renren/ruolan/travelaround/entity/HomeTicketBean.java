package com.renren.ruolan.travelaround.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/11/16.
 */

public class HomeTicketBean implements Serializable {

    /**
     * status : 0
     * result : {"totalRecord":"20","currentPage":"1","pageSize":"10","totalPage":"2","productList":[{"productID":"35992","isCombined":"0","catalogID":"2","catalogName":"酒店","customItem":{},"imageUrl":"http://img.hifangjia.com:8999/images/md/group1/M01/1C/EF/eBif6FgcJ9OADIg0AAFNDE7bbAA593.jpg","title":"入住1晚北京龙脉温泉度假村多种房型任选＋早餐＋熔岩温泉，开启浪漫温泉之旅。","distance":"0","proName":"北京龙脉温泉度假村","proCity":"北京","viewCount":"40","miniPrice":"199","recommendCode":"0","recommendTxt":"无","canMinus":"False","canUseCoupon":"1","bookingDay":"0"},{"productID":"31642","isCombined":"0","catalogID":"2","catalogName":"酒店","customItem":{},"imageUrl":"http://img.hifangjia.com:8999/images/md/group1/M01/1C/EF/eBif6FgcJ3SATCN8AAFZOqMG3pk952.jpg","title":"【专享定制】古北水镇大酒店1晚+美味大餐+司马台长城+特色手工Diy+暖汤温泉","distance":"0","proName":"古北水镇大酒店","proCity":"北京","viewCount":"36","miniPrice":"1218","recommendCode":"0","recommendTxt":"无","canMinus":"False","canUseCoupon":"1","bookingDay":"1"},{"productID":"1301","isCombined":"0","catalogID":"2","catalogName":"酒店","customItem":{},"imageUrl":"http://img.hifangjia.com:8999/images/md/group1/M01/1C/EF/eBif6FgcJ-qAScVjAAGKwwCbt88298.jpg","title":"【亲子定制】南宫温泉住宿1晚+双人早餐+乐享温泉水世界/儿童欢乐城堡/儿童创意DIY或家庭营养套餐","distance":"0","proName":"北京南宫温泉度假村","proCity":"北京","viewCount":"121","miniPrice":"618","recommendCode":"0","recommendTxt":"无","canMinus":"False","canUseCoupon":"1","bookingDay":"1"},{"productID":"21698","isCombined":"0","catalogID":"1","catalogName":"门票","customItem":{},"imageUrl":"http://img.hifangjia.com:8999/images/md/group1/M01/1C/F5/eBif6Fgpbx6AafQlAAFwQmYF3hc825.jpg","title":"北京欢乐谷，京城万圣恐怖大战，上映时间2016.10.14-11.13 凭胆入场","distance":"0","proName":"北京欢乐谷","proCity":"北京","viewCount":"167","miniPrice":"6","recommendCode":"0","recommendTxt":"无","canMinus":"False","canUseCoupon":"1","bookingDay":"1"},{"productID":"31629","isCombined":"0","catalogID":"2","catalogName":"酒店","customItem":{},"imageUrl":"http://img.hifangjia.com:8999/images/md/group1/M01/1C/EF/eBif6FgcJRSAUgVdAAGnwcUNiNo002.jpg","title":"【亲子定制】稻香湖景酒店住宿1晚+双人温泉城堡门票/免费双人茶/咖啡/双人电影院线电影票/五十元代金券/动物园","distance":"0","proName":"北京稻香湖景酒店","proCity":"北京","viewCount":"95","miniPrice":"538","recommendCode":"0","recommendTxt":"无","canMinus":"False","canUseCoupon":"1","bookingDay":"1"},{"productID":"21699","isCombined":"0","catalogID":"1","catalogName":"门票","customItem":{},"imageUrl":"http://img.hifangjia.com:8999/images/md/group1/M01/1C/A1/eBif6FgHCfeAFznLAAYlTYNqbhY648.jpg","title":"首批国家AAAA级旅游景点！各种海洋鱼类及生物达千余种，国内生最大生物收藏量！","distance":"0","proName":"北京海洋馆","proCity":"北京","viewCount":"136","miniPrice":"120","recommendCode":"0","recommendTxt":"无","canMinus":"False","canUseCoupon":"1","bookingDay":"0"},{"productID":"31555","isCombined":"0","catalogID":"2","catalogName":"酒店","customItem":{},"imageUrl":"http://img.hifangjia.com:8999/images/md/group1/M01/12/CB/eBif6FfDfEiAboBuAAoXlO6c5wM704.jpg","title":"密云古北水镇（长城脚下的水乡小镇），浪漫晚餐，酒吧双人特色调酒体验，司马台长城，月老祠甜蜜祈福","distance":"0","proName":"古北水镇大酒店","proCity":"北京","viewCount":"18","miniPrice":"1088","recommendCode":"0","recommendTxt":"无","canMinus":"False","canUseCoupon":"1","bookingDay":"1"},{"productID":"21704","isCombined":"0","catalogID":"1","catalogName":"门票","customItem":{},"imageUrl":"http://img.hifangjia.com:8999/images/md/group1/M01/0F/F9/eBif6Fd-L6yAPPL2AAOfPD_4oVY608.jpg","title":"中国古代宫廷建筑之精华","distance":"0","proName":"故宫","proCity":"北京","viewCount":"71","miniPrice":"10","recommendCode":"0","recommendTxt":"无","canMinus":"False","canUseCoupon":"1","bookingDay":"1"}]}
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
         * totalRecord : 20
         * currentPage : 1
         * pageSize : 10
         * totalPage : 2
         * productList : [{"productID":"35992","isCombined":"0","catalogID":"2","catalogName":"酒店","customItem":{},"imageUrl":"http://img.hifangjia.com:8999/images/md/group1/M01/1C/EF/eBif6FgcJ9OADIg0AAFNDE7bbAA593.jpg","title":"入住1晚北京龙脉温泉度假村多种房型任选＋早餐＋熔岩温泉，开启浪漫温泉之旅。","distance":"0","proName":"北京龙脉温泉度假村","proCity":"北京","viewCount":"40","miniPrice":"199","recommendCode":"0","recommendTxt":"无","canMinus":"False","canUseCoupon":"1","bookingDay":"0"},{"productID":"31642","isCombined":"0","catalogID":"2","catalogName":"酒店","customItem":{},"imageUrl":"http://img.hifangjia.com:8999/images/md/group1/M01/1C/EF/eBif6FgcJ3SATCN8AAFZOqMG3pk952.jpg","title":"【专享定制】古北水镇大酒店1晚+美味大餐+司马台长城+特色手工Diy+暖汤温泉","distance":"0","proName":"古北水镇大酒店","proCity":"北京","viewCount":"36","miniPrice":"1218","recommendCode":"0","recommendTxt":"无","canMinus":"False","canUseCoupon":"1","bookingDay":"1"},{"productID":"1301","isCombined":"0","catalogID":"2","catalogName":"酒店","customItem":{},"imageUrl":"http://img.hifangjia.com:8999/images/md/group1/M01/1C/EF/eBif6FgcJ-qAScVjAAGKwwCbt88298.jpg","title":"【亲子定制】南宫温泉住宿1晚+双人早餐+乐享温泉水世界/儿童欢乐城堡/儿童创意DIY或家庭营养套餐","distance":"0","proName":"北京南宫温泉度假村","proCity":"北京","viewCount":"121","miniPrice":"618","recommendCode":"0","recommendTxt":"无","canMinus":"False","canUseCoupon":"1","bookingDay":"1"},{"productID":"21698","isCombined":"0","catalogID":"1","catalogName":"门票","customItem":{},"imageUrl":"http://img.hifangjia.com:8999/images/md/group1/M01/1C/F5/eBif6Fgpbx6AafQlAAFwQmYF3hc825.jpg","title":"北京欢乐谷，京城万圣恐怖大战，上映时间2016.10.14-11.13 凭胆入场","distance":"0","proName":"北京欢乐谷","proCity":"北京","viewCount":"167","miniPrice":"6","recommendCode":"0","recommendTxt":"无","canMinus":"False","canUseCoupon":"1","bookingDay":"1"},{"productID":"31629","isCombined":"0","catalogID":"2","catalogName":"酒店","customItem":{},"imageUrl":"http://img.hifangjia.com:8999/images/md/group1/M01/1C/EF/eBif6FgcJRSAUgVdAAGnwcUNiNo002.jpg","title":"【亲子定制】稻香湖景酒店住宿1晚+双人温泉城堡门票/免费双人茶/咖啡/双人电影院线电影票/五十元代金券/动物园","distance":"0","proName":"北京稻香湖景酒店","proCity":"北京","viewCount":"95","miniPrice":"538","recommendCode":"0","recommendTxt":"无","canMinus":"False","canUseCoupon":"1","bookingDay":"1"},{"productID":"21699","isCombined":"0","catalogID":"1","catalogName":"门票","customItem":{},"imageUrl":"http://img.hifangjia.com:8999/images/md/group1/M01/1C/A1/eBif6FgHCfeAFznLAAYlTYNqbhY648.jpg","title":"首批国家AAAA级旅游景点！各种海洋鱼类及生物达千余种，国内生最大生物收藏量！","distance":"0","proName":"北京海洋馆","proCity":"北京","viewCount":"136","miniPrice":"120","recommendCode":"0","recommendTxt":"无","canMinus":"False","canUseCoupon":"1","bookingDay":"0"},{"productID":"31555","isCombined":"0","catalogID":"2","catalogName":"酒店","customItem":{},"imageUrl":"http://img.hifangjia.com:8999/images/md/group1/M01/12/CB/eBif6FfDfEiAboBuAAoXlO6c5wM704.jpg","title":"密云古北水镇（长城脚下的水乡小镇），浪漫晚餐，酒吧双人特色调酒体验，司马台长城，月老祠甜蜜祈福","distance":"0","proName":"古北水镇大酒店","proCity":"北京","viewCount":"18","miniPrice":"1088","recommendCode":"0","recommendTxt":"无","canMinus":"False","canUseCoupon":"1","bookingDay":"1"},{"productID":"21704","isCombined":"0","catalogID":"1","catalogName":"门票","customItem":{},"imageUrl":"http://img.hifangjia.com:8999/images/md/group1/M01/0F/F9/eBif6Fd-L6yAPPL2AAOfPD_4oVY608.jpg","title":"中国古代宫廷建筑之精华","distance":"0","proName":"故宫","proCity":"北京","viewCount":"71","miniPrice":"10","recommendCode":"0","recommendTxt":"无","canMinus":"False","canUseCoupon":"1","bookingDay":"1"}]
         */

        private String totalRecord;
        private String currentPage;
        private String pageSize;
        private String totalPage;
        private List<ProductListEntity> productList;

        public String getTotalRecord() {
            return totalRecord;
        }

        public void setTotalRecord(String totalRecord) {
            this.totalRecord = totalRecord;
        }

        public String getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(String currentPage) {
            this.currentPage = currentPage;
        }

        public String getPageSize() {
            return pageSize;
        }

        public void setPageSize(String pageSize) {
            this.pageSize = pageSize;
        }

        public String getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(String totalPage) {
            this.totalPage = totalPage;
        }

        public List<ProductListEntity> getProductList() {
            return productList;
        }

        public void setProductList(List<ProductListEntity> productList) {
            this.productList = productList;
        }

        public static class ProductListEntity {
            /**
             * productID : 35992
             * isCombined : 0
             * catalogID : 2
             * catalogName : 酒店
             * customItem : {}
             * imageUrl : http://img.hifangjia.com:8999/images/md/group1/M01/1C/EF/eBif6FgcJ9OADIg0AAFNDE7bbAA593.jpg
             * title : 入住1晚北京龙脉温泉度假村多种房型任选＋早餐＋熔岩温泉，开启浪漫温泉之旅。
             * distance : 0
             * proName : 北京龙脉温泉度假村
             * proCity : 北京
             * viewCount : 40
             * miniPrice : 199
             * recommendCode : 0
             * recommendTxt : 无
             * canMinus : False
             * canUseCoupon : 1
             * bookingDay : 0
             */

            private String productID;
            private String isCombined;
            private String catalogID;
            private String catalogName;
            private CustomItemEntity customItem;
            private String imageUrl;
            private String title;
            private String distance;
            private String proName;
            private String proCity;
            private String viewCount;
            private String miniPrice;
            private String recommendCode;
            private String recommendTxt;
            private String canMinus;
            private String canUseCoupon;
            private String bookingDay;

            public String getProductID() {
                return productID;
            }

            public void setProductID(String productID) {
                this.productID = productID;
            }

            public String getIsCombined() {
                return isCombined;
            }

            public void setIsCombined(String isCombined) {
                this.isCombined = isCombined;
            }

            public String getCatalogID() {
                return catalogID;
            }

            public void setCatalogID(String catalogID) {
                this.catalogID = catalogID;
            }

            public String getCatalogName() {
                return catalogName;
            }

            public void setCatalogName(String catalogName) {
                this.catalogName = catalogName;
            }

            public CustomItemEntity getCustomItem() {
                return customItem;
            }

            public void setCustomItem(CustomItemEntity customItem) {
                this.customItem = customItem;
            }

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDistance() {
                return distance;
            }

            public void setDistance(String distance) {
                this.distance = distance;
            }

            public String getProName() {
                return proName;
            }

            public void setProName(String proName) {
                this.proName = proName;
            }

            public String getProCity() {
                return proCity;
            }

            public void setProCity(String proCity) {
                this.proCity = proCity;
            }

            public String getViewCount() {
                return viewCount;
            }

            public void setViewCount(String viewCount) {
                this.viewCount = viewCount;
            }

            public String getMiniPrice() {
                return miniPrice;
            }

            public void setMiniPrice(String miniPrice) {
                this.miniPrice = miniPrice;
            }

            public String getRecommendCode() {
                return recommendCode;
            }

            public void setRecommendCode(String recommendCode) {
                this.recommendCode = recommendCode;
            }

            public String getRecommendTxt() {
                return recommendTxt;
            }

            public void setRecommendTxt(String recommendTxt) {
                this.recommendTxt = recommendTxt;
            }

            public String getCanMinus() {
                return canMinus;
            }

            public void setCanMinus(String canMinus) {
                this.canMinus = canMinus;
            }

            public String getCanUseCoupon() {
                return canUseCoupon;
            }

            public void setCanUseCoupon(String canUseCoupon) {
                this.canUseCoupon = canUseCoupon;
            }

            public String getBookingDay() {
                return bookingDay;
            }

            public void setBookingDay(String bookingDay) {
                this.bookingDay = bookingDay;
            }

            public static class CustomItemEntity {
            }
        }
    }
}
