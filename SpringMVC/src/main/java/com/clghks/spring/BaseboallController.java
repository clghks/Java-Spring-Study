package com.clghks.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/baseball")
public class BaseboallController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String index(){
		return "/baseball/index";
	}
	
	@RequestMapping(value="/team", method={RequestMethod.GET})
	public ModelAndView showTeam(@RequestParam(value="name", required=true) String teamName){
		ModelAndView modelAndView = new ModelAndView("/baseball/teamView");
		modelAndView.addObject("teamName", teamName);
		
		return modelAndView;
	}
}
