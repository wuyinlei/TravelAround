package com.renren.ruolan.travelaround.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/11/25.
 */

public class SearchDetailInfo implements Serializable {


    /**
     * status : 0
     * result : {"catalogList":[{"catalogID":"0","catalogName":"全部"},{"catalogID":"1","catalogName":"门票"},{"catalogID":"2","catalogName":"酒店"},{"catalogID":"3","catalogName":"游玩"},{"catalogID":"4","catalogName":"餐饮"},{"catalogID":"5","catalogName":"懒游"},{"catalogID":"74","catalogName":"跟团"}],"productList":[{"productID":"1301","isCombined":"0","catalogID":"2","catalogName":"酒店","imageUrl":"http://img.hifangjia.com:8999/images/xs/group1/M01/1C/F8/eBif6FgyoWCAP6HXAAG9da8u0OQ117.jpg","title":"北京南宫温泉度假村","distance":"0","satisfaction":"0","collectedCount":"11","isFree":"1","miniPrice":"618","canMinus":"False"},{"productID":"46195","isCombined":"0","catalogID":"2","catalogName":"酒店","imageUrl":"http://img.hifangjia.com:8999/images/xs/group1/M01/1C/FB/eBif6Fg3quuADS_IAALp3EW9a20497.jpg","title":"古北水镇大酒店","distance":"0","satisfaction":"0","collectedCount":"1","isFree":"1","miniPrice":"666","canMinus":"True"},{"productID":"46190","isCombined":"0","catalogID":"2","catalogName":"酒店","imageUrl":"http://img.hifangjia.com:8999/images/xs/group1/M01/1C/FB/eBif6Fg3ooiADCUqAAGipAhJ_mE861.jpg","title":"北京新华联丽景温泉酒店","distance":"0","satisfaction":"0","collectedCount":"0","isFree":"1","miniPrice":"642","canMinus":"True"},{"productID":"46186","isCombined":"0","catalogID":"2","catalogName":"酒店","imageUrl":"http://img.hifangjia.com:8999/images/xs/group1/M01/1C/FA/eBif6Fg2oCCASdiOAALKE1yp9zc808.jpg","title":"北京美神宫温泉城堡酒店","distance":"0","satisfaction":"0","collectedCount":"0","isFree":"1","miniPrice":"488","canMinus":"True"},{"productID":"35398","isCombined":"0","catalogID":"2","catalogName":"酒店","imageUrl":"http://img.hifangjia.com:8999/images/xs/group1/M01/1C/F8/eBif6Fgyom2ACqJDAAFQV1nM1v0481.jpg","title":"北京张裕爱斐堡国际酒庄（欧洲小镇度假酒店）","distance":"0","satisfaction":"0","collectedCount":"923","isFree":"1","miniPrice":"518","canMinus":"False"},{"productID":"31642","isCombined":"0","catalogID":"2","catalogName":"酒店","imageUrl":"http://img.hifangjia.com:8999/images/xs/group1/M01/1C/F8/eBif6Fgyo9OAAe7LAAG-9ns08S4277.jpg","title":"古北水镇大酒店","distance":"0","satisfaction":"0","collectedCount":"806","isFree":"1","miniPrice":"1218","canMinus":"False"},{"productID":"31629","isCombined":"0","catalogID":"2","catalogName":"酒店","imageUrl":"http://img.hifangjia.com:8999/images/xs/group1/M01/1C/F8/eBif6FgyoNiAHD8sAAF6uWasRKE780.jpg","title":"北京稻香湖景酒店","distance":"0","satisfaction":"0","collectedCount":"251","isFree":"1","miniPrice":"538","canMinus":"False"},{"productID":"21698","isCombined":"0","catalogID":"1","catalogName":"门票","imageUrl":"http://img.hifangjia.com:8999/images/xs/group1/M01/1C/F5/eBif6Fgpbx6AafQlAAFwQmYF3hc825.jpg","title":"北京欢乐谷","distance":"0","satisfaction":"0","collectedCount":"282","isFree":"1","miniPrice":"6","canMinus":"False"}],"hasResult":"1","totalRecord":"633","currentPage":"1","pageSize":"8","totalPage":"80","key":"北京","catalogID":"0"}
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
         * catalogList : [{"catalogID":"0","catalogName":"全部"},{"catalogID":"1","catalogName":"门票"},{"catalogID":"2","catalogName":"酒店"},{"catalogID":"3","catalogName":"游玩"},{"catalogID":"4","catalogName":"餐饮"},{"catalogID":"5","catalogName":"懒游"},{"catalogID":"74","catalogName":"跟团"}]
         * productList : [{"productID":"1301","isCombined":"0","catalogID":"2","catalogName":"酒店","imageUrl":"http://img.hifangjia.com:8999/images/xs/group1/M01/1C/F8/eBif6FgyoWCAP6HXAAG9da8u0OQ117.jpg","title":"北京南宫温泉度假村","distance":"0","satisfaction":"0","collectedCount":"11","isFree":"1","miniPrice":"618","canMinus":"False"},{"productID":"46195","isCombined":"0","catalogID":"2","catalogName":"酒店","imageUrl":"http://img.hifangjia.com:8999/images/xs/group1/M01/1C/FB/eBif6Fg3quuADS_IAALp3EW9a20497.jpg","title":"古北水镇大酒店","distance":"0","satisfaction":"0","collectedCount":"1","isFree":"1","miniPrice":"666","canMinus":"True"},{"productID":"46190","isCombined":"0","catalogID":"2","catalogName":"酒店","imageUrl":"http://img.hifangjia.com:8999/images/xs/group1/M01/1C/FB/eBif6Fg3ooiADCUqAAGipAhJ_mE861.jpg","title":"北京新华联丽景温泉酒店","distance":"0","satisfaction":"0","collectedCount":"0","isFree":"1","miniPrice":"642","canMinus":"True"},{"productID":"46186","isCombined":"0","catalogID":"2","catalogName":"酒店","imageUrl":"http://img.hifangjia.com:8999/images/xs/group1/M01/1C/FA/eBif6Fg2oCCASdiOAALKE1yp9zc808.jpg","title":"北京美神宫温泉城堡酒店","distance":"0","satisfaction":"0","collectedCount":"0","isFree":"1","miniPrice":"488","canMinus":"True"},{"productID":"35398","isCombined":"0","catalogID":"2","catalogName":"酒店","imageUrl":"http://img.hifangjia.com:8999/images/xs/group1/M01/1C/F8/eBif6Fgyom2ACqJDAAFQV1nM1v0481.jpg","title":"北京张裕爱斐堡国际酒庄（欧洲小镇度假酒店）","distance":"0","satisfaction":"0","collectedCount":"923","isFree":"1","miniPrice":"518","canMinus":"False"},{"productID":"31642","isCombined":"0","catalogID":"2","catalogName":"酒店","imageUrl":"http://img.hifangjia.com:8999/images/xs/group1/M01/1C/F8/eBif6Fgyo9OAAe7LAAG-9ns08S4277.jpg","title":"古北水镇大酒店","distance":"0","satisfaction":"0","collectedCount":"806","isFree":"1","miniPrice":"1218","canMinus":"False"},{"productID":"31629","isCombined":"0","catalogID":"2","catalogName":"酒店","imageUrl":"http://img.hifangjia.com:8999/images/xs/group1/M01/1C/F8/eBif6FgyoNiAHD8sAAF6uWasRKE780.jpg","title":"北京稻香湖景酒店","distance":"0","satisfaction":"0","collectedCount":"251","isFree":"1","miniPrice":"538","canMinus":"False"},{"productID":"21698","isCombined":"0","catalogID":"1","catalogName":"门票","imageUrl":"http://img.hifangjia.com:8999/images/xs/group1/M01/1C/F5/eBif6Fgpbx6AafQlAAFwQmYF3hc825.jpg","title":"北京欢乐谷","distance":"0","satisfaction":"0","collectedCount":"282","isFree":"1","miniPrice":"6","canMinus":"False"}]
         * hasResult : 1
         * totalRecord : 633
         * currentPage : 1
         * pageSize : 8
         * totalPage : 80
         * key : 北京
         * catalogID : 0
         */

        private String hasResult;
        private String totalRecord;
        private String currentPage;
        private String pageSize;
        private String totalPage;
        private String key;
        private String catalogID;
        private List<CatalogListEntity> catalogList;
        private List<ProductListEntity> productList;

        public String getHasResult() {
            return hasResult;
        }

        public void setHasResult(String hasResult) {
            this.hasResult = hasResult;
        }

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

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getCatalogID() {
            return catalogID;
        }

        public void setCatalogID(String catalogID) {
            this.catalogID = catalogID;
        }

        public List<CatalogListEntity> getCatalogList() {
            return catalogList;
        }

        public void setCatalogList(List<CatalogListEntity> catalogList) {
            this.catalogList = catalogList;
        }

        public List<ProductListEntity> getProductList() {
            return productList;
        }

        public void setProductList(List<ProductListEntity> productList) {
            this.productList = productList;
        }

        public static class CatalogListEntity {
            /**
             * catalogID : 0
             * catalogName : 全部
             */

            private String catalogID;
            private String catalogName;

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
        }

        public static class ProductListEntity {
            /**
             * productID : 1301
             * isCombined : 0
             * catalogID : 2
             * catalogName : 酒店
             * imageUrl : http://img.hifangjia.com:8999/images/xs/group1/M01/1C/F8/eBif6FgyoWCAP6HXAAG9da8u0OQ117.jpg
             * title : 北京南宫温泉度假村
             * distance : 0
             * satisfaction : 0
             * collectedCount : 11
             * isFree : 1
             * miniPrice : 618
             * canMinus : False
             */

            private String productID;
            private String isCombined;
            private String catalogID;
            private String catalogName;
            private String imageUrl;
            private String title;
            private String distance;
            private String satisfaction;
            private String collectedCount;
            private String isFree;
            private String miniPrice;
            private String canMinus;

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

            public String getSatisfaction() {
                return satisfaction;
            }

            public void setSatisfaction(String satisfaction) {
                this.satisfaction = satisfaction;
            }

            public String getCollectedCount() {
                return collectedCount;
            }

            public void setCollectedCount(String collectedCount) {
                this.collectedCount = collectedCount;
            }

            public String getIsFree() {
                return isFree;
            }

            public void setIsFree(String isFree) {
                this.isFree = isFree;
            }

            public String getMiniPrice() {
                return miniPrice;
            }

            public void setMiniPrice(String miniPrice) {
                this.miniPrice = miniPrice;
            }

            public String getCanMinus() {
                return canMinus;
            }

            public void setCanMinus(String canMinus) {
                this.canMinus = canMinus;
            }
        }
    }
}
