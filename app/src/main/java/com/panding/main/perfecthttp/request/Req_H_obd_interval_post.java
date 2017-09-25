package com.panding.main.perfecthttp.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/7/1.
 */

public class Req_H_obd_interval_post {


    /**
     * car_no : 66887679002
     * terminal_num : 331250
     * time : 1
     * interval : 2
     * device_code : 0304
     */

    @SerializedName("car_no")
    private String carNo;
    @SerializedName("terminal_num")
    private String terminalNum;
    @SerializedName("time")
    private String time;
    @SerializedName("interval")
    private String interval;
    @SerializedName("device_code")
    private String deviceCode;

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public String getTerminalNum() {
        return terminalNum;
    }

    public void setTerminalNum(String terminalNum) {
        this.terminalNum = terminalNum;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }
}
