package com.panding.main.perfecthttp.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/6/14.
 */

public class Req_hfence_postbind {

    /**
     * user_id : 71153
     * area_name : as
     * bt : 1
     * bt_min : 2
     * et : 3
     * et_min : 4
     * type : out
     * sel_car : |100167,粤KFC005
     * sel_team : |10,广东侍卫长
     */

    @SerializedName("user_id")
    private String userId;
    @SerializedName("area_name")
    private String areaName;
    @SerializedName("bt")
    private String bt;
    @SerializedName("bt_min")
    private String btMin;
    @SerializedName("et")
    private String et;
    @SerializedName("et_min")
    private String etMin;
    @SerializedName("type")
    private String type;
    @SerializedName("sel_car")
    private String selCar;
    @SerializedName("sel_team")
    private String selTeam;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getBt() {
        return bt;
    }

    public void setBt(String bt) {
        this.bt = bt;
    }

    public String getBtMin() {
        return btMin;
    }

    public void setBtMin(String btMin) {
        this.btMin = btMin;
    }

    public String getEt() {
        return et;
    }

    public void setEt(String et) {
        this.et = et;
    }

    public String getEtMin() {
        return etMin;
    }

    public void setEtMin(String etMin) {
        this.etMin = etMin;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSelCar() {
        return selCar;
    }

    public void setSelCar(String selCar) {
        this.selCar = selCar;
    }

    public String getSelTeam() {
        return selTeam;
    }

    public void setSelTeam(String selTeam) {
        this.selTeam = selTeam;
    }
}
