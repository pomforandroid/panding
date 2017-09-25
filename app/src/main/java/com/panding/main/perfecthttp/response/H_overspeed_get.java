package com.panding.main.perfecthttp.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/7/1.
 */

public class H_overspeed_get {

    /**
     * errcode : 0
     * Server : H
     * msg : 查找失败!
     * car_id : 066887679002
     * speed_max : 120
     * speed_min : 0
     */

    @SerializedName("errcode")
    private int errcode;
    @SerializedName("Server")
    private String Server;
    @SerializedName("msg")
    private String msg;
    @SerializedName("car_id")
    private String carId;
    @SerializedName("speed_max")
    private int speedMax;
    @SerializedName("speed_min")
    private int speedMin;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getServer() {
        return Server;
    }

    public void setServer(String Server) {
        this.Server = Server;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public int getSpeedMax() {
        return speedMax;
    }

    public void setSpeedMax(int speedMax) {
        this.speedMax = speedMax;
    }

    public int getSpeedMin() {
        return speedMin;
    }

    public void setSpeedMin(int speedMin) {
        this.speedMin = speedMin;
    }
}
