package com.panding.main.perfecthttp.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/7/24.
 */

public class Req_h_url_get {

    /**
     * object_id : 100555
     * pic_type : welcome
     */

    @SerializedName("object_id")
    private String objectId;
    @SerializedName("pic_type")
    private String picType;

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getPicType() {
        return picType;
    }

    public void setPicType(String picType) {
        this.picType = picType;
    }
}
