package com.renren.ruolan.travelaround.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wuyinlei on 2016/11/19.
 */


public class DiscoveryArticleData implements Serializable {


    /**
     * status : 0
     * result : {"totalRecord":"60","currentPage":"1","pageSize":"8","totalPage":"8","articleList":[{"articleID":"60","imageUrl":"http://img.hifangjia.com:8999/images/ori/group1/M00/10/C7/eBif6FexPbeASNXGAAE0PUbBrGo727.jpg","title":"告别人挤人 这些小而美的地方在等你"},{"articleID":"59","imageUrl":"http://img.hifangjia.com:8999/images/ori/group1/M00/10/C7/eBif6FexPGiATRwPAAEx_RfjFM4274.jpg","title":"快上车 我们往西边去避暑"},{"articleID":"58","imageUrl":"http://img.hifangjia.com:8999/images/ori/group1/M01/10/C6/eBif6FexOqOAfr_iAAENQjqXhvQ552.jpg","title":"出国游需谨记的奇葩法律"},{"articleID":"57","imageUrl":"http://img.hifangjia.com:8999/images/ori/group1/M00/10/C6/eBif6FexOayAdB1sAADxNIopxrc319.jpg","title":"深圳周边的八大海岛 美到爆！"},{"articleID":"56","imageUrl":"http://img.hifangjia.com:8999/images/ori/group1/M01/10/C6/eBif6FexOQyAD0WjAAF0nwkCXIw610.jpg","title":"这六条自驾线路承包了全中国99%的美景"},{"articleID":"55","imageUrl":"http://img.hifangjia.com:8999/images/ori/group1/M01/10/C6/eBif6FexNuGAWmlzAAGXI8oVrRA562.jpg","title":"牵你手去这颗星球上最美的地方看看"},{"articleID":"54","imageUrl":"http://img.hifangjia.com:8999/images/ori/group1/M00/10/C6/eBif6FexNZKAeL-OAAFWHMYaD1E184.jpg","title":"来泡一泡广东十大最受欢迎温泉"},{"articleID":"53","imageUrl":"http://img.hifangjia.com:8999/images/ori/group1/M00/10/C6/eBif6FexMiiABNJVAAI3doJkBlY652.jpg","title":"适合广东人周末短途游的12个城市"}]}
     * message : 成功
     * errorcode :
     */

    private String status;
    /**
     * totalRecord : 60
     * currentPage : 1
     * pageSize : 8
     * totalPage : 8
     * articleList : [{"articleID":"60","imageUrl":"http://img.hifangjia.com:8999/images/ori/group1/M00/10/C7/eBif6FexPbeASNXGAAE0PUbBrGo727.jpg","title":"告别人挤人 这些小而美的地方在等你"},{"articleID":"59","imageUrl":"http://img.hifangjia.com:8999/images/ori/group1/M00/10/C7/eBif6FexPGiATRwPAAEx_RfjFM4274.jpg","title":"快上车 我们往西边去避暑"},{"articleID":"58","imageUrl":"http://img.hifangjia.com:8999/images/ori/group1/M01/10/C6/eBif6FexOqOAfr_iAAENQjqXhvQ552.jpg","title":"出国游需谨记的奇葩法律"},{"articleID":"57","imageUrl":"http://img.hifangjia.com:8999/images/ori/group1/M00/10/C6/eBif6FexOayAdB1sAADxNIopxrc319.jpg","title":"深圳周边的八大海岛 美到爆！"},{"articleID":"56","imageUrl":"http://img.hifangjia.com:8999/images/ori/group1/M01/10/C6/eBif6FexOQyAD0WjAAF0nwkCXIw610.jpg","title":"这六条自驾线路承包了全中国99%的美景"},{"articleID":"55","imageUrl":"http://img.hifangjia.com:8999/images/ori/group1/M01/10/C6/eBif6FexNuGAWmlzAAGXI8oVrRA562.jpg","title":"牵你手去这颗星球上最美的地方看看"},{"articleID":"54","imageUrl":"http://img.hifangjia.com:8999/images/ori/group1/M00/10/C6/eBif6FexNZKAeL-OAAFWHMYaD1E184.jpg","title":"来泡一泡广东十大最受欢迎温泉"},{"articleID":"53","imageUrl":"http://img.hifangjia.com:8999/images/ori/group1/M00/10/C6/eBif6FexMiiABNJVAAI3doJkBlY652.jpg","title":"适合广东人周末短途游的12个城市"}]
     */

    private ResultBean result;
    private String message;
    private String errorcode;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
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

    public static class ResultBean {
        private String totalRecord;
        private String currentPage;
        private String pageSize;
        private String totalPage;
        /**
         * articleID : 60
         * imageUrl : http://img.hifangjia.com:8999/images/ori/group1/M00/10/C7/eBif6FexPbeASNXGAAE0PUbBrGo727.jpg
         * title : 告别人挤人 这些小而美的地方在等你
         */

        private List<ArticleListBean> articleList;

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

        public List<ArticleListBean> getArticleList() {
            return articleList;
        }

        public void setArticleList(List<ArticleListBean> articleList) {
            this.articleList = articleList;
        }

        public static class ArticleListBean {
            private String articleID;
            private String imageUrl;
            private String title;

            public String getArticleID() {
                return articleID;
            }

            public void setArticleID(String articleID) {
                this.articleID = articleID;
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
        }
    }
}
