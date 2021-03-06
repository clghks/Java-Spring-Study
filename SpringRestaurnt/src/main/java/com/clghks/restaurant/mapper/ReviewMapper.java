package com.clghks.restaurant.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.clghks.restaurant.dto.Restaurant;
import com.clghks.restaurant.dto.Review;

public interface ReviewMapper {
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
	public void deleteReview(@Param("rid") int rid, @Param("uid") String uid);
	
	/**
	 * 식당 정보를 가져 온다.
	 * @param restaurantId
	 * @return
	 */
	public Restaurant getRestaurantById(int restaurantId);
	
	
	/**
	 * 평균 평점 
	 * @param id
	 * @return
	 */
	public Double getAverageById(String id);
}
