package com.application.padc.retrofiteventbus.agent.response;

import com.application.padc.retrofiteventbus.vo.RestaurantVO;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by wm02 on 6/21/2017.
 */

public class RestaurantListResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("timestamp")
    private String timestamp;

    @SerializedName("restaurants")
    private List<RestaurantVO> restaurants;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public List<RestaurantVO> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<RestaurantVO> restaurants) {
        this.restaurants = restaurants;
    }
}
