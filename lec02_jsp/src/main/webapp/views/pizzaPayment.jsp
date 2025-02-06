<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userName = (String)request.getAttribute("name");
	String userPhone = (String)request.getAttribute("phone");
	String userEmail = (String)request.getAttribute("email");
	// size가 String이었으면 int size = Integer.parseInt((String)request.getAttribute("size"));
	// 이렇게 해야됨
	int size = (int)request.getAttribute("size");
	String[] toppings = (String[])request.getAttribute("toppings");
	int price = (int)request.getAttribute("price");
	String time = (String)request.getAttribute("time");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>피자 주문 결과 확인</title>
</head>
<body>
	<% %>
	<h1>주문내역</h1>
	<h4>[고객정보]</h4>
	<ul>
		<li>성함 : <%=userName %></li>
		<li>전화번호 : <%=userPhone %></li>
		<li>이메일 : <%=userEmail %></li>
	</ul>
	<h4>[주문정보]</h4>
	<ul>
		<li>사이즈 : 
			<%
				switch(size){
				case 1 : out.println("small"); break;
				case 2 : out.println("mediium"); break;
				case 3 : out.println("large"); break;
				}
				
			%>
		</li>
		<li>토핑 : 
			<ul>
				<%
					for(int i=0; i<toppings.length; i++) {
						String text = "";
						switch(toppings[i]){
							case "1" : text = "새우"; break;
							case "2" : text = "고구마"; break;
							case "3" : text = "감자"; break;
							case "4" : text = "파인애플"; break;
						}%>
						<li><%=text %></li>
					<%}%>
			</ul>
		</li>
	</ul>
	<h4>위와 같이 주문하셨습니다.</h4>
	<h3>총 가격은 <%=price %>원 입니다.</h3>
	<h3><%=time %>까지 배달될 예정입니다.</h3>
</body>
</html>