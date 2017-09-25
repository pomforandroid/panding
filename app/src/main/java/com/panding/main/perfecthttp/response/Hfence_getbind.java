package com.panding.main.perfecthttp.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2017/6/14.
 */

public class Hfence_getbind {

    /**
     * total : 1
     * rows : [{"area_name":"cen","uid":"593fa0e9e4b0bcf988423464","bt":9,"group_id":"417","selcar":"","selteam":"全部车辆,","area_uid":"5812bc35e4b0dd10c5b6226e","type":"离开区域","et":18}]
     * errcode : 0
     * msg : 获取绑定信息成功！
     */

    @SerializedName("total")
    private int total;
    @SerializedName("errcode")
    private int errcode;
    @SerializedName("msg")
    private String msg;
    @SerializedName("rows")
    private List<RowsBean> rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
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

    public List<RowsBean> getRows() {
        return rows;
    }

    public void setRows(List<RowsBean> rows) {
        this.rows = rows;
    }

    public static class RowsBean {
        /**
         * area_name : cen
         * uid : 593fa0e9e4b0bcf988423464
         * bt : 9
         * group_id : 417
         * selcar :
         * selteam : 全部车辆,
         * area_uid : 5812bc35e4b0dd10c5b6226e
         * type : 离开区域
         * et : 18
         */

        @SerializedName("area_name")
        private String areaName;
        @SerializedName("uid")
        private String uid;
        @SerializedName("bt")
        private int bt;
        @SerializedName("group_id")
        private String groupId;
        @SerializedName("selcar")
        private String selcar;
        @SerializedName("selteam")
        private String selteam;
        @SerializedName("area_uid")
        private String areaUid;
        @SerializedName("type")
        private String type;
        @SerializedName("et")
        private int et;

        public String getAreaName() {
            return areaName;
        }

        public void setAreaName(String areaName) {
            this.areaName = areaName;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public int getBt() {
            return bt;
        }

        public void setBt(int bt) {
            this.bt = bt;
        }

        public String getGroupId() {
            return groupId;
        }

        public void setGroupId(String groupId) {
            this.groupId = groupId;
        }

        public String getSelcar() {
            return selcar;
        }

        public void setSelcar(String selcar) {
            this.selcar = selcar;
        }

        public String getSelteam() {
            return selteam;
        }

        public void setSelteam(String selteam) {
            this.selteam = selteam;
        }

        public String getAreaUid() {
            return areaUid;
        }

        public void setAreaUid(String areaUid) {
            this.areaUid = areaUid;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getEt() {
            return et;
        }

        public void setEt(int et) {
            this.et = et;
        }
    }
}
