package com.panding.main.perfecthttp.request;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2017/6/14.
 */

public class Area {

    /**
     * area_name : ttt
     * mode : area
     * pos_list : [{"x":22.59227,"y":113.06995,"idx":0},{"x":22.591612,"y":113.0708,"idx":1},{"x":22.590338,"y":113.06963,"idx":2},{"x":22.590984,"y":113.068794,"idx":3},{"x":22.590984,"y":113.0688,"idx":4}]
     */

    @SerializedName("area_name")
    private String areaName;
    @SerializedName("mode")
    private String mode;
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

    public List<PosListBean> getPosList() {
        return posList;
    }

    public void setPosList(List<PosListBean> posList) {
        this.posList = posList;
    }

    public static class PosListBean {
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
    }
}
