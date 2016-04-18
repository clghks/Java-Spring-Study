package com.clghks.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonApp {
	public static void main(String[] args) {
		String[] config = {"beans.xml", "beans2.xml", "beans3.xml"};
		ApplicationContext context = new ClassPathXmlApplicationContext(config);
		
		Person person = (Person) context.getBean("choi");
		person.result();
		System.out.println();
		
		Person personKim = (Person) context.getBean("kim");
		personKim.result();
		System.out.println();

		Person personLee = (Person) context.getBean("lee");
		personLee.result();

	}
}
