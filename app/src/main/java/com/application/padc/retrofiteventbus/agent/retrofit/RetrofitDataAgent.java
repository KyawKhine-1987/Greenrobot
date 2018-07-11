package com.application.padc.retrofiteventbus.agent.retrofit;

import android.util.Log;

import com.application.padc.retrofiteventbus.agent.RestaurantDataAgent;
import com.application.padc.retrofiteventbus.agent.response.RestaurantListResponse;
import com.application.padc.retrofiteventbus.event.DataEvent;
import com.application.padc.retrofiteventbus.util.Constant;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by wm02 on 6/21/2017.
 */

public class RetrofitDataAgent implements RestaurantDataAgent {

    private static final String LOG_TAG = RetrofitDataAgent.class.getName();

    private static RetrofitDataAgent objInstance;

    private final RestaurantApi theApi;

    private RetrofitDataAgent() {
        Log.i(LOG_TAG, "TEST: RetrofitDataAgent() called...");

        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        theApi = retrofit.create(RestaurantApi.class);
    }

    public static RetrofitDataAgent getInstance() {
        Log.i(LOG_TAG, "TEST: RetrofitDataAgent() called...");

        if (objInstance == null) {
            objInstance = new RetrofitDataAgent();
        }
        return objInstance;
    }

    @Override
    public void loadRestaurant() {
        Log.i(LOG_TAG, "TEST: loadRestaurant() called...");

        Call<RestaurantListResponse> loadAttractionCall = theApi.loadRestaurant();
        loadAttractionCall.enqueue(new Callback<RestaurantListResponse>() {
            @Override
            public void onResponse(Call<RestaurantListResponse> call, Response<RestaurantListResponse> response) {
                Log.i(LOG_TAG, "TEST: onResponse() called...");

                RestaurantListResponse restaurantListResponse = response.body();
                if (restaurantListResponse == null) {
                    //AttractionModel.getInstance().notifyErrorInLoadingAttractions(response.message());
                } else {
                    EventBus.getDefault().post(new DataEvent.RestaurantListLoadEvent(restaurantListResponse.getRestaurants()));
                    //AttractionModel.getInstance().notifyAttractionsLoaded(attractionListResponse.getAttractionList());
                }
            }

            @Override
            public void onFailure(Call<RestaurantListResponse> call, Throwable throwable) {
                Log.i(LOG_TAG, "TEST: onFailure() called...");

            }
        });
    }
}
