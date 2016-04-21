package com.clghks.restaurant.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.clghks.restaurant.dto.Restaurant;
import com.clghks.restaurant.service.RestaurantService;

@Controller
@RequestMapping("/restaurant")
public class RestaurantController {
	@Autowired
	private RestaurantService restaurantService;
	
	@ModelAttribute("restaurant")
	public Restaurant initRestaurant(){
		Restaurant restaurant = new Restaurant();
		return restaurant;
	}
	
	@RequestMapping
	public String index(){
		restaurantService.getRestaurantList(1, 10);
		return "/restaurant/index";
	}
	
	// retuarn void는 /view/restaurant/add.jsp
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public void add(Model model){
		Restaurant restaurant = initRestaurant();
		model.addAttribute("restaurant", restaurant);
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView add(@ModelAttribute("restaurant") Restaurant restaurant, MultipartFile file, BindingResult bindingResult){
		ModelAndView modelAndView = new ModelAndView("/restaurant/addok");
		
		// file.isEmpty() 파일이 없다는 것
		// file.getOriginalFilename().isEmpty() 파일이름이 없는 경우?
		if(!file.getOriginalFilename().isEmpty() && !file.isEmpty()){
			try {
				File uploadFile = new File("/Users/chihwan/Documents/java_spring_study/upload/", file.getOriginalFilename());
				file.transferTo(uploadFile);
				restaurant.setImage(file.getBytes());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(!bindingResult.hasErrors()){
			restaurantService.insertRestaurant(restaurant);
		}
		
		return modelAndView;
	}
	
	@RequestMapping("/update")
	public String update(){
		List<Restaurant> restaurants = restaurantService.getRestaurantList(0, 10);
		
		Restaurant restaurant = restaurants.get(0);
		restaurant.setResturantName("식당11010");
		restaurant.setLat(22.00);
		restaurant.setLon(32.2);
		restaurant.setPr("식당1 설명");
		
		restaurantService.updateRestaurant(restaurant);
		
		return "/restaurant/index";
	}
		
	@RequestMapping("/delete")
	public String delete(){
		List<Restaurant> restaurants = restaurantService.getRestaurantList(0, 10);
		restaurantService.deleteRestaurant(restaurants.get(0).getResturantId());
		
		return "/restaurant/index";
	}
	
	@RequestMapping("/count")
	public String getCount(){
		System.out.println(restaurantService.getCount());
		
		return "/restaurant/index";
	}
}
