package com.clghks.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseboallController {
	
	@RequestMapping("/baseball")
	public String index(){
		return "forward:/baseball2";
	}
	
	@RequestMapping("/baseball1")
	public String baseball1(){
		return "redirect:/baseball3";
	}
	
	@RequestMapping("/baseball4")
	public String baseball4(){
		return "redirect:http://www.naver.com";
	}
	
	@RequestMapping("baseball2")
	public String baseball2(){
		return "/baseball/index2";
	}
	
	@RequestMapping("baseball3")
	public String baseball3(){
		return "/baseball/index3";
	}
	
}
