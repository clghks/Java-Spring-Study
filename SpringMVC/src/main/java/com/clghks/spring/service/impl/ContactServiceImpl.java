package com.clghks.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clghks.spring.dto.Contact;
import com.clghks.spring.mapper.ContactsMapper;
import com.clghks.spring.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService{
	@Autowired
	private ContactsMapper contactMapper;
	
	@Override
	public List<Contact> getAllContacts() {
		return contactMapper.getAllContacts();
	}

}
