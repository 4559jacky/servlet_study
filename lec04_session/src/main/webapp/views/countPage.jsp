<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%	
	// 방문 횟수를 저장하는 쿠키를 생성합니다.
	// 쿠키의 key값은 visit_count입니다.
	// 쿠키의 유효기간은 1일입니다.
	// 한번 방문할때마다 쿠키의 값을 1증가시킵니다.
	int visitCount = 1;
	Cookie[] cookies = request.getCookies();
	if(cookies != null) {
		for(Cookie c : cookies) {
			if("visit_count".equals(c.getName())) {
				visitCount = Integer.parseInt(c.getValue())+1;
			}
		}
	}
	
	Cookie c = new Cookie("visit_count",String.valueOf(visitCount));
	c.setMaxAge(60*60*24);
	response.addCookie(c);
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>
	당신은 이 페이지를
	<strong><%=c.getValue()%></strong>번 방문했습니다.
	</p>
</body>
</html>