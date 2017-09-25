package com.panding.main.perfecthttp.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/7/8.
 */

public class Req_Bd_location_history {

    /**
     * usernum : 粤KFC005
     * password : 100167
     * starttime : 2017-05-30 10:00
     * endtime : 2017-05-30 10:59
     */

    @SerializedName("usernum")
    private String usernum;
    @SerializedName("password")
    private String password;
    @SerializedName("starttime")
    private String starttime;
    @SerializedName("endtime")
    private String endtime;

    public String getUsernum() {
        return usernum;
    }

    public void setUsernum(String usernum) {
        this.usernum = usernum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }
}
