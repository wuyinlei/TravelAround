package com.renren.ruolan.travelaround.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/11/22.
 */

public class ProductCmtData implements Serializable {


    /**
     * status : 0
     * result : {"totalRecord":"1","currentPage":"1","totalPage":"1","satisfaction":"0","commentTotal":"1","commentList":[{"commentID":"1030","userImage":"http://fjapi.chufadian.com/User/Account/image/youke/70.png","userName":"","mobile":"","star":"0","content":"刷身份证直接进入故宫，真是太方便省事了，不用排队，不用担心买不到票。故宫真是太大了，一天的时间只泛泛游览了不到一半的地方，皇宫已不复当年的光彩耀眼，但恢宏的气势仍令人叹服。","commentDate":"2016-07-20"}],"canComment":"False"}
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
         * totalRecord : 1
         * currentPage : 1
         * totalPage : 1
         * satisfaction : 0
         * commentTotal : 1
         * commentList : [{"commentID":"1030","userImage":"http://fjapi.chufadian.com/User/Account/image/youke/70.png","userName":"","mobile":"","star":"0","content":"刷身份证直接进入故宫，真是太方便省事了，不用排队，不用担心买不到票。故宫真是太大了，一天的时间只泛泛游览了不到一半的地方，皇宫已不复当年的光彩耀眼，但恢宏的气势仍令人叹服。","commentDate":"2016-07-20"}]
         * canComment : False
         */

        private String totalRecord;
        private String currentPage;
        private String totalPage;
        private String satisfaction;
        private String commentTotal;
        private String canComment;
        private List<CommentListEntity> commentList;

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

        public String getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(String totalPage) {
            this.totalPage = totalPage;
        }

        public String getSatisfaction() {
            return satisfaction;
        }

        public void setSatisfaction(String satisfaction) {
            this.satisfaction = satisfaction;
        }

        public String getCommentTotal() {
            return commentTotal;
        }

        public void setCommentTotal(String commentTotal) {
            this.commentTotal = commentTotal;
        }

        public String getCanComment() {
            return canComment;
        }

        public void setCanComment(String canComment) {
            this.canComment = canComment;
        }

        public List<CommentListEntity> getCommentList() {
            return commentList;
        }

        public void setCommentList(List<CommentListEntity> commentList) {
            this.commentList = commentList;
        }

        public static class CommentListEntity {
            /**
             * commentID : 1030
             * userImage : http://fjapi.chufadian.com/User/Account/image/youke/70.png
             * userName :
             * mobile :
             * star : 0
             * content : 刷身份证直接进入故宫，真是太方便省事了，不用排队，不用担心买不到票。故宫真是太大了，一天的时间只泛泛游览了不到一半的地方，皇宫已不复当年的光彩耀眼，但恢宏的气势仍令人叹服。
             * commentDate : 2016-07-20
             */

            private String commentID;
            private String userImage;
            private String userName;
            private String mobile;
            private String star;
            private String content;
            private String commentDate;

            public String getCommentID() {
                return commentID;
            }

            public void setCommentID(String commentID) {
                this.commentID = commentID;
            }

            public String getUserImage() {
                return userImage;
            }

            public void setUserImage(String userImage) {
                this.userImage = userImage;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getStar() {
                return star;
            }

            public void setStar(String star) {
                this.star = star;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getCommentDate() {
                return commentDate;
            }

            public void setCommentDate(String commentDate) {
                this.commentDate = commentDate;
            }
        }
    }
}
