package com.clghks.springjdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContactApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		ContactsDao contactsDao = (ContactsDao) context.getBean("contactsDao");
		for(Contact contact : contactsDao.getContactsList()){
			System.out.println("성 : " + contact.getFirstName() + ", 이름 : " + contact.getLastName());
		}
	}
}
