package com.panding.main.perfecthttp.response;

import java.util.List;

/**
 * Created by Administrator on 2017/6/7.
 */

public class H_Location_history {

    /**
     * errcode : 0
     * msg : 查找成功
     * location_list : [{"server":"H","gps_time":"2017-05-30 10:04:26","rcv_time":"2017-05-30 10:04:42","lon":110.631103515625,"lat":21.643075942993164,"speed":29,"direct":308,"mileage":"51225.27","gps_flag":"0"},{"server":"H","gps_time":"2017-05-30 10:04:56","rcv_time":"2017-05-30 10:05:13","lon":110.6316146850586,"lat":21.644363403320312,"speed":29,"direct":298,"mileage":"51225.506","gps_flag":"0"},{"server":"H","gps_time":"2017-05-30 10:05:27","rcv_time":"2017-05-30 10:05:45","lon":110.62962341308594,"lat":21.645294189453125,"speed":23,"direct":301,"mileage":"51225.86","gps_flag":"0"},{"server":"H","gps_time":"2017-05-30 10:05:57","rcv_time":"2017-05-30 10:06:18","lon":110.62805938720703,"lat":21.64604949951172,"speed":16,"direct":302,"mileage":"51226.172","gps_flag":"0"},{"server":"H","gps_time":"2017-05-30 10:06:27","rcv_time":"2017-05-30 10:06:44","lon":110.6270751953125,"lat":21.64661979675293,"speed":11,"direct":324,"mileage":"51226.324","gps_flag":"0"}]
     */

    private int errcode;
    private String msg;
    private List<LocationListBean> location_list;

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

    public List<LocationListBean> getLocation_list() {
        return location_list;
    }

    public void setLocation_list(List<LocationListBean> location_list) {
        this.location_list = location_list;
    }

    public static class LocationListBean {
        /**
         * server : H
         * gps_time : 2017-05-30 10:04:26
         * rcv_time : 2017-05-30 10:04:42
         * lon : 110.631103515625
         * lat : 21.643075942993164
         * speed : 29
         * direct : 308
         * mileage : 51225.27
         * gps_flag : 0
         */

        private String server;
        private String gps_time;
        private String rcv_time;
        private double lon;
        private double lat;
        private int speed;
        private int direct;
        private String mileage;
        private String gps_flag;

        public String getServer() {
            return server;
        }

        public void setServer(String server) {
            this.server = server;
        }

        public String getGps_time() {
            return gps_time;
        }

        public void setGps_time(String gps_time) {
            this.gps_time = gps_time;
        }

        public String getRcv_time() {
            return rcv_time;
        }

        public void setRcv_time(String rcv_time) {
            this.rcv_time = rcv_time;
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

        public int getDirect() {
            return direct;
        }

        public void setDirect(int direct) {
            this.direct = direct;
        }

        public String getMileage() {
            return mileage;
        }

        public void setMileage(String mileage) {
            this.mileage = mileage;
        }

        public String getGps_flag() {
            return gps_flag;
        }

        public void setGps_flag(String gps_flag) {
            this.gps_flag = gps_flag;
        }
    }
}
