package com.panding.main.perfecthttp.response;

import java.util.List;

/**
 * Created by Administrator on 2017/5/31.
 */

public class Alarm_all {

    /**
     * errcode : 0
     * Alarm_All : [{"Server":"new","Alarmtype":"车辆劫持","Lon":"113.0665512084961","Lat":"22.614530563354492","Speed":"0","GPSFlag":"null","Direct":"191","GPSTime":"2015-09-16 09:42:17","RcvTime":"2015-09-16 09:42:17","StatusDes":"10","Mileage":"null","OilNum":"0"},{"Server":"new","Alarmtype":"车辆防盗器","Lon":"113.0665512084961","Lat":"22.614561080932617","Speed":"0","GPSFlag":"null","Direct":"191","GPSTime":"2015-09-16 09:42:43","RcvTime":"2015-09-16 09:42:43","StatusDes":"10","Mileage":"null","OilNum":"0"}]
     */

    private String errcode;
    private List<AlarmAllBean> Alarm_All;

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public List<AlarmAllBean> getAlarm_All() {
        return Alarm_All;
    }

    public void setAlarm_All(List<AlarmAllBean> Alarm_All) {
        this.Alarm_All = Alarm_All;
    }

    public static class AlarmAllBean {
        /**
         * Server : new
         * Alarmtype : 车辆劫持
         * Lon : 113.0665512084961
         * Lat : 22.614530563354492
         * Speed : 0
         * GPSFlag : null
         * Direct : 191
         * GPSTime : 2015-09-16 09:42:17
         * RcvTime : 2015-09-16 09:42:17
         * StatusDes : 10
         * Mileage : null
         * OilNum : 0
         */

        private String Server;
        private String Alarmtype;
        private String Lon;
        private String Lat;
        private String Speed;
        private String GPSFlag;
        private String Direct;
        private String GPSTime;
        private String RcvTime;
        private String StatusDes;
        private String Mileage;
        private String OilNum;

        public String getServer() {
            return Server;
        }

        public void setServer(String Server) {
            this.Server = Server;
        }

        public String getAlarmtype() {
            return Alarmtype;
        }

        public void setAlarmtype(String Alarmtype) {
            this.Alarmtype = Alarmtype;
        }

        public String getLon() {
            return Lon;
        }

        public void setLon(String Lon) {
            this.Lon = Lon;
        }

        public String getLat() {
            return Lat;
        }

        public void setLat(String Lat) {
            this.Lat = Lat;
        }

        public String getSpeed() {
            return Speed;
        }

        public void setSpeed(String Speed) {
            this.Speed = Speed;
        }

        public String getGPSFlag() {
            return GPSFlag;
        }

        public void setGPSFlag(String GPSFlag) {
            this.GPSFlag = GPSFlag;
        }

        public String getDirect() {
            return Direct;
        }

        public void setDirect(String Direct) {
            this.Direct = Direct;
        }

        public String getGPSTime() {
            return GPSTime;
        }

        public void setGPSTime(String GPSTime) {
            this.GPSTime = GPSTime;
        }

        public String getRcvTime() {
            return RcvTime;
        }

        public void setRcvTime(String RcvTime) {
            this.RcvTime = RcvTime;
        }

        public String getStatusDes() {
            return StatusDes;
        }

        public void setStatusDes(String StatusDes) {
            this.StatusDes = StatusDes;
        }

        public String getMileage() {
            return Mileage;
        }

        public void setMileage(String Mileage) {
            this.Mileage = Mileage;
        }

        public String getOilNum() {
            return OilNum;
        }

        public void setOilNum(String OilNum) {
            this.OilNum = OilNum;
        }
    }
}

