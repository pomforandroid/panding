package com.panding.main.perfecthttp.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/12.
 */

public class Login_bd_group implements Parcelable {


    /**
     * errcode : 0
     * server : BD
     * msg : 查找成功
     * groupList : [{"groupName":"江门总部","carList":[{"id":"15928","cid":"033000011","cname":"粤JEB886(DW11)","password":"123456","cowner":"广东侍卫长"},{"id":"15956","cid":"011000050","cname":"粤J45F20(DW11)","password":"123456","cowner":"广东侍卫长"},{"id":"17110","cid":"011000123","cname":"粤A3YH78","password":"000000","cowner":"广东侍卫长"}]}]
     * vehiclegroup : 3
     * access_token : bearer McITXQEAkfSfuNSTmlXeu1zBy6t6RZlUy4XqgkM7hi0ocSYZtM9E0cWBgkWfWo58RSlU9zeaq7S_B3EVaq8s67lDunU3ngymX5_wgEDsSo4BTmdAy3zCyIVnzbdrybVQIvTUnVjOyNAQy8XQpz7yQwYdtBBKCNgDYY_TG5nv6coN4O0LNtOQEUKnDdFGT-fuuJR4k7huoBqmt9ffYWzfPk07_5rhtNt9pjftzg31l7j03d0Om84JBPcgJ6n5cJevhjLcRZxfd93vNsRx8jLr06A_X7QZ9eKyeqiWl12-17LyoBWFDfm-F33AE91ZXLtnbcQg5z6hqL42nIsKD_Kf6zFhCZE
     */

    @SerializedName("errcode")
    private int errcode;
    @SerializedName("server")
    private String server;
    @SerializedName("msg")
    private String msg;
    @SerializedName("vehiclegroup")
    private int vehiclegroup;
    @SerializedName("access_token")
    private String accessToken;
    @SerializedName("groupList")
    private List<GroupListBean> groupList;

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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
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

    public List<GroupListBean> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<GroupListBean> groupList) {
        this.groupList = groupList;
    }

    public static class GroupListBean implements Parcelable {
        /**
         * groupName : 江门总部
         * carList : [{"id":"15928","cid":"033000011","cname":"粤JEB886(DW11)","password":"123456","cowner":"广东侍卫长"},{"id":"15956","cid":"011000050","cname":"粤J45F20(DW11)","password":"123456","cowner":"广东侍卫长"},{"id":"17110","cid":"011000123","cname":"粤A3YH78","password":"000000","cowner":"广东侍卫长"}]
         */

        @SerializedName("groupName")
        private String groupName;
        @SerializedName("carList")
        private List<CarListBean> carList;

        public String getGroupName() {
            return groupName;
        }

        public void setGroupName(String groupName) {
            this.groupName = groupName;
        }

        public List<CarListBean> getCarList() {
            return carList;
        }

        public void setCarList(List<CarListBean> carList) {
            this.carList = carList;
        }

        public static class CarListBean implements Parcelable {
            /**
             * id : 15928
             * cid : 033000011
             * cname : 粤JEB886(DW11)
             * password : 123456
             * cowner : 广东侍卫长
             */

            @SerializedName("id")
            private String id;
            @SerializedName("cid")
            private String cid;
            @SerializedName("cname")
            private String cname;
            @SerializedName("password")
            private String password;
            @SerializedName("cowner")
            private String cowner;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getCid() {
                return cid;
            }

            public void setCid(String cid) {
                this.cid = cid;
            }

            public String getCname() {
                return cname;
            }

            public void setCname(String cname) {
                this.cname = cname;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public String getCowner() {
                return cowner;
            }

            public void setCowner(String cowner) {
                this.cowner = cowner;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.id);
                dest.writeString(this.cid);
                dest.writeString(this.cname);
                dest.writeString(this.password);
                dest.writeString(this.cowner);
            }

            public CarListBean() {
            }

            protected CarListBean(Parcel in) {
                this.id = in.readString();
                this.cid = in.readString();
                this.cname = in.readString();
                this.password = in.readString();
                this.cowner = in.readString();
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
            dest.writeList(this.carList);
        }

        public GroupListBean() {
        }

        protected GroupListBean(Parcel in) {
            this.groupName = in.readString();
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
        dest.writeInt(this.errcode);
        dest.writeString(this.server);
        dest.writeString(this.msg);
        dest.writeInt(this.vehiclegroup);
        dest.writeString(this.accessToken);
        dest.writeTypedList(this.groupList);
    }

    public Login_bd_group() {
    }

    protected Login_bd_group(Parcel in) {
        this.errcode = in.readInt();
        this.server = in.readString();
        this.msg = in.readString();
        this.vehiclegroup = in.readInt();
        this.accessToken = in.readString();
        this.groupList = in.createTypedArrayList(GroupListBean.CREATOR);
    }

    public static final Creator<Login_bd_group> CREATOR = new Creator<Login_bd_group>() {
        @Override
        public Login_bd_group createFromParcel(Parcel source) {
            return new Login_bd_group(source);
        }

        @Override
        public Login_bd_group[] newArray(int size) {
            return new Login_bd_group[size];
        }
    };
}
