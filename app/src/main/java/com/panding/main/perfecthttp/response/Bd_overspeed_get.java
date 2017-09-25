package com.panding.main.perfecthttp.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/7/21.
 */

public class Bd_overspeed_get {

    /**
     * id : 7054715
     * cid : 015800113
     * cmdtype : 0
     * cmdid : SPEED
     * cmdmsg :
     * createtime : 2017-07-21T09:22:39.65
     * cmdtxt :
     * updatetime : null
     * getcount : 0
     * delflag : 1
     * retime : 2017-07-21T09:22:42
     * isread : 0
     * returnmsg : 110
     * comid : 2
     * equid : 23259
     * sessionid : 636362257596485230
     * clientid :
     * errcode : 0
     * msg : 查找成功!
     */

    @SerializedName("id")
    private int id;
    @SerializedName("cid")
    private String cid;
    @SerializedName("cmdtype")
    private String cmdtype;
    @SerializedName("cmdid")
    private String cmdid;
    @SerializedName("cmdmsg")
    private String cmdmsg;
    @SerializedName("createtime")
    private String createtime;
    @SerializedName("cmdtxt")
    private String cmdtxt;
    @SerializedName("updatetime")
    private Object updatetime;
    @SerializedName("getcount")
    private int getcount;
    @SerializedName("delflag")
    private int delflag;
    @SerializedName("retime")
    private String retime;
    @SerializedName("isread")
    private int isread;
    @SerializedName("returnmsg")
    private String returnmsg;
    @SerializedName("comid")
    private int comid;
    @SerializedName("equid")
    private int equid;
    @SerializedName("sessionid")
    private String sessionid;
    @SerializedName("clientid")
    private String clientid;
    @SerializedName("errcode")
    private int errcode;
    @SerializedName("msg")
    private String msg;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCmdtype() {
        return cmdtype;
    }

    public void setCmdtype(String cmdtype) {
        this.cmdtype = cmdtype;
    }

    public String getCmdid() {
        return cmdid;
    }

    public void setCmdid(String cmdid) {
        this.cmdid = cmdid;
    }

    public String getCmdmsg() {
        return cmdmsg;
    }

    public void setCmdmsg(String cmdmsg) {
        this.cmdmsg = cmdmsg;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getCmdtxt() {
        return cmdtxt;
    }

    public void setCmdtxt(String cmdtxt) {
        this.cmdtxt = cmdtxt;
    }

    public Object getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Object updatetime) {
        this.updatetime = updatetime;
    }

    public int getGetcount() {
        return getcount;
    }

    public void setGetcount(int getcount) {
        this.getcount = getcount;
    }

    public int getDelflag() {
        return delflag;
    }

    public void setDelflag(int delflag) {
        this.delflag = delflag;
    }

    public String getRetime() {
        return retime;
    }

    public void setRetime(String retime) {
        this.retime = retime;
    }

    public int getIsread() {
        return isread;
    }

    public void setIsread(int isread) {
        this.isread = isread;
    }

    public String getReturnmsg() {
        return returnmsg;
    }

    public void setReturnmsg(String returnmsg) {
        this.returnmsg = returnmsg;
    }

    public int getComid() {
        return comid;
    }

    public void setComid(int comid) {
        this.comid = comid;
    }

    public int getEquid() {
        return equid;
    }

    public void setEquid(int equid) {
        this.equid = equid;
    }

    public String getSessionid() {
        return sessionid;
    }

    public void setSessionid(String sessionid) {
        this.sessionid = sessionid;
    }

    public String getClientid() {
        return clientid;
    }

    public void setClientid(String clientid) {
        this.clientid = clientid;
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
