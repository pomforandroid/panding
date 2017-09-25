package com.panding.main.perfecthttp.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2017/7/24.
 */

public class H_Url_get {


    /**
     * errcode : 0
     * msg : 查询成功!
     * url : [{"loao_name":"mmexport1482483858126.jpg","upload_time":"2017-07-31  15:41:05.0","loao_type":"welcome","logo_url":"http://163.177.98.242:8080/pdlogo/2/mmexport1482483858126.jpg","html_url":"http://m.qiche4s.cn/100048681/cars_4068.html","user_id":"2"},{"loao_name":"volvo1.jpg","upload_time":"2017-07-31  15:41:27.0","loao_type":"welcome","logo_url":"http://163.177.98.242:8080/pdlogo/2/volvo1.jpg","html_url":"http://m.qiche4s.cn/100085951/cars_2145.html","user_id":"2"},{"loao_name":"volvo3.jpg","upload_time":"2017-07-31 15:41:33.0","loao_type":"welcome","logo_url":"http://163.177.98.242:8080/pdlogo/2/volvo3.jpg","html_url":"","user_id":"2"},{"loao_name":"XR-V1000px x 300px-01.jpg","upload_time":"2017-07-31 15:41:39.0","loao_type":"welcome","logo_url":"http://163.177.98.242:8080/pdlogo/2/XR-V1000px x 300px- 01.jpg","html_url":"http://m.qiche4s.cn/100030258/cars_4279.html","user_id":"2"},{"loao_name":"皇冠广告图.jpg","upload_time":"2017-07-31  15:41:43.0","loao_type":"welcome","logo_url":"http://163.177.98.242:8080/pdlogo/2/皇冠广告图.jpg","html_url":"http://m.qiche4s.cn/100026544/cars_2848.html","user_id":"2"},{"loao_name":"竞瑞1000px x 300px-01-01.jpg","upload_time":"2017-07-31 15:41:47.0","loao_type":"welcome","logo_url":"http://163.177.98.242:8080/pdlogo/2/竞瑞1000px x 300px-01- 01.jpg","html_url":"","user_id":"2"}]
     */

    @SerializedName("errcode")
    private int errcode;
    @SerializedName("msg")
    private String msg;
    @SerializedName("url")
    private List<UrlBean> url;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<UrlBean> getUrl() {
        return url;
    }

    public void setUrl(List<UrlBean> url) {
        this.url = url;
    }

    public static class UrlBean {
        /**
         * loao_name : mmexport1482483858126.jpg
         * upload_time : 2017-07-31  15:41:05.0
         * loao_type : welcome
         * logo_url : http://163.177.98.242:8080/pdlogo/2/mmexport1482483858126.jpg
         * html_url : http://m.qiche4s.cn/100048681/cars_4068.html
         * user_id : 2
         */

        @SerializedName("loao_name")
        private String loaoName;
        @SerializedName("upload_time")
        private String uploadTime;
        @SerializedName("loao_type")
        private String loaoType;
        @SerializedName("logo_url")
        private String logoUrl;
        @SerializedName("html_url")
        private String htmlUrl;
        @SerializedName("user_id")
        private String userId;

        public String getLoaoName() {
            return loaoName;
        }

        public void setLoaoName(String loaoName) {
            this.loaoName = loaoName;
        }

        public String getUploadTime() {
            return uploadTime;
        }

        public void setUploadTime(String uploadTime) {
            this.uploadTime = uploadTime;
        }

        public String getLoaoType() {
            return loaoType;
        }

        public void setLoaoType(String loaoType) {
            this.loaoType = loaoType;
        }

        public String getLogoUrl() {
            return logoUrl;
        }

        public void setLogoUrl(String logoUrl) {
            this.logoUrl = logoUrl;
        }

        public String getHtmlUrl() {
            return htmlUrl;
        }

        public void setHtmlUrl(String htmlUrl) {
            this.htmlUrl = htmlUrl;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
    }
}
