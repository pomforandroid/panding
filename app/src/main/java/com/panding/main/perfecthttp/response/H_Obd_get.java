package com.panding.main.perfecthttp.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/6/16.
 */

public class H_Obd_get {


    /**
     * car_id : 066887679001
     * keytime : 0
     * vehideid : 331249
     * ip : 117.136.42.229
     * updatetime : 2017-07-14 09:22:48
     * datetime : 1970-01-01 08:00:00
     * vol : 12.2
     * rpm : 4517
     * speed : 121
     * throttle : 7.06
     * engine_load : 21.96
     * temp : -22
     * avg_oil : 20.16
     * mil : 6.5
     * total_mil : 6.5
     * instant_oil : 0.01
     * cur_oil : 1.31
     * total_oil : 1.31
     * error_num : 0
     * speed_up : 0
     * speed_down : 0
     * error_code : 空
     * msg : 查找成功!
     * errcode : 0
     */

    @SerializedName("car_id")
    private String carId;
    @SerializedName("keytime")
    private int keytime;
    @SerializedName("vehideid")
    private int vehideid;
    @SerializedName("ip")
    private String ip;
    @SerializedName("updatetime")
    private String updatetime;
    @SerializedName("datetime")
    private String datetime;
    @SerializedName("vol")
    private double vol;
    @SerializedName("rpm")
    private int rpm;
    @SerializedName("speed")
    private int speed;
    @SerializedName("throttle")
    private double throttle;
    @SerializedName("engine_load")
    private double engineLoad;
    @SerializedName("temp")
    private int temp;
    @SerializedName("avg_oil")
    private double avgOil;
    @SerializedName("mil")
    private double mil;
    @SerializedName("total_mil")
    private double totalMil;
    @SerializedName("instant_oil")
    private double instantOil;
    @SerializedName("cur_oil")
    private double curOil;
    @SerializedName("total_oil")
    private double totalOil;
    @SerializedName("error_num")
    private int errorNum;
    @SerializedName("speed_up")
    private int speedUp;
    @SerializedName("speed_down")
    private int speedDown;
    @SerializedName("error_code")
    private String errorCode;
    @SerializedName("msg")
    private String msg;
    @SerializedName("errcode")
    private int errcode;

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public int getKeytime() {
        return keytime;
    }

    public void setKeytime(int keytime) {
        this.keytime = keytime;
    }

    public int getVehideid() {
        return vehideid;
    }

    public void setVehideid(int vehideid) {
        this.vehideid = vehideid;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public double getVol() {
        return vol;
    }

    public void setVol(double vol) {
        this.vol = vol;
    }

    public int getRpm() {
        return rpm;
    }

    public void setRpm(int rpm) {
        this.rpm = rpm;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getThrottle() {
        return throttle;
    }

    public void setThrottle(double throttle) {
        this.throttle = throttle;
    }

    public double getEngineLoad() {
        return engineLoad;
    }

    public void setEngineLoad(double engineLoad) {
        this.engineLoad = engineLoad;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public double getAvgOil() {
        return avgOil;
    }

    public void setAvgOil(double avgOil) {
        this.avgOil = avgOil;
    }

    public double getMil() {
        return mil;
    }

    public void setMil(double mil) {
        this.mil = mil;
    }

    public double getTotalMil() {
        return totalMil;
    }

    public void setTotalMil(double totalMil) {
        this.totalMil = totalMil;
    }

    public double getInstantOil() {
        return instantOil;
    }

    public void setInstantOil(double instantOil) {
        this.instantOil = instantOil;
    }

    public double getCurOil() {
        return curOil;
    }

    public void setCurOil(double curOil) {
        this.curOil = curOil;
    }

    public double getTotalOil() {
        return totalOil;
    }

    public void setTotalOil(double totalOil) {
        this.totalOil = totalOil;
    }

    public int getErrorNum() {
        return errorNum;
    }

    public void setErrorNum(int errorNum) {
        this.errorNum = errorNum;
    }

    public int getSpeedUp() {
        return speedUp;
    }

    public void setSpeedUp(int speedUp) {
        this.speedUp = speedUp;
    }

    public int getSpeedDown() {
        return speedDown;
    }

    public void setSpeedDown(int speedDown) {
        this.speedDown = speedDown;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }
}
