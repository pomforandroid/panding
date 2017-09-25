package com.panding.main.perfecthttp.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/7/21.
 */

public class Bd_alarm_mode_put {

    /**
     * response_code : 204
     * errcode : 0
     * mode : SMART
     * msg : 设置成功!
     */

    @SerializedName("response_code")
    private int responseCode;
    @SerializedName("errcode")
    private int errcode;
    @SerializedName("mode")
    private String mode;
    @SerializedName("msg")
    private String msg;

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
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
