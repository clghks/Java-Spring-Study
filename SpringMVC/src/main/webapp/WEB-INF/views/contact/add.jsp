<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form
		modelAttribute="contact"
		method="post"
	>
		<p>
			<form:label path="lastName">성:</form:label>
			<form:input path="LastName"/>
		</p>
		
		<p>
			<form:label path="firstName">이름:</form:label>
			<form:input path="firstName"/>
		</p>
		<input type="submit" value="추가">
	</form:form>
</body>
</html>