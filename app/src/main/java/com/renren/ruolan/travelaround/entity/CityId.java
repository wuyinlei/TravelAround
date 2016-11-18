package com.renren.ruolan.travelaround.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/11/18.
 */

public class CityId implements Serializable {

    /**
     * status : 0
     * result : {"hotCityList":[{"cityID":"18","cityName":"北京"},{"cityID":"107","cityName":"承德"},{"cityID":"45","cityName":"广州"},{"cityID":"47","cityName":"惠州"},{"cityID":"192","cityName":"南京"},{"cityID":"111","cityName":"秦皇岛"},{"cityID":"194","cityName":"苏州"},{"cityID":"56","cityName":"深圳"},{"cityID":"291","cityName":"上海"},{"cityID":"200","cityName":"扬州"},{"cityID":"115","cityName":"张家口"},{"cityID":"62","cityName":"珠海"}],"cityList":[{"cityID":"104","cityName":"三沙市"},{"cityID":"388","cityName":"韩城"},{"cityID":"338","cityName":"阿勒泰"},{"cityID":"314","cityName":"阿里"},{"cityID":"368","cityName":"澳门"},{"cityID":"116","cityName":"安阳"},{"cityID":"1","cityName":"安庆"},{"cityID":"77","cityName":"安顺"},{"cityID":"213","cityName":"鞍山"},{"cityID":"228","cityName":"阿拉善盟"},{"cityID":"292","cityName":"阿坝"},{"cityID":"281","cityName":"安康"},{"cityID":"321","cityName":"阿克苏"},{"cityID":"322","cityName":"阿拉尔"},{"cityID":"323","cityName":"巴音郭楞"},{"cityID":"324","cityName":"博尔塔拉"},{"cityID":"282","cityName":"宝鸡"},{"cityID":"293","cityName":"巴中"},{"cityID":"229","cityName":"巴彦淖尔市"},{"cityID":"230","cityName":"包头"},{"cityID":"214","cityName":"本溪"},{"cityID":"253","cityName":"滨州"},{"cityID":"179","cityName":"白城"},{"cityID":"180","cityName":"白山"},{"cityID":"78","cityName":"毕节"},{"cityID":"63","cityName":"百色"},{"cityID":"64","cityName":"北海"},{"cityID":"2","cityName":"蚌埠"},{"cityID":"18","cityName":"北京"},{"cityID":"28","cityName":"白银"},{"cityID":"86","cityName":"白沙"},{"cityID":"87","cityName":"保亭"},{"cityID":"105","cityName":"保定"},{"cityID":"339","cityName":"保山"},{"cityID":"340","cityName":"楚雄"},{"cityID":"315","cityName":"昌都"},{"cityID":"366","cityName":"重庆"},{"cityID":"106","cityName":"沧州"},{"cityID":"107","cityName":"承德"},{"cityID":"88","cityName":"昌江"},{"cityID":"89","cityName":"澄迈县"},{"cityID":"3","cityName":"巢湖"},{"cityID":"4","cityName":"池州"},{"cityID":"5","cityName":"滁州"},{"cityID":"65","cityName":"崇左"},{"cityID":"42","cityName":"潮州"},{"cityID":"181","cityName":"长春"},{"cityID":"165","cityName":"常德"},{"cityID":"166","cityName":"长沙"},{"cityID":"167","cityName":"郴州"},{"cityID":"188","cityName":"长白山"},{"cityID":"189","cityName":"常州"},{"cityID":"215","cityName":"朝阳"},{"cityID":"231","cityName":"赤峰"},{"cityID":"294","cityName":"成都"},{"cityID":"270","cityName":"长治"},{"cityID":"325","cityName":"昌吉"},{"cityID":"271","cityName":"大同"},{"cityID":"295","cityName":"达州"},{"cityID":"296","cityName":"德阳"},{"cityID":"216","cityName":"大连"},{"cityID":"217","cityName":"丹东"},{"cityID":"254","cityName":"德州"},{"cityID":"255","cityName":"东营"},{"cityID":"43","cityName":"东莞"},{"cityID":"29","cityName":"定西"},{"cityID":"90","cityName":"定安县"},{"cityID":"91","cityName":"东方"},{"cityID":"134","cityName":"大庆"},{"cityID":"135","cityName":"大兴安岭"},{"cityID":"341","cityName":"大理"},{"cityID":"342","cityName":"德宏"},{"cityID":"343","cityName":"迪庆"},{"cityID":"148","cityName":"鄂州"},{"cityID":"149","cityName":"恩施"},{"cityID":"232","cityName":"鄂尔多斯"},{"cityID":"218","cityName":"抚顺"},{"cityID":"219","cityName":"阜新"},{"cityID":"202","cityName":"抚州"},{"cityID":"19","cityName":"福州"},{"cityID":"6","cityName":"阜阳"},{"cityID":"44","cityName":"佛山"},{"cityID":"66","cityName":"防城港"},{"cityID":"67","cityName":"桂林"},{"cityID":"68","cityName":"贵港"},{"cityID":"79","cityName":"贵阳"},{"cityID":"45","cityName":"广州"},{"cityID":"30","cityName":"甘南"},{"cityID":"203","cityName":"赣州"},{"cityID":"297","cityName":"甘孜"},{"cityID":"298","cityName":"广安"},{"cityID":"299","cityName":"广元"},{"cityID":"245","cityName":"果洛"},{"cityID":"240","cityName":"固原"},{"cityID":"369","cityName":"高雄"},{"cityID":"370","cityName":"花莲"},{"cityID":"355","cityName":"杭州"},{"cityID":"356","cityName":"湖州"},{"cityID":"344","cityName":"红河"},{"cityID":"283","cityName":"汉中"},{"cityID":"326","cityName":"哈密"},{"cityID":"327","cityName":"和田"},{"cityID":"246","cityName":"海北"},{"cityID":"247","cityName":"海东"},{"cityID":"248","cityName":"海南藏族"},{"cityID":"249","cityName":"海西"},{"cityID":"250","cityName":"黄南"},{"cityID":"190","cityName":"淮安"},{"cityID":"168","cityName":"衡阳"},{"cityID":"169","cityName":"怀化"},{"cityID":"220","cityName":"葫芦岛"},{"cityID":"233","cityName":"呼和浩特"},{"cityID":"234","cityName":"呼伦贝尔"},{"cityID":"256","cityName":"菏泽"},{"cityID":"7","cityName":"合肥"},{"cityID":"8","cityName":"淮北"},{"cityID":"9","cityName":"淮南"},{"cityID":"10","cityName":"黄山"},{"cityID":"46","cityName":"河源"},{"cityID":"47","cityName":"惠州"},{"cityID":"69","cityName":"河池"},{"cityID":"70","cityName":"贺州"},{"cityID":"150","cityName":"黄冈"},{"cityID":"151","cityName":"黄石"},{"cityID":"136","cityName":"哈尔滨"},{"cityID":"137","cityName":"鹤岗"},{"cityID":"138","cityName":"黑河"},{"cityID":"108","cityName":"邯郸"},{"cityID":"109","cityName":"衡水"},{"cityID":"92","cityName":"海口"},{"cityID":"117","cityName":"鹤壁"},{"cityID":"118","cityName":"济源"},{"cityID":"119","cityName":"焦作"},{"cityID":"139","cityName":"鸡西"},{"cityID":"140","cityName":"佳木斯"},{"cityID":"152","cityName":"荆门"},{"cityID":"153","cityName":"荆州"},{"cityID":"48","cityName":"江门"},{"cityID":"49","cityName":"揭阳"},{"cityID":"31","cityName":"嘉峪关"},{"cityID":"32","cityName":"金昌"},{"cityID":"33","cityName":"酒泉"},{"cityID":"257","cityName":"济南"},{"cityID":"258","cityName":"济宁"},{"cityID":"221","cityName":"锦州"},{"cityID":"182","cityName":"吉林"},{"cityID":"204","cityName":"吉安"},{"cityID":"205","cityName":"景德镇"},{"cityID":"206","cityName":"九江"},{"cityID":"272","cityName":"晋城"},{"cityID":"273","cityName":"晋中"},{"cityID":"357","cityName":"嘉兴"},{"cityID":"358","cityName":"金华"},{"cityID":"371","cityName":"基隆"},{"cityID":"372","cityName":"嘉义"},{"cityID":"385","cityName":"金门"},{"cityID":"345","cityName":"昆明"},{"cityID":"328","cityName":"喀什"},{"cityID":"329","cityName":"克拉玛依"},{"cityID":"330","cityName":"克孜勒苏柯尔克孜"},{"cityID":"120","cityName":"开封"},{"cityID":"121","cityName":"洛阳"},{"cityID":"93","cityName":"乐东"},{"cityID":"94","cityName":"临高县"},{"cityID":"95","cityName":"陵水"},{"cityID":"110","cityName":"廊坊"},{"cityID":"34","cityName":"兰州"},{"cityID":"35","cityName":"临夏"},{"cityID":"36","cityName":"陇南"},{"cityID":"20","cityName":"龙岩"},{"cityID":"11","cityName":"六安"},{"cityID":"71","cityName":"来宾"},{"cityID":"72","cityName":"柳州"},{"cityID":"80","cityName":"六盘水"},{"cityID":"274","cityName":"临汾"},{"cityID":"275","cityName":"吕梁"},{"cityID":"300","cityName":"乐山"},{"cityID":"301","cityName":"凉山"},{"cityID":"191","cityName":"连云港"},{"cityID":"183","cityName":"辽源"},{"cityID":"170","cityName":"娄底"},{"cityID":"222","cityName":"辽阳"},{"cityID":"259","cityName":"莱芜"},{"cityID":"260","cityName":"聊城"},{"cityID":"261","cityName":"临沂"},{"cityID":"346","cityName":"丽江"},{"cityID":"347","cityName":"临沧"},{"cityID":"316","cityName":"拉萨"},{"cityID":"317","cityName":"林芝"},{"cityID":"359","cityName":"丽水"},{"cityID":"380","cityName":"苗栗"},{"cityID":"302","cityName":"眉山"},{"cityID":"303","cityName":"绵阳"},{"cityID":"50","cityName":"茂名"},{"cityID":"51","cityName":"梅州"},{"cityID":"12","cityName":"马鞍山"},{"cityID":"141","cityName":"牡丹江"},{"cityID":"122","cityName":"南阳"},{"cityID":"21","cityName":"南平"},{"cityID":"22","cityName":"宁德"},{"cityID":"73","cityName":"南宁"},{"cityID":"304","cityName":"南充"},{"cityID":"305","cityName":"内江"},{"cityID":"192","cityName":"南京"},{"cityID":"193","cityName":"南通"},{"cityID":"207","cityName":"南昌"},{"cityID":"382","cityName":"南投"},{"cityID":"360","cityName":"宁波"},{"cityID":"318","cityName":"那曲"},{"cityID":"348","cityName":"怒江"},{"cityID":"350","cityName":"普洱"},{"cityID":"386","cityName":"澎湖"},{"cityID":"384","cityName":"屏东"},{"cityID":"208","cityName":"萍乡"},{"cityID":"223","cityName":"盘锦"},{"cityID":"306","cityName":"攀枝花"},{"cityID":"23","cityName":"莆田"},{"cityID":"37","cityName":"平凉"},{"cityID":"123","cityName":"平顶山"},{"cityID":"96","cityName":"琼海"},{"cityID":"97","cityName":"琼中"},{"cityID":"142","cityName":"七台河"},{"cityID":"143","cityName":"齐齐哈尔"},{"cityID":"111","cityName":"秦皇岛"},{"cityID":"154","cityName":"潜江"},{"cityID":"38","cityName":"庆阳"},{"cityID":"24","cityName":"泉州"},{"cityID":"74","cityName":"钦州"},{"cityID":"81","cityName":"黔东南"},{"cityID":"82","cityName":"黔南"},{"cityID":"83","cityName":"黔西南"},{"cityID":"52","cityName":"清远"},{"cityID":"262","cityName":"青岛"},{"cityID":"349","cityName":"曲靖"},{"cityID":"319","cityName":"日喀则"},{"cityID":"263","cityName":"日照"},{"cityID":"224","cityName":"沈阳"},{"cityID":"209","cityName":"上饶"},{"cityID":"194","cityName":"苏州"},{"cityID":"195","cityName":"宿迁"},{"cityID":"171","cityName":"邵阳"},{"cityID":"184","cityName":"四平"},{"cityID":"185","cityName":"松原"},{"cityID":"307","cityName":"遂宁"},{"cityID":"276","cityName":"朔州"},{"cityID":"331","cityName":"石河子"},{"cityID":"284","cityName":"商洛"},{"cityID":"241","cityName":"石嘴山"},{"cityID":"291","cityName":"上海"},{"cityID":"53","cityName":"汕头"},{"cityID":"54","cityName":"汕尾"},{"cityID":"55","cityName":"韶关"},{"cityID":"56","cityName":"深圳"},{"cityID":"25","cityName":"三明"},{"cityID":"13","cityName":"宿州"},{"cityID":"155","cityName":"神农架林区"},{"cityID":"156","cityName":"十堰"},{"cityID":"157","cityName":"随州"},{"cityID":"112","cityName":"石家庄"},{"cityID":"144","cityName":"双鸭山"},{"cityID":"145","cityName":"绥化"},{"cityID":"98","cityName":"三亚"},{"cityID":"124","cityName":"三门峡"},{"cityID":"125","cityName":"商丘"},{"cityID":"320","cityName":"山南"},{"cityID":"361","cityName":"绍兴"},{"cityID":"362","cityName":"台州"},{"cityID":"373","cityName":"台北"},{"cityID":"374","cityName":"台东"},{"cityID":"375","cityName":"台南"},{"cityID":"376","cityName":"台中"},{"cityID":"337","cityName":"塔城"},{"cityID":"379","cityName":"桃园"},{"cityID":"99","cityName":"屯昌县"},{"cityID":"113","cityName":"唐山"},{"cityID":"158","cityName":"天门"},{"cityID":"14","cityName":"铜陵"},{"cityID":"39","cityName":"天水"},{"cityID":"84","cityName":"铜仁"},{"cityID":"313","cityName":"天津"},{"cityID":"285","cityName":"铜川"},{"cityID":"332","cityName":"图木舒克"},{"cityID":"333","cityName":"吐鲁番"},{"cityID":"277","cityName":"太原"},{"cityID":"186","cityName":"通化"},{"cityID":"196","cityName":"泰州"},{"cityID":"225","cityName":"铁岭"},{"cityID":"235","cityName":"通辽"},{"cityID":"264","cityName":"泰安"},{"cityID":"265","cityName":"威海"},{"cityID":"266","cityName":"潍坊"},{"cityID":"236","cityName":"乌海"},{"cityID":"237","cityName":"乌兰察布市"},{"cityID":"197","cityName":"无锡"},{"cityID":"334","cityName":"乌鲁木齐"},{"cityID":"335","cityName":"五家渠"},{"cityID":"286","cityName":"渭南"},{"cityID":"147","cityName":"乌苏里江"},{"cityID":"242","cityName":"吴忠"},{"cityID":"75","cityName":"梧州"},{"cityID":"40","cityName":"武威"},{"cityID":"15","cityName":"芜湖"},{"cityID":"159","cityName":"武汉"},{"cityID":"100","cityName":"万宁"},{"cityID":"101","cityName":"文昌"},{"cityID":"102","cityName":"五指山"},{"cityID":"363","cityName":"温州"},{"cityID":"351","cityName":"文山"},{"cityID":"352","cityName":"西双版纳"},{"cityID":"377","cityName":"新竹"},{"cityID":"367","cityName":"香港"},{"cityID":"387","cityName":"新北"},{"cityID":"126","cityName":"新乡"},{"cityID":"127","cityName":"信阳"},{"cityID":"128","cityName":"许昌"},{"cityID":"160","cityName":"仙桃"},{"cityID":"161","cityName":"咸宁"},{"cityID":"162","cityName":"襄阳"},{"cityID":"163","cityName":"孝感"},{"cityID":"114","cityName":"邢台"},{"cityID":"16","cityName":"宣城"},{"cityID":"26","cityName":"厦门"},{"cityID":"227","cityName":"兴城"},{"cityID":"287","cityName":"西安"},{"cityID":"288","cityName":"咸阳"},{"cityID":"278","cityName":"忻州"},{"cityID":"251","cityName":"西宁"},{"cityID":"198","cityName":"徐州"},{"cityID":"210","cityName":"新余"},{"cityID":"172","cityName":"湘潭"},{"cityID":"173","cityName":"湘西"},{"cityID":"238","cityName":"锡林郭勒盟"},{"cityID":"239","cityName":"兴安盟"},{"cityID":"226","cityName":"营口"},{"cityID":"267","cityName":"烟台"},{"cityID":"174","cityName":"益阳"},{"cityID":"175","cityName":"永州"},{"cityID":"176","cityName":"岳阳"},{"cityID":"187","cityName":"延边"},{"cityID":"211","cityName":"宜春"},{"cityID":"212","cityName":"鹰潭"},{"cityID":"199","cityName":"盐城"},{"cityID":"200","cityName":"扬州"},{"cityID":"252","cityName":"玉树"},{"cityID":"279","cityName":"阳泉"},{"cityID":"280","cityName":"运城"},{"cityID":"308","cityName":"雅安"},{"cityID":"309","cityName":"宜宾"},{"cityID":"289","cityName":"延安"},{"cityID":"290","cityName":"榆林"},{"cityID":"243","cityName":"银川"},{"cityID":"336","cityName":"伊犁"},{"cityID":"76","cityName":"玉林"},{"cityID":"57","cityName":"阳江"},{"cityID":"58","cityName":"云浮"},{"cityID":"146","cityName":"伊春"},{"cityID":"164","cityName":"宜昌"},{"cityID":"383","cityName":"云林"},{"cityID":"378","cityName":"宜兰"},{"cityID":"353","cityName":"玉溪"},{"cityID":"354","cityName":"昭通"},{"cityID":"364","cityName":"舟山"},{"cityID":"365","cityName":"衢州"},{"cityID":"381","cityName":"彰化"},{"cityID":"115","cityName":"张家口"},{"cityID":"129","cityName":"郑州"},{"cityID":"130","cityName":"周口"},{"cityID":"131","cityName":"驻马店"},{"cityID":"132","cityName":"漯河"},{"cityID":"133","cityName":"濮阳"},{"cityID":"103","cityName":"儋州"},{"cityID":"59","cityName":"湛江"},{"cityID":"60","cityName":"肇庆"},{"cityID":"61","cityName":"中山"},{"cityID":"62","cityName":"珠海"},{"cityID":"85","cityName":"遵义"},{"cityID":"27","cityName":"漳州"},{"cityID":"41","cityName":"张掖"},{"cityID":"17","cityName":"亳州"},{"cityID":"244","cityName":"中卫"},{"cityID":"310","cityName":"资阳"},{"cityID":"311","cityName":"自贡"},{"cityID":"312","cityName":"泸州"},{"cityID":"201","cityName":"镇江"},{"cityID":"177","cityName":"张家界"},{"cityID":"178","cityName":"株洲"},{"cityID":"268","cityName":"枣庄"},{"cityID":"269","cityName":"淄博"}]}
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
        private List<HotCityListEntity> hotCityList;
        private List<CityListEntity> cityList;

        public List<HotCityListEntity> getHotCityList() {
            return hotCityList;
        }

        public void setHotCityList(List<HotCityListEntity> hotCityList) {
            this.hotCityList = hotCityList;
        }

        public List<CityListEntity> getCityList() {
            return cityList;
        }

        public void setCityList(List<CityListEntity> cityList) {
            this.cityList = cityList;
        }

        public static class HotCityListEntity {
            /**
             * cityID : 18
             * cityName : 北京
             */

            private String cityID;
            private String cityName;

            public String getCityID() {
                return cityID;
            }

            public void setCityID(String cityID) {
                this.cityID = cityID;
            }

            public String getCityName() {
                return cityName;
            }

            public void setCityName(String cityName) {
                this.cityName = cityName;
            }
        }

        public static class CityListEntity {
            /**
             * cityID : 104
             * cityName : 三沙市
             */

            private String cityID;
            private String cityName;

            public String getCityID() {
                return cityID;
            }

            public void setCityID(String cityID) {
                this.cityID = cityID;
            }

            public String getCityName() {
                return cityName;
            }

            public void setCityName(String cityName) {
                this.cityName = cityName;
            }
        }
    }
}
