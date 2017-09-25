package com.panding.main.perfecthttp.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/9/19.
 */

public class Pd_repair_get {

    /**
     * errcode : 0
     * frameCode :
     * order : 2017-10-25 00:00:00.0
     * mainWorker : 2019
     * getCarMan : 7
     * mainType :
     * partCost :
     * laborCost : 0
     * stars : Y
     */

    @SerializedName("errcode")
    private int errcode;
    @SerializedName("frameCode")
    private String frameCode;
    @SerializedName("order")
    private String order;
    @SerializedName("mainWorker")
    private String mainWorker;
    @SerializedName("getCarMan")
    private String getCarMan;
    @SerializedName("mainType")
    private String mainType;
    @SerializedName("partCost")
    private String partCost;
    @SerializedName("laborCost")
    private String laborCost;
    @SerializedName("stars")
    private String stars;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getFrameCode() {
        return frameCode;
    }

    public void setFrameCode(String frameCode) {
        this.frameCode = frameCode;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getMainWorker() {
        return mainWorker;
    }

    public void setMainWorker(String mainWorker) {
        this.mainWorker = mainWorker;
    }

    public String getGetCarMan() {
        return getCarMan;
    }

    public void setGetCarMan(String getCarMan) {
        this.getCarMan = getCarMan;
    }

    public String getMainType() {
        return mainType;
    }

    public void setMainType(String mainType) {
        this.mainType = mainType;
    }

    public String getPartCost() {
        return partCost;
    }

    public void setPartCost(String partCost) {
        this.partCost = partCost;
    }

    public String getLaborCost() {
        return laborCost;
    }

    public void setLaborCost(String laborCost) {
        this.laborCost = laborCost;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }
}
