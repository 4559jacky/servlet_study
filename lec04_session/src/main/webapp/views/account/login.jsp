<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie[] cookies = request.getCookies();
	String rememberId = null;
	if(cookies != null) {
		for(Cookie c : cookies) {
			if("remember_id".equals(c.getName())) {
				rememberId = c.getValue();
			}
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<body>
	<form action="/loginEnd" method="post">
		<label for="accountId">아이디 : </label>
		<input type="text" id="accountId" name="account_id"
		value="<%=rememberId == null ? "" : rememberId%>">
		<label for="accountPw">비밀번호 : </label>
		<input type="password" id="accountPw" name="account_pw">
		<br>
		<input type="checkbox" id="rememberId" name="remember_id"
		<%if(rememberId != null) {%>checked <%}%> >
		<label for="rememberId">아이디 기억하기</label>
		<input type="submit" value="로그인">
	</form>
</body>
</html>