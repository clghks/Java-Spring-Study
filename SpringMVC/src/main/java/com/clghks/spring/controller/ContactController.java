package com.clghks.spring.controller;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.clghks.spring.dto.Contact;

@Controller
@RequestMapping("/contact")
public class ContactController {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setJdbcTemplate(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@RequestMapping
	public String index(Model model){
		String sql = "SELECT * FROM contacts";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		model.addAttribute("model", list);
		
		return "/contact/index";
	}
	
	@ModelAttribute("contact")
	public Contact initContact(){
		Contact contact = new Contact();
		return contact;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addContact(Model model, @ModelAttribute("contact") Contact contact){
		model.addAttribute("contact", contact);
		return "/contact/add";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView addContact(@ModelAttribute("contact") Contact contact, BindingResult bindingResult){
		if (bindingResult.hasErrors()){
			System.out.println("오류~~~~");
		}
		ModelAndView modelAndView = new ModelAndView("/contact/addResult");
		modelAndView.addObject("contact", contact);
		return modelAndView;
	}
	
}
