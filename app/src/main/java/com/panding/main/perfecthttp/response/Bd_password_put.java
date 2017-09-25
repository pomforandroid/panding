package com.panding.main.perfecthttp.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/7/19.
 */

public class Bd_password_put {

    /**
     * errcode : 0
     * msg : 修改完成!
     */

    @SerializedName("errcode")
    private int errcode;
    @SerializedName("msg")
    private String msg;

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
