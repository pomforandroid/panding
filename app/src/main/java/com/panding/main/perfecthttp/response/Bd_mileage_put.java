package com.panding.main.perfecthttp.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/7/22.
 */

public class Bd_mileage_put {

    /**
     * response_code : 204
     * errcode : 0
     * msg : 修改完成!
     */

    @SerializedName("response_code")
    private int responseCode;
    @SerializedName("errcode")
    private int errcode;
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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
