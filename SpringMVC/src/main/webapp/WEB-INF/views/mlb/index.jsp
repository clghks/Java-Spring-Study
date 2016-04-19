<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/spring/resources/js/jquery-1.12.3.min.js"></script>
<script type="text/javascript">
	function GetXmlTeam(){
		$.ajax({
			type: "post",
			url: "/spring/ajax/xmlTeam",
			dataType: "xml",
			success: function(data){
				alert(data);
			},
			errer: function(xhr, status, err){
				alert(err);
			}
			
		})
		
	}
</script>
</head>
<body>
	<a href="#" onclick="GetXmlTeam()">보스턴 가져오기</a>
</body>
</html>