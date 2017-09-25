package com.panding.main.perfecthttp.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/6/24.
 */

public class Req_Operation_status {

    /**
     * terminal_num : 13244936374
     * code : OPENDOOR
     */

    @SerializedName("terminal_num")
    private String terminalNum;
    @SerializedName("code")
    private String code;

    public String getTerminalNum() {
        return terminalNum;
    }

    public void setTerminalNum(String terminalNum) {
        this.terminalNum = terminalNum;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
