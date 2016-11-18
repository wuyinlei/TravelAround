package com.renren.ruolan.travelaround.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/11/18.
 */

public class SelefHotelData implements Serializable {

    /**
     * status : 0
     * result : {"totalRecord":"26","currentPage":"1","pageSize":"8","totalPage":"4","productList":[{"productID":"45772","isCombined":"0","catalogID":"1","catalogName":"门票","imageUrl":"http://img.hifangjia.com:8999/images/md/group1/M01/1C/CD/eBif6FgRfWqAayeOAAEE1SZpdlU192.jpg","title":"金盛万豪水汇","distance":"0","proName":"金盛万豪水汇","viewCount":"2","miniPrice":"19.9","tagList":["休闲"]},{"productID":"45769","isCombined":"0","catalogID":"1","catalogName":"门票","imageUrl":"http://img.hifangjia.com:8999/images/md/group1/M01/1C/CD/eBif6FgRfR2ACIGNAAG8XX99W-8517.jpg","title":"唐都汗蒸时代广场","distance":"0","proName":"唐都汗蒸时代广场","viewCount":"3","miniPrice":"35","tagList":["休闲"]},{"productID":"45756","isCombined":"0","catalogID":"1","catalogName":"门票","imageUrl":"http://img.hifangjia.com:8999/images/md/group1/M01/1C/CC/eBif6FgRe_KARJ_cAADXLvJadHY938.jpg","title":"欢乐港湾水上乐园","distance":"0","proName":"欢乐港湾水上乐园","viewCount":"1","miniPrice":"9.8","tagList":["休闲"]},{"productID":"42435","isCombined":"0","catalogID":"2","catalogName":"酒店","imageUrl":"http://img.hifangjia.com:8999/images/md/group1/M01/19/B3/eBif6FfjzLKAdCP4AAEit2Wen-8671.jpg","title":"唐山时代星城公寓酒店","distance":"0","proName":"唐山时代星城公寓酒店","viewCount":"4","miniPrice":"188","tagList":["度假型"]},{"productID":"41443","isCombined":"0","catalogID":"2","catalogName":"酒店","imageUrl":"http://img.hifangjia.com:8999/images/md/group1/M01/19/37/eBif6FfjszSARKkqAAECwg6ma6Q461.jpg","title":"唐山爱时特套房酒店","distance":"0","proName":"唐山爱时特套房酒店","viewCount":"2","miniPrice":"427","tagList":["度假型"]},{"productID":"41314","isCombined":"0","catalogID":"2","catalogName":"酒店","imageUrl":"http://img.hifangjia.com:8999/images/md/group1/M01/19/26/eBif6FfjryGAX8n3AAuHBKYDcdk531.jpg","title":"唐山南湖紫天鹅庄木屋别墅","distance":"0","proName":"唐山南湖紫天鹅庄木屋别墅","viewCount":"4","miniPrice":"516","tagList":["度假型"]},{"productID":"40479","isCombined":"0","catalogID":"2","catalogName":"酒店","imageUrl":"http://img.hifangjia.com:8999/images/md/group1/M01/18/B7/eBif6FfjlwmAPKR8AAJof_2yZrU836.jpg","title":"唐山大唐凤凰园商务酒店","distance":"0","proName":"唐山大唐凤凰园商务酒店","viewCount":"2","miniPrice":"368","tagList":["度假型"]},{"productID":"38597","isCombined":"0","catalogID":"2","catalogName":"酒店","imageUrl":"http://img.hifangjia.com:8999/images/md/group1/M01/17/C2/eBif6FfjXlmAbsKKAAHJ17_-liQ654.jpg","title":"迁西景忠山万松禅院度假酒店","distance":"0","proName":"迁西景忠山万松禅院度假酒店","viewCount":"6","miniPrice":"338","tagList":["度假型"]}]}
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
         * totalRecord : 26
         * currentPage : 1
         * pageSize : 8
         * totalPage : 4
         * productList : [{"productID":"45772","isCombined":"0","catalogID":"1","catalogName":"门票","imageUrl":"http://img.hifangjia.com:8999/images/md/group1/M01/1C/CD/eBif6FgRfWqAayeOAAEE1SZpdlU192.jpg","title":"金盛万豪水汇","distance":"0","proName":"金盛万豪水汇","viewCount":"2","miniPrice":"19.9","tagList":["休闲"]},{"productID":"45769","isCombined":"0","catalogID":"1","catalogName":"门票","imageUrl":"http://img.hifangjia.com:8999/images/md/group1/M01/1C/CD/eBif6FgRfR2ACIGNAAG8XX99W-8517.jpg","title":"唐都汗蒸时代广场","distance":"0","proName":"唐都汗蒸时代广场","viewCount":"3","miniPrice":"35","tagList":["休闲"]},{"productID":"45756","isCombined":"0","catalogID":"1","catalogName":"门票","imageUrl":"http://img.hifangjia.com:8999/images/md/group1/M01/1C/CC/eBif6FgRe_KARJ_cAADXLvJadHY938.jpg","title":"欢乐港湾水上乐园","distance":"0","proName":"欢乐港湾水上乐园","viewCount":"1","miniPrice":"9.8","tagList":["休闲"]},{"productID":"42435","isCombined":"0","catalogID":"2","catalogName":"酒店","imageUrl":"http://img.hifangjia.com:8999/images/md/group1/M01/19/B3/eBif6FfjzLKAdCP4AAEit2Wen-8671.jpg","title":"唐山时代星城公寓酒店","distance":"0","proName":"唐山时代星城公寓酒店","viewCount":"4","miniPrice":"188","tagList":["度假型"]},{"productID":"41443","isCombined":"0","catalogID":"2","catalogName":"酒店","imageUrl":"http://img.hifangjia.com:8999/images/md/group1/M01/19/37/eBif6FfjszSARKkqAAECwg6ma6Q461.jpg","title":"唐山爱时特套房酒店","distance":"0","proName":"唐山爱时特套房酒店","viewCount":"2","miniPrice":"427","tagList":["度假型"]},{"productID":"41314","isCombined":"0","catalogID":"2","catalogName":"酒店","imageUrl":"http://img.hifangjia.com:8999/images/md/group1/M01/19/26/eBif6FfjryGAX8n3AAuHBKYDcdk531.jpg","title":"唐山南湖紫天鹅庄木屋别墅","distance":"0","proName":"唐山南湖紫天鹅庄木屋别墅","viewCount":"4","miniPrice":"516","tagList":["度假型"]},{"productID":"40479","isCombined":"0","catalogID":"2","catalogName":"酒店","imageUrl":"http://img.hifangjia.com:8999/images/md/group1/M01/18/B7/eBif6FfjlwmAPKR8AAJof_2yZrU836.jpg","title":"唐山大唐凤凰园商务酒店","distance":"0","proName":"唐山大唐凤凰园商务酒店","viewCount":"2","miniPrice":"368","tagList":["度假型"]},{"productID":"38597","isCombined":"0","catalogID":"2","catalogName":"酒店","imageUrl":"http://img.hifangjia.com:8999/images/md/group1/M01/17/C2/eBif6FfjXlmAbsKKAAHJ17_-liQ654.jpg","title":"迁西景忠山万松禅院度假酒店","distance":"0","proName":"迁西景忠山万松禅院度假酒店","viewCount":"6","miniPrice":"338","tagList":["度假型"]}]
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
             * productID : 45772
             * isCombined : 0
             * catalogID : 1
             * catalogName : 门票
             * imageUrl : http://img.hifangjia.com:8999/images/md/group1/M01/1C/CD/eBif6FgRfWqAayeOAAEE1SZpdlU192.jpg
             * title : 金盛万豪水汇
             * distance : 0
             * proName : 金盛万豪水汇
             * viewCount : 2
             * miniPrice : 19.9
             * tagList : ["休闲"]
             */

            private String productID;
            private String isCombined;
            private String catalogID;
            private String catalogName;
            private String imageUrl;
            private String title;
            private String distance;
            private String proName;
            private String viewCount;
            private String miniPrice;
            private List<String> tagList;

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

            public String getProName() {
                return proName;
            }

            public void setProName(String proName) {
                this.proName = proName;
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

            public List<String> getTagList() {
                return tagList;
            }

            public void setTagList(List<String> tagList) {
                this.tagList = tagList;
            }
        }
    }
}
