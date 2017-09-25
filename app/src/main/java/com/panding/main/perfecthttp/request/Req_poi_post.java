package com.panding.main.perfecthttp.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/6/9.
 */

public class Req_poi_post {

    /**
     * snippet : 100是否
     * title : 是否f
     * poi_id : 123123sfas
     * object_id : 100167
     */

    @SerializedName("snippet")
    private String snippet;
    @SerializedName("title")
    private String title;
    @SerializedName("poi_id")
    private String poiId;
    @SerializedName("object_id")
    private String objectId;

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

    public String getPoiId() {
        return poiId;
    }

    public void setPoiId(String poiId) {
        this.poiId = poiId;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }
}
