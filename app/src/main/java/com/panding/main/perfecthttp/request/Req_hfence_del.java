package com.panding.main.perfecthttp.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/6/14.
 */

public class Req_hfence_del {

    /**
     * user_id : 417
     * _id : 582dc161e4b01b725d10a058
     */

    @SerializedName("user_id")
    private String userId;
    @SerializedName("_id")
    private String id;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
