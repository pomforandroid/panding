package com.panding.main.perfecthttp.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/12.
 */

public class Login_h_group implements Parcelable {


    /**
     * server : H
     * userID : 71086
     * errcode : 0
     * vehiclegroup : 1
     * msg : 查找成功!
     * group_list : [{"group_name":"未分车组","group_id":"0","car_list":[{"object_id":"331249","car_license_num":"66887679001","veh_type":"轿车","terminal_num":"66887679001","device_code":"0101","car_owner_name":"侍卫长"},{"object_id":"331250","car_license_num":"66887679002","veh_type":"轿车","terminal_num":"66887679002","device_code":"0101","car_owner_name":"侍卫长"},{"object_id":"331251","car_license_num":"66887679003","veh_type":"轿车","terminal_num":"66887679003","device_code":"0101","car_owner_name":"侍卫长"},{"object_id":"331252","car_license_num":"66887679004","veh_type":"轿车","terminal_num":"66887679004","device_code":"0101","car_owner_name":"侍卫长"},{"object_id":"331253","car_license_num":"66887679005","veh_type":"轿车","terminal_num":"66887679005","device_code":"0101","car_owner_name":"侍卫长"}]}]
     */

    @SerializedName("server")
    private String server;
    @SerializedName("userID")
    private String userID;
    @SerializedName("errcode")
    private int errcode;
    @SerializedName("vehiclegroup")
    private int vehiclegroup;
    @SerializedName("msg")
    private String msg;
    @SerializedName("group_list")
    private List<GroupListBean> groupList;

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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<GroupListBean> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<GroupListBean> groupList) {
        this.groupList = groupList;
    }

    public static class GroupListBean implements Parcelable {
        /**
         * group_name : 未分车组
         * group_id : 0
         * car_list : [{"object_id":"331249","car_license_num":"66887679001","veh_type":"轿车","terminal_num":"66887679001","device_code":"0101","car_owner_name":"侍卫长"},{"object_id":"331250","car_license_num":"66887679002","veh_type":"轿车","terminal_num":"66887679002","device_code":"0101","car_owner_name":"侍卫长"},{"object_id":"331251","car_license_num":"66887679003","veh_type":"轿车","terminal_num":"66887679003","device_code":"0101","car_owner_name":"侍卫长"},{"object_id":"331252","car_license_num":"66887679004","veh_type":"轿车","terminal_num":"66887679004","device_code":"0101","car_owner_name":"侍卫长"},{"object_id":"331253","car_license_num":"66887679005","veh_type":"轿车","terminal_num":"66887679005","device_code":"0101","car_owner_name":"侍卫长"}]
         */

        @SerializedName("group_name")
        private String groupName;
        @SerializedName("group_id")
        private String groupId;
        @SerializedName("car_list")
        private List<CarListBean> carList;

        public String getGroupName() {
            return groupName;
        }

        public void setGroupName(String groupName) {
            this.groupName = groupName;
        }

        public String getGroupId() {
            return groupId;
        }

        public void setGroupId(String groupId) {
            this.groupId = groupId;
        }

        public List<CarListBean> getCarList() {
            return carList;
        }

        public void setCarList(List<CarListBean> carList) {
            this.carList = carList;
        }

        public static class CarListBean implements Parcelable {
            /**
             * object_id : 331249
             * car_license_num : 66887679001
             * veh_type : 轿车
             * terminal_num : 66887679001
             * device_code : 0101
             * car_owner_name : 侍卫长
             */

            @SerializedName("object_id")
            private String objectId;
            @SerializedName("car_license_num")
            private String carLicenseNum;
            @SerializedName("veh_type")
            private String vehType;
            @SerializedName("terminal_num")
            private String terminalNum;
            @SerializedName("device_code")
            private String deviceCode;
            @SerializedName("car_owner_name")
            private String carOwnerName;

            public String getObjectId() {
                return objectId;
            }

            public void setObjectId(String objectId) {
                this.objectId = objectId;
            }

            public String getCarLicenseNum() {
                return carLicenseNum;
            }

            public void setCarLicenseNum(String carLicenseNum) {
                this.carLicenseNum = carLicenseNum;
            }

            public String getVehType() {
                return vehType;
            }

            public void setVehType(String vehType) {
                this.vehType = vehType;
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

            public String getCarOwnerName() {
                return carOwnerName;
            }

            public void setCarOwnerName(String carOwnerName) {
                this.carOwnerName = carOwnerName;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.objectId);
                dest.writeString(this.carLicenseNum);
                dest.writeString(this.vehType);
                dest.writeString(this.terminalNum);
                dest.writeString(this.deviceCode);
                dest.writeString(this.carOwnerName);
            }

            public CarListBean() {
            }

            protected CarListBean(Parcel in) {
                this.objectId = in.readString();
                this.carLicenseNum = in.readString();
                this.vehType = in.readString();
                this.terminalNum = in.readString();
                this.deviceCode = in.readString();
                this.carOwnerName = in.readString();
            }

            public static final Creator<CarListBean> CREATOR = new Creator<CarListBean>() {
                @Override
                public CarListBean createFromParcel(Parcel source) {
                    return new CarListBean(source);
                }

                @Override
                public CarListBean[] newArray(int size) {
                    return new CarListBean[size];
                }
            };
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.groupName);
            dest.writeString(this.groupId);
            dest.writeList(this.carList);
        }

        public GroupListBean() {
        }

        protected GroupListBean(Parcel in) {
            this.groupName = in.readString();
            this.groupId = in.readString();
            this.carList = new ArrayList<CarListBean>();
            in.readList(this.carList, CarListBean.class.getClassLoader());
        }

        public static final Creator<GroupListBean> CREATOR = new Creator<GroupListBean>() {
            @Override
            public GroupListBean createFromParcel(Parcel source) {
                return new GroupListBean(source);
            }

            @Override
            public GroupListBean[] newArray(int size) {
                return new GroupListBean[size];
            }
        };
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
        dest.writeString(this.msg);
        dest.writeList(this.groupList);
    }

    public Login_h_group() {
    }

    protected Login_h_group(Parcel in) {
        this.server = in.readString();
        this.userID = in.readString();
        this.errcode = in.readInt();
        this.vehiclegroup = in.readInt();
        this.msg = in.readString();
        this.groupList = new ArrayList<GroupListBean>();
        in.readList(this.groupList, GroupListBean.class.getClassLoader());
    }

    public static final Creator<Login_h_group> CREATOR = new Creator<Login_h_group>() {
        @Override
        public Login_h_group createFromParcel(Parcel source) {
            return new Login_h_group(source);
        }

        @Override
        public Login_h_group[] newArray(int size) {
            return new Login_h_group[size];
        }
    };
}
