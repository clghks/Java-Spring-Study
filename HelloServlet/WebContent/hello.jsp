<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@ include file="param.jsp" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<!-- HTML �ּ� -->
	<!-- �ҽ����⿡�� �ּ��� ǥ�� �ȴ�. -->

	<%-- JSP �ּ� --%>
	<%-- �ҽ����⿡�� �ּ��� ǥ�� �ȵȴ�. --%>	
		
	<%-- �޼ҵ� ���� --%>
	<%!
		public Date test(){
			return new Date();
		}
	%>
	
	<%-- ���? --%>
	<%
		out.println("x = " + x);
		x++;
	%>
	
	<%-- ���? --%>
	<h3>��� : <%= x %></h3>
	<h3>Test ��� : <%=test() %> </h3>
</body>
</html>