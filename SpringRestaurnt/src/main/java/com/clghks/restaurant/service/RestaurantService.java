package com.clghks.restaurant.service;

import java.util.List;

import com.clghks.restaurant.dto.Restaurant;

public interface RestaurantService {
	public List<Restaurant> getRestaurantList(int page, int pageCount);
	public int getCount();
	public void insertRestaurant(Restaurant restaurant);
	public void updateRestaurant(Restaurant restaurant);
	public void deleteRestaurant(int restaurantId);
}
