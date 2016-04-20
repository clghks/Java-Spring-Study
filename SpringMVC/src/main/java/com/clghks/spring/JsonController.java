package com.clghks.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/json")
public class JsonController {
	
	@RequestMapping("/jsonOut")
//	@RequestMapping(value="/jsonOut",  produces="application/json;charset=UTF-8")
	@ResponseBody
	public List<UserInfoDto> jsonOut(){
		List<UserInfoDto> userInfoDtos = new ArrayList<UserInfoDto>();
		userInfoDtos.add(new UserInfoDto("영업", "홍길동1"));
		userInfoDtos.add(new UserInfoDto("영업", "홍길동2"));
		userInfoDtos.add(new UserInfoDto("기획", "홍길동3"));
		userInfoDtos.add(new UserInfoDto("기획", "홍길동4"));
		userInfoDtos.add(new UserInfoDto("기획", "홍길동5"));
		userInfoDtos.add(new UserInfoDto("개발", "홍길동6"));
		userInfoDtos.add(new UserInfoDto("개발", "홍길동7"));
		userInfoDtos.add(new UserInfoDto("개발", "홍길동8"));
		userInfoDtos.add(new UserInfoDto("개발", "홍길동9"));
		userInfoDtos.add(new UserInfoDto("영업", "홍길동10"));
		userInfoDtos.add(new UserInfoDto("영업", "홍길동11"));
		
		return userInfoDtos;
	}
	
}
