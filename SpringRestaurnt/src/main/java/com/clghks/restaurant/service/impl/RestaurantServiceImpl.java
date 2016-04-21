package com.clghks.restaurant.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clghks.restaurant.dto.Restaurant;
import com.clghks.restaurant.mapper.RestaurantMapper;
import com.clghks.restaurant.service.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService{
	@Autowired
	private RestaurantMapper restaurantMapper;
	
	@Override
	public List<Restaurant> getRestaurantList(int page, int pageCount) {
		int startIdx = (page -1) * pageCount;
		return restaurantMapper.getRestaurantList(startIdx, pageCount);
	}

	@Override
	public int getCount() {
		return restaurantMapper.getCount();
	}

	@Override
	public void insertRestaurant(Restaurant restaurant) {
		restaurantMapper.insertRestaurant(restaurant);
	}

	@Override
	public void updateRestaurant(Restaurant restaurant) {
		restaurantMapper.updateRestaurant(restaurant);
	}

	@Override
	public void deleteRestaurant(int restaurantId) {
		restaurantMapper.deleteRestaurant(restaurantId);
	}

}
