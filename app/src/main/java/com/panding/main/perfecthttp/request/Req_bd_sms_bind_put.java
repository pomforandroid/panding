package com.panding.main.perfecthttp.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/7/28.
 */

public class Req_bd_sms_bind_put {

    /**
     * vercode : 458110
     * new_password : 000000
     * old_password : 123456
     * cid : 015813298
     * mobile : 13528317730
     */

    @SerializedName("vercode")
    private String vercode;
    @SerializedName("new_password")
    private String newPassword;
    @SerializedName("old_password")
    private String oldPassword;
    @SerializedName("cid")
    private String cid;
    @SerializedName("mobile")
    private String mobile;

    public String getVercode() {
        return vercode;
    }

    public void setVercode(String vercode) {
        this.vercode = vercode;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
