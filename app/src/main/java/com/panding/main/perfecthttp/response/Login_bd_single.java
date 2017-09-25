package com.panding.main.perfecthttp.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/6/12.
 */

public class Login_bd_single implements Parcelable {

    /**
     * errcode : 0
     * server : BD
     * cid : 011000242
     * terminal_num : 011000242
     * device_code : 0101
     * password : 123456
     * msg : 查找成功
     * cname : 粤A4XZ57
     * cowner : 广东侍卫长
     * vehiclegroup : 2
     * access_token : bearer 9SPi4da8o8aK3ooZVMcynaCZ43EJTDg8EobIrUMZwp_WQafBZNnt4H7S4TKZ2jm0skY2J6k3Q3tMB1QFDSKbBD10LKnu4jkuz0_HGKrRi2eI6By412vZegJiPIG0dVyoS1-LOJ5BZe2nV7D2rxeKGYuZ-DkV5RZWK7xkyE1tn9GLnWcXa6B93NEEnJwk6kQ5Nj7vhH9DeALTTB9l-IeEjWTzJ2e4mbG_zEjXTCMnMqPbRBu6hnz-wa5yW2obRzaupydVRaNLLuGgeSUYnBHX5FCBPQc9Zea5UJQwkPKGZDMXKdt_-VJAHe6IBjf2Sk7Pgg9-7AHc07Rjf6CIkST4spfCxGvRAWAb1ykh5WEvOlKsQDvo
     */

    @SerializedName("errcode")
    private int errcode;
    @SerializedName("server")
    private String server;
    @SerializedName("cid")
    private String cid;
    @SerializedName("terminal_num")
    private String terminalNum;
    @SerializedName("device_code")
    private String deviceCode;
    @SerializedName("password")
    private String password;
    @SerializedName("msg")
    private String msg;
    @SerializedName("cname")
    private String cname;
    @SerializedName("cowner")
    private String cowner;
    @SerializedName("vehiclegroup")
    private int vehiclegroup;
    @SerializedName("access_token")
    private String accessToken;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCowner() {
        return cowner;
    }

    public void setCowner(String cowner) {
        this.cowner = cowner;
    }

    public int getVehiclegroup() {
        return vehiclegroup;
    }

    public void setVehiclegroup(int vehiclegroup) {
        this.vehiclegroup = vehiclegroup;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.errcode);
        dest.writeString(this.server);
        dest.writeString(this.cid);
        dest.writeString(this.terminalNum);
        dest.writeString(this.deviceCode);
        dest.writeString(this.password);
        dest.writeString(this.msg);
        dest.writeString(this.cname);
        dest.writeString(this.cowner);
        dest.writeInt(this.vehiclegroup);
        dest.writeString(this.accessToken);
    }

    public Login_bd_single() {
    }

    protected Login_bd_single(Parcel in) {
        this.errcode = in.readInt();
        this.server = in.readString();
        this.cid = in.readString();
        this.terminalNum = in.readString();
        this.deviceCode = in.readString();
        this.password = in.readString();
        this.msg = in.readString();
        this.cname = in.readString();
        this.cowner = in.readString();
        this.vehiclegroup = in.readInt();
        this.accessToken = in.readString();
    }

    public static final Creator<Login_bd_single> CREATOR = new Creator<Login_bd_single>() {
        @Override
        public Login_bd_single createFromParcel(Parcel source) {
            return new Login_bd_single(source);
        }

        @Override
        public Login_bd_single[] newArray(int size) {
            return new Login_bd_single[size];
        }
    };
}
