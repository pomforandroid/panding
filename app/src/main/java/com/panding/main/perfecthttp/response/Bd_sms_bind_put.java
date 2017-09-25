package com.panding.main.perfecthttp.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/7/28.
 */

public class Bd_sms_bind_put {

    /**
     * code : 0
     * data : 2017-07-26 16:22:53
     * Message : 激活成功
     * response_code : 200
     * errcode : 0
     * msg : 激活成功!
     */

    @SerializedName("code")
    private int code;
    @SerializedName("data")
    private String data;
    @SerializedName("Message")
    private String Message;
    @SerializedName("response_code")
    private int responseCode;
    @SerializedName("errcode")
    private int errcode;
    @SerializedName("msg")
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

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
