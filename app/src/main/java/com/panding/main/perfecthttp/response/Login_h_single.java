package com.panding.main.perfecthttp.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/6/12.
 */

public class Login_h_single implements Parcelable {

    /**
     * server : H
     * userID : 71146
     * errcode : 0
     * vehiclegroup : 0
     * car_license_num : 66887679002
     * object_id : 331250
     * car_owner_name : 侍卫长
     * terminal_num : 66887679002
     * device_code : 0101
     * vehicle_type : 轿车
     * msg : 已激活
     */

    @SerializedName("server")
    private String server;
    @SerializedName("userID")
    private String userID;
    @SerializedName("errcode")
    private int errcode;
    @SerializedName("vehiclegroup")
    private int vehiclegroup;
    @SerializedName("car_license_num")
    private String carLicenseNum;
    @SerializedName("object_id")
    private String objectId;
    @SerializedName("car_owner_name")
    private String carOwnerName;
    @SerializedName("terminal_num")
    private String terminalNum;
    @SerializedName("device_code")
    private String deviceCode;
    @SerializedName("vehicle_type")
    private String vehicleType;
    @SerializedName("msg")
    private String msg;

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public int getVehiclegroup() {
        return vehiclegroup;
    }

    public void setVehiclegroup(int vehiclegroup) {
        this.vehiclegroup = vehiclegroup;
    }

    public String getCarLicenseNum() {
        return carLicenseNum;
    }

    public void setCarLicenseNum(String carLicenseNum) {
        this.carLicenseNum = carLicenseNum;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getCarOwnerName() {
        return carOwnerName;
    }

    public void setCarOwnerName(String carOwnerName) {
        this.carOwnerName = carOwnerName;
    }

    public String getTerminalNum() {
        return terminalNum;
    }

    public void setTerminalNum(String terminalNum) {
        this.terminalNum = terminalNum;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.server);
        dest.writeString(this.userID);
        dest.writeInt(this.errcode);
        dest.writeInt(this.vehiclegroup);
        dest.writeString(this.carLicenseNum);
        dest.writeString(this.objectId);
        dest.writeString(this.carOwnerName);
        dest.writeString(this.terminalNum);
        dest.writeString(this.deviceCode);
        dest.writeString(this.vehicleType);
        dest.writeString(this.msg);
    }

    public Login_h_single() {
    }

    protected Login_h_single(Parcel in) {
        this.server = in.readString();
        this.userID = in.readString();
        this.errcode = in.readInt();
        this.vehiclegroup = in.readInt();
        this.carLicenseNum = in.readString();
        this.objectId = in.readString();
        this.carOwnerName = in.readString();
        this.terminalNum = in.readString();
        this.deviceCode = in.readString();
        this.vehicleType = in.readString();
        this.msg = in.readString();
    }

    public static final Creator<Login_h_single> CREATOR = new Creator<Login_h_single>() {
        @Override
        public Login_h_single createFromParcel(Parcel source) {
            return new Login_h_single(source);
        }

        @Override
        public Login_h_single[] newArray(int size) {
            return new Login_h_single[size];
        }
    };
}
