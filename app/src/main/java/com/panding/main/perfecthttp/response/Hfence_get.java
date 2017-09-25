package com.panding.main.perfecthttp.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2017/6/14.
 */

public class Hfence_get implements Parcelable {

    /**
     * errcode : 0
     * ret : 0
     * msg : 获取成功！
     * area : [{"area_name":"cen","mode":"区域范围","_id":"5812bc35e4b0dd10c5b6226e","pos_list":[{"x":22.59227,"y":113.06995,"idx":0},{"x":22.591612,"y":113.0708,"idx":1},{"x":22.590338,"y":113.06963,"idx":2},{"x":22.590984,"y":113.068794,"idx":3},{"x":22.590984,"y":113.0688,"idx":4}]},{"area_name":"56","mode":"区域范围","_id":"582d94c6e4b01b725d109fa3","pos_list":[{"x":39.95637,"y":116.390465,"idx":0},{"x":39.912804,"y":116.46933,"idx":1},{"x":39.88921,"y":116.359825,"idx":2},{"x":39.914448,"y":116.318275,"idx":3},{"x":39.95383,"y":116.33051,"idx":4}]},{"area_name":"mytest","mode":"区域范围","_id":"582dc161e4b01b725d10a058","pos_list":[{"x":22.57863,"y":113.08163,"idx":0},{"x":22.575645,"y":113.078896,"idx":1},{"x":22.578896,"y":113.07931,"idx":2}]},{"area_name":"吧","mode":"区域范围","_id":"593b6bffe4b0bcf988422eac","pos_list":[{"x":22.629354,"y":113.072586,"idx":0},{"x":22.613432,"y":113.08776,"idx":1},{"x":22.63676,"y":113.10276,"idx":2},{"x":22.649204,"y":113.08477,"idx":3},{"x":22.64562,"y":113.07351,"idx":4}]}]
     */

    @SerializedName("errcode")
    private int errcode;
    @SerializedName("ret")
    private int ret;
    @SerializedName("msg")
    private String msg;
    @SerializedName("area")
    private List<AreaBean> area;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<AreaBean> getArea() {
        return area;
    }

    public void setArea(List<AreaBean> area) {
        this.area = area;
    }

    public static class AreaBean implements Parcelable {
        /**
         * area_name : cen
         * mode : 区域范围
         * _id : 5812bc35e4b0dd10c5b6226e
         * pos_list : [{"x":22.59227,"y":113.06995,"idx":0},{"x":22.591612,"y":113.0708,"idx":1},{"x":22.590338,"y":113.06963,"idx":2},{"x":22.590984,"y":113.068794,"idx":3},{"x":22.590984,"y":113.0688,"idx":4}]
         */

        @SerializedName("area_name")
        private String areaName;
        @SerializedName("mode")
        private String mode;
        @SerializedName("_id")
        private String id;
        @SerializedName("pos_list")
        private List<PosListBean> posList;

        public String getAreaName() {
            return areaName;
        }

        public void setAreaName(String areaName) {
            this.areaName = areaName;
        }

        public String getMode() {
            return mode;
        }

        public void setMode(String mode) {
            this.mode = mode;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<PosListBean> getPosList() {
            return posList;
        }

        public void setPosList(List<PosListBean> posList) {
            this.posList = posList;
        }

        public static class PosListBean implements Parcelable {
            /**
             * x : 22.59227
             * y : 113.06995
             * idx : 0
             */

            @SerializedName("x")
            private double x;
            @SerializedName("y")
            private double y;
            @SerializedName("idx")
            private int idx;

            public double getX() {
                return x;
            }

            public void setX(double x) {
                this.x = x;
            }

            public double getY() {
                return y;
            }

            public void setY(double y) {
                this.y = y;
            }

            public int getIdx() {
                return idx;
            }

            public void setIdx(int idx) {
                this.idx = idx;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeDouble(this.x);
                dest.writeDouble(this.y);
                dest.writeInt(this.idx);
            }

            public PosListBean() {
            }

            protected PosListBean(Parcel in) {
                this.x = in.readDouble();
                this.y = in.readDouble();
                this.idx = in.readInt();
            }

            public static final Creator<PosListBean> CREATOR = new Creator<PosListBean>() {
                @Override
                public PosListBean createFromParcel(Parcel source) {
                    return new PosListBean(source);
                }

                @Override
                public PosListBean[] newArray(int size) {
                    return new PosListBean[size];
                }
            };
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.areaName);
            dest.writeString(this.mode);
            dest.writeString(this.id);
            dest.writeTypedList(this.posList);
        }

        public AreaBean() {
        }

        protected AreaBean(Parcel in) {
            this.areaName = in.readString();
            this.mode = in.readString();
            this.id = in.readString();
            this.posList = in.createTypedArrayList(PosListBean.CREATOR);
        }

        public static final Creator<AreaBean> CREATOR = new Creator<AreaBean>() {
            @Override
            public AreaBean createFromParcel(Parcel source) {
                return new AreaBean(source);
            }

            @Override
            public AreaBean[] newArray(int size) {
                return new AreaBean[size];
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
        dest.writeInt(this.ret);
        dest.writeString(this.msg);
        dest.writeTypedList(this.area);
    }

    public Hfence_get() {
    }

    protected Hfence_get(Parcel in) {
        this.errcode = in.readInt();
        this.ret = in.readInt();
        this.msg = in.readString();
        this.area = in.createTypedArrayList(AreaBean.CREATOR);
    }

    public static final Creator<Hfence_get> CREATOR = new Creator<Hfence_get>() {
        @Override
        public Hfence_get createFromParcel(Parcel source) {
            return new Hfence_get(source);
        }

        @Override
        public Hfence_get[] newArray(int size) {
            return new Hfence_get[size];
        }
    };
}
