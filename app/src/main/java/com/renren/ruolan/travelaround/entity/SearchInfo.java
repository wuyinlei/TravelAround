package com.renren.ruolan.travelaround.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/11/25.
 */

public class SearchInfo implements Serializable {


    /**
     * status : 0
     * result : {"catalogList":[{"catalogID":"0","catalogName":"全部"},{"catalogID":"1","catalogName":"门票"},{"catalogID":"2","catalogName":"酒店"},{"catalogID":"3","catalogName":"游玩"},{"catalogID":"4","catalogName":"餐饮"},{"catalogID":"5","catalogName":"懒游"},{"catalogID":"74","catalogName":"跟团"}],"searchList":[{"key":"欢乐谷","title":"北京欢乐谷"},{"key":"故宫","title":"紫禁城"},{"key":"野生动物园","title":"动物园"},{"key":"温泉","title":"温泉"}]}
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
        private List<CatalogListEntity> catalogList;
        private List<SearchListEntity> searchList;

        public List<CatalogListEntity> getCatalogList() {
            return catalogList;
        }

        public void setCatalogList(List<CatalogListEntity> catalogList) {
            this.catalogList = catalogList;
        }

        public List<SearchListEntity> getSearchList() {
            return searchList;
        }

        public void setSearchList(List<SearchListEntity> searchList) {
            this.searchList = searchList;
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

        public static class SearchListEntity {
            /**
             * key : 欢乐谷
             * title : 北京欢乐谷
             */

            private String key;
            private String title;

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }
    }
}
