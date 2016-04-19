package com.clghks.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseboallController {
	
	@RequestMapping("/baseball")
	public String index(){
		return "/baseball/index";
	}
	
}
