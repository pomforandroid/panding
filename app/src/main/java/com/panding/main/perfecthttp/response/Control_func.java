package com.panding.main.perfecthttp.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2017/6/8.
 */

public class Control_func {

    /**
     * errcode : 0
     * msg : 查找成功
     * server : H
     * total : 3
     * func_list : [{"func_name":"油路","button_name":"恢油|断油","button_code":"OPENOIL|CLOSEOIL","car_id":"066887679005","status":"10","code":"OIL","operation_time":"2017-07-13 15:09:43","ret":"恢油完成(远程)"},{"func_name":"车门","button_name":"开门|关门","button_code":"OPENDOOR|CLOSEDOOR","car_id":"066887679005","status":"10","code":"CLOSEDOOR","operation_time":"2017-07-14 11:43:27","ret":"关门完成(远程)"},{"func_name":"震动报警","button_name":"打开|关闭","button_code":"VIBRATEMODEON|VIBRATEMODEOFF","car_id":"066887679005","status":"10","code":"VIBRATEMODEON","operation_time":"2017-07-14 11:43:07","ret":"震动报警开(远程)"},{"func_name":"OBD功能","button_name":"查看","button_code":"HOBD","car_id":"066887679005","status":"10","code":"VIBRATEMODEON","operation_time":"2017-07-14 11:43:07","ret":"震动报警开(远程)"}]
     */

    @SerializedName("errcode")
    private int errcode;
    @SerializedName("msg")
    private String msg;
    @SerializedName("server")
    private String server;
    @SerializedName("total")
    private int total;
    @SerializedName("func_list")
    private List<FuncListBean> funcList;

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

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<FuncListBean> getFuncList() {
        return funcList;
    }

    public void setFuncList(List<FuncListBean> funcList) {
        this.funcList = funcList;
    }

    public static class FuncListBean {
        /**
         * func_name : 油路
         * button_name : 恢油|断油
         * button_code : OPENOIL|CLOSEOIL
         * car_id : 066887679005
         * status : 10
         * code : OIL
         * operation_time : 2017-07-13 15:09:43
         * ret : 恢油完成(远程)
         */

        @SerializedName("func_name")
        private String funcName;
        @SerializedName("button_name")
        private String buttonName;
        @SerializedName("button_code")
        private String buttonCode;
        @SerializedName("car_id")
        private String carId;
        @SerializedName("status")
        private String status;
        @SerializedName("code")
        private String code;
        @SerializedName("operation_time")
        private String operationTime;
        @SerializedName("ret")
        private String ret;

        public String getFuncName() {
            return funcName;
        }

        public void setFuncName(String funcName) {
            this.funcName = funcName;
        }

        public String getButtonName() {
            return buttonName;
        }

        public void setButtonName(String buttonName) {
            this.buttonName = buttonName;
        }

        public String getButtonCode() {
            return buttonCode;
        }

        public void setButtonCode(String buttonCode) {
            this.buttonCode = buttonCode;
        }

        public String getCarId() {
            return carId;
        }

        public void setCarId(String carId) {
            this.carId = carId;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
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
