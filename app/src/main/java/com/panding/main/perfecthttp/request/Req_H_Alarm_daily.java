package com.panding.main.perfecthttp.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/6/2.
 */

public class Req_H_Alarm_daily {


    /**
     * vehicle_num : 粤J8008L
     * object_id : 326577
     * date : 2017-05-26
     */

    @SerializedName("vehicle_num")
    private String vehicleNum;
    @SerializedName("object_id")
    private String objectId;
    @SerializedName("date")
    private String date;

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
