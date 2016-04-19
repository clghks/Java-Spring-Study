<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring 3.0 MVC : Hello World</title>
</head>
<body>
	<p>모델값 호출</p>
	<url>
		<li>message1 = ${message1} </li>
		<li>message1(커스텀태그로부터) = <c:out value="${message1}" /> </li>

		<li>message2 = ${message2} </li>
		<li>currentDate(포맷적용) = <fmt:formatDate value="${currentDate}" pattern="yyyy년 MM월 dd일" /> </li>
		
	</url>
</body>
</html>