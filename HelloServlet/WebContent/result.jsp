<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		session.setAttribute("userId", "clghks");
		Calendar calendar = new GregorianCalendar();
	%>
	<jsp:forward page="yoil.jsp" >
		<jsp:param value="<%= calendar.get(Calendar.DAY_OF_WEEK) %>" name="yo"/>
	</jsp:forward>
</body>
</html>