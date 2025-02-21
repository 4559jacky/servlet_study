<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세/수정</title>
</head>
<body>
	<form action="<c:url value='/boardUpdate'/>" method="post">
		<input type="hidden" name="board_no" value="<c:out value='${vo.boardNo }'/>"/>
		<input type="text" name="board_title" value="<c:out value='${vo.boardTitle }'/>" />
		<textarea name="board_content"><c:out value="${vo.boardContent }"/></textarea>
		<input type="submit" value="수정"/>
	</form>
	<a href="<c:url value='/boardDelete?board_no=20'/>">삭제</a>
</body>
</html>