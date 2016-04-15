<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String phone = request.getParameter("phone");
	%>
	<h2><%= phone%>입니다.</h2>
	<%
	switch(phone){
	case "아이폰":
		%> 
		<img src="http://techholic.co.kr/wp-content/uploads/2013/09/iPhone5s_Gld_iOS7_PRINT.jpg">		<%
		break;
		
	case "갤럭시":
		%> 
		<img src="https://farm2.staticflickr.com/1507/25080737221_dd109d20e7_b.jpg">
		<%
		break;
		
	case "옵티머스":
		%> 
		<img src="http://www.hellombl.com/upload/adboard/sb1502/145648457939063_p7wa.jpg">		
		<%
		break;
		
	case "베가":
		%> 
		<img src="http://file.ivega.co.kr/upload/product/feature/1399510705350_30l7m0.jpg">		
		<%
		break;
	}
%>    

