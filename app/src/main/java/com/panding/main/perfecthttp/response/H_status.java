package com.panding.main.perfecthttp.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2017/6/24.
 */

public class H_status {


    /**
     * ret : [{"car_info":"<img src='/bg/car/3.png' style='vertical-align:middle;'> 点火关"}]
     * msg : 查找成功
     * errcode : 0
     * car_status : 点火关
     */

    @SerializedName("msg")
    private String msg;
    @SerializedName("errcode")
    private int errcode;
    @SerializedName("car_status")
    private String carStatus;
    @SerializedName("ret")
    private List<RetBean> ret;

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

    public String getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(String carStatus) {
        this.carStatus = carStatus;
    }

    public List<RetBean> getRet() {
        return ret;
    }

    public void setRet(List<RetBean> ret) {
        this.ret = ret;
    }

    public static class RetBean {
        /**
         * car_info : <img src='/bg/car/3.png' style='vertical-align:middle;'> 点火关
         */

        @SerializedName("car_info")
        private String carInfo;

        public String getCarInfo() {
            return carInfo;
        }

        public void setCarInfo(String carInfo) {
            this.carInfo = carInfo;
        }
    }
}
