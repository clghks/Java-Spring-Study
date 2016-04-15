package com.clghks.helloservlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/imageServlet")
public class ImageServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Connection conn = null;
		String msg = null;
		try {
			int id = Integer.parseInt(req.getParameter("id") + "");

			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			conn = DriverManager.getConnection(AppConfig.dbURl, AppConfig.dbUser, AppConfig.dbPass);
			
			String sql = "SELECT photo From contacts WHERE contact_id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			
			ResultSet resultSet = stmt.executeQuery();
			if (resultSet.next()){
				Blob blob = resultSet.getBlob("photo");
				InputStream inputStream = blob.getBinaryStream();
				OutputStream outputStream = resp.getOutputStream();
				resp.setContentType("image/jpeg");
				
				byte[] buffer = new byte[1024];
				int byteRead = -1;
				while((byteRead = inputStream.read(buffer)) != -1){
					outputStream.write(buffer, 0, byteRead);
				}
				inputStream.close();
				outputStream.close();
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

	}
	
}
