package com.panding.main.perfecthttp.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2017/6/28.
 */

public class Operation_status_all {

    /**
     * errcode : 0
     * server : H
     * msg : 查找成功!
     * operation_list : [{"car_id":"062601090126","statue":"10","code":"CLOSEDOOR","operation_time":"2016-10-26 14:50:56","ret":"关门指令完成"}]
     */

    @SerializedName("errcode")
    private int errcode;
    @SerializedName("server")
    private String server;
    @SerializedName("msg")
    private String msg;
    @SerializedName("operation_list")
    private List<OperationListBean> operationList;

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

    public List<OperationListBean> getOperationList() {
        return operationList;
    }

    public void setOperationList(List<OperationListBean> operationList) {
        this.operationList = operationList;
    }

    public static class OperationListBean {
        /**
         * car_id : 062601090126
         * statue : 10
         * code : CLOSEDOOR
         * operation_time : 2016-10-26 14:50:56
         * ret : 关门指令完成
         */

        @SerializedName("car_id")
        private String carId;
        @SerializedName("statue")
        private String statue;
        @SerializedName("code")
        private String code;
        @SerializedName("operation_time")
        private String operationTime;
        @SerializedName("ret")
        private String ret;

        public String getCarId() {
            return carId;
        }

        public void setCarId(String carId) {
            this.carId = carId;
        }

        public String getStatue() {
            return statue;
        }

        public void setStatue(String statue) {
            this.statue = statue;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getOperationTime() {
            return operationTime;
        }

        public void setOperationTime(String operationTime) {
            this.operationTime = operationTime;
        }

        public String getRet() {
            return ret;
        }

        public void setRet(String ret) {
            this.ret = ret;
        }
    }
}
