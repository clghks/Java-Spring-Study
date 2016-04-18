package com.clghks.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		HelloWorld obj = (HelloWorld) context.getBean("hello");
		obj.getInsa();
	}
	
}
