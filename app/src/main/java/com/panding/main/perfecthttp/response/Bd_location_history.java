package com.panding.main.perfecthttp.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2017/7/8.
 */

public class Bd_location_history {

    /**
     * total_count : 18
     * item_count : 18
     * page_count : 1
     * items : [{"id":85887,"equid":"011000242","lat":"22.515448","lng":"113.050137","olat":"22.5127075049916","olng":"113.055525998682","blat":"22.5189382253688","blng":"113.061967465849","spe":0,"hax":"328.619995","utctime":1499308547,"bak1":null,"mileage":5806158,"bak2":"0010000000,6,90,6,0000000000,13.522,,0,,","bak3":"p1,0,170706023547","bak4":null,"bak5":null,"bak6":null,"cretattime":"2017-07-06T10:35:47"},{"id":85886,"equid":"011000242","lat":"22.515448","lng":"113.050137","olat":"22.5127075049916","olng":"113.055525998682","blat":"22.5189382253688","blng":"113.061967465849","spe":0,"hax":"328.619995","utctime":1499308438,"bak1":null,"mileage":5806158,"bak2":"0000000000,6,90,5,0000000000,13.632,,0,,","bak3":"p1,0,170706023358","bak4":null,"bak5":null,"bak6":null,"cretattime":"2017-07-06T10:33:58"},{"id":85882,"equid":"011000242","lat":"22.515255","lng":"113.050187","olat":"22.5125146018215","olng":"113.055576109781","blat":"22.5187447063292","blng":"113.062017862682","spe":6,"hax":"354.970001","utctime":1499308423,"bak1":null,"mileage":5806136,"bak2":"0100000000,6,90,5,0000000000,13.522,,0,,","bak3":"p1,0,170706023343","bak4":null,"bak5":null,"bak6":null,"cretattime":"2017-07-06T10:33:43"},{"id":85881,"equid":"011000242","lat":"22.515167","lng":"113.050218","olat":"22.5124266627961","olng":"113.055607180703","blat":"22.5186563795973","blng":"113.062049085583","spe":4,"hax":"90.889999","utctime":1499308408,"bak1":null,"mileage":5806126,"bak2":"0100000000,6,90,7,0000000000,14.071,,0,,","bak3":"p1,0,170706023328","bak4":null,"bak5":null,"bak6":null,"cretattime":"2017-07-06T10:33:28"},{"id":85880,"equid":"011000242","lat":"22.514890","lng":"113.049512","olat":"22.5121481962283","olng":"113.05489940552","blat":"22.5183869614257","blng":"113.061339746783","spe":20,"hax":"64.629997","utctime":1499308393,"bak1":null,"mileage":5806047,"bak2":"0100000000,6,90,9,0000000000,14.071,,0,,","bak3":"p1,0,170706023313","bak4":null,"bak5":null,"bak6":null,"cretattime":"2017-07-06T10:33:13"},{"id":85868,"equid":"011000242","lat":"22.520637","lng":"113.061902","olat":"22.5179182397645","olng":"113.067317629892","blat":"22.5239625732429","blng":"113.073792354016","spe":48,"hax":"179.990005","utctime":1499308213,"bak1":null,"mileage":5804361,"bak2":"0100000000,6,90,9,0000000000,14.071,,0,,","bak3":"p1,0,170706023013","bak4":null,"bak5":null,"bak6":null,"cretattime":"2017-07-06T10:30:13"}]
     * errcode : 0
     * msg : 查找成功!
     */

    @SerializedName("total_count")
    private int totalCount;
    @SerializedName("item_count")
    private int itemCount;
    @SerializedName("page_count")
    private int pageCount;
    @SerializedName("errcode")
    private int errcode;
    @SerializedName("msg")
    private String msg;
    @SerializedName("items")
    private List<ItemsBean> items;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
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

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class ItemsBean {
        /**
         * id : 85887
         * equid : 011000242
         * lat : 22.515448
         * lng : 113.050137
         * olat : 22.5127075049916
         * olng : 113.055525998682
         * blat : 22.5189382253688
         * blng : 113.061967465849
         * spe : 0
         * hax : 328.619995
         * utctime : 1499308547
         * bak1 : null
         * mileage : 5806158
         * bak2 : 0010000000,6,90,6,0000000000,13.522,,0,,
         * bak3 : p1,0,170706023547
         * bak4 : null
         * bak5 : null
         * bak6 : null
         * cretattime : 2017-07-06T10:35:47
         */

        @SerializedName("id")
        private int id;
        @SerializedName("equid")
        private String equid;
        @SerializedName("lat")
        private String lat;
        @SerializedName("lng")
        private String lng;
        @SerializedName("olat")
        private String olat;
        @SerializedName("olng")
        private String olng;
        @SerializedName("blat")
        private String blat;
        @SerializedName("blng")
        private String blng;
        @SerializedName("spe")
        private int spe;
        @SerializedName("hax")
        private String hax;
        @SerializedName("utctime")
        private int utctime;
        @SerializedName("bak1")
        private Object bak1;
        @SerializedName("mileage")
        private int mileage;
        @SerializedName("bak2")
        private String bak2;
        @SerializedName("bak3")
        private String bak3;
        @SerializedName("bak4")
        private Object bak4;
        @SerializedName("bak5")
        private Object bak5;
        @SerializedName("bak6")
        private Object bak6;
        @SerializedName("cretattime")
        private String cretattime;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getEquid() {
            return equid;
        }

        public void setEquid(String equid) {
            this.equid = equid;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getLng() {
            return lng;
        }

        public void setLng(String lng) {
            this.lng = lng;
        }

        public String getOlat() {
            return olat;
        }

        public void setOlat(String olat) {
            this.olat = olat;
        }

        public String getOlng() {
            return olng;
        }

        public void setOlng(String olng) {
            this.olng = olng;
        }

        public String getBlat() {
            return blat;
        }

        public void setBlat(String blat) {
            this.blat = blat;
        }

        public String getBlng() {
            return blng;
        }

        public void setBlng(String blng) {
            this.blng = blng;
        }

        public int getSpe() {
            return spe;
        }

        public void setSpe(int spe) {
            this.spe = spe;
        }

        public String getHax() {
            return hax;
        }

        public void setHax(String hax) {
            this.hax = hax;
        }

        public int getUtctime() {
            return utctime;
        }

        public void setUtctime(int utctime) {
            this.utctime = utctime;
        }

        public Object getBak1() {
            return bak1;
        }

        public void setBak1(Object bak1) {
            this.bak1 = bak1;
        }

        public int getMileage() {
            return mileage;
        }

        public void setMileage(int mileage) {
            this.mileage = mileage;
        }

        public String getBak2() {
            return bak2;
        }

        public void setBak2(String bak2) {
            this.bak2 = bak2;
        }

        public String getBak3() {
            return bak3;
        }

        public void setBak3(String bak3) {
            this.bak3 = bak3;
        }

        public Object getBak4() {
            return bak4;
        }

        public void setBak4(Object bak4) {
            this.bak4 = bak4;
        }

        public Object getBak5() {
            return bak5;
        }

        public void setBak5(Object bak5) {
            this.bak5 = bak5;
        }

        public Object getBak6() {
            return bak6;
        }

        public void setBak6(Object bak6) {
            this.bak6 = bak6;
        }

        public String getCretattime() {
            return cretattime;
        }

        public void setCretattime(String cretattime) {
            this.cretattime = cretattime;
        }
    }
}
