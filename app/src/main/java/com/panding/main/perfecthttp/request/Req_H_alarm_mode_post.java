package com.panding.main.perfecthttp.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/6/30.
 */

public class Req_H_alarm_mode_post {

    /**
     * terminal_num : 212120
     * mode : SMART
     */

    @SerializedName("terminal_num")
    private String terminalNum;
    @SerializedName("mode")
    private String mode;

    public String getTerminalNum() {
        return terminalNum;
    }

    public void setTerminalNum(String terminalNum) {
        this.terminalNum = terminalNum;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}
