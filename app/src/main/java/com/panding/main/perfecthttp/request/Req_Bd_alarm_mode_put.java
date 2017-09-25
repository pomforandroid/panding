package com.panding.main.perfecthttp.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/7/21.
 */

public class Req_Bd_alarm_mode_put {

    /**
     * usernum : 015800113
     * password : 887106
     * mode : CLOSE
     */

    @SerializedName("usernum")
    private String usernum;
    @SerializedName("password")
    private String password;
    @SerializedName("mode")
    private String mode;

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

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}
