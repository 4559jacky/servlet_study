<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 실패</title>
<link href='/resources/css/member/login_result.css' 
rel="stylesheet" type="text/css">
</head>
<body>
	<%@ include file="/views/include/header.jsp" %>
	<%@ include file="/views/include/nav.jsp" %>
	<section>
		<div id="section_wrap">
			<div class="word">
				<h3>로그인 실패!!</h3>
				<span>(아이디 혹은 비밀번호를 확인해보세요.)</span>
			</div>
			<div class="others">
				<a href='/memberCreate'>회원가입</a>
				<a href='/memberLogin'>로그인</a>
			</div>
		</div>
	</section>	
</body>
</html>