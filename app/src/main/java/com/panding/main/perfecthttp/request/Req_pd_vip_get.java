package com.panding.main.perfecthttp.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/9/19.
 */

public class Req_pd_vip_get {

    /**
     * username : 粤J5920J
     * password : 4407211
     */

    @SerializedName("username")
    private String username;
    @SerializedName("password")
    private String password;

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
}
