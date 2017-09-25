package com.panding.main.perfecthttp.response;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2017/6/2.
 */

public class H_Client_info implements Parcelable {

    /**
     * server : H
     * id : 326577
     * car_license_num : 粤J8008L
     * car_type : 威驰
     * license_color :
     * car_color : 紫色
     * car_owner_name : 胡雪红
     * contact_num : 13828028393
     * linkMan1 : 胡雪红
     * contact1_num : 13828028393
     * service_start_time : 2016-09-01 00:00:00.0
     * service_end_time : 2017-09-27 00:00:00.0
     * insurance_time : 2016-09-03 00:00:00.0
     * repaire_time : 2017-09-02 00:00:00.0
     * email : 周曼玲20160927
     * engin_num :
     * carFrame_num : LFMA8E2A2G0200952
     * terminal_num : 62608131892
     * sim_num : 13427317391
     * vehTeam_ID : 16744
     * errcode : 0
     * msg : 查找成功!
     */

    private String server;
    private String id;
    private String car_license_num;
    private String car_type;
    private String license_color;
    private String car_color;
    private String car_owner_name;
    private String contact_num;
    private String linkMan1;
    private String contact1_num;
    private String service_start_time;
    private String service_end_time;
    private String insurance_time;
    private String repaire_time;
    private String email;
    private String engin_num;
    private String carFrame_num;
    private String terminal_num;
    private String sim_num;
    private String vehTeam_ID;
    private int errcode;
    private String msg;

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCar_license_num() {
        return car_license_num;
    }

    public void setCar_license_num(String car_license_num) {
        this.car_license_num = car_license_num;
    }

    public String getCar_type() {
        return car_type;
    }

    public void setCar_type(String car_type) {
        this.car_type = car_type;
    }

    public String getLicense_color() {
        return license_color;
    }

    public void setLicense_color(String license_color) {
        this.license_color = license_color;
    }

    public String getCar_color() {
        return car_color;
    }

    public void setCar_color(String car_color) {
        this.car_color = car_color;
    }

    public String getCar_owner_name() {
        return car_owner_name;
    }

    public void setCar_owner_name(String car_owner_name) {
        this.car_owner_name = car_owner_name;
    }

    public String getContact_num() {
        return contact_num;
    }

    public void setContact_num(String contact_num) {
        this.contact_num = contact_num;
    }

    public String getLinkMan1() {
        return linkMan1;
    }

    public void setLinkMan1(String linkMan1) {
        this.linkMan1 = linkMan1;
    }

    public String getContact1_num() {
        return contact1_num;
    }

    public void setContact1_num(String contact1_num) {
        this.contact1_num = contact1_num;
    }

    public String getService_start_time() {
        return service_start_time;
    }

    public void setService_start_time(String service_start_time) {
        this.service_start_time = service_start_time;
    }

    public String getService_end_time() {
        return service_end_time;
    }

    public void setService_end_time(String service_end_time) {
        this.service_end_time = service_end_time;
    }

    public String getInsurance_time() {
        return insurance_time;
    }

    public void setInsurance_time(String insurance_time) {
        this.insurance_time = insurance_time;
    }

    public String getRepaire_time() {
        return repaire_time;
    }

    public void setRepaire_time(String repaire_time) {
        this.repaire_time = repaire_time;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEngin_num() {
        return engin_num;
    }

    public void setEngin_num(String engin_num) {
        this.engin_num = engin_num;
    }

    public String getCarFrame_num() {
        return carFrame_num;
    }

    public void setCarFrame_num(String carFrame_num) {
        this.carFrame_num = carFrame_num;
    }

    public String getTerminal_num() {
        return terminal_num;
    }

    public void setTerminal_num(String terminal_num) {
        this.terminal_num = terminal_num;
    }

    public String getSim_num() {
        return sim_num;
    }

    public void setSim_num(String sim_num) {
        this.sim_num = sim_num;
    }

    public String getVehTeam_ID() {
        return vehTeam_ID;
    }

    public void setVehTeam_ID(String vehTeam_ID) {
        this.vehTeam_ID = vehTeam_ID;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.server);
        dest.writeString(this.id);
        dest.writeString(this.car_license_num);
        dest.writeString(this.car_type);
        dest.writeString(this.license_color);
        dest.writeString(this.car_color);
        dest.writeString(this.car_owner_name);
        dest.writeString(this.contact_num);
        dest.writeString(this.linkMan1);
        dest.writeString(this.contact1_num);
        dest.writeString(this.service_start_time);
        dest.writeString(this.service_end_time);
        dest.writeString(this.insurance_time);
        dest.writeString(this.repaire_time);
        dest.writeString(this.email);
        dest.writeString(this.engin_num);
        dest.writeString(this.carFrame_num);
        dest.writeString(this.terminal_num);
        dest.writeString(this.sim_num);
        dest.writeString(this.vehTeam_ID);
        dest.writeInt(this.errcode);
        dest.writeString(this.msg);
    }

    public H_Client_info() {
    }

    protected H_Client_info(Parcel in) {
        this.server = in.readString();
        this.id = in.readString();
        this.car_license_num = in.readString();
        this.car_type = in.readString();
        this.license_color = in.readString();
        this.car_color = in.readString();
        this.car_owner_name = in.readString();
        this.contact_num = in.readString();
        this.linkMan1 = in.readString();
        this.contact1_num = in.readString();
        this.service_start_time = in.readString();
        this.service_end_time = in.readString();
        this.insurance_time = in.readString();
        this.repaire_time = in.readString();
        this.email = in.readString();
        this.engin_num = in.readString();
        this.carFrame_num = in.readString();
        this.terminal_num = in.readString();
        this.sim_num = in.readString();
        this.vehTeam_ID = in.readString();
        this.errcode = in.readInt();
        this.msg = in.readString();
    }

    public static final Creator<H_Client_info> CREATOR = new Creator<H_Client_info>() {
        @Override
        public H_Client_info createFromParcel(Parcel source) {
            return new H_Client_info(source);
        }

        @Override
        public H_Client_info[] newArray(int size) {
            return new H_Client_info[size];
        }
    };
}
