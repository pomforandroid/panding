package com.panding.main.perfecthttp.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/7/12.
 */

public class Req_Bd_fence_put {

    /**
     * usernum : 033000011
     * password : 123456
     * lat : 30.626389030784622
     * lng : 104.0282629704412
     * radius : 5001
     * id : 10595
     * validate_flag : 1
     */

    @SerializedName("usernum")
    private String usernum;
    @SerializedName("password")
    private String password;
    @SerializedName("lat")
    private String lat;
    @SerializedName("lng")
    private String lng;
    @SerializedName("radius")
    private int radius;
    @SerializedName("id")
    private int id;
    @SerializedName("validate_flag")
    private int validateFlag;

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

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValidateFlag() {
        return validateFlag;
    }

    public void setValidateFlag(int validateFlag) {
        this.validateFlag = validateFlag;
    }
}
