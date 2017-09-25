package com.panding.main.perfecthttp.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2017/7/18.
 */

public class Bd_alarm_daily {

    /**
     * errcode : 0
     * msg : 查找成功!
     * alarm_list : [{"cid":"015809176","lat":"22.555058","lng":"113.070786","olat":"22.5523538663634","olng":"113.076219700336","blat":"22.5582438100364","blng":"113.082733701992","spe":0,"hax":"235.460007","createtime":"2016-12-23 11:53:18","atype":"SOS报警"},{"cid":"015809176","lat":"22.555058","lng":"113.070786","olat":"22.5523538663634","olng":"113.076219700336","blat":"22.5582438100364","blng":"113.082733701992","spe":0,"hax":"235.460007","createtime":"2016-12-23 11:52:48","atype":"喇叭告警"},{"cid":"015809176","lat":"22.555070","lng":"113.070864","olat":"22.55236596253","olng":"113.076297823409","blat":"22.5582545946358","blng":"113.082812098542","spe":0,"hax":"78.230003","createtime":"2016-12-23 11:49:48","atype":"碰撞告警"},{"cid":"015809176","lat":"22.555070","lng":"113.070864","olat":"22.55236596253","olng":"113.076297823409","blat":"22.5582545946358","blng":"113.082812098542","spe":0,"hax":"78.230003","createtime":"2016-12-23 11:49:48","atype":"碰撞告警"},{"cid":"015809176","lat":"22.555015","lng":"113.071098","olat":"22.5523112418814","olng":"113.076532184844","blat":"22.5581959333625","blng":"113.08304719201","spe":0,"hax":"78.230003","createtime":"2016-12-23 11:48:43","atype":"SOS报警"}]
     */

    @SerializedName("errcode")
    private int errcode;
    @SerializedName("msg")
    private String msg;
    @SerializedName("alarm_list")
    private List<AlarmListBean> alarmList;

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

    public List<AlarmListBean> getAlarmList() {
        return alarmList;
    }

    public void setAlarmList(List<AlarmListBean> alarmList) {
        this.alarmList = alarmList;
    }

    public static class AlarmListBean {
        /**
         * cid : 015809176
         * lat : 22.555058
         * lng : 113.070786
         * olat : 22.5523538663634
         * olng : 113.076219700336
         * blat : 22.5582438100364
         * blng : 113.082733701992
         * spe : 0
         * hax : 235.460007
         * createtime : 2016-12-23 11:53:18
         * atype : SOS报警
         */

        @SerializedName("cid")
        private String cid;
        @SerializedName("lat")
        private String lat;
        @SerializedName("lng")
        private String lng;
        @SerializedName("olat")
        private String olat;
        @SerializedName("olng")
        private String olng;
        @SerializedName("blat")
        private String blat;
        @SerializedName("blng")
        private String blng;
        @SerializedName("spe")
        private int spe;
        @SerializedName("hax")
        private String hax;
        @SerializedName("createtime")
        private String createtime;
        @SerializedName("atype")
        private String atype;

        public String getCid() {
            return cid;
        }

        public void setCid(String cid) {
            this.cid = cid;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getLng() {
            return lng;
        }

        public void setLng(String lng) {
            this.lng = lng;
        }

        public String getOlat() {
            return olat;
        }

        public void setOlat(String olat) {
            this.olat = olat;
        }

        public String getOlng() {
            return olng;
        }

        public void setOlng(String olng) {
            this.olng = olng;
        }

        public String getBlat() {
            return blat;
        }

        public void setBlat(String blat) {
            this.blat = blat;
        }

        public String getBlng() {
            return blng;
        }

        public void setBlng(String blng) {
            this.blng = blng;
        }

        public int getSpe() {
            return spe;
        }

        public void setSpe(int spe) {
            this.spe = spe;
        }

        public String getHax() {
            return hax;
        }

        public void setHax(String hax) {
            this.hax = hax;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getAtype() {
            return atype;
        }

        public void setAtype(String atype) {
            this.atype = atype;
        }
    }
}
