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
	<%if(session.isNew() || session.getAttribute("account") == null) { %>
		<a href="login">로그인</a>
	<% } else {%>
		<a href="logout">로그아웃</a>
	<%} %>
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
	<h2>조회수 카운트하기</h2>
	<a href="/changePage">화면 전환</a>
	
	<h2>세션 연습하기</h2>
	<ol>
		<li>
			<a href="/createSession">
				생성하기
			</a>
		</li>
		<li>
			<%	
				String memberId = "세션 없음";
				// 세션은 JSP의 내장객체이다. 따로 불러올 필요가 없다.
				if(session != null) {
					if(session.getAttribute("member_id") == null) {
						memberId = "세션 없음";
					} else {
					// 세션은 오브젝트로 되어있기 때문에 downcasting 해주어야한다.
					memberId = (String)session.getAttribute("member_id");
					}
				}
			%>
			<%=memberId %>
		</li>
	</ol>
	<a href="/productList">상품목록</a>
	<a href="">장바구니</a>
	
	
</body>
</html>