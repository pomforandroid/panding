package com.panding.main.perfecthttp.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/6/24.
 */

public class Req_h_pay_history {


    /**
     * car_no : 粤JEB886
     * object_id : 100037
     */

    @SerializedName("car_no")
    private String carNo;
    @SerializedName("object_id")
    private String objectId;

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }
}
