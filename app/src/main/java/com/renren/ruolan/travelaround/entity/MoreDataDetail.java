package com.renren.ruolan.travelaround.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/11/18.
 */

public class MoreDataDetail implements Serializable {

    /**
     * status : 0
     * result : {"hasRoute":"False","detailList":[{"content":"北京顺景温泉泉眼位于北京市朝阳区四环内四元桥附近的顺景园内，是集特色温泉于一身的温泉水世界。温泉建筑总面积为9.8万平方米。泉眼深度约为3500米，平均日出水量达到4000立方米。\n\n顺景温泉水世界，建筑面积 9.8万平方米，共设有96个造型各异温泉泡池，可容纳5000人同时享用。室内外温泉池相互衔接，清池湖泊、小桥流水...充满着神秘色彩，给人以原始丛林的生态之美。 \n\n北京顺景温泉酒店主要由三大部分组成：酒店餐厅、客房部分；贵宾会所部分；水世界部分。\n\n酒店餐厅、客房部分：酒店餐厅由中餐厅、宴会厅、西餐厅、日餐厅构成，集国内、外各类美食于一体，可同时接纳600人用餐；北京顺景温泉酒店大堂由总服务台、商务中心、商场构成，可满足一系列商务活动及购买国际、国内流行商品；酒店商务会议室可满足各类会议需求。","imgList":["http://img.hifangjia.com:8999/images/ori/group1/M00/0D/37/eBif6FdHxbyAHFpfAAGifqRWd3c023.jpg"]},{"content":"水世界部分 水世界前厅由商场、休闲区、总服务台、观景台、商务中心等项目构成；嬉水区由室内外温泉嬉水、药王谷、男女宾浴区等项目构成；水世界餐厅休闲区域由大型广式自助餐厅、英美式桌球、美容美发、棋牌室、沐足区、网吧、休息大厅、电影厅、睡眠厅、芳香SPA等项目构成。","imgList":["http://img.hifangjia.com:8999/images/ori/group1/M00/0D/37/eBif6FdHxbyAb4SnAAGyS7i9SnE284.jpg"]},{"content":"沐足及日式汤屋 沐足及日式汤屋","imgList":["http://img.hifangjia.com:8999/images/ori/group1/M00/0D/37/eBif6FdHxb2AdP7_AAHrrfHE9y4188.jpg","http://img.hifangjia.com:8999/images/ori/group1/M00/0D/37/eBif6FdHxb2AEuctAACcOU3J48M458.jpg"]},{"content":"溶洞及药王谷 顺景温泉水取自地下基岩深处，洁净无污染，水质滑腻。此类高矿质含量的温泉水在北京并不多见，极其珍贵。奢华大气的酒店大堂，宽敞明亮的室内空间，让每一位下踏者尊享荣华与高贵；室内温泉区，环境优美、景色怡人，雕栏画栋、金碧辉煌下的温泉泡池更显得优雅端庄；享受沐浴温泉的意境，品位花拥绿绕的芬芳。","imgList":["http://img.hifangjia.com:8999/images/ori/group1/M00/0D/37/eBif6FdHxb2AZ7f_AADVb0k1pc8067.jpg","http://img.hifangjia.com:8999/images/ori/group1/M00/0D/37/eBif6FdHxb2AP7v7AACdWVGKXBI771.jpg"]},{"content":"温泉池 温泉池","imgList":["http://img.hifangjia.com:8999/images/ori/group1/M00/0D/37/eBif6FdHxb6AQpYOAADJ4hIsn9g013.jpg","http://img.hifangjia.com:8999/images/ori/group1/M00/0D/37/eBif6FdHxb6ASafIAAH0iYz8mT0013.jpg"]},{"content":"","imgList":["http://img.hifangjia.com:8999/images/ori/group1/M00/0D/37/eBif6FdHxb6AYjR_AAJJnN7hwx0678.jpg"]}]}
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
         * hasRoute : False
         * detailList : [{"content":"北京顺景温泉泉眼位于北京市朝阳区四环内四元桥附近的顺景园内，是集特色温泉于一身的温泉水世界。温泉建筑总面积为9.8万平方米。泉眼深度约为3500米，平均日出水量达到4000立方米。\n\n顺景温泉水世界，建筑面积 9.8万平方米，共设有96个造型各异温泉泡池，可容纳5000人同时享用。室内外温泉池相互衔接，清池湖泊、小桥流水...充满着神秘色彩，给人以原始丛林的生态之美。 \n\n北京顺景温泉酒店主要由三大部分组成：酒店餐厅、客房部分；贵宾会所部分；水世界部分。\n\n酒店餐厅、客房部分：酒店餐厅由中餐厅、宴会厅、西餐厅、日餐厅构成，集国内、外各类美食于一体，可同时接纳600人用餐；北京顺景温泉酒店大堂由总服务台、商务中心、商场构成，可满足一系列商务活动及购买国际、国内流行商品；酒店商务会议室可满足各类会议需求。","imgList":["http://img.hifangjia.com:8999/images/ori/group1/M00/0D/37/eBif6FdHxbyAHFpfAAGifqRWd3c023.jpg"]},{"content":"水世界部分 水世界前厅由商场、休闲区、总服务台、观景台、商务中心等项目构成；嬉水区由室内外温泉嬉水、药王谷、男女宾浴区等项目构成；水世界餐厅休闲区域由大型广式自助餐厅、英美式桌球、美容美发、棋牌室、沐足区、网吧、休息大厅、电影厅、睡眠厅、芳香SPA等项目构成。","imgList":["http://img.hifangjia.com:8999/images/ori/group1/M00/0D/37/eBif6FdHxbyAb4SnAAGyS7i9SnE284.jpg"]},{"content":"沐足及日式汤屋 沐足及日式汤屋","imgList":["http://img.hifangjia.com:8999/images/ori/group1/M00/0D/37/eBif6FdHxb2AdP7_AAHrrfHE9y4188.jpg","http://img.hifangjia.com:8999/images/ori/group1/M00/0D/37/eBif6FdHxb2AEuctAACcOU3J48M458.jpg"]},{"content":"溶洞及药王谷 顺景温泉水取自地下基岩深处，洁净无污染，水质滑腻。此类高矿质含量的温泉水在北京并不多见，极其珍贵。奢华大气的酒店大堂，宽敞明亮的室内空间，让每一位下踏者尊享荣华与高贵；室内温泉区，环境优美、景色怡人，雕栏画栋、金碧辉煌下的温泉泡池更显得优雅端庄；享受沐浴温泉的意境，品位花拥绿绕的芬芳。","imgList":["http://img.hifangjia.com:8999/images/ori/group1/M00/0D/37/eBif6FdHxb2AZ7f_AADVb0k1pc8067.jpg","http://img.hifangjia.com:8999/images/ori/group1/M00/0D/37/eBif6FdHxb2AP7v7AACdWVGKXBI771.jpg"]},{"content":"温泉池 温泉池","imgList":["http://img.hifangjia.com:8999/images/ori/group1/M00/0D/37/eBif6FdHxb6AQpYOAADJ4hIsn9g013.jpg","http://img.hifangjia.com:8999/images/ori/group1/M00/0D/37/eBif6FdHxb6ASafIAAH0iYz8mT0013.jpg"]},{"content":"","imgList":["http://img.hifangjia.com:8999/images/ori/group1/M00/0D/37/eBif6FdHxb6AYjR_AAJJnN7hwx0678.jpg"]}]
         */

        private String hasRoute;
        private List<DetailListEntity> detailList;

        public String getHasRoute() {
            return hasRoute;
        }

        public void setHasRoute(String hasRoute) {
            this.hasRoute = hasRoute;
        }

        public List<DetailListEntity> getDetailList() {
            return detailList;
        }

        public void setDetailList(List<DetailListEntity> detailList) {
            this.detailList = detailList;
        }

        public static class DetailListEntity {
            /**
             * content : 北京顺景温泉泉眼位于北京市朝阳区四环内四元桥附近的顺景园内，是集特色温泉于一身的温泉水世界。温泉建筑总面积为9.8万平方米。泉眼深度约为3500米，平均日出水量达到4000立方米。

             顺景温泉水世界，建筑面积 9.8万平方米，共设有96个造型各异温泉泡池，可容纳5000人同时享用。室内外温泉池相互衔接，清池湖泊、小桥流水...充满着神秘色彩，给人以原始丛林的生态之美。

             北京顺景温泉酒店主要由三大部分组成：酒店餐厅、客房部分；贵宾会所部分；水世界部分。

             酒店餐厅、客房部分：酒店餐厅由中餐厅、宴会厅、西餐厅、日餐厅构成，集国内、外各类美食于一体，可同时接纳600人用餐；北京顺景温泉酒店大堂由总服务台、商务中心、商场构成，可满足一系列商务活动及购买国际、国内流行商品；酒店商务会议室可满足各类会议需求。
             * imgList : ["http://img.hifangjia.com:8999/images/ori/group1/M00/0D/37/eBif6FdHxbyAHFpfAAGifqRWd3c023.jpg"]
             */

            private String content;
            private List<String> imgList;

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public List<String> getImgList() {
                return imgList;
            }

            public void setImgList(List<String> imgList) {
                this.imgList = imgList;
            }
        }
    }
}
