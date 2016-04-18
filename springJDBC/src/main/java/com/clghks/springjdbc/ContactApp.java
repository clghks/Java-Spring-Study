package com.clghks.springjdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.clghks.springjdbc.jdbc.ContactsDao;

public class ContactApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		ContactsDao contactsDao = (ContactsDao) context.getBean("contactsDao");
		
		for(Contact contact : contactsDao.getContactsList()){
			System.out.println("이름 : " + contact.getFirstName() + " " + contact.getLastName());
		}
		System.out.println();
		
		ContactsDao contactsDao2 = (ContactsDao) context.getBean("contactsDao2");
		for(Contact contact : contactsDao2.getContactsList()){
			System.out.println("이름 : " + contact.getFirstName() + " " + contact.getLastName());
		}
	}
}
