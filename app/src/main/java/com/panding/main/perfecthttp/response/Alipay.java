package com.panding.main.perfecthttp.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/6/20.
 */

public class Alipay {

    /**
     * errcode : 0
     * msg : success!
     * result : alipay_sdk=alipay-sdk-java-dynamicVersionNo&app_id=2017041306687534&biz_content=%7B%22body%22%3A%22body%22%2C%22out_trade_no%22%3A%221600411501%22%2C%22passback_params%22%3A%2269%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%22subject%22%3A%22App%E6%94%AF%E4%BB%98%E6%B5%8B%E8%AF%95Java%22%2C%22timeout_express%22%3A%2230m%22%2C%22total_amount%22%3A%2211%22%7D&charset=UTF-8&format=json&method=alipay.trade.app.pay&notify_url=http%3A%2F%2Fwxplay.swzcn.com%2FSwzPay%2Fpay%2Fnotifyurl&sign=Umy4lYmq5wIxTGr0pq6XMDzeASP%2FHPs8CylAULBqX9ft2TI7c%2B%2B00idc%2FFWe0jGnlh0xsFPlNkU0%2FYXzloJoWt9bot9mquFTqszmY6p0Mrr0ikBN76zbaQKfm%2FTJ%2B%2BK6lF90PxILDNWkmcjylCd7OlFnxBZPCLxOJcoigCpvcQ%3D&sign_type=RSA2&timestamp=2017-05-08+16%3A00%3A41&version=1.0
     */

    @SerializedName("errcode")
    private int errcode;
    @SerializedName("msg")
    private String msg;
    @SerializedName("result")
    private String result;

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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
