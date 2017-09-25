package com.panding.main.perfecthttp.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/6/24.
 */

public class Req_bd_location_last {

    /**
     * usernum : 015800113
     * password : 887106
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
