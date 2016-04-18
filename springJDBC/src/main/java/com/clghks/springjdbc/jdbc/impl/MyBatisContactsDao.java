package com.clghks.springjdbc.jdbc.impl;

import java.util.List;

import com.clghks.springjdbc.Contact;
import com.clghks.springjdbc.jdbc.ContactsDao;
import com.clghks.springjdbc.mapper.ContactsMapper;

public class MyBatisContactsDao implements ContactsDao{
	
	private ContactsMapper contactsMapper;
	
	public void setContactsMapper(ContactsMapper contactsMapper) {
		this.contactsMapper = contactsMapper;
	}

	public List<Contact> getContactsList() {
		return contactsMapper.getAllContacts();
	}

}
