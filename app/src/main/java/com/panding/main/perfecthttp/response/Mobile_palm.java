package com.panding.main.perfecthttp.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/8/22.
 */

public class Mobile_palm {


    /**
     * errcode : 0
     * plamform : H
     * msg : 属于H平台!
     */

    @SerializedName("errcode")
    private int errcode;
    @SerializedName("plamform")
    private String plamform;
    @SerializedName("msg")
    private String msg;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getPlamform() {
        return plamform;
    }

    public void setPlamform(String plamform) {
        this.plamform = plamform;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
