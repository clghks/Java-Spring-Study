package com.clghks.spring.service;

import java.util.List;

import com.clghks.spring.dto.Contact;

public interface ContactService {
	public List<Contact> getAllContacts();
	
	public void insertContact(Contact contact);
}
