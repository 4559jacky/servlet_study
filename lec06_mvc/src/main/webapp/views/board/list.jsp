<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.gn.board.vo.Board" %>
<%@ page import="java.util.*" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<% List<Board> boardList = (List<Board>)request.getAttribute("resultList"); %>
<!DOCTYPE html>
<html> 
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link href='<%=request.getContextPath()%>/resources/css/board/list.css' rel="stylesheet" type="text/css">

</head>
<body>
	<%@ include file="/views/include/header.jsp" %>
	<%@ include file="/views/include/nav.jsp" %>
	<section>
		<div id="section_wrap">
			<div class="word">
				<h3>게시글 목록</h3>
			</div><br>
			<div class="board_list">
				<table>
					<colgroup>
						<col width="10%">
						<col width="50%">
						<col width="20%">
						<col width="20%">
					</colgroup>
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일시</th>
						</tr>
					</thead>
					<tbody>
						<%if(boardList.size()>0) {
							DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
							for(int i=0; i<boardList.size(); i++) {
								int board_no = boardList.get(i).getBoardNo();
								String board_title = boardList.get(i).getBoardTitle();
								String member_name = boardList.get(i).getMemberName();
								String reg_date = dtf.format(boardList.get(i).getRegDate());
							%>
							<tr>
								<td><%=board_no %></td>
								<td><%=board_title %></td>
								<td><%=member_name %></td>
								<td><%=reg_date %></td>
							</tr>
							<%}
							} else {%>
							<tr>
								<td colspan="4">조회된 데이터가 없습니다.</td>
							</tr>
						<%} %>
					</tbody>
				</table>
			</div>
		</div>
	</section>
	<script>
		
	</script>
</body>
</html>