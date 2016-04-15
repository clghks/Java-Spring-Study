<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>&{fn:escapeXml("<b>My Movie</b>")}</h1>
	<c:set var="movie" value="    국제시장,     서울시장,      대구시장,     광주시장" />
	<h2>${fn:contains(movie, "국제")}</h2>
	<c:if test="${fn:contains(movie, '국제')}">
	 	yes
	</c:if>
	
	<h3>${fn:length(movie)}</h3>
	<h3>${fn:replace(movie, '시장', 'Market')}</h3>
	<c:set var="m_array" value="${fn:split(movie, ',')}" />
	<c:forEach var="m" items="${m_array}">
		<li>${fn:trim(m)}</li>
	</c:forEach>
	
	${fn:join(m_array, '|')}
</body>
</html>