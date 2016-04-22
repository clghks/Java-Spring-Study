package com.clghks.restaurant.controller;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	public byte[] getImage(@RequestParam("id") int restaurantId, HttpServletResponse httpServletResponse) throws IOException{
		Restaurant restaurant = restaurantService.getRestaurantById(restaurantId);
		if(restaurant.getImage() == null){
			// Java 7 이상
			File file = new File("/Users/chihwan/Documents/java_spring_study/upload/fegvsdfv.jpg");
			return Files.readAllBytes(file.toPath());
		}else{
			httpServletResponse.setCharacterEncoding("UTF-8");
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

//	// retuarn void는 /view/restaurant/add.jsp
//	@RequestMapping(value={"/add", "/edit/{id}"}, method=RequestMethod.GET)
//	public String add(Model model, @PathVariable int id, HttpServletRequest request){
//		String uri = request.getRequestURI();
//		if(uri != null && uri.endsWith("add")){
//			Restaurant restaurant = initRestaurant();
//			model.addAttribute("restaurant", restaurant);
//			model.addAttribute("isAdd", true);
//		}else{
//			Restaurant restaurant = restaurantService.getRestaurantById(id);
//			model.addAttribute("restaurant", restaurant);
//			model.addAttribute("isAdd", false);
//		}
//		return "/restaurant/add";
//	}
	
	@RequestMapping(value={"/add", "/edit"}, method=RequestMethod.GET)
	public String add(Model model, @RequestParam(value="id", required=false) Integer id, HttpServletRequest request){
		String uri = request.getRequestURI();
		if(uri != null && uri.endsWith("add")){
			Restaurant restaurant = initRestaurant();
			model.addAttribute("restaurant", restaurant);
			model.addAttribute("isAdd", true);
		}else{
			Restaurant restaurant = restaurantService.getRestaurantById(id);
			model.addAttribute("restaurant", restaurant);
			model.addAttribute("isAdd", false);
		}
		return "/restaurant/add";
	}
	
	@RequestMapping(value={"/add", "/edit"}, method=RequestMethod.POST)
	// FileUpload 시 type에대한 오류 체크로직이 도작하지 않을 수 있음.
	// BindingResult를 FileUpload보다 파라미터를 먼저 넣어주면 된다. 
	public ModelAndView add(@ModelAttribute("restaurant") Restaurant restaurant, BindingResult bindingResult, @RequestParam(value="id", required=false) Integer id, MultipartFile file, HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView("/restaurant/addok");
		
		// 필드 에러 체크
		if(!bindingResult.hasFieldErrors("resturantName")){	//기존의 바인드된 에러 메시지가 있는지 체크
			if(restaurant.getResturantName() == null || restaurant.getResturantName().length() == 0){
				bindingResult.rejectValue("resturantName", "error.requied");
			}
		}
		
		if(!bindingResult.hasFieldErrors("lat")){
			if(restaurant.getLat() < -90 || restaurant.getLat() > 90){
				bindingResult.rejectValue("lat", "error.lat.value");
			}
		}
		
		if(!bindingResult.hasFieldErrors("lon")){
			if(restaurant.getLon() < -180 || restaurant.getLon() > 180){
				bindingResult.rejectValue("lon", "error.lon.value");
			}
		}
		
		// file.isEmpty() 파일이 없다는 것
		// file.getOriginalFilename().isEmpty() 파일이름이 없는 경우?
		if(!file.getOriginalFilename().isEmpty() && !file.isEmpty()){
			try {
				restaurant.setImage(file.getBytes());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		String uri = request.getRequestURI();
		if(!bindingResult.hasErrors()){
			if(uri != null && uri.endsWith("add")){
				restaurantService.insertRestaurant(restaurant);
			}else{
				restaurantService.updateRestaurant(restaurant);
			}
		}else{
			// 에러가 있으면 원래 화면으로 돌아감
			modelAndView = new ModelAndView("/restaurant/add");
			if(uri != null && uri.endsWith("add")){
				modelAndView.addObject("isAdd", true);
			}else{
				modelAndView.addObject("isAdd", false);
			}
			modelAndView.getModel().putAll(bindingResult.getModel());
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public void update(@RequestParam("id") int restaurantId, Model model){
		Restaurant restaurant = restaurantService.getRestaurantById(restaurantId);
		model.addAttribute("restaurant", restaurant);
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("restaurant") Restaurant restaurant, MultipartFile file, BindingResult bindingResult){
		ModelAndView modelAndView = new ModelAndView("/restaurant/updateok");
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
			restaurantService.updateRestaurant(restaurant);
		}else{
			// 에러가 있으면 원래 화면으로 돌아감
			modelAndView = new ModelAndView();
			modelAndView.getModel().putAll(bindingResult.getModel());
		}
		
		return modelAndView;
	}
		
	@RequestMapping("/delete")
	public String delete(@RequestParam("id") int restaurantId){
		restaurantService.deleteRestaurant(restaurantId);
		return "redirect:/restaurant/list";
	}
	
	@RequestMapping("/count")
	public String getCount(){
		System.out.println(restaurantService.getCount());
		
		return "/restaurant/index";
	}
}
