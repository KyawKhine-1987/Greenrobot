package com.application.padc.retrofiteventbus.event;

import com.application.padc.retrofiteventbus.vo.RestaurantVO;

import java.util.List;

/**
 * Created by wm02 on 6/21/2017.
 */

public class DataEvent {

    public static class RestaurantListLoadEvent{
        private List<RestaurantVO> restaurantVOList;

        public RestaurantListLoadEvent(List<RestaurantVO> restaurants) {
            this.restaurantVOList = restaurants;
        }

        public List<RestaurantVO> getRestaurantVOList() {
            return restaurantVOList;
        }

    }
}
