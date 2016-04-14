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
		int yoil = Integer.parseInt(request.getParameter("yo"));
		switch(yoil){
		case 1:	// 일요일
		%>
			<img src="shk.jpg" />
		<%
			break;
			
		case 5:
			out.println(session.getAttribute("userId") + " 어서오세요~");
			out.println(application.getInitParameter("msg2"));
		%>
			<br/><img src="sh.jpg" height="500"/>
		<%
				break;	
		}
	%>
</body>
</html>