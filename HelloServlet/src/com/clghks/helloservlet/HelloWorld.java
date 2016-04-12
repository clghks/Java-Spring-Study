package com.clghks.helloservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorld extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		아무 동작을 하지 않음 
//		super.service(arg0, arg1);
		
		PrintWriter writer = res.getWriter();
		writer.println("<html>");
		writer.println("<body><h1>Hello World!</h>");
		writer.println(req.getAttribute("userId") + " <br/>");
		String[] propertys = req.getParameterValues("property");
		for (String property : propertys) {
			writer.println(property + " <br/>");
		}
		
		writer.println("</body>");
		writer.print("</html>");
	}
	
}
