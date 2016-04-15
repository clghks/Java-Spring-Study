<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="xmlhttp.js"></script>
<script type="text/javascript">
	function LoadXML() {
		httpObj = createXMLHttp(readComplete);
		var phonePage = "";
		if(httpObj){
			httpObj.open("GET", "user.xml", true);
			httpObj.send(null);
		}else{
			alert("지원하지 않는 브라우저 입니다.");
		}
	}
	
	function readComplete(){
		if((httpObj.readyState == 4) && (httpObj.status == 200)){
			var xmlData = httpObj.responseXML;
			var irum_tag = xmlData.getElementsByTagName("Irum");
			var htmlData = "";
			for (var i = 0; i < irum_tag.length; i++) {
				htmlData += "<b>" + irum_tag[i].childNodes[0].nodeValue + "</b><br/>"
			}
			document.getElementById("result").innerHTML = htmlData;
		}else{
			document.getElementById("result").innerHTML = "<b>Loding..</b>"
		}
	}
</script>
</head>

<body>
	<form name="ajaxForm">
		<input type="button" onclick="LoadXML()" value="XML" />
	</form>
	
	<div id="result">
	
	</div>
</body>
</html>