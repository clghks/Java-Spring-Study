package com.clghks.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clghks.spring.dto.Contact;
import com.clghks.spring.service.ContactService;

@Controller
@RequestMapping("/Sawon")
public class SawonController {

	@Autowired
	private ContactService contactService;
	
	@RequestMapping
	public String index(Model model){
		List<Contact> list = contactService.getAllContacts();
		model.addAttribute("model", list);
		
		return "/sawonView";
	}
}
