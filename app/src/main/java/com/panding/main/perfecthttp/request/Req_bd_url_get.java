package com.panding.main.perfecthttp.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/8/1.
 */

public class Req_bd_url_get {

    /**
     * cid : 015800113
     * password : 887106
     * pic_type : welcome
     */

    @SerializedName("cid")
    private String cid;
    @SerializedName("password")
    private String password;
    @SerializedName("pic_type")
    private String picType;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPicType() {
        return picType;
    }

    public void setPicType(String picType) {
        this.picType = picType;
    }
}
