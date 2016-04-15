<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*, java.sql.*" %>    
   	<%!
		private String dbURl = "jdbc:mysql://hanromeo9.cafe24.com:3306/hanromeo9?useUnicode=true";
		private String dbUser = "hanromeo9";
		private String dbPass = "clghks123";
	%>
	    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Connection conn = null;
	String msg = null;
	try {
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		conn = DriverManager.getConnection(dbURl, dbUser, dbPass);
		
		String sql = "select * from contacts";
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		ResultSet resultSet = stmt.executeQuery();
		
		%>
		<table border="1" width="100%">
		<colgroup>
			<col width="20%"/>
			<col width="30%"/>
			<col width="30%"/>
			<col width="20%"/>
		</colgroup>
			
			<tr>
				<th>ID</th>
				<th>성</th>
				<th>이름</th>
				<th>이미지</th>
			</tr>
		<%			
		while(resultSet.next()){
%>
			<tr>
				<th><%= resultSet.getInt("contact_id") %></th>
				<th><%= resultSet.getString("first_name") %></th>
				<th><%= resultSet.getString("last_name") %></th>
				<th>(<a href="Show.jsp?id=<%= resultSet.getInt("contact_id") %>">Show Image</a>)</th>
			</tr>
<%			
		}
%> 			
		</table>
<%		
	} catch (Exception e) {
		e.printStackTrace();
		
		%> 예외 발생 : <%= e.getMessage()%> <%
	} finally {
		try {
			if(conn != null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
%>

</body>
</html>