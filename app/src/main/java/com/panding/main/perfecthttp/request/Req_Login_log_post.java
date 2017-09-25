package com.panding.main.perfecthttp.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/6/28.
 */

public class Req_Login_log_post {

    /**
     * terminal_num : 62601090126
     * ip : 110.1.1.1
     * phone_type : IOS
     */

    @SerializedName("terminal_num")
    private String terminalNum;
    @SerializedName("ip")
    private String ip;
    @SerializedName("phone_type")
    private String phoneType;

    public String getTerminalNum() {
        return terminalNum;
    }

    public void setTerminalNum(String terminalNum) {
        this.terminalNum = terminalNum;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }
}
