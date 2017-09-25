package com.panding.main.perfecthttp.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/9/18.
 */

public class Req_pd_login_post {

    /**
     * username : 粤J5920J
     * password : 4407211
     * mobile : 12121
     */

    @SerializedName("username")
    private String username;
    @SerializedName("password")
    private String password;
    @SerializedName("mobile")
    private String mobile;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
