package com.clghks.spring;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {

	@RequestMapping("/hello")
	public ModelAndView helloworld(){
		ModelAndView mav = new ModelAndView("/helloview");

		mav.addObject("message1", "<strong>Spring mvc</strong>");
		mav.getModelMap().put("message2", "메시지2");
		mav.addObject("currentDate", new Date());
		return mav;
	}
	
	@RequestMapping("/hello2")
	public ModelAndView helloworld2(){
		ModelAndView mav = new ModelAndView();

		mav.setViewName("/helloview");
		mav.addObject("message1", "<strong>Spring mvc</strong>");
		mav.getModelMap().put("message2", "메시지2");
		mav.addObject("currentDate", new Date());
		return mav;
	}
}
