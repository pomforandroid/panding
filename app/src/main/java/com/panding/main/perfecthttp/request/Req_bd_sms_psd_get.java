package com.panding.main.perfecthttp.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/7/28.
 */

public class Req_bd_sms_psd_get {

    /**
     * mobile : 18022998008
     * vercode : 865397
     * newpsd : 887106
     */

    @SerializedName("mobile")
    private String mobile;
    @SerializedName("vercode")
    private String vercode;
    @SerializedName("newpsd")
    private String newpsd;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getVercode() {
        return vercode;
    }

    public void setVercode(String vercode) {
        this.vercode = vercode;
    }

    public String getNewpsd() {
        return newpsd;
    }

    public void setNewpsd(String newpsd) {
        this.newpsd = newpsd;
    }
}
