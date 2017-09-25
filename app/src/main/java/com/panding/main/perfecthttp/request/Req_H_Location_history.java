package com.panding.main.perfecthttp.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/6/7.
 */

public class Req_H_Location_history {

    /**
     * vehicle_num : 粤KFC005
     * object_id : 100167
     * start_time : 2017-05-30 10:00
     * end_time : 2017-05-30 10:59
     */

    @SerializedName("vehicle_num")
    private String vehicleNum;
    @SerializedName("object_id")
    private String objectId;
    @SerializedName("start_time")
    private String startTime;
    @SerializedName("end_time")
    private String endTime;

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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
