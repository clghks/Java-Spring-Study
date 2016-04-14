package com.clghks.helloservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "HelloWorld2", urlPatterns = {"/ShowDate"})
public class HelloWorld2 extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7223982185495920155L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
	
		PrintWriter printWriter = resp.getWriter();
		printWriter.println("now = " + new Date());
	}
}
