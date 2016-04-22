<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>레스토랑 추가</title>
</head>
<body>
	<form:form
		modelAttribute="restaurant" method="post" enctype="multipart/form-data"
	>
		<p>
			<form:label path="resturantName">레스토랑 명 : </form:label>
			<form:input path="resturantName"/>
			<form:errors path="resturantName"></form:errors>
		</p>
		
		<p>
			<form:label path="lat">위도 : </form:label>
			<form:input path="lat"/>
			<form:errors path="lat"></form:errors>
		</p>
		
		<p>
			<form:label path="lon">경도 : </form:label>
			<form:input path="lon"/>
			<form:errors path="lon"></form:errors>
		</p>
		
		<p>
			<form:label path="pr">소개말 : </form:label>
			<form:textarea path="pr" rows="4" cols="70"/>
		</p>
		
		<p>
			<form:label path="image">레스토랑 이미지 : </form:label>
			<input type="file" name="file"/>
		</p>
		<input type="submit" value="추가">
	</form:form>

</body>
</html>