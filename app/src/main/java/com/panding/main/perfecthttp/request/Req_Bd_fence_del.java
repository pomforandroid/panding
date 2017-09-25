package com.panding.main.perfecthttp.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/7/12.
 */

public class Req_Bd_fence_del {

    /**
     * usernum : 033000011
     * password : 123456
     * id : 10594
     */

    @SerializedName("usernum")
    private String usernum;
    @SerializedName("password")
    private String password;
    @SerializedName("id")
    private int id;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
