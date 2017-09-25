package com.panding.main.perfecthttp.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2017/6/24.
 */

public class H_driving_get {


    /**
     * errcode : 0
     * msg : 查找成功
     * all_highest_speed : 0
     * all_average_speed : 0
     * all_total_mile : 4384
     * dirving_list : [{"drive_date":"2017-03","highest_speed":0,"average_speed":0,"total_mile":840},{"drive_date":"2017-04","highest_speed":0,"average_speed":0,"total_mile":1035},{"drive_date":"2017-05","highest_speed":0,"average_speed":0,"total_mile":1032},{"drive_date":"2017-06","highest_speed":0,"average_speed":0,"total_mile":710},{"drive_date":"2017-07","highest_speed":0,"average_speed":0,"total_mile":767}]
     */

    @SerializedName("errcode")
    private int errcode;
    @SerializedName("msg")
    private String msg;
    @SerializedName("all_highest_speed")
    private int allHighestSpeed;
    @SerializedName("all_average_speed")
    private int allAverageSpeed;
    @SerializedName("all_total_mile")
    private int allTotalMile;
    @SerializedName("dirving_list")
    private List<DirvingListBean> dirvingList;

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

    public int getAllHighestSpeed() {
        return allHighestSpeed;
    }

    public void setAllHighestSpeed(int allHighestSpeed) {
        this.allHighestSpeed = allHighestSpeed;
    }

    public int getAllAverageSpeed() {
        return allAverageSpeed;
    }

    public void setAllAverageSpeed(int allAverageSpeed) {
        this.allAverageSpeed = allAverageSpeed;
    }

    public int getAllTotalMile() {
        return allTotalMile;
    }

    public void setAllTotalMile(int allTotalMile) {
        this.allTotalMile = allTotalMile;
    }

    public List<DirvingListBean> getDirvingList() {
        return dirvingList;
    }

    public void setDirvingList(List<DirvingListBean> dirvingList) {
        this.dirvingList = dirvingList;
    }

    public static class DirvingListBean {
        /**
         * drive_date : 2017-03
         * highest_speed : 0
         * average_speed : 0
         * total_mile : 840
         */

        @SerializedName("drive_date")
        private String driveDate;
        @SerializedName("highest_speed")
        private int highestSpeed;
        @SerializedName("average_speed")
        private int averageSpeed;
        @SerializedName("total_mile")
        private int totalMile;

        public String getDriveDate() {
            return driveDate;
        }

        public void setDriveDate(String driveDate) {
            this.driveDate = driveDate;
        }

        public int getHighestSpeed() {
            return highestSpeed;
        }

        public void setHighestSpeed(int highestSpeed) {
            this.highestSpeed = highestSpeed;
        }

        public int getAverageSpeed() {
            return averageSpeed;
        }

        public void setAverageSpeed(int averageSpeed) {
            this.averageSpeed = averageSpeed;
        }

        public int getTotalMile() {
            return totalMile;
        }

        public void setTotalMile(int totalMile) {
            this.totalMile = totalMile;
        }
    }
}
