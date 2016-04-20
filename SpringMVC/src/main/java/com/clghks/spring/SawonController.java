package com.clghks.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Sawon")
public class SawonController {
	
	@RequestMapping
	public String index(){
		return "/sawonView";
	}
	
	
}
