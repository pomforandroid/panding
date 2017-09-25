package com.panding.main.perfecthttp.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2017/6/24.
 */

public class H_package_get {

    /**
     * errcode : 0
     * msg : 查询成功!
     * package_list : [{"addtime":"2017-06-19 17:10:23.0","cardyear":"1","id":7,"insuranceyear":"1","isdelete":0,"isused":"是","package_name":"套餐一","price":"1500","remark":"一年服务 一年保险 一年卡费","serviceyear":"1","userid":1}]
     */

    @SerializedName("errcode")
    private int errcode;
    @SerializedName("msg")
    private String msg;
    @SerializedName("package_list")
    private List<PackageListBean> packageList;

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

    public List<PackageListBean> getPackageList() {
        return packageList;
    }

    public void setPackageList(List<PackageListBean> packageList) {
        this.packageList = packageList;
    }

    public static class PackageListBean {
        /**
         * addtime : 2017-06-19 17:10:23.0
         * cardyear : 1
         * id : 7
         * insuranceyear : 1
         * isdelete : 0
         * isused : 是
         * package_name : 套餐一
         * price : 1500
         * remark : 一年服务 一年保险 一年卡费
         * serviceyear : 1
         * userid : 1
         */

        @SerializedName("addtime")
        private String addtime;
        @SerializedName("cardyear")
        private String cardyear;
        @SerializedName("id")
        private int id;
        @SerializedName("insuranceyear")
        private String insuranceyear;
        @SerializedName("isdelete")
        private int isdelete;
        @SerializedName("isused")
        private String isused;
        @SerializedName("package_name")
        private String packageName;
        @SerializedName("price")
        private String price;
        @SerializedName("remark")
        private String remark;
        @SerializedName("serviceyear")
        private String serviceyear;
        @SerializedName("userid")
        private int userid;

        private boolean checked;

        public boolean isChecked() {
            return checked;
        }

        public void setChecked(boolean checked) {
            this.checked = checked;
        }

        public String getAddtime() {
            return addtime;
        }

        public void setAddtime(String addtime) {
            this.addtime = addtime;
        }

        public String getCardyear() {
            return cardyear;
        }

        public void setCardyear(String cardyear) {
            this.cardyear = cardyear;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getInsuranceyear() {
            return insuranceyear;
        }

        public void setInsuranceyear(String insuranceyear) {
            this.insuranceyear = insuranceyear;
        }

        public int getIsdelete() {
            return isdelete;
        }

        public void setIsdelete(int isdelete) {
            this.isdelete = isdelete;
        }

        public String getIsused() {
            return isused;
        }

        public void setIsused(String isused) {
            this.isused = isused;
        }

        public String getPackageName() {
            return packageName;
        }

        public void setPackageName(String packageName) {
            this.packageName = packageName;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getServiceyear() {
            return serviceyear;
        }

        public void setServiceyear(String serviceyear) {
            this.serviceyear = serviceyear;
        }

        public int getUserid() {
            return userid;
        }

        public void setUserid(int userid) {
            this.userid = userid;
        }
    }
}
