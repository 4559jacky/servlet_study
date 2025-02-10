<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie[] cookies = request.getCookies();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키, 세션</title>
</head>
<body>
	<h1>쿠키 연습하기</h1>
	<ul>
		<li>
			<a href="/createCookie">생성하기</a>
		</li>
		<li>
			<%
			String userId="쿠키없음";
			if(cookies != null) {
				for(Cookie c : cookies) {
					if("user_id".equals(c.getName())) {
						userId = c.getValue();
					}
				}
			} %>
			아이디 : <%=userId %>
		</li>
		<li>
			<a href="/editCookie">수정하기</a>
		</li>
		<li>
			<a href="/removeCookie">삭제하기</a>
		</li>
	</ul>
	<a href="/changePage">화면 전환</a>
	
</body>
</html>