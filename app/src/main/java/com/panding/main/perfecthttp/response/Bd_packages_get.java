package com.panding.main.perfecthttp.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2017/7/19.
 */

public class Bd_packages_get {

    /**
     * total_count : 2
     * item_count : 2
     * page_count : 1
     * items : [{"id":226,"depid":915,"depcode":"0,789,793,812,813,915","pcode":"0000223","pname":"1年续费套餐","pprice":1200,"ptype":0,"equtype":30,"pclimit":1,"simlimit":0,"insurlimit":1,"enable":1,"createtime":"2017-03-07T13:46:00.353","updatetime":"2017-03-29T16:07:34.177","equname":"小管家5.2"},{"id":266,"depid":915,"depcode":"0,789,793,812,813,915","pcode":"0000263","pname":"两年套餐","pprice":2000,"ptype":0,"equtype":30,"pclimit":1,"simlimit":1,"insurlimit":0,"enable":1,"createtime":"2017-03-08T11:03:28.163","updatetime":"2017-03-29T16:07:33.213","equname":"小管家5.2"}]
     * errcode : 0
     * msg : 查找成功!
     */

    @SerializedName("total_count")
    private int totalCount;
    @SerializedName("item_count")
    private int itemCount;
    @SerializedName("page_count")
    private int pageCount;
    @SerializedName("errcode")
    private int errcode;
    @SerializedName("msg")
    private String msg;
    @SerializedName("items")
    private List<ItemsBean> items;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
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

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class ItemsBean {
        /**
         * id : 226
         * depid : 915
         * depcode : 0,789,793,812,813,915
         * pcode : 0000223
         * pname : 1年续费套餐
         * pprice : 1200
         * ptype : 0
         * equtype : 30
         * pclimit : 1
         * simlimit : 0
         * insurlimit : 1
         * enable : 1
         * createtime : 2017-03-07T13:46:00.353
         * updatetime : 2017-03-29T16:07:34.177
         * equname : 小管家5.2
         */

        @SerializedName("id")
        private int id;
        @SerializedName("depid")
        private int depid;
        @SerializedName("depcode")
        private String depcode;
        @SerializedName("pcode")
        private String pcode;
        @SerializedName("pname")
        private String pname;
        @SerializedName("pprice")
        private int pprice;
        @SerializedName("ptype")
        private int ptype;
        @SerializedName("equtype")
        private int equtype;
        @SerializedName("pclimit")
        private int pclimit;
        @SerializedName("simlimit")
        private int simlimit;
        @SerializedName("insurlimit")
        private int insurlimit;
        @SerializedName("enable")
        private int enable;
        @SerializedName("createtime")
        private String createtime;
        @SerializedName("updatetime")
        private String updatetime;
        @SerializedName("equname")
        private String equname;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getDepid() {
            return depid;
        }

        public void setDepid(int depid) {
            this.depid = depid;
        }

        public String getDepcode() {
            return depcode;
        }

        public void setDepcode(String depcode) {
            this.depcode = depcode;
        }

        public String getPcode() {
            return pcode;
        }

        public void setPcode(String pcode) {
            this.pcode = pcode;
        }

        public String getPname() {
            return pname;
        }

        public void setPname(String pname) {
            this.pname = pname;
        }

        public int getPprice() {
            return pprice;
        }

        public void setPprice(int pprice) {
            this.pprice = pprice;
        }

        public int getPtype() {
            return ptype;
        }

        public void setPtype(int ptype) {
            this.ptype = ptype;
        }

        public int getEqutype() {
            return equtype;
        }

        public void setEqutype(int equtype) {
            this.equtype = equtype;
        }

        public int getPclimit() {
            return pclimit;
        }

        public void setPclimit(int pclimit) {
            this.pclimit = pclimit;
        }

        public int getSimlimit() {
            return simlimit;
        }

        public void setSimlimit(int simlimit) {
            this.simlimit = simlimit;
        }

        public int getInsurlimit() {
            return insurlimit;
        }

        public void setInsurlimit(int insurlimit) {
            this.insurlimit = insurlimit;
        }

        public int getEnable() {
            return enable;
        }

        public void setEnable(int enable) {
            this.enable = enable;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getUpdatetime() {
            return updatetime;
        }

        public void setUpdatetime(String updatetime) {
            this.updatetime = updatetime;
        }

        public String getEquname() {
            return equname;
        }

        public void setEquname(String equname) {
            this.equname = equname;
        }
    }
}
