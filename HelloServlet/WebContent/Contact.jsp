<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>주소록 입력</h1>
	<form action="contactServlet" method="post" enctype="multipart/form-data">
		<table border="0">
			<tr>
				<td>이름 : </td>
				<td><input type="text" name="lastName" size="45" /></td>
			</tr>
			<tr>
				<td>성 : </td>
				<td><input type="text" name="firstName" size="45" /></td>
			</tr>
			<tr>
				<td>사진 : </td>
				<td><input type="file" name="photo" size="45" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="저장">
			</td>
		</table>
	</form>
</body>
</html>