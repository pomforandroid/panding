package com.panding.main.perfecthttp.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/7/28.
 */

public class Req_bd_sms_count_get {

    /**
     * mobile : 18022998008
     */

    @SerializedName("mobile")
    private String mobile;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
