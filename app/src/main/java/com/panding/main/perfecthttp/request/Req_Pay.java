package com.panding.main.perfecthttp.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/6/20.
 */

public class Req_Pay {

    /**
     * car_num :
     * object_id :
     * price :
     * service_year :
     * insurance_year :
     * card_year :
     * service_end_date :
     * package_name :
     * remark :
     */

    @SerializedName("car_num")
    private String carNum;
    @SerializedName("object_id")
    private String objectId;
    @SerializedName("price")
    private String price;
    @SerializedName("service_year")
    private String serviceYear;
    @SerializedName("insurance_year")
    private String insuranceYear;
    @SerializedName("card_year")
    private String cardYear;
    @SerializedName("service_end_date")
    private String serviceEndDate;
    @SerializedName("package_name")
    private String packageName;
    @SerializedName("remark")
    private String remark;

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getServiceYear() {
        return serviceYear;
    }

    public void setServiceYear(String serviceYear) {
        this.serviceYear = serviceYear;
    }

    public String getInsuranceYear() {
        return insuranceYear;
    }

    public void setInsuranceYear(String insuranceYear) {
        this.insuranceYear = insuranceYear;
    }

    public String getCardYear() {
        return cardYear;
    }

    public void setCardYear(String cardYear) {
        this.cardYear = cardYear;
    }

    public String getServiceEndDate() {
        return serviceEndDate;
    }

    public void setServiceEndDate(String serviceEndDate) {
        this.serviceEndDate = serviceEndDate;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
