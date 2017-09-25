package com.panding.main.perfecthttp.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/6/24.
 */

public class Req_H_driving_get {


    /**
     * vehicle_num : 粤J8008L
     * object_id : 326577
     */

    @SerializedName("vehicle_num")
    private String vehicleNum;
    @SerializedName("object_id")
    private String objectId;

    public String getVehicleNum() {
        return vehicleNum;
    }

    public void setVehicleNum(String vehicleNum) {
        this.vehicleNum = vehicleNum;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }
}
