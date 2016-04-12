package com.clghks.helloservlet;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class CheckSessionListener implements HttpSessionListener {
	private static int sesstionCount = 0;
	
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		sesstionCount++;
		HttpSession session = arg0.getSession();
		System.out.println("sessionCreated sessionCount : " + sesstionCount + ", session Id : " + session.getId());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		sesstionCount--;
		HttpSession session = arg0.getSession();
		System.out.println("sessionDestroyed sessionCount : " + sesstionCount + ", session Id : " + session.getId());
	}

}
