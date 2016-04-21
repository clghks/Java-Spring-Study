package com.clghks.restaurant.controller;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.clghks.restaurant.dto.Restaurant;
import com.clghks.restaurant.service.RestaurantService;

@Controller
@RequestMapping("/restaurant")
public class RestaurantController {
	private final int MAX_BUF_BYTE = 1024000; 

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
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public void list(@RequestParam(value="page", defaultValue="1") int page, Model model){
		int count = restaurantService.getCount();
		List<Restaurant> list = restaurantService.getRestaurantList(page, 5);
		int allPage = (int) Math.ceil(count/5.0);
		
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		model.addAttribute("allpage", allPage);
	}
	
	@RequestMapping("/getImage")
	@ResponseBody
	public byte[] getImage(@RequestParam("id") int restaurantId, HttpServletResponse httpServletResponse){
		Restaurant restaurant = restaurantService.getRestaurantById(restaurantId);
		if(restaurant.getImage() == null){
			return getDefaultImage();
		}else{			
			httpServletResponse.setContentLength(restaurant.getImage().length);
			httpServletResponse.setContentType("image/png");
			
			return restaurant.getImage();
		}
	}
	
	private byte[] getDefaultImage() {
		BufferedInputStream bufferedInputStream = null;
		ByteArrayOutputStream byteArrayOutputStream = null;
		try {
			File file = new File("/Users/chihwan/Documents/java_spring_study/upload/fegvsdfv.jpg");
			if(file.exists()){
				FileInputStream fileInputStream = new FileInputStream(file);
				byte[] buffer = new byte[MAX_BUF_BYTE];
				bufferedInputStream = new BufferedInputStream(fileInputStream);
				byteArrayOutputStream = new ByteArrayOutputStream();

				int len = 0;
				while ((len = bufferedInputStream.read(buffer)) >= 0) {
					byteArrayOutputStream.write(buffer, 0, len);
				}
				return byteArrayOutputStream.toByteArray();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				bufferedInputStream.close();
				byteArrayOutputStream.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return null;
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
		}else{
			// 에러가 있으면 원래 화면으로 돌아감
			modelAndView = new ModelAndView();
			modelAndView.getModel().putAll(bindingResult.getModel());
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
