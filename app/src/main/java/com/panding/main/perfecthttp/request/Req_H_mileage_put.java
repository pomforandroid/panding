package com.panding.main.perfecthttp.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/7/22.
 */

public class Req_H_mileage_put {

    /**
     * vehicle_num : 66887679005
     * object_id : 331253
     * new_mileage : 200
     */

    @SerializedName("vehicle_num")
    private String vehicleNum;
    @SerializedName("object_id")
    private String objectId;
    @SerializedName("new_mileage")
    private String newMileage;

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

    public String getNewMileage() {
        return newMileage;
    }

    public void setNewMileage(String newMileage) {
        this.newMileage = newMileage;
    }
}
