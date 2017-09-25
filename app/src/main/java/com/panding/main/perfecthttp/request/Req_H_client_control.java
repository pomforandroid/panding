package com.panding.main.perfecthttp.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/6/8.
 */

public class Req_H_client_control {
    /**
     * code : SETALARMON
     * car_no : 66887679001
     * terminal_num : 66887679001
     */

    @SerializedName("code")
    private String code;
    @SerializedName("car_no")
    private String carNo;
    @SerializedName("terminal_num")
    private String terminalNum;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

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


    /**
     * code : SETALARMO
     * car_no : 粤JEB886
     * car_id : 100037
     */
   /* SETALARMO      设防
    SETALARMOFF    解防
    OPENDOOR       开门
    CLOSEDOOR      关门
    VIBRATEMODEON  震动开
    VIBRATEMODEOFF 震动关
    OPENOIL        开油门
    CLOSEOIL       关油门
*/


}
