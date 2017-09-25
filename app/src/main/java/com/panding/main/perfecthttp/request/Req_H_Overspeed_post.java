package com.panding.main.perfecthttp.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/6/30.
 */

public class Req_H_Overspeed_post {


    /**
     * car_no : 粤JEB886
     * terminal_num : 212120
     * min : 10
     * max : 120
     */

    @SerializedName("car_no")
    private String carNo;
    @SerializedName("terminal_num")
    private String terminalNum;
    @SerializedName("min")
    private String min;
    @SerializedName("max")
    private String max;

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public String getTerminalNum() {
        return terminalNum;
    }

    public void setTerminalNum(String terminalNum) {
        this.terminalNum = terminalNum;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }
}
