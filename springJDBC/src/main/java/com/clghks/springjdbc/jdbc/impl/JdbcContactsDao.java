package com.clghks.springjdbc.jdbc.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.clghks.springjdbc.Contact;
import com.clghks.springjdbc.jdbc.ContactsDao;

@Component("contactsDao1")
public class JdbcContactsDao implements ContactsDao{

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Contact> getContactsList() {
		String sql = "SELECT * FROM contacts";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		
		List<Contact> contacts = new ArrayList<Contact>();
		for(Map<String, Object> map : list){
			Contact contact = new Contact();
			contact.setFirstName(map.get("first_name").toString());
			contact.setLastName(map.get("last_name").toString());
			contacts.add(contact);
		}
		return contacts;
	}

}
