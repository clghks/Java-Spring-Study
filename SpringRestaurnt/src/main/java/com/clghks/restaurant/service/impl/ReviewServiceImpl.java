package com.clghks.restaurant.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clghks.restaurant.dto.Restaurant;
import com.clghks.restaurant.dto.Review;
import com.clghks.restaurant.mapper.ReviewMapper;
import com.clghks.restaurant.service.ReviewServeice;

@Service
public class ReviewServiceImpl implements ReviewServeice{
	@Autowired
	private ReviewMapper reviewMapper;
	
	@Override
	public List<Review> getReviewsById(String id) {
		return reviewMapper.getReviewsById(id);
	}

	@Override
	public void createReview(Review review) {
		reviewMapper.createReview(review);
	}

	@Override
	public void deleteReview(int rid, String uid) {
		reviewMapper.deleteReview(rid, uid);
	}

	@Override
	public Double getAverageById(String id) {
		return reviewMapper.getAverageById(id);
	}

	@Override
	public Restaurant getRestaurantById(int restaurantId) {
		return reviewMapper.getRestaurantById(restaurantId);
	}

}
