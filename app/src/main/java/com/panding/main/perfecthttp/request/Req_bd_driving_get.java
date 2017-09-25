package com.panding.main.perfecthttp.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/8/1.
 */

public class Req_bd_driving_get {

    /**
     * usernum : xxC005
     * password : xxx167
     */

    @SerializedName("usernum")
    private String usernum;
    @SerializedName("password")
    private String password;

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
}
