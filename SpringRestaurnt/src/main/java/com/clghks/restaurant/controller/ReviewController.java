package com.clghks.restaurant.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.clghks.restaurant.dto.Restaurant;
import com.clghks.restaurant.dto.Review;
import com.clghks.restaurant.service.RestaurantService;
import com.clghks.restaurant.service.ReviewServeice;

@Controller
@RequestMapping("/review")
public class ReviewController {
	@Autowired
	private ReviewServeice reviewServeice;

	@ModelAttribute("review")
	public Review initReview(){
		Review review = new Review();
		return review;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String review(@PathVariable Integer id, Model model){
		Restaurant restaurant = reviewServeice.getRestaurantById(id);
		Double average = reviewServeice.getAverageById(String.valueOf(id));
		
		List<Review> list = reviewServeice.getReviewsById(String.valueOf(id));
		model.addAttribute("restaurant", restaurant);
		model.addAttribute("average", (average == null) ? 0 : average);
		model.addAttribute("reviewList", list);
		model.addAttribute("startList", starList());
		model.addAttribute("review", initReview());

		return "/review/review";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.POST)
	public String review(@ModelAttribute("restaurant") Review review, BindingResult bindingResult){
		if(!bindingResult.hasErrors()){
			reviewServeice.createReview(review);
		}
		return "redirect:/restaurant/list";
	}
	
	protected Map<String, String> starList(){
		try {
			Map<String, String> starMap = new LinkedHashMap<String, String>();
			starMap.put("5", "★★★★★");
			starMap.put("4", "★★★★");
			starMap.put("3", "★★★");
			starMap.put("2", "★★");
			starMap.put("1", "★");

			return starMap;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
