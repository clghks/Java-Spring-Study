package com.clghks.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/json")
public class JsonController {
	
	@RequestMapping("/jsonOut")
//	@RequestMapping(value="/jsonOut",  produces="application/json;charset=UTF-8")
	@ResponseBody
	public List<UserInfoDto> jsonOut(@RequestParam String cd){
		if (cd == null || "".equals(cd)){
			return new ArrayList<UserInfoDto>();
		}
		
		List<UserInfoDto> userInfoDtos = new ArrayList<UserInfoDto>();
		if("영업".equals(cd)){
			userInfoDtos.add(new UserInfoDto("영업", "홍길동1"));
			userInfoDtos.add(new UserInfoDto("영업", "홍길동2"));
			userInfoDtos.add(new UserInfoDto("영업", "홍길동10"));
			userInfoDtos.add(new UserInfoDto("영업", "홍길동11"));
		}else if("기획".equals(cd)){
			userInfoDtos.add(new UserInfoDto("기획", "홍길동3"));
			userInfoDtos.add(new UserInfoDto("기획", "홍길동4"));
			userInfoDtos.add(new UserInfoDto("기획", "홍길동5"));
		}else if("개발".equals(cd)){
			userInfoDtos.add(new UserInfoDto("개발", "홍길동6"));
			userInfoDtos.add(new UserInfoDto("개발", "홍길동7"));
			userInfoDtos.add(new UserInfoDto("개발", "홍길동8"));
			userInfoDtos.add(new UserInfoDto("개발", "홍길동9"));
		}

		return userInfoDtos;
	}
	
	// spring 3.1~
	@RequestMapping(value="/jsonIn", consumes="application/json")
//	spring 3.0
//	@RequestMapping(value="/jsonIn", headers="application/json")
	public ModelAndView showSawon(@RequestBody UserInfoDto dto){
		ModelAndView modelAndView = new ModelAndView("/showSawonView");
		modelAndView.addObject("model", dto);

		return modelAndView;
	}
	
	
}
