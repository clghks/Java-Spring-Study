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
//	@RequestMapping(value="/jsonOut",  produces="application/json")
	@ResponseBody
	public List<UserInfoDto> jsonOut(){
		List<UserInfoDto> userInfoDtos = new ArrayList<UserInfoDto>();
		userInfoDtos.add(new UserInfoDto("영업", "홍길동1"));
		userInfoDtos.add(new UserInfoDto("영업", "홍길동2"));
		userInfoDtos.add(new UserInfoDto("영업", "홍길동3"));
		
		return userInfoDtos;
	}
	
}
