<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@ taglib uri="http://www.clghks.co.kr/tags" prefix="ora"%>
<%@ taglib uri="http://www.clghks.co.kr/ageTag" prefix="ora1" %>
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
	
	<%
		Calendar calendar = new GregorianCalendar();
		calendar.set(1986, 9, 1);
		
		Date birth = calendar.getTime();
	%>
	
	<%-- ���? --%>
	<h3>��� : <%= x %></h3>
	<h3>Test ��� : <%=test() %> </h3>
	
	<h3><ora:helloTag message="�ȳ��ϼ���."/></h3>
	
	<h3>����: <ora1:ageTag birthday="<%=birth %>"/></h3>
</body>
</html>