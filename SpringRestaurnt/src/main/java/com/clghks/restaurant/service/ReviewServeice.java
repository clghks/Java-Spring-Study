package com.clghks.restaurant.service;

import java.util.List;

import com.clghks.restaurant.dto.Restaurant;
import com.clghks.restaurant.dto.Review;

public interface ReviewServeice {
	/**
	 * @param id 레스토랑 ID
	 * @return
	 */
	public List<Review> getReviewsById(String id);

	/**
	 * 리뷰 쓰기
	 * @param review
	 */
	public void createReview(Review review);

	/**
	 * 리뷰 삭제 
	 * @param rid
	 * @param uid
	 */
	public void deleteReview(int rid, String uid);
	
	/**
	 * 평균 평점 
	 * @param id
	 * @return
	 */
	public Double getAverageById(String id);
	
	public Restaurant getRestaurantById(int restaurantId);
}
