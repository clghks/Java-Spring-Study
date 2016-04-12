package com.clghks.helloservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReqServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 응답을 한글로 보내기 위해서 처리
		resp.setContentType("text/html; charset=euc-kr");
		
		// 파라미터를 받기 전에 설정 해야함
		req.setCharacterEncoding("euc-kr");

		String name = req.getParameter("name");
		String[] propertys = req.getParameterValues("property");
		
		PrintWriter writer = resp.getWriter();
		writer.println("<html>");
		writer.println("<body>");
		writer.println(name + " <br/>");
		for (String property : propertys) {
			writer.println(property + " <br/>");
		}
		
//		해더 정보 구하기 
		writer.println("------ 해더 정보 구하기 ------<br/>");
		Enumeration<String> hedars = req.getHeaderNames();
		while(hedars.hasMoreElements()){
			String hederName = hedars.nextElement();
			writer.println(hederName + "<br/>");
			writer.println(req.getHeader(hederName) + "<br/>");
		}
		
		writer.println("</body>");
		writer.print("</html>");
	}
	
}
