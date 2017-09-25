package com.panding.main.perfecthttp.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/6/24.
 */

public class Operation_status {

    /**
     * Server : H
     * car_id : 013244936374
     * statue : 10
     * code : OPENDOOR
     * operationtime : 2014-05-25 16:29:13
     * ret : 完成
     * errcode : 0
     * msg : 查找成功!
     */

    @SerializedName("Server")
    private String Server;
    @SerializedName("car_id")
    private String carId;
    @SerializedName("statue")
    private int statue;
    @SerializedName("code")
    private String code;
    @SerializedName("operationtime")
    private String operationtime;
    @SerializedName("ret")
    private String ret;
    @SerializedName("errcode")
    private int errcode;
    @SerializedName("msg")
    private String msg;

    public String getServer() {
        return Server;
    }

    public void setServer(String Server) {
        this.Server = Server;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public int getStatue() {
        return statue;
    }

    public void setStatue(int statue) {
        this.statue = statue;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOperationtime() {
        return operationtime;
    }

    public void setOperationtime(String operationtime) {
        this.operationtime = operationtime;
    }

    public String getRet() {
        return ret;
    }

    public void setRet(String ret) {
        this.ret = ret;
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
