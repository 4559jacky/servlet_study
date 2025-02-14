<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ page import="com.gn.member.vo.Member" %> --%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>계정 수정 화면</title>
<link href="/resources/css/member/update.css"
rel="stylesheet" type="text/css">
<script src="<%=request.getContextPath()%>/resources/js/jquery-3.7.1.js"></script>
</head>
<body>
	<%@ include file="/views/include/header.jsp" %>
	<%@ include file="/views/include/nav.jsp" %>
	<section>
		<div id="section_wrap">
			<div class="word">
				<h3>계정 수정</h3>
			</div>
			<br>
			<%-- <% Member m = (Member)session.getAttribute("member"); %> --%>
			
			<div class="update_member_form">
				<form action='/memberUpdateEnd' name="update_member_form" method="post">
					<input type="hidden" name="member_no" value="<%=m.getMemberNo()%>">
					<input type="text" name="member_id" value="<%=m.getMemberId()%>" readonly disabled> <br>
					<input type="password" name="member_pw" placeholder="수정 비밀번호"> <br>
					<input type="password" name="member_pw_check" placeholder="수정 비밀번호 확인"> <br>
					<input type="text" name="member_name" value="<%=m.getMemberName()%>" placeholder="닉네임"> <br>
					<input type="button" value="수정" onclick="updateMemberForm();">
				</form>
			</div>
		</div>	
	</section>	
	<script>
	const updateMemberForm = function(){
		const form = document.update_member_form;
		if(!form.member_id.value){
			alert('아이디를 입력하세요');
			form.member_id.focus();
		}else if(!form.member_pw.value){
			alert('비밀번호를 입력하세요.');
			form.member_pw.focus();
		} else if(!form.member_pw_check.value){
			alert('비밀번호 확인을 입력하세요.');
			form.member_pw_check.focus();
		} else if(!form.member_name.value){
			alert('닉네임을 입력하세요.');
			form.member_name.focus();
		} else{
			// form.submit();
			// 1. 경로 : /memberUpdateEnd -> MemberUpdateEndServlet(암호화 필터 도움 절실!!)
			// 2. 타입 : post
			$.ajax({
				url : "/memberUpdateEnd",
				type : 'post',
				data : {
					"member_pw" : form.member_pw.value,
					"member_name" : form.member_name.value,
					"member_no" : form.member_no.value
				},
				dataType : 'JSON',
				contentType: "application/x-www-form-urlencoded; charset=UTF-8",
				success : function(data){
					alert(data.res_msg);
					if(data.res_code == 200) {
						location.href = "/";
					}
				},
			})
		}
	}
	</script>
</body>
</html>