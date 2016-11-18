package com.renren.ruolan.travelaround.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/11/18.
 */

public class DiscoveryTagData implements Serializable {


    /**
     * status : 0
     * result : {"provinceID":"1","tagList":[{"classID":"60,68","title":"主题公园","code":"CG0005"},{"classID":"7,65","title":"亲子游","code":"CG0002"},{"classID":"4,10,66,70","title":"游山水","code":"CG0008"},{"classID":"45,3,8,59,6,53","title":"休闲观光","code":"CG0007"},{"classID":"11,1","title":"海边玩水","code":"CG0003"},{"classID":"5","title":"农家乐","code":"CG0006"},{"classID":"12","title":"漂流","code":"CG0009"},{"classID":"2","title":"泡温泉","code":"CG0004"}]}
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
         * provinceID : 1
         * tagList : [{"classID":"60,68","title":"主题公园","code":"CG0005"},{"classID":"7,65","title":"亲子游","code":"CG0002"},{"classID":"4,10,66,70","title":"游山水","code":"CG0008"},{"classID":"45,3,8,59,6,53","title":"休闲观光","code":"CG0007"},{"classID":"11,1","title":"海边玩水","code":"CG0003"},{"classID":"5","title":"农家乐","code":"CG0006"},{"classID":"12","title":"漂流","code":"CG0009"},{"classID":"2","title":"泡温泉","code":"CG0004"}]
         */

        private String provinceID;
        private List<TagListEntity> tagList;

        public String getProvinceID() {
            return provinceID;
        }

        public void setProvinceID(String provinceID) {
            this.provinceID = provinceID;
        }

        public List<TagListEntity> getTagList() {
            return tagList;
        }

        public void setTagList(List<TagListEntity> tagList) {
            this.tagList = tagList;
        }

        public static class TagListEntity {
            /**
             * classID : 60,68
             * title : 主题公园
             * code : CG0005
             */

            private String classID;
            private String title;
            private String code;

            public String getClassID() {
                return classID;
            }

            public void setClassID(String classID) {
                this.classID = classID;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }
        }
    }
}
