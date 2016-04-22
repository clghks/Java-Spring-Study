<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${restaurant.resturantName} 리뷰</title>
</head>
<body>
	<h3>${restaurant.resturantName}</h3>
	<img src="<c:url value="/restaurant/getImage?id=${restaurant.resturantId}" />" height="100"/>
	
	<c:set var="newline" value="\n"></c:set>
	<p>좌표 : ( ${restaurant.lat}, ${restaurant.lon} )</p>
	<p>평점 : ${average}</p>
	<p>소개말 : ${fn:replace(restaurant.pr, newline, '<br/>')}</p>
	<hr />
	
	<form:form
		modelAttribute="review"
		method="post"
	>
		<form:input path="rid" value="${restaurant.resturantId}" type="hidden"/>
		<p>
			<form:label path="rate">평점 : </form:label>
			<form:select path="rate" items="${startList}"/>
			<form:errors path="rate" cssClass="error"/>
		</p>
		
		<p>
			<form:label path="body">내용 : </form:label>
			<form:textarea path="body" rows="4" cols="70"/>
			<form:errors path="body" cssClass="error"/>
		</p>
		<input type="submit" value="쓰기">
	</form:form>
	<hr />
	
	<c:set var="appUrl" value="<%= request.getContextPath() %>" />
		<c:forEach var="review" items="${reviewList}">
			<table>
				<tr>
					<th>
						<c:forEach begin="1" end="${review.rate}">
						★
						</c:forEach>
					</th>
					<th>
						${review.body}
					</th>
					<th>
						<fmt:formatDate value="${review.update}" pattern="yyyy-MM-dd"/>
					</th>
					<th>
						<form:form modelAttribute="review" method="post" action="${appUrl}/review/delete/${review.resturantId}?rid=${review.rid}&uid=${review.uid}">
							<input type="submit" value="삭제" />
						</form:form>
					</th>			
				</tr>
			</table>
		</c:forEach>
</body>
</html>