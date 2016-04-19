package com.clghks.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("mlb")
public class MlbController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String index(){
		return "/mlb/index";
	}
}
