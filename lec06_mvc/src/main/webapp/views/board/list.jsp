<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ page import="com.gn.board.vo.Board" %>
<%@ page import="java.util.*" %> --%>
<%-- <%@ page import="java.time.format.DateTimeFormatter" %> --%>
<%-- <% List<Board> boardList = (List<Board>)request.getAttribute("resultList"); %> --%>
<!DOCTYPE html>
<html> 
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link href='<%=request.getContextPath()%>/resources/css/board/list.css' rel="stylesheet" type="text/css">
<link href='<%=request.getContextPath()%>/resources/css/include/paging.css' rel="stylesheet" type="text/css">
<script src="<%=request.getContextPath()%>/resources/js/jquery-3.7.1.js"></script>
</head>
<body>
	<%@ include file="/views/include/header.jsp" %>
	<%@ include file="/views/include/nav.jsp" %>
	<%Board paging = (Board)request.getAttribute("paging"); %>
	<section>
		<div id="section_wrap">
			<div class="search">
				<form action="/boardList" name="search_board_form" method="get">
					<input type="text" name="board_title" placeholder="검색하고자 하는 게시글 제목을 입력하세요."
					value="<%=paging.getBoardTitle() == null ? "" : paging.getBoardTitle()%>">
					<input type="submit" value="검색">
				</form>	
			</div>
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
						<!-- 내 코드 -->
						<%-- <%if(boardList.size()>0) {
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
						<%} %> --%>
						<%@ page import="com.gn.board.vo.Board, java.util.*, java.time.format.*" %>
						<%
							List<Board> list = (List<Board>)request.getAttribute("resultList");
							DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm");
						%>
						<c:forEach var="b" items="${resultList}" varStatus="vs">
							<%-- <tr data-board-no="<%=list.get(i).getBoardNo() %>"> --%>
							<tr data-board-no="${b.boardNo}">
								<%-- <td><%=((paging.getNowPage()-1)*paging.getNumPerPage())+(i+1) %></td> --%>
								<td>${(paging.nowPage-1)*paging.numPerPage+(vs.index+1)}</td>
								<%-- <td><%=list.get(i).getBoardTitle() %></td> --%>
								<td>${b.boardTitle}</td>
								<%-- <td><%=list.get(i).getMemberName() %></td> --%>
								<td>${b.memberName}</td>
								<%-- <td><%=list.get(i).getRegDate().format(dtf) %></td> --%>
								<td>${b.regDate}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</section>
	<c:if test="${not empty paging }">
		<div class="center">
			<div class="pagination">
				<c:if test="${not empty paging.boardTitle}">
    				<c:set var="boardTitleParam" value="${'&board_title='}${paging.boardTitle}" />
				</c:if>
				<c:if test="${paging.prev}">
					<a href="/boardList?nowPage=${paging.pageBarStart-1}${boardTitleParam}">&laquo;</a>
				</c:if>
				<c:forEach var="i" begin="${paging.pageBarStart }" end="${paging.pageBarEnd }">
					<a href="/boardList?nowPage=${i }${boardTitleParam}">
						${i }
					</a>
				</c:forEach>
				<c:if test="${paging.next}">
					<a href="/boardList?nowPage=${paging.pageBarEnd+1}${boardTitleParam}">&raquo;</a>
				</c:if>
			</div>
		</div>
	</c:if>
	<script>
		$('.board_list tbody tr').on('click',function(){
			const boardNo = $(this).data('board-no');
			location.href='/boardDetail?board_no='+boardNo;
		})
	</script>	
	
	
</body>
</html>