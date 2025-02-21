<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홈화면</title>
</head>
<body>
	<ol>
		<li>
			<a href="/boardList">목록 조회</a>
		</li>
		<c:url value="boardDetail" var="url">
			<c:param name="board_no" value="20"/>
		</c:url>
		<li>
			<a href="<c:url value='/boardDetail?board_no=20'/>">상세 조회</a>
			<%-- <a href="${url }">상세 조회</a> --%>
		</li>
		<li>
			<%-- <c:url value="/boardDetail" var ="detailUrl">
				<c:param name="board_title" value="제목"/>
				<c:param name="board_content" value="내용"/>
			</c:url> --%>
			<%-- <a href="${detailUrl }">상세 조회(2)</a> --%>
		</li>
		<li>수정</li>
		<li>삭제</li>
		<li>
			<form action="<c:url value='/boardCreate'/>" method="post">
				<fieldset>
					<legend>게시글</legend>
					<input type="text" name="board_title"><br>
					<input type="text" name="board_content"><br>
					<input type="number" name="board_writer"><br>
					<input type="submit" value="등록">
				</fieldset>
			</form>
		</li>
		<li>
			<a href="<c:url value='/boardManyInsert'/>">여러개 한번에 insert하기</a>
		</li>
		

	</ol>
</body>
</html>