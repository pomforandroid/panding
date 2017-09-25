package com.panding.main.perfecthttp.response;

/**
 * Created by Administrator on 2017/6/2.
 */

public class H_Location_last {

    /**
     * server : H
     * veh_type : 轿车
     * vehicle_num : 66887679002
     * sim : 66887679002
     * gps_time : 2017-06-30 08:31:02
     * rcv_time : 2017-06-30 09:23:01
     * lon : 113.04996490478516
     * lat : 22.601255416870117
     * speed : 0
     * direct : 72
     * mileage : 351.166
     * gps_flag : 0
     * guard : 0
     * vol : -1
     * guard_status : 运动设防(手动)
     * errcode : 0
     * msg : 查找成功!
     */

    private String server;
    private String veh_type;
    private String vehicle_num;
    private String sim;
    private String gps_time;
    private String rcv_time;
    private double lon;
    private double lat;
    private int speed;
    private int direct;
    private String mileage;
    private String gps_flag;
    private int guard;
    private double vol;
    private String guard_status;
    private int errcode;
    private String msg;

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getVeh_type() {
        return veh_type;
    }

    public void setVeh_type(String veh_type) {
        this.veh_type = veh_type;
    }

    public String getVehicle_num() {
        return vehicle_num;
    }

    public void setVehicle_num(String vehicle_num) {
        this.vehicle_num = vehicle_num;
    }

    public String getSim() {
        return sim;
    }

    public void setSim(String sim) {
        this.sim = sim;
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

    public int getGuard() {
        return guard;
    }

    public void setGuard(int guard) {
        this.guard = guard;
    }

    public double getVol() {
        return vol;
    }

    public void setVol(double vol) {
        this.vol = vol;
    }

    public String getGuard_status() {
        return guard_status;
    }

    public void setGuard_status(String guard_status) {
        this.guard_status = guard_status;
    }

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
}
