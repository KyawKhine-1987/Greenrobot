package com.application.padc.retrofiteventbus.agent.retrofit;

import com.application.padc.retrofiteventbus.agent.response.RestaurantListResponse;
import com.application.padc.retrofiteventbus.util.ApiConfig;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by wm02 on 6/21/2017.
 */

public interface RestaurantApi {

    @GET(ApiConfig.RESTAURANT_LIST)
    Call<RestaurantListResponse> loadRestaurant();

}
