package com.application.padc.retrofiteventbus.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by wm02 on 6/21/2017.
 */

public class RestaurantVO {

    @SerializedName("title")
    private String title;

    @SerializedName("addr-short")
    private String addrshort;

    @SerializedName("image")
    private String image;

    @SerializedName("total-rating-count")
    private int totalratingcount;

    @SerializedName("average-rating-value")
    private double averageratingvalue;

    @SerializedName("is-ad")
    private boolean isad;

    @SerializedName("is-new")
    private boolean isnew;

    @SerializedName("tags")
    private String[] tags;

    @SerializedName("lead-time-in-min")
    private int leadtimeinmin;

    public String getTitle() {
        return title;
    }

    public String getAddrshort() {
        return addrshort;
    }

    public String getImage() {
        return image;
    }

    public int getTotalratingcount() {
        return totalratingcount;
    }

    public double getAverageratingvalue() {
        return averageratingvalue;
    }

    public boolean isad() {
        return isad;
    }

    public boolean isnew() {
        return isnew;
    }

    public String[] getTags() {
        return tags;
    }

    public int getLeadtimeinmin() {
        return leadtimeinmin;
    }
}
