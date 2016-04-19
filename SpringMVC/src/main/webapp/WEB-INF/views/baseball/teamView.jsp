<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${teamName} 프로야구팀 소개입니다.</title>
</head>
<body>
	<h3>${teamName} 프로야구팀 소개입니다.</h3>
	
	<%
		String teamName = request.getParameter("name");
		if("dodgers".equals(teamName)){
			%>
				<img src="/spring/resources/la.jpg"> 
				<h1>로스앤젤레스 다저스는 미국 캘리포니아 주 로스앤젤레스를 연고지로 하는 프로 야구 팀이다. 메이저 리그 내셔널 리그 서부 지구 소속이다. 이 팀은 1883년, 뉴욕의 브루클린에서 브루클린 다저스로 시작해 1958년 캘리포니아 주의 로스앤젤레스로 연고지를 옮겼다. 홈구장은 다저 스타디움이다. 샌프란시스코 자이언츠와는 라이벌 관계다.</h1>
			<%
		}else if("boston".equals(teamName)){
			%>
				<img src="https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcS_ZnUrvK3zFKXrMFBM5S0-WdNgJDw0Kc_82-j83Zw7PUvVa2H8thhMdtjc"> 
				<h1>보스턴 레드삭스는 미국 매사추세츠 주 보스턴에 연고를 두고 있는 프로 야구 팀으로, 메이저 리그 베이스볼의 아메리칸 리그 동부 지구에 속해있다. 1901년 아메리칸 리그의 8개 프랜차이즈 팀 중 하나로 창단되었으며, 1912년부터 펜웨이 파크를 홈구장으로 사용해오고 있다. ‘레드삭스’라는 팀명은 1908년 경 구단주인 존 테일러가 지은 것이며, 이전의 보스턴 팀은 ‘레드스타킹스’가 있었다. 월드 시리즈 7회 우승의 전력을 가지고 있다.</h1>
			<%
		}else if("baltimore".equals(teamName)){
			%>
				<img src="https://lh3.googleusercontent.com/-LKshlT4uM4s/VxECKZ18dqI/AAAAAAAAUpE/_L7l-a8_EbwhXUmX94gIsMF1haLr0LKzg/w852-h474/img20160415-26551-90toxq"> 
				<h1>볼티모어 오리올스는 미국 메릴랜드 주 볼티모어를 연고지로 하는 프로 야구팀이다. 메이저 리그 아메리칸 리그 동부 지구 소속이다. 팀 이름의 유래는 꾀꼬리가 메릴랜드 주의 상징새인 이유로 이름이 붙은 것이다. 현재 구단주로는 피터 안젤로스가 있으나, 칼 립켄 주니어가 이끄는 투자단에게 구단을 매각하라는 압력이 갈수록 거세지고 있는데, 그 이유는 피터 안젤로스의 무능함이 지적되고 있다. 감독으로는 벅 쇼월터, 단장으로는 앤디 맥파일이 있다.</h1>
			<%
		}
	%>
</body>
</html>