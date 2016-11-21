package com.renren.ruolan.travelaround.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/11/21.
 */

public class TagData implements Serializable {

    /**
     * status : 0
     * result : {"totalRecord":"24","currentPage":"1","pageSize":"8","totalPage":"3","productList":[{"productID":"24322","isCombined":"0","catalogID":"1","catalogName":"门票","imageUrl":"http://img.hifangjia.com:8999/images/md/group1/M00/0F/43/eBif6FdJQFuANal6AABJqCfzinE901.jpg","title":"北京红螺湖鸟岛","distance":"0","proName":"北京红螺湖鸟岛","proCity":"北京","viewCount":"64","miniPrice":"18"},{"productID":"24320","isCombined":"0","catalogID":"1","catalogName":"门票","imageUrl":"http://img.hifangjia.com:8999/images/md/group1/M01/0F/F8/eBif6Fd99-WAHQnFAAOikNySs24740.jpg","title":"八十四个场馆，近百种职业体验项目，让孩子实现长大后的理想","distance":"0","proName":"蓝天城儿童职业体验中心","proCity":"北京","viewCount":"55","miniPrice":"160"},{"productID":"24317","isCombined":"0","catalogID":"1","catalogName":"门票","imageUrl":"http://img.hifangjia.com:8999/images/md/group1/M00/0F/42/eBif6FdJP9aAX_DgAAB_QuOjfdk480.jpg","title":"北京KOKOMA航海主题乐园","distance":"0","proName":"北京KOKOMA航海主题乐园","proCity":"北京","viewCount":"104","miniPrice":"188"},{"productID":"24313","isCombined":"0","catalogID":"1","catalogName":"门票","imageUrl":"http://img.hifangjia.com:8999/images/md/group1/M00/0F/42/eBif6FdJP4KAKIAnAAAz9mylzkw229.jpg","title":"北京八大处富斯特滑道","distance":"0","proName":"北京八大处富斯特滑道","proCity":"北京","viewCount":"63","miniPrice":"20"},{"productID":"21945","isCombined":"0","catalogID":"1","catalogName":"门票","imageUrl":"http://img.hifangjia.com:8999/images/md/group1/M00/0D/3A/eBif6FdHx0yAIPdfAAEKBhKmuHE492.jpg","title":"金鹿家园","distance":"0","proName":"金鹿家园","proCity":"北京","viewCount":"117","miniPrice":"20"},{"productID":"21936","isCombined":"0","catalogID":"1","catalogName":"门票","imageUrl":"http://img.hifangjia.com:8999/images/md/group1/M01/0F/F9/eBif6FeDNrOAPrPGAAZUG-6c3uw334.jpg","title":"野鸭湖国家湿地公园","distance":"0","proName":"野鸭湖国家湿地公园","proCity":"北京","viewCount":"46","miniPrice":"45"},{"productID":"21914","isCombined":"0","catalogID":"1","catalogName":"门票","imageUrl":"http://img.hifangjia.com:8999/images/md/group1/M00/0D/37/eBif6FdHxY-AEG7bAABqIJuwHLM548.jpg","title":"世界公园","distance":"0","proName":"世界公园","proCity":"北京","viewCount":"54","miniPrice":"12"},{"productID":"21907","isCombined":"0","catalogID":"1","catalogName":"门票","imageUrl":"http://img.hifangjia.com:8999/images/md/group1/M00/0D/36/eBif6FdHxTSADw1xAABDQ-7mIqg401.jpg","title":"工体翻斗乐儿童乐园","distance":"0","proName":"工体翻斗乐儿童乐园","proCity":"北京","viewCount":"54","miniPrice":"55"}]}
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
         * totalRecord : 24
         * currentPage : 1
         * pageSize : 8
         * totalPage : 3
         * productList : [{"productID":"24322","isCombined":"0","catalogID":"1","catalogName":"门票","imageUrl":"http://img.hifangjia.com:8999/images/md/group1/M00/0F/43/eBif6FdJQFuANal6AABJqCfzinE901.jpg","title":"北京红螺湖鸟岛","distance":"0","proName":"北京红螺湖鸟岛","proCity":"北京","viewCount":"64","miniPrice":"18"},{"productID":"24320","isCombined":"0","catalogID":"1","catalogName":"门票","imageUrl":"http://img.hifangjia.com:8999/images/md/group1/M01/0F/F8/eBif6Fd99-WAHQnFAAOikNySs24740.jpg","title":"八十四个场馆，近百种职业体验项目，让孩子实现长大后的理想","distance":"0","proName":"蓝天城儿童职业体验中心","proCity":"北京","viewCount":"55","miniPrice":"160"},{"productID":"24317","isCombined":"0","catalogID":"1","catalogName":"门票","imageUrl":"http://img.hifangjia.com:8999/images/md/group1/M00/0F/42/eBif6FdJP9aAX_DgAAB_QuOjfdk480.jpg","title":"北京KOKOMA航海主题乐园","distance":"0","proName":"北京KOKOMA航海主题乐园","proCity":"北京","viewCount":"104","miniPrice":"188"},{"productID":"24313","isCombined":"0","catalogID":"1","catalogName":"门票","imageUrl":"http://img.hifangjia.com:8999/images/md/group1/M00/0F/42/eBif6FdJP4KAKIAnAAAz9mylzkw229.jpg","title":"北京八大处富斯特滑道","distance":"0","proName":"北京八大处富斯特滑道","proCity":"北京","viewCount":"63","miniPrice":"20"},{"productID":"21945","isCombined":"0","catalogID":"1","catalogName":"门票","imageUrl":"http://img.hifangjia.com:8999/images/md/group1/M00/0D/3A/eBif6FdHx0yAIPdfAAEKBhKmuHE492.jpg","title":"金鹿家园","distance":"0","proName":"金鹿家园","proCity":"北京","viewCount":"117","miniPrice":"20"},{"productID":"21936","isCombined":"0","catalogID":"1","catalogName":"门票","imageUrl":"http://img.hifangjia.com:8999/images/md/group1/M01/0F/F9/eBif6FeDNrOAPrPGAAZUG-6c3uw334.jpg","title":"野鸭湖国家湿地公园","distance":"0","proName":"野鸭湖国家湿地公园","proCity":"北京","viewCount":"46","miniPrice":"45"},{"productID":"21914","isCombined":"0","catalogID":"1","catalogName":"门票","imageUrl":"http://img.hifangjia.com:8999/images/md/group1/M00/0D/37/eBif6FdHxY-AEG7bAABqIJuwHLM548.jpg","title":"世界公园","distance":"0","proName":"世界公园","proCity":"北京","viewCount":"54","miniPrice":"12"},{"productID":"21907","isCombined":"0","catalogID":"1","catalogName":"门票","imageUrl":"http://img.hifangjia.com:8999/images/md/group1/M00/0D/36/eBif6FdHxTSADw1xAABDQ-7mIqg401.jpg","title":"工体翻斗乐儿童乐园","distance":"0","proName":"工体翻斗乐儿童乐园","proCity":"北京","viewCount":"54","miniPrice":"55"}]
         */

        private String totalRecord;
        private String currentPage;
        private String pageSize;
        private int totalPage;
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

        public int getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(int totalPage) {
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
             * productID : 24322
             * isCombined : 0
             * catalogID : 1
             * catalogName : 门票
             * imageUrl : http://img.hifangjia.com:8999/images/md/group1/M00/0F/43/eBif6FdJQFuANal6AABJqCfzinE901.jpg
             * title : 北京红螺湖鸟岛
             * distance : 0
             * proName : 北京红螺湖鸟岛
             * proCity : 北京
             * viewCount : 64
             * miniPrice : 18
             */

            private String productID;
            private String isCombined;
            private String catalogID;
            private String catalogName;
            private String imageUrl;
            private String title;
            private String distance;
            private String proName;
            private String proCity;
            private String viewCount;
            private String miniPrice;

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
        }
    }
}
