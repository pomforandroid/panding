package com.panding.main.perfecthttp.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/25.
 */

public class H_location_history_daily implements Parcelable {

    /**
     * errcode : 0
     * msg : 查找成功
     * location_list : [{"start_time":"07:50:04","duration":"0 小时 25 分钟","total_mile":7.179,"total":50,"loc_list":[{"server":"H","gps_time":"2017-07-21 07:50:04","rcv_time":"2017-07-21 07:50:09","lon":112.95670318603516,"lat":22.762868881225586,"speed":5,"direct":104,"mileage":"9605.608"},{"server":"H","gps_time":"2017-07-21 07:50:35","rcv_time":"2017-07-21 07:50:40","lon":112.95687103271484,"lat":22.762277603149414,"speed":3,"direct":231,"mileage":"9605.654"},{"server":"H","gps_time":"2017-07-21 07:51:05","rcv_time":"2017-07-21 07:51:11","lon":112.95662689208984,"lat":22.761877059936523,"speed":9,"direct":210,"mileage":"9605.687"}]},{"start_time":"15:58:41","duration":"0 小时 47 分钟","total_mile":20.365,"total":95,"loc_list":[{"server":"H","gps_time":"2017-07-21 15:58:41","rcv_time":"2017-07-21 15:58:46","lon":112.92428588867188,"lat":22.72418975830078,"speed":1,"direct":35,"mileage":"9612.819"},{"server":"H","gps_time":"2017-07-21 15:59:11","rcv_time":"2017-07-21 15:59:17","lon":112.92354583740234,"lat":22.72553062438965,"speed":23,"direct":329,"mileage":"9612.964"},{"server":"H","gps_time":"2017-07-21 15:59:42","rcv_time":"2017-07-21 15:59:48","lon":112.92230224609375,"lat":22.72674560546875,"speed":42,"direct":301,"mileage":"9613.158"}]}]
     */

    @SerializedName("errcode")
    private int errcode;
    @SerializedName("msg")
    private String msg;
    @SerializedName("location_list")
    private List<LocationListBean> locationList;

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

    public List<LocationListBean> getLocationList() {
        return locationList;
    }

    public void setLocationList(List<LocationListBean> locationList) {
        this.locationList = locationList;
    }

    public static class LocationListBean implements Parcelable {
        /**
         * start_time : 07:50:04
         * duration : 0 小时 25 分钟
         * total_mile : 7.179
         * total : 50
         * loc_list : [{"server":"H","gps_time":"2017-07-21 07:50:04","rcv_time":"2017-07-21 07:50:09","lon":112.95670318603516,"lat":22.762868881225586,"speed":5,"direct":104,"mileage":"9605.608"},{"server":"H","gps_time":"2017-07-21 07:50:35","rcv_time":"2017-07-21 07:50:40","lon":112.95687103271484,"lat":22.762277603149414,"speed":3,"direct":231,"mileage":"9605.654"},{"server":"H","gps_time":"2017-07-21 07:51:05","rcv_time":"2017-07-21 07:51:11","lon":112.95662689208984,"lat":22.761877059936523,"speed":9,"direct":210,"mileage":"9605.687"}]
         */

        @SerializedName("start_time")
        private String startTime;
        @SerializedName("duration")
        private String duration;
        @SerializedName("total_mile")
        private double totalMile;
        @SerializedName("total")
        private int total;
        @SerializedName("loc_list")
        private List<LocListBean> locList;

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public double getTotalMile() {
            return totalMile;
        }

        public void setTotalMile(double totalMile) {
            this.totalMile = totalMile;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<LocListBean> getLocList() {
            return locList;
        }

        public void setLocList(List<LocListBean> locList) {
            this.locList = locList;
        }

        public static class LocListBean implements Parcelable {
            /**
             * server : H
             * gps_time : 2017-07-21 07:50:04
             * rcv_time : 2017-07-21 07:50:09
             * lon : 112.95670318603516
             * lat : 22.762868881225586
             * speed : 5
             * direct : 104
             * mileage : 9605.608
             */

            @SerializedName("server")
            private String server;
            @SerializedName("gps_time")
            private String gpsTime;
            @SerializedName("rcv_time")
            private String rcvTime;
            @SerializedName("lon")
            private double lon;
            @SerializedName("lat")
            private double lat;
            @SerializedName("speed")
            private int speed;
            @SerializedName("direct")
            private int direct;
            @SerializedName("mileage")
            private String mileage;

            public String getServer() {
                return server;
            }

            public void setServer(String server) {
                this.server = server;
            }

            public String getGpsTime() {
                return gpsTime;
            }

            public void setGpsTime(String gpsTime) {
                this.gpsTime = gpsTime;
            }

            public String getRcvTime() {
                return rcvTime;
            }

            public void setRcvTime(String rcvTime) {
                this.rcvTime = rcvTime;
            }

            public double getLon() {
                return lon;
            }

            public void setLon(double lon) {
                this.lon = lon;
            }

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }

            public int getSpeed() {
                return speed;
            }

            public void setSpeed(int speed) {
                this.speed = speed;
            }

            public int getDirect() {
                return direct;
            }

            public void setDirect(int direct) {
                this.direct = direct;
            }

            public String getMileage() {
                return mileage;
            }

            public void setMileage(String mileage) {
                this.mileage = mileage;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.server);
                dest.writeString(this.gpsTime);
                dest.writeString(this.rcvTime);
                dest.writeDouble(this.lon);
                dest.writeDouble(this.lat);
                dest.writeInt(this.speed);
                dest.writeInt(this.direct);
                dest.writeString(this.mileage);
            }

            public LocListBean() {
            }

            protected LocListBean(Parcel in) {
                this.server = in.readString();
                this.gpsTime = in.readString();
                this.rcvTime = in.readString();
                this.lon = in.readDouble();
                this.lat = in.readDouble();
                this.speed = in.readInt();
                this.direct = in.readInt();
                this.mileage = in.readString();
            }

            public static final Creator<LocListBean> CREATOR = new Creator<LocListBean>() {
                @Override
                public LocListBean createFromParcel(Parcel source) {
                    return new LocListBean(source);
                }

                @Override
                public LocListBean[] newArray(int size) {
                    return new LocListBean[size];
                }
            };
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.startTime);
            dest.writeString(this.duration);
            dest.writeDouble(this.totalMile);
            dest.writeInt(this.total);
            dest.writeList(this.locList);
        }

        public LocationListBean() {
        }

        protected LocationListBean(Parcel in) {
            this.startTime = in.readString();
            this.duration = in.readString();
            this.totalMile = in.readDouble();
            this.total = in.readInt();
            this.locList = new ArrayList<LocListBean>();
            in.readList(this.locList, LocListBean.class.getClassLoader());
        }

        public static final Creator<LocationListBean> CREATOR = new Creator<LocationListBean>() {
            @Override
            public LocationListBean createFromParcel(Parcel source) {
                return new LocationListBean(source);
            }

            @Override
            public LocationListBean[] newArray(int size) {
                return new LocationListBean[size];
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
        dest.writeString(this.msg);
        dest.writeList(this.locationList);
    }

    public H_location_history_daily() {
    }

    protected H_location_history_daily(Parcel in) {
        this.errcode = in.readInt();
        this.msg = in.readString();
        this.locationList = new ArrayList<LocationListBean>();
        in.readList(this.locationList, LocationListBean.class.getClassLoader());
    }

    public static final Creator<H_location_history_daily> CREATOR = new Creator<H_location_history_daily>() {
        @Override
        public H_location_history_daily createFromParcel(Parcel source) {
            return new H_location_history_daily(source);
        }

        @Override
        public H_location_history_daily[] newArray(int size) {
            return new H_location_history_daily[size];
        }
    };
}
