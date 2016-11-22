package com.renren.ruolan.travelaround.entity;

import cn.bmob.v3.BmobObject;

/**
 * Created by Administrator on 2016/11/22.
 *
 */

public class CmtInfo extends BmobObject {

    public CmtInfo() {
    }

    public CmtInfo(String commentID, String userImage , String content, String commentDate, String productID) {
        this.commentID = commentID;
        this.userImage = userImage;
        this.content = content;
        this.commentDate = commentDate;
        this.productID = productID;
    }



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
    private String productID;


    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

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
