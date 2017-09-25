package com.panding.main.perfecthttp.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2017/6/9.
 */

public class Poi_get {


    /**
     * errcode : 0
     * msg : 查找成功!
     * object_id : 100167
     * poi_list : [{"poi_id":"123123sfas","snippet":"100是否","title":"是否f"}]
     */

    @SerializedName("errcode")
    private int errcode;
    @SerializedName("msg")
    private String msg;
    @SerializedName("object_id")
    private String objectId;
    @SerializedName("poi_list")
    private List<PoiListBean> poiList;

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

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public List<PoiListBean> getPoiList() {
        return poiList;
    }

    public void setPoiList(List<PoiListBean> poiList) {
        this.poiList = poiList;
    }

    public static class PoiListBean {
        /**
         * poi_id : 123123sfas
         * snippet : 100是否
         * title : 是否f
         */

        @SerializedName("poi_id")
        private String poiId;
        @SerializedName("snippet")
        private String snippet;
        @SerializedName("title")
        private String title;

        public String getPoiId() {
            return poiId;
        }

        public void setPoiId(String poiId) {
            this.poiId = poiId;
        }

        public String getSnippet() {
            return snippet;
        }

        public void setSnippet(String snippet) {
            this.snippet = snippet;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
