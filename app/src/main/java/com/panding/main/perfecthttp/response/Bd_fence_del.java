package com.panding.main.perfecthttp.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/7/12.
 */

public class Bd_fence_del {

    /**
     * errcode : 0
     * msg : 接口访问成功，删除成功
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
