package com.panding.main.perfecthttp.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/6/24.
 */

public class Bd_location_last {

    /**
     * id : 0
     * equid : 015800113
     * lat : 22.621585
     * lng : 113.077954
     * olat : 22.6188968525001
     * olng : 113.083402147873
     * blat : 22.6246780781134
     * blng : 113.089947084258
     * spe : 0
     * hax : 74.430000
     * utctime : 1500367178
     * bak1 : null
     * mileage : 5764940
     * bak2 : 0000000000,6,90,0,0000000000,12.646,14.600,0,,
     * bak3 : p2,0,170718083938
     * bak4 : 0,789,793,812,813,915
     * bak5 : null
     * bak6 : null
     * cretattime : 2017-07-18 16:39:38
     * errcode : 0
     * msg : 查找成功!
     * vol : 12.646
     * guard_code : 000
     * guard_status : 静止解防
     */

    @SerializedName("id")
    private int id;
    @SerializedName("equid")
    private String equid;
    @SerializedName("lat")
    private String lat;
    @SerializedName("lng")
    private String lng;
    @SerializedName("olat")
    private String olat;
    @SerializedName("olng")
    private String olng;
    @SerializedName("blat")
    private String blat;
    @SerializedName("blng")
    private String blng;
    @SerializedName("spe")
    private int spe;
    @SerializedName("hax")
    private String hax;
    @SerializedName("utctime")
    private int utctime;
    @SerializedName("bak1")
    private Object bak1;
    @SerializedName("mileage")
    private double mileage;
    @SerializedName("bak2")
    private String bak2;
    @SerializedName("bak3")
    private String bak3;
    @SerializedName("bak4")
    private String bak4;
    @SerializedName("bak5")
    private Object bak5;
    @SerializedName("bak6")
    private Object bak6;
    @SerializedName("cretattime")
    private String cretattime;
    @SerializedName("errcode")
    private int errcode;
    @SerializedName("msg")
    private String msg;
    @SerializedName("vol")
    private String vol;
    @SerializedName("guard_code")
    private String guardCode;
    @SerializedName("guard_status")
    private String guardStatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEquid() {
        return equid;
    }

    public void setEquid(String equid) {
        this.equid = equid;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getOlat() {
        return olat;
    }

    public void setOlat(String olat) {
        this.olat = olat;
    }

    public String getOlng() {
        return olng;
    }

    public void setOlng(String olng) {
        this.olng = olng;
    }

    public String getBlat() {
        return blat;
    }

    public void setBlat(String blat) {
        this.blat = blat;
    }

    public String getBlng() {
        return blng;
    }

    public void setBlng(String blng) {
        this.blng = blng;
    }

    public int getSpe() {
        return spe;
    }

    public void setSpe(int spe) {
        this.spe = spe;
    }

    public String getHax() {
        return hax;
    }

    public void setHax(String hax) {
        this.hax = hax;
    }

    public int getUtctime() {
        return utctime;
    }

    public void setUtctime(int utctime) {
        this.utctime = utctime;
    }

    public Object getBak1() {
        return bak1;
    }

    public void setBak1(Object bak1) {
        this.bak1 = bak1;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public String getBak2() {
        return bak2;
    }

    public void setBak2(String bak2) {
        this.bak2 = bak2;
    }

    public String getBak3() {
        return bak3;
    }

    public void setBak3(String bak3) {
        this.bak3 = bak3;
    }

    public String getBak4() {
        return bak4;
    }

    public void setBak4(String bak4) {
        this.bak4 = bak4;
    }

    public Object getBak5() {
        return bak5;
    }

    public void setBak5(Object bak5) {
        this.bak5 = bak5;
    }

    public Object getBak6() {
        return bak6;
    }

    public void setBak6(Object bak6) {
        this.bak6 = bak6;
    }

    public String getCretattime() {
        return cretattime;
    }

    public void setCretattime(String cretattime) {
        this.cretattime = cretattime;
    }

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getVol() {
        return vol;
    }

    public void setVol(String vol) {
        this.vol = vol;
    }

    public String getGuardCode() {
        return guardCode;
    }

    public void setGuardCode(String guardCode) {
        this.guardCode = guardCode;
    }

    public String getGuardStatus() {
        return guardStatus;
    }

    public void setGuardStatus(String guardStatus) {
        this.guardStatus = guardStatus;
    }
}
