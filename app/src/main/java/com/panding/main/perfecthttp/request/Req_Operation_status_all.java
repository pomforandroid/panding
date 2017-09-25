package com.panding.main.perfecthttp.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/6/28.
 */

public class Req_Operation_status_all {

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
