package com.panding.main.perfecthttp.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/6/24.
 */

public class Bd_obd {

   /* id (Stringeger, optional): 内码 ,
    cid (string, optional): 设备号 ,
    c1 (number, optional): 电瓶电压 ,
    c2 (Stringeger, optional): 发动机转速 ,
    c3 (Stringeger, optional): 行驶车速 ,
    c4 (number, optional): 节气门开度 ,
    c5 (number, optional): 发动机负荷 ,
    c6 (number, optional): 冷却液温度 ,
    c7 (number, optional): 瞬时油耗 ,
    c8 (number, optional): 平均油耗 ,
    c9 (number, optional): 本次里程 ,
    c10 (number, optional): 总里程 ,
    c11 (number, optional): 本次油耗 ,
    c12 (number, optional): 累计油耗 ,
    c13 (string, optional): 当前故障码数量 ,
    c14 (string, optional): 本次急加速次数 ,
    c15 (string, optional): 本次急减速次数 ,
    cretattime (string, optional): 时间*/
    /**
     * id : 438
     * cid : 015800113
     * c1 : 14.6
     * c2 : 851
     * c3 : 0
     * c4 : 15.29
     * c5 : 14.12
     * c6 : 90
     * c7 : 1.03
     * c8 : 7.46
     * c9 : 1.62
     * c10 : 637
     * c11 : 0.31
     * c12 : 52.83
     * c13 : 0
     * c14 : 1
     * c15 : 0
     * cretattime : 2016-10-03T16:15:15.29
     * errcode : 0
     * msg : 查找成功!
     */

    @SerializedName("id")
    private String id;
    @SerializedName("cid")
    private String cid;
    @SerializedName("c1")
    private double c1;
    @SerializedName("c2")
    private String c2;
    @SerializedName("c3")
    private String c3;
    @SerializedName("c4")
    private double c4;
    @SerializedName("c5")
    private double c5;
    @SerializedName("c6")
    private String c6;
    @SerializedName("c7")
    private double c7;
    @SerializedName("c8")
    private double c8;
    @SerializedName("c9")
    private double c9;
    @SerializedName("c10")
    private String c10;
    @SerializedName("c11")
    private double c11;
    @SerializedName("c12")
    private double c12;
    @SerializedName("c13")
    private String c13;
    @SerializedName("c14")
    private String c14;
    @SerializedName("c15")
    private String c15;
    @SerializedName("cretattime")
    private String cretattime;
    @SerializedName("errcode")
    private int errcode;
    @SerializedName("msg")
    private String msg;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public double getC1() {
        return c1;
    }

    public void setC1(double c1) {
        this.c1 = c1;
    }

    public String getC2() {
        return c2;
    }

    public void setC2(String c2) {
        this.c2 = c2;
    }

    public String getC3() {
        return c3;
    }

    public void setC3(String c3) {
        this.c3 = c3;
    }

    public double getC4() {
        return c4;
    }

    public void setC4(double c4) {
        this.c4 = c4;
    }

    public double getC5() {
        return c5;
    }

    public void setC5(double c5) {
        this.c5 = c5;
    }

    public String getC6() {
        return c6;
    }

    public void setC6(String c6) {
        this.c6 = c6;
    }

    public double getC7() {
        return c7;
    }

    public void setC7(double c7) {
        this.c7 = c7;
    }

    public double getC8() {
        return c8;
    }

    public void setC8(double c8) {
        this.c8 = c8;
    }

    public double getC9() {
        return c9;
    }

    public void setC9(double c9) {
        this.c9 = c9;
    }

    public String getC10() {
        return c10;
    }

    public void setC10(String c10) {
        this.c10 = c10;
    }

    public double getC11() {
        return c11;
    }

    public void setC11(double c11) {
        this.c11 = c11;
    }

    public double getC12() {
        return c12;
    }

    public void setC12(double c12) {
        this.c12 = c12;
    }

    public String getC13() {
        return c13;
    }

    public void setC13(String c13) {
        this.c13 = c13;
    }

    public String getC14() {
        return c14;
    }

    public void setC14(String c14) {
        this.c14 = c14;
    }

    public String getC15() {
        return c15;
    }

    public void setC15(String c15) {
        this.c15 = c15;
    }

    public String getCretattime() {
        return cretattime;
    }

    public void setCretattime(String cretattime) {
        this.cretattime = cretattime;
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
}
