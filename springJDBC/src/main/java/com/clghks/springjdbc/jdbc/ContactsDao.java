package com.clghks.springjdbc.jdbc;

import java.util.List;

import com.clghks.springjdbc.Contact;

public interface ContactsDao {
	public List<Contact> getContactsList();
}
