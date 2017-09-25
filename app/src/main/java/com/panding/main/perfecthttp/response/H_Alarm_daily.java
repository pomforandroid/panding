package com.panding.main.perfecthttp.response;

import java.util.List;

/**
 * Created by Administrator on 2017/6/2.
 */

public class H_Alarm_daily {

    /**
     * errcode : 0
     * server : new
     * msg : 查找成功
     * alarm_list : [{"alarm_type":"碰撞报警","lon":112.911376953125,"lat":22.769437789916992,"speed":0,"gps_flag":"0","direct":17,"alarm_time":"2017-05-26 16:14:53","update_time":"2017-05-26 16:14:53","status_des":100,"mileage":"0","oil_num":0},{"alarm_type":"碰撞报警","lon":112.911376953125,"lat":22.769445419311523,"speed":0,"gps_flag":"0","direct":17,"alarm_time":"2017-05-26 16:15:03","update_time":"2017-05-26 16:15:03","status_des":100,"mileage":"0","oil_num":0}]
     */

    private int errcode;
    private String server;
    private String msg;
    private List<AlarmListBean> alarm_list;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<AlarmListBean> getAlarm_list() {
        return alarm_list;
    }

    public void setAlarm_list(List<AlarmListBean> alarm_list) {
        this.alarm_list = alarm_list;
    }

    public static class AlarmListBean {
        /**
         * alarm_type : 碰撞报警
         * lon : 112.911376953125
         * lat : 22.769437789916992
         * speed : 0
         * gps_flag : 0
         * direct : 17
         * alarm_time : 2017-05-26 16:14:53
         * update_time : 2017-05-26 16:14:53
         * status_des : 100
         * mileage : 0
         * oil_num : 0
         */

        private String alarm_type;
        private double lon;
        private double lat;
        private int speed;
        private String gps_flag;
        private int direct;
        private String alarm_time;
        private String update_time;
        private int status_des;
        private String mileage;
        private int oil_num;

        public String getAlarm_type() {
            return alarm_type;
        }

        public void setAlarm_type(String alarm_type) {
            this.alarm_type = alarm_type;
        }

        public double getLon() {
            return lon;
        }

        public void setLon(double lon) {
            this.lon = lon;
        }

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public int getSpeed() {
            return speed;
        }

        public void setSpeed(int speed) {
            this.speed = speed;
        }

        public String getGps_flag() {
            return gps_flag;
        }

        public void setGps_flag(String gps_flag) {
            this.gps_flag = gps_flag;
        }

        public int getDirect() {
            return direct;
        }

        public void setDirect(int direct) {
            this.direct = direct;
        }

        public String getAlarm_time() {
            return alarm_time;
        }

        public void setAlarm_time(String alarm_time) {
            this.alarm_time = alarm_time;
        }

        public String getUpdate_time() {
            return update_time;
        }

        public void setUpdate_time(String update_time) {
            this.update_time = update_time;
        }

        public int getStatus_des() {
            return status_des;
        }

        public void setStatus_des(int status_des) {
            this.status_des = status_des;
        }

        public String getMileage() {
            return mileage;
        }

        public void setMileage(String mileage) {
            this.mileage = mileage;
        }

        public int getOil_num() {
            return oil_num;
        }

        public void setOil_num(int oil_num) {
            this.oil_num = oil_num;
        }
    }
}
