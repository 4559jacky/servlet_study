<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> 
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link href='<%=request.getContextPath()%>/resources/css/member/login.css' 
rel="stylesheet" type="text/css">
</head>
<body>
	<%@ include file="/views/include/header.jsp" %>
	<%@ include file="/views/include/nav.jsp" %>
	<section>
		<div id="section_wrap">
			<div class="word">
				<h3>로그인</h3>
			</div>
			<div class="login_form">
				<form action='/memberLoginEnd' name="login_form" method="post">
					<input type="text"	name="member_id" 	placeholder="아이디"> <br>
					<input type="password"	name="member_pw" 	placeholder="비밀번호"> <br>
					<input type="button"	value="로그인" onclick="loginForm();"> 
					<input type="reset"	value="초기화">					
				</form>
			</div>
			<div class="find_password_create_account">
				<a href='/memberCreate'>회원가입</a>
			</div>
		</div>
	</section>		
	<script type="text/javascript">
		function loginForm() {
			let form = document.login_form;
			if (form.member_id.value == '') {
				alert('아이디를 입력하세요.');
				form.member_id.focus();	
			} else if (form.member_pw.value == '') {
				alert('비밀번호를 입력하세요.');
				form.member_pw.focus();
			} else {
				form.submit();
			}
		}
	</script>
</body>
</html>