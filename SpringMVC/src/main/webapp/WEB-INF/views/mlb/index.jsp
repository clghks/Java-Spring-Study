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
				var teamHtml = "";
				$(data).find("Team").each(function(){
					$(this).find("name").each(function(){
						var name = $(this).text();
						teamHtml = "<p>" + name + "</p>";
					})
					
					$(this).find("logo").each(function(){
						var logo = $(this).text();
						// teamHtml += "<img src='/mvc/resources/img/" + logo + "'/>";
						teamHtml += "<img src='" + logo + "'/>";
					})
					$("#result").empty();
					$("#result").append(teamHtml);
				})
			},
			errer: function(xhr, status, err){
				alert(err);
			}
			
		})
	}
	
	function GetXmlTeams(){
		$.ajax({
			type: "post",
			url: "/spring/ajax/xmlMlb",
			dataType: "xml",
			success: function(data){
				var teamHtml = "<table>";
				teamHtml += "<tr>";
				teamHtml += "<th>로고</th>";
				teamHtml += "<th>팀명</th>";
				teamHtml += "</tr>";
				$(data).find("TeamList").each(function(){
					$(this).find("teamList").each(function(){
						var logo = $(this).find("logo").text();
						teamHtml += "<tr><th><img src='" + logo + "' height='200' /></th>";
						var name = $(this).find("name").text();
						teamHtml += "<th>" + name + "</th></tr>";
					})
				})
				teamHtml += "</table>";
				$("#result").empty();
				$("#result").append(teamHtml);

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
	<a href="#" onclick="GetXmlTeams()">MLB 가져오기</a>
	<p id="result" />
</body>
</html>