package com.clghks.helloservlet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/contactServlet")
@MultipartConfig(maxFileSize=16177215) // 16MB
public class ContactServlet extends HttpServlet{
	
	// db 설정
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");

		InputStream inputStream = null;
		Part filePart = req.getPart("photo");
		if(filePart != null){
			System.out.println("fileName : " + filePart.getName());
			System.out.println("fileSize : " + filePart.getSize());
			System.out.println("contentType" + filePart.getContentType());
			
			inputStream = filePart.getInputStream();
		}
		
		Connection conn = null;
		String msg = null;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			conn = DriverManager.getConnection(AppConfig.dbURl, AppConfig.dbUser, AppConfig.dbPass);
			
			String sql = "INSERT INTO contacts (first_name, last_name, photo) values (? , ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, firstName);
			stmt.setString(2, lastName);
			if(inputStream != null){
				stmt.setBlob(3, inputStream);
			}
			
			int row = stmt.executeUpdate();
			if(row > 0){
				msg = "성공적으로 입력했습니다.";
			}
		} catch(SQLException se){
			msg = "에러 발생 : " + se.getMessage();
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		req.setAttribute("message", msg);
		getServletContext().getRequestDispatcher("/Message.jsp").forward(req, resp);
	}	
}
