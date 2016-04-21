package com.clghks.restaurant.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.clghks.restaurant.dto.Restaurant;

public interface RestaurantMapper {
//	/**
//	 * 식당 리스트를 가져온다 
//	 * @param page	현재 페이지(1, 2, 3...)
//	 * @param pageCount	한페이지당 갯수
//	 * @return
//	 */
//	public List<Restaurant> getRestaurantList(@Param("page") int page, @Param("pageCount") int pageCount);

	/**
	 * 식당 리스트를 가져온다 
	 * @param startIdx
	 * @param pageCount
	 * @return
	 */
	public List<Restaurant> getRestaurantList(@Param("startIdx") int startIdx, @Param("pageCount") int pageCount);

	/**
	 * 식당 정보를 가져 온다.
	 * @param restaurantId
	 * @return
	 */
	public Restaurant getRestaurantById(int restaurantId);
	
	/**
	 * 모든 식당의 갯수를 가져온다
	 * @return 모든 식당의 갯수
	 */
	public int getCount();
	
	/**
	 * 식당 추가
	 * @param restaurant
	 */
	public void insertRestaurant(Restaurant restaurant);

	/**
	 * 식당 수정 
	 * @param restaurant
	 */
	public void updateRestaurant(Restaurant restaurant);

	/**
	 * 식당 삭제
	 * @param restaurantId
	 */
	public void deleteRestaurant(int restaurantId);
}
