<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>레스토랑 리스트</title>
</head>
<body>
	<h1>레스토랑 리스트</h1>
	<table border="1" width="100%">
		<colgroup>
			<col width="20%"/>
			<col width="30%"/>
			<col width="20%"/>
			<col width="20%"/>
		</colgroup>
			
			<tr>
				<th>이미지</th>
				<th>이름</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>
		<c:forEach var="item" items="${list}">
			<tr>
				<th><img src="<c:url value="/restaurant/getImage?id=${item.resturantId}" />" height="100"/></th>
				<th>${item.resturantName}</th>
				<th><a href="<c:url value="/restaurant/edit?id=${item.resturantId}" />">[수정]</a></th>
				<th><a href="<c:url value="/restaurant/delete?id=${item.resturantId}" />">[삭제]</a></th>
			</tr>
		</c:forEach>
	</table>
	
	<div id="pagingView">
		<c:forEach begin="1" end="${allpage}" var="i">
			<c:if test="${i eq page}">
				${i} &nbsp;
			</c:if>
			<c:if test="${i ne page}">
				<a href="<c:url value="/restaurant/list?page=${i}" />">${i}</a> &nbsp;
			</c:if>
		</c:forEach>
	</div>
</body>
</html>