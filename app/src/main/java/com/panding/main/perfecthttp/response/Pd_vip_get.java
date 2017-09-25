package com.panding.main.perfecthttp.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/9/19.
 */

public class Pd_vip_get {


    /**
     * errcode : 0
     * cardID : A203839
     * endDate : 2026-12-31 00:00:00.0
     * mainPoint : 511.00
     * discPoint : 311.00
     * usePoint : 200.00
     */

    @SerializedName("errcode")
    private int errcode;
    @SerializedName("cardID")
    private String cardID;
    @SerializedName("endDate")
    private String endDate;
    @SerializedName("mainPoint")
    private String mainPoint;
    @SerializedName("discPoint")
    private String discPoint;
    @SerializedName("usePoint")
    private String usePoint;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getCardID() {
        return cardID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getMainPoint() {
        return mainPoint;
    }

    public void setMainPoint(String mainPoint) {
        this.mainPoint = mainPoint;
    }

    public String getDiscPoint() {
        return discPoint;
    }

    public void setDiscPoint(String discPoint) {
        this.discPoint = discPoint;
    }

    public String getUsePoint() {
        return usePoint;
    }

    public void setUsePoint(String usePoint) {
        this.usePoint = usePoint;
    }
}
