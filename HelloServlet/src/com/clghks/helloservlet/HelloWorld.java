package com.clghks.helloservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
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
//		writer.println("<html>");
//		writer.println("<body>");
		writer.println("<h1>Hello World!</h1><br/>");
		writer.println("sesstion : " + req.getSession().getAttribute("userId") + ", " + req.getSession().getMaxInactiveInterval() + " <br/>");

		ServletContext context = getServletContext();
		writer.println("app : " + context.getAttribute("userId") + " <br/>");

		writer.println(getServletConfig().getInitParameter("msg") + ", " + getServletConfig().getInitParameter("msg1") + " <br/>");
		
		writer.println(getServletContext().getInitParameter("msg2") + ", " + getServletContext().getInitParameter("msg3") + " <br/>");

		String[] propertys = req.getParameterValues("property");
		for (String property : propertys) {
			writer.println(property + " <br/>");
		}
		
//		writer.println("</body>");
//		writer.print("</html>");
	}
	
}
