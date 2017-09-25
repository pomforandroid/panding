package com.panding.main.perfecthttp.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2017/6/24.
 */

public class H_pay_history {

    /**
     * errcode : 0
     * msg : 查询成功!
     * package_list : [{"cardyear":"1","insuranceyear":"1","objectid":"100037","out_trade_no":"0907563370","packagename":"套餐一","paytype":"alipay","remark":"套餐详细，白送了啊","serviceyear":"1","sevice_endtime":"2019-03-13 00:00:00.0","sevice_newendtime":"2020-03-13 00:00:00.0","time_end":"2017-06-21 09:09:49","total_fee":"0.01","transaction_id":"2017062121001004780259311098","vehiclenum":"粤JEB886"},{"cardyear":"1","insuranceyear":"1","objectid":"100037","out_trade_no":"1733531391","packagename":"套餐一","paytype":"wechatpay","remark":"一年服务 一年保险 一年卡费","serviceyear":"1","sevice_endtime":"2020-03-13 00:00:00.0","sevice_newendtime":"2021-03-13 00:00:00.0","time_end":"20170623173420","total_fee":"1.00","transaction_id":"4004162001201706237070337234","vehiclenum":"粤JEB886"}]
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
         * cardyear : 1
         * insuranceyear : 1
         * objectid : 100037
         * out_trade_no : 0907563370
         * packagename : 套餐一
         * paytype : alipay
         * remark : 套餐详细，白送了啊
         * serviceyear : 1
         * sevice_endtime : 2019-03-13 00:00:00.0
         * sevice_newendtime : 2020-03-13 00:00:00.0
         * time_end : 2017-06-21 09:09:49
         * total_fee : 0.01
         * transaction_id : 2017062121001004780259311098
         * vehiclenum : 粤JEB886
         */

        @SerializedName("cardyear")
        private String cardyear;
        @SerializedName("insuranceyear")
        private String insuranceyear;
        @SerializedName("objectid")
        private String objectid;
        @SerializedName("out_trade_no")
        private String outTradeNo;
        @SerializedName("packagename")
        private String packagename;
        @SerializedName("paytype")
        private String paytype;
        @SerializedName("remark")
        private String remark;
        @SerializedName("serviceyear")
        private String serviceyear;
        @SerializedName("sevice_endtime")
        private String seviceEndtime;
        @SerializedName("sevice_newendtime")
        private String seviceNewendtime;
        @SerializedName("time_end")
        private String timeEnd;
        @SerializedName("total_fee")
        private String totalFee;
        @SerializedName("transaction_id")
        private String transactionId;
        @SerializedName("vehiclenum")
        private String vehiclenum;

        public String getCardyear() {
            return cardyear;
        }

        public void setCardyear(String cardyear) {
            this.cardyear = cardyear;
        }

        public String getInsuranceyear() {
            return insuranceyear;
        }

        public void setInsuranceyear(String insuranceyear) {
            this.insuranceyear = insuranceyear;
        }

        public String getObjectid() {
            return objectid;
        }

        public void setObjectid(String objectid) {
            this.objectid = objectid;
        }

        public String getOutTradeNo() {
            return outTradeNo;
        }

        public void setOutTradeNo(String outTradeNo) {
            this.outTradeNo = outTradeNo;
        }

        public String getPackagename() {
            return packagename;
        }

        public void setPackagename(String packagename) {
            this.packagename = packagename;
        }

        public String getPaytype() {
            return paytype;
        }

        public void setPaytype(String paytype) {
            this.paytype = paytype;
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

        public String getSeviceEndtime() {
            return seviceEndtime;
        }

        public void setSeviceEndtime(String seviceEndtime) {
            this.seviceEndtime = seviceEndtime;
        }

        public String getSeviceNewendtime() {
            return seviceNewendtime;
        }

        public void setSeviceNewendtime(String seviceNewendtime) {
            this.seviceNewendtime = seviceNewendtime;
        }

        public String getTimeEnd() {
            return timeEnd;
        }

        public void setTimeEnd(String timeEnd) {
            this.timeEnd = timeEnd;
        }

        public String getTotalFee() {
            return totalFee;
        }

        public void setTotalFee(String totalFee) {
            this.totalFee = totalFee;
        }

        public String getTransactionId() {
            return transactionId;
        }

        public void setTransactionId(String transactionId) {
            this.transactionId = transactionId;
        }

        public String getVehiclenum() {
            return vehiclenum;
        }

        public void setVehiclenum(String vehiclenum) {
            this.vehiclenum = vehiclenum;
        }
    }
}
