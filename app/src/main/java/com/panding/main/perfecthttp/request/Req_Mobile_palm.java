package com.panding.main.perfecthttp.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/8/22.
 */

public class Req_Mobile_palm {

    /**
     * mobile : 18678923170
     * vehicle_num : 粤KFC005
     */

    @SerializedName("mobile")
    private String mobile;
    @SerializedName("vehicle_num")
    private String vehicleNum;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getVehicleNum() {
        return vehicleNum;
    }

    public void setVehicleNum(String vehicleNum) {
        this.vehicleNum = vehicleNum;
    }
}
