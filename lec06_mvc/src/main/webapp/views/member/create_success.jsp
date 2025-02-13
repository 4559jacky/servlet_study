<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 성공</title>
<link href="<%=request.getContextPath()%>/resources/css/member/create_result.css" 
rel="stylesheet" type="text/css">
</head>
<body>
	<%@ include file="/views/include/header.jsp" %>
	<%@ include file="/views/include/nav.jsp" %>
	<section>
		<div id="section_wrap">
			<div class="word">
				<h3>회원가입 성공! 로그인해주세요.</h3>
			</div>
			<div class="others">
				<a href="#">로그인</a>
			</div>
		</div>
	</section>
</body>
</html>