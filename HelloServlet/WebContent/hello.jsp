<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@ include file="param.jsp" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<!-- HTML 주석 -->
	<!-- 소스보기에서 주석이 표시 된다. -->

	<%-- JSP 주석 --%>
	<%-- 소스보기에서 주석이 표시 안된다. --%>	
		
	<%-- 메소드 선언 --%>
	<%!
		public Date test(){
			return new Date();
		}
	%>
	
	<%-- 출력? --%>
	<%
		out.println("x = " + x);
		x++;
	%>
	
	<%-- 출력? --%>
	<h3>결과 : <%= x %></h3>
	<h3>Test 결과 : <%=test() %> </h3>
</body>
</html>