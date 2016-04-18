package com.clghks.springjdbc.jdbc.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.clghks.springjdbc.Contact;
import com.clghks.springjdbc.jdbc.ContactsDao;
import com.clghks.springjdbc.mapper.ContactsMapper;

public class MyBatisContactsDao implements ContactsDao{
	
	@Autowired
	private ContactsMapper contactsMapper;
	
	public List<Contact> getContactsList() {
		return contactsMapper.getAllContacts();
	}

}
