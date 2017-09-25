package com.panding.main.perfecthttp.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/7/21.
 */

public class Bd_alarm_mode_get {

    /**
     * id : 156
     * cid : 015800113
     * alertkeys : 1,2,3,4,5,10,91
     * createtime : 2017-07-21T11:27:11.53
     * errcode : 0
     * mode : SMART
     * msg : 获取成功!
     */

    @SerializedName("id")
    private int id;
    @SerializedName("cid")
    private String cid;
    @SerializedName("alertkeys")
    private String alertkeys;
    @SerializedName("createtime")
    private String createtime;
    @SerializedName("errcode")
    private int errcode;
    @SerializedName("mode")
    private String mode;
    @SerializedName("msg")
    private String msg;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getAlertkeys() {
        return alertkeys;
    }

    public void setAlertkeys(String alertkeys) {
        this.alertkeys = alertkeys;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
