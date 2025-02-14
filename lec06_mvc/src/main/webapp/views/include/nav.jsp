<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.gn.member.vo.Member" %>
<% Member m = (Member)session.getAttribute("member"); %>
<link href="<%=request.getContextPath() %>/resources/css/include/nav.css"
rel="stylesheet" type="text/css">
<nav>
	<div id="nav_wrap">
		<div class="menu">
			<ul>
				<%if(m == null) { %>
					<li>
						<a href="/memberLogin">로그인</a>
					</li>
					<li>
						<a href="/memberCreate">회원가입</a>
					</li>
				<%} else { %>
					<%-- <li><%=m.getMemberId() %></li> --%>
					<li>
						<a href="/memberLogout">로그아웃</a>
					</li>
					<li>
						<a href="/memberUpdate">계정 수정</a>
					</li>
				<%} %>
			</ul>
		</div>
	</div>
</nav>
<script>
	
</script>