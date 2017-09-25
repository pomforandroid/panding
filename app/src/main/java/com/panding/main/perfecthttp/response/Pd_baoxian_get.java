package com.panding.main.perfecthttp.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/9/19.
 */

public class Pd_baoxian_get {


    /**
     * errcode : 0
     * company : 中保
     * orderCode : PDAA201744070000120666/PDZA201
     * startDate : 2017-07-27 00:00:00.0
     * endDate : 2018-07-26 00:00:00.0
     */

    @SerializedName("errcode")
    private int errcode;
    @SerializedName("company")
    private String company;
    @SerializedName("orderCode")
    private String orderCode;
    @SerializedName("startDate")
    private String startDate;
    @SerializedName("endDate")
    private String endDate;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
