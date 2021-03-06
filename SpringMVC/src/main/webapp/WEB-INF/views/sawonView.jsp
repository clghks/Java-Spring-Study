<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.12.3.min.js"/>"></script>

<body>
	<ul>
		<li><span id="marketing" data-cd="영업" value="영업">영업</span></li>
		<li><span id="dev" value="개발">개발</span></li>
		<li><span id="plan" value="기획">기획</span></li>
	</ul>
	
	<ul>
		<li><span id="marketing">영업부</span></li>
		<li><span id="newSawon">신입사원 추가</span></li>
	</ul>
	
	<h1>전체 사원 명단</h1>
	<c:forEach var="item" items="${model}">
		<li>${item.contactId} ${item.firstName} ${item.lastName}</li>
	</c:forEach>
	
	<p id="result"></p>
	
	<script type="text/javascript">
		$(document).ready(function(){
			$("span").click(function(){
				$.ajax({
					type: "post",
					url: "<c:url value="/json/jsonOut" />",
					data: {"cd": $(this).attr("value")},
					dataType: "json",
					success: function(data){
						var html = "<ul>";
						for(var i=0; i<data.length; i++){
							html += "<li>" + data[i].name + "</li>";
						}
						html += "</ul>";
						$("#result").empty();
						$("#result").append(html);

					},
					errer: function(xhr, status, err){
						alert(err);
					}
				})
			});
			
			$("#newSawon").click(function(){
				var datas = {
					cd:"영업",
					name:"김태희"
				};
				$.ajax({
					type: "POST",
					url: "<c:url value="/json/jsonIn" />",
					contentType: "application/json;charset=UTF-8",
					data : '{"cd":"영업부", "name":"김태희"}',
					dataType: "html",
					success: function(data){
						$("#result").empty();
						$("#result").append(data);
					},
					error: function(xhr, status, error){
						alert(error);
					}
				})
			});
		})
	</script>
</body>
</html>
