package com.panding.main.perfecthttp.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/6/29.
 */

public class Req_H_password_put {


    /**
     * username : sftest
     * password_old : 000000
     * password_new : 1234
     * vehiclegroup : 1
     */

    @SerializedName("username")
    private String username;
    @SerializedName("password_old")
    private String passwordOld;
    @SerializedName("password_new")
    private String passwordNew;
    @SerializedName("vehiclegroup")
    private int vehiclegroup;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordOld() {
        return passwordOld;
    }

    public void setPasswordOld(String passwordOld) {
        this.passwordOld = passwordOld;
    }

    public String getPasswordNew() {
        return passwordNew;
    }

    public void setPasswordNew(String passwordNew) {
        this.passwordNew = passwordNew;
    }

    public int getVehiclegroup() {
        return vehiclegroup;
    }

    public void setVehiclegroup(int vehiclegroup) {
        this.vehiclegroup = vehiclegroup;
    }
}
