package com.panding.main.perfecthttp.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/6/14.
 */

public class Req_Hfence_post {

    /**
     * user_id : 417
     * area : {"area_name":"ttt","mode":area,"pos_list":[{"x":22.59227,"y":113.06995,"idx":0},{"x":22.591612,"y":113.0708,"idx":1},{"x":22.590338,"y":113.06963,"idx":2},{"x":22.590984,"y":113.068794,"idx":3},{"x":22.590984,"y":113.0688,"idx":4}]}
     */

    @SerializedName("user_id")
    private String userId;
    @SerializedName("area")
    private String area;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
