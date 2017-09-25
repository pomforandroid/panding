package com.panding.main.perfecthttp.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2017/8/1.
 */

public class Bd_url_get {

    /**
     * errcode : 0
     * msg : 查询成功!
     * url : [{"loao_name":"sfddeee.JPEG","upload_time":"2017-08-01 17:46:58.0","loao_type":"welcome","logo_url":"http://163.177.98.242:8080/pdlogo/6/sfddeee.JPEG","html_url":"","user_id":"6"}]
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
         * loao_name : sfddeee.JPEG
         * upload_time : 2017-08-01 17:46:58.0
         * loao_type : welcome
         * logo_url : http://163.177.98.242:8080/pdlogo/6/sfddeee.JPEG
         * html_url :
         * user_id : 6
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
