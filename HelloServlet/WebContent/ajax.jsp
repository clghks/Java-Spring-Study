<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="xmlhttp.js"></script>
<script type="text/javascript">
	function LoadFile(phone) {
		httpObj = createXMLHttp(readComplete);
		var phonePage = "";
		if(httpObj){
			httpObj.open("GET", "phoneList.jsp?phone=" + phone, true);
			httpObj.send(null);
		}else{
			alert("지원하지 않는 브라우저 입니다.");
		}
	}
	
	function readComplete(){
		if((httpObj.readyState == 4) && (httpObj.status == 200)){
			document.getElementById("result").innerHTML = httpObj.responseText;			
		}else{
			document.getElementById("result").innerHTML = "<b>Loding..</b>"
		}
	}
</script>
</head>

<body>
	<form name="ajaxForm">
		<input type="button" onclick="LoadFile('아이폰')" value="아이폰" />
		<input type="button" onclick="LoadFile('갤럭시')" value="갤럭시" />
		<input type="button" onclick="LoadFile('옵티머스')" value="옵티머스" />
		<input type="button" onclick="LoadFile('베가')" value="베가"/>
	</form>
	
	<div id="result">
	
	</div>
</body>
</html>