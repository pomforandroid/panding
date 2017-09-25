package com.panding.main.perfecthttp.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/7/12.
 */

public class Req_Bd_fence_get {

    /**
     * usernum : 033000011
     * password : 123456
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
