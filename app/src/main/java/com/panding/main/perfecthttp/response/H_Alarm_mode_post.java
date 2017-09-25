package com.panding.main.perfecthttp.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/6/30.
 */

public class H_Alarm_mode_post {

    /**
     * errcode : 0
     * msg : 修改模式成功！
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
