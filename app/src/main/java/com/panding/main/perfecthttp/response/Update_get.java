package com.panding.main.perfecthttp.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/6/16.
 */

public class Update_get {

    /**
     * errcode : 0
     * id : 8
     * version_code : 9
     * version_name : 4.0.2
     * content : \n1.修复部分手机地图打开错误的问题。\n2.使用全新的百度地图，优化地图功能。\n3.增加用户修改密码功能。\n4.修复群组用户下，切换车辆实时位置不更新的错误。
     * download_url : http://221.4.180.194/download/apk/appupdate/NewSwzPlam.apk
     * md5 : C7C1D86E04D76E314F43C57908B62C0A
     * isSilent : 0
     * isForce : 0
     * isAutoInstall : 0
     * isIgnorable : 0
     * size : 400
     */

    @SerializedName("errcode")
    private int errcode;
    @SerializedName("id")
    private String id;
    @SerializedName("version_code")
    private int versionCode;
    @SerializedName("version_name")
    private String versionName;
    @SerializedName("content")
    private String content;
    @SerializedName("download_url")
    private String downloadUrl;
    @SerializedName("md5")
    private String md5;
    @SerializedName("isSilent")
    private int isSilent;
    @SerializedName("isForce")
    private int isForce;
    @SerializedName("isAutoInstall")
    private int isAutoInstall;
    @SerializedName("isIgnorable")
    private int isIgnorable;
    @SerializedName("size")
    private int size;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public int getIsSilent() {
        return isSilent;
    }

    public void setIsSilent(int isSilent) {
        this.isSilent = isSilent;
    }

    public int getIsForce() {
        return isForce;
    }

    public void setIsForce(int isForce) {
        this.isForce = isForce;
    }

    public int getIsAutoInstall() {
        return isAutoInstall;
    }

    public void setIsAutoInstall(int isAutoInstall) {
        this.isAutoInstall = isAutoInstall;
    }

    public int getIsIgnorable() {
        return isIgnorable;
    }

    public void setIsIgnorable(int isIgnorable) {
        this.isIgnorable = isIgnorable;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
