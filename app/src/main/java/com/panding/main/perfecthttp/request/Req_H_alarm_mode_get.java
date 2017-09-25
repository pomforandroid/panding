package com.panding.main.perfecthttp.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/6/30.
 */

public class Req_H_alarm_mode_get {

    /**
     * terminal_num : 212120
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
