<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 결과 화면</title>
</head>
<body>
	<h1>반가워요 <%= request.getAttribute("userId")%>님</h1>
	<h2>비밀번호가 <%= request.getAttribute("userPw")%>이시네요~</h2>
	<a href="/">홈페이지로 이동</a>
</body>
</html>