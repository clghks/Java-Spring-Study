package com.clghks.helloservlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class InitializeListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext context = event.getServletContext();
		context.setAttribute("msg4", "Good night");
		
		String msg2 = (String) context.getInitParameter("msg2");
		System.out.println("contextInitialized msg2 : " + msg2);
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("contextDestroyed");
	}
}
