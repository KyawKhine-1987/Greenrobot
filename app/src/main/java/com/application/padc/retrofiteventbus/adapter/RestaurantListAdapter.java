package com.application.padc.retrofiteventbus.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.application.padc.retrofiteventbus.R;
import com.application.padc.retrofiteventbus.view.holder.RestaurantViewHolder;
import com.application.padc.retrofiteventbus.vo.RestaurantVO;

import java.util.List;

/**
 * Created by wm02 on 6/22/2017.
 */

public class RestaurantListAdapter extends RecyclerView.Adapter<RestaurantViewHolder>{

    private static final String LOG_TAG = RestaurantListAdapter.class.getName();

    Context context;
    List<RestaurantVO> restaurantVOList;

    public RestaurantListAdapter(Context context, List<RestaurantVO> restaurantVOList) {
        Log.i(LOG_TAG, "TEST: RestaurantListAdapter() called...");

        this.context = context;
        this.restaurantVOList = restaurantVOList;
    }


    @Override
    public RestaurantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.i(LOG_TAG, "TEST: onCreateViewHolder() called...");

        View view = LayoutInflater.from(context).inflate(R.layout.restaurant_item, parent, false);
        return new RestaurantViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RestaurantViewHolder holder, int position) {
        Log.i(LOG_TAG, "TEST: onBindViewHolder() called...");

        holder.bind(restaurantVOList.get(position));
    }

    @Override
    public int getItemCount() {
        Log.i(LOG_TAG, "TEST: getItemCount() called...");

        return restaurantVOList.size();
    }

}
