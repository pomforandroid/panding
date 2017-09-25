package com.panding.main.perfecthttp.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/6/8.
 */

public class Req_control_func {


    /**
     * terminal_num : 62601090126
     */

    @SerializedName("terminal_num")
    private String terminalNum;

    public String getTerminalNum() {
        return terminalNum;
    }

    public void setTerminalNum(String terminalNum) {
        this.terminalNum = terminalNum;
    }
}
