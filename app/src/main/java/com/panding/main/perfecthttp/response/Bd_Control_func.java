package com.panding.main.perfecthttp.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2017/7/24.
 */

public class Bd_Control_func {

    /**
     * errcode : 0
     * msg : 查找成功
     * server : BD
     * total : 4
     * func_list : [{"func_name":"油路","button_name":"恢油|断油","button_code":"OC_DISABLE|OC_ENABLE","ret":"断油(已执行)","status":"0","code":"","cid":"","operation_time":""},{"func_name":"车门","button_name":"开门|关门","button_code":"OPENS15|CLOSES15","ret":"已解锁","status":"0","code":"S15","cid":"015813298","operation_time":""},{"func_name":"震动报警","button_name":"打开|关闭","button_code":"VIBON|VIBOFF","ret":"震动关","status":"0","code":"VIB","cid":"015813298","operation_time":""},{"func_name":"OBD功能","button_name":"查看","button_code":"BDOBD"}]
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
         * button_code : OC_DISABLE|OC_ENABLE
         * ret : 断油(已执行)
         * status : 0
         * code :
         * cid :
         * operation_time :
         */

        @SerializedName("func_name")
        private String funcName;
        @SerializedName("button_name")
        private String buttonName;
        @SerializedName("button_code")
        private String buttonCode;
        @SerializedName("ret")
        private String ret;
        @SerializedName("status")
        private String status;
        @SerializedName("code")
        private String code;
        @SerializedName("cid")
        private String cid;
        @SerializedName("operation_time")
        private String operationTime;

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

        public String getRet() {
            return ret;
        }

        public void setRet(String ret) {
            this.ret = ret;
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

        public String getCid() {
            return cid;
        }

        public void setCid(String cid) {
            this.cid = cid;
        }

        public String getOperationTime() {
            return operationTime;
        }

        public void setOperationTime(String operationTime) {
            this.operationTime = operationTime;
        }
    }
}
