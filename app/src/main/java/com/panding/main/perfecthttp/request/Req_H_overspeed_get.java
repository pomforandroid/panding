package com.panding.main.perfecthttp.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/7/1.
 */

public class Req_H_overspeed_get {

    /**
     * terminal_num : 66887679002
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
