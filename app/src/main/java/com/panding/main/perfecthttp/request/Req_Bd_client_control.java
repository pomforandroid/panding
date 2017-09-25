package com.panding.main.perfecthttp.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/7/19.
 */

public class Req_Bd_client_control {


    /**
     * code : S12
     * usernum : 033000011
     * password : 123456
     * client_type : IOS
     */

    @SerializedName("code")
    private String code;
    @SerializedName("usernum")
    private String usernum;
    @SerializedName("password")
    private String password;
    @SerializedName("client_type")
    private String clientType;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUsernum() {
        return usernum;
    }

    public void setUsernum(String usernum) {
        this.usernum = usernum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }
}
