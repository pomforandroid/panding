package com.panding.main.perfecthttp.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/8/24.
 */

public class Req_H_password_reset {

    /**
     * mobile : 135
     * vehicle_num : 66887679001
     * password : 123456
     */

    @SerializedName("mobile")
    private String mobile;
    @SerializedName("vehicle_num")
    private String vehicleNum;
    @SerializedName("password")
    private String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
