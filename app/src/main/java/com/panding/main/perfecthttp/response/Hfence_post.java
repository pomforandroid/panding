package com.panding.main.perfecthttp.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/6/14.
 */

public class Hfence_post {

    /**
     * ret : 0
     * msg : 新增区域成功！
     * errcode : 0
     */

    @SerializedName("ret")
    private int ret;
    @SerializedName("msg")
    private String msg;
    @SerializedName("errcode")
    private int errcode;

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }
}
