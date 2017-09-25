package com.panding.main.perfecthttp.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/6/19.
 */

public class Req_h_activate {

    /**
     * vehicle_num : 粤JEB886
     * car_owner_name : 公司车1
     * contact_num : 13544950801
     * link_man1 : 麦健华1
     * contact_num1 : 13544950801
     * password : 123456
     */

    @SerializedName("vehicle_num")
    private String vehicleNum;
    @SerializedName("car_owner_name")
    private String carOwnerName;
    @SerializedName("contact_num")
    private String contactNum;
    @SerializedName("link_man1")
    private String linkMan1;
    @SerializedName("contact_num1")
    private String contactNum1;
    @SerializedName("password")
    private String password;

    public String getVehicleNum() {
        return vehicleNum;
    }

    public void setVehicleNum(String vehicleNum) {
        this.vehicleNum = vehicleNum;
    }

    public String getCarOwnerName() {
        return carOwnerName;
    }

    public void setCarOwnerName(String carOwnerName) {
        this.carOwnerName = carOwnerName;
    }

    public String getContactNum() {
        return contactNum;
    }

    public void setContactNum(String contactNum) {
        this.contactNum = contactNum;
    }

    public String getLinkMan1() {
        return linkMan1;
    }

    public void setLinkMan1(String linkMan1) {
        this.linkMan1 = linkMan1;
    }

    public String getContactNum1() {
        return contactNum1;
    }

    public void setContactNum1(String contactNum1) {
        this.contactNum1 = contactNum1;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
