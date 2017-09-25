package com.panding.main.perfecthttp.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/6/20.
 */

public class WechatPay {


    /**
     * errcode : 0
     * msg : success!
     * appid : wxb7f9ab7fbba036e5
     * noncestr : 1558388364
     * package : Sign=WXPay
     * partnerid : 1461190102
     * prepayid : wx20170508155922172fd1f47b01350261 41
     * sign : C6E95E942127D4D86B76D72F2A86A149
     * timestamp : 1494230319
     */

    @SerializedName("errcode")
    private int errcode;
    @SerializedName("msg")
    private String msg;
    @SerializedName("appid")
    private String appid;
    @SerializedName("noncestr")
    private String noncestr;
    @SerializedName("package")
    private String packageX;
    @SerializedName("partnerid")
    private String partnerid;
    @SerializedName("prepayid")
    private String prepayid;
    @SerializedName("sign")
    private String sign;
    @SerializedName("timestamp")
    private String timestamp;

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

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getNoncestr() {
        return noncestr;
    }

    public void setNoncestr(String noncestr) {
        this.noncestr = noncestr;
    }

    public String getPackageX() {
        return packageX;
    }

    public void setPackageX(String packageX) {
        this.packageX = packageX;
    }

    public String getPartnerid() {
        return partnerid;
    }

    public void setPartnerid(String partnerid) {
        this.partnerid = partnerid;
    }

    public String getPrepayid() {
        return prepayid;
    }

    public void setPrepayid(String prepayid) {
        this.prepayid = prepayid;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
