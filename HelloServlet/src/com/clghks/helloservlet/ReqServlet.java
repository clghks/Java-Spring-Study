package com.clghks.helloservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
			writer.println(hederName + " : ");
			writer.println(req.getHeader(hederName) + "<br/>");
		}
		writer.println("ip : " + req.getRemoteAddr());
		
		writer.println("</body>");
		writer.print("</html>");
		
//		요청이 사라진다 (다른 곳으로 보낼때)
//		resp.sendRedirect("http://www.naver.com");

//		다른 곳으로 요청을 보낸다 (요청을 재사용할수 있다?)
//		ServletContext context = getServletContext();
//		RequestDispatcher dispatcher = context.getRequestDispatcher("/HelloWorld");
//		dispatcher.forward(req, resp);
		
//		값을 추가해서 전달 할때
		req.setAttribute("userId", "clghks");
		
//		Requset에서도 dispatcher를 가져 올 수 있다. (위에 코드랑 차이가 없다???) 
		RequestDispatcher dispatcher = req.getRequestDispatcher("/HelloWorld");
		dispatcher.forward(req, resp);
		
		
	}
	
}
