package com.panding.main.perfecthttp.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/7/19.
 */

public class Req_Bd_password_put {

    /**
     * cid : 033000011
     * old_password : 123456
     * new_password : 000000
     */

    @SerializedName("cid")
    private String cid;
    @SerializedName("old_password")
    private String oldPassword;
    @SerializedName("new_password")
    private String newPassword;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
