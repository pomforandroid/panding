package com.panding.main.perfecthttp.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/7/18.
 */

public class Req_Bd_alarm_daily {

    /**
     * cid : 015809176
     * date : 2016-12-23
     */

    @SerializedName("cid")
    private String cid;
    @SerializedName("date")
    private String date;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
