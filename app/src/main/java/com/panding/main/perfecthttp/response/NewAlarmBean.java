package com.panding.main.perfecthttp.response;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2017/6/1.
 */

public class NewAlarmBean implements Parcelable {

    /**
     * Server : new
     * Alarmtype : 车辆劫持
     * Lon : 113.0665512084961
     * Lat : 22.614530563354492
     * Speed : 0
     * GPSFlag : null
     * Direct : 191
     * GPSTime : 2015-09-16 09:42:17
     * RcvTime : 2015-09-16 09:42:17
     * StatusDes : 10
     * Mileage : null
     * OilNum : 0
     */

    private boolean noresult;
    private String Alarmtype;
    private String Lon;
    private String Lat;
    private String GPSTime;

    public NewAlarmBean(boolean noresult, String alarmtype, String lon, String lat, String GPSTime) {
        this.noresult = noresult;
        Alarmtype = alarmtype;
        Lon = lon;
        Lat = lat;
        this.GPSTime = GPSTime;
    }

    public boolean isNoresult() {
        return noresult;
    }

    public void setNoresult(boolean noresult) {
        this.noresult = noresult;
    }

    public String getAlarmtype() {
        return Alarmtype;
    }

    public void setAlarmtype(String alarmtype) {
        Alarmtype = alarmtype;
    }

    public String getLon() {
        return Lon;
    }

    public void setLon(String lon) {
        Lon = lon;
    }

    public String getLat() {
        return Lat;
    }

    public void setLat(String lat) {
        Lat = lat;
    }

    public String getGPSTime() {
        return GPSTime;
    }

    public void setGPSTime(String GPSTime) {
        this.GPSTime = GPSTime;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte(this.noresult ? (byte) 1 : (byte) 0);
        dest.writeString(this.Alarmtype);
        dest.writeString(this.Lon);
        dest.writeString(this.Lat);
        dest.writeString(this.GPSTime);
    }

    protected NewAlarmBean(Parcel in) {
        this.noresult = in.readByte() != 0;
        this.Alarmtype = in.readString();
        this.Lon = in.readString();
        this.Lat = in.readString();
        this.GPSTime = in.readString();
    }

    public static final Creator<NewAlarmBean> CREATOR = new Creator<NewAlarmBean>() {
        @Override
        public NewAlarmBean createFromParcel(Parcel source) {
            return new NewAlarmBean(source);
        }

        @Override
        public NewAlarmBean[] newArray(int size) {
            return new NewAlarmBean[size];
        }
    };
}
