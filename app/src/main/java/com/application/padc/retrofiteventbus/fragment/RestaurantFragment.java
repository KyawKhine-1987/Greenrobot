package com.application.padc.retrofiteventbus.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.application.padc.retrofiteventbus.R;
import com.application.padc.retrofiteventbus.adapter.RestaurantListAdapter;
import com.application.padc.retrofiteventbus.agent.RestaurantDataAgent;
import com.application.padc.retrofiteventbus.agent.retrofit.RetrofitDataAgent;
import com.application.padc.retrofiteventbus.event.DataEvent;
import com.application.padc.retrofiteventbus.vo.RestaurantVO;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RestaurantFragment extends Fragment {

    private static final String LOG_TAG = RestaurantFragment.class.getName();

    @BindView(R.id.rvrestaurantList)
    RecyclerView rvrestaurantList;

    @BindView(R.id.tvrestaurantcount)
    TextView tvrestaurantcount;

    RestaurantListAdapter restaurantListAdapter;

    public RestaurantFragment() {
        Log.i(LOG_TAG, "TEST: RestaurantFragment() called...");

        // Required empty public constructor
    }

    public static RestaurantFragment newInstance() {
        Log.i(LOG_TAG, "TEST: onCreateViewHolder() called...");

        RestaurantFragment fragment = new RestaurantFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i(LOG_TAG, "TEST: onCreate() called...");

        super.onCreate(savedInstanceState);
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i(LOG_TAG, "TEST: onCreateView() called...");

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_restaurant, container, false);
        ButterKnife.bind(this, rootView);

        RestaurantDataAgent restaurantDataAgent = RetrofitDataAgent.getInstance();
        restaurantDataAgent.loadRestaurant();

        return rootView;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onRestaurantListThread(DataEvent.RestaurantListLoadEvent event)
    {
        Log.i(LOG_TAG, "TEST: onRestaurantListThread() called...");

        binddata(event.getRestaurantVOList());
    }

    private void binddata(List<RestaurantVO> restaurantVOList) {
        Log.i(LOG_TAG, "TEST: binddata() called...");

        tvrestaurantcount.setText(restaurantVOList.size()+" Restaurants to deliver to you");
        restaurantListAdapter = new RestaurantListAdapter(getContext(), restaurantVOList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        rvrestaurantList.setLayoutManager(layoutManager);
        rvrestaurantList.setHasFixedSize(true);
        rvrestaurantList.setAdapter(restaurantListAdapter);
    }

    @Override
    public void onDestroy() {
        Log.i(LOG_TAG, "TEST: onDestroy() called...");

        super.onDestroy();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }
}
