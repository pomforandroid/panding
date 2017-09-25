package com.panding.main.perfecthttp.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/9/19.
 */

public class Pd_remind_get {

    /**
     * errcode : 0
     * nextYear : 2019
     * nextMonth : 7
     * nextTime : 2017-06-06 00:00:00.0
     */

    @SerializedName("errcode")
    private int errcode;
    @SerializedName("nextYear")
    private String nextYear;
    @SerializedName("nextMonth")
    private String nextMonth;
    @SerializedName("nextTime")
    private String nextTime;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getNextYear() {
        return nextYear;
    }

    public void setNextYear(String nextYear) {
        this.nextYear = nextYear;
    }

    public String getNextMonth() {
        return nextMonth;
    }

    public void setNextMonth(String nextMonth) {
        this.nextMonth = nextMonth;
    }

    public String getNextTime() {
        return nextTime;
    }

    public void setNextTime(String nextTime) {
        this.nextTime = nextTime;
    }
}
