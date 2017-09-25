package com.panding.main.perfecthttp.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/7/12.
 */

public class Bd_fence_get {

    /**
     * id : 10592
     * user_id : 033000011
     * validate_flag : 0
     * lat : 30.626389030784622
     * lng : 104.0282629704412
     * radius : 5001
     * create_time : 2017-06-13T14:55:44.527
     * errcode : 0
     * msg : 获取完成!
     */

    @SerializedName("id")
    private int id;
    @SerializedName("user_id")
    private String userId;
    @SerializedName("validate_flag")
    private int validateFlag;
    @SerializedName("lat")
    private String lat;
    @SerializedName("lng")
    private String lng;
    @SerializedName("radius")
    private int radius;
    @SerializedName("create_time")
    private String createTime;
    @SerializedName("errcode")
    private int errcode;
    @SerializedName("msg")
    private String msg;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getValidateFlag() {
        return validateFlag;
    }

    public void setValidateFlag(int validateFlag) {
        this.validateFlag = validateFlag;
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
