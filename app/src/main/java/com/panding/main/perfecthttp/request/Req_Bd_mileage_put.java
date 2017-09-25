package com.panding.main.perfecthttp.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/7/22.
 */

public class Req_Bd_mileage_put {

    /**
     * usernum : 015800113
     * password : 887106
     * new_mileage : 38000
     */

    @SerializedName("usernum")
    private String usernum;
    @SerializedName("password")
    private String password;
    @SerializedName("new_mileage")
    private String newMileage;

    public String getUsernum() {
        return usernum;
    }

    public void setUsernum(String usernum) {
        this.usernum = usernum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewMileage() {
        return newMileage;
    }

    public void setNewMileage(String newMileage) {
        this.newMileage = newMileage;
    }
}
