<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록 출력</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>내용</th>
			</tr>
		</thead>
			<c:choose>
				<c:when test="${not empty resultList}">
					<c:forEach var="b" items="${resultList }" varStatus="vs">
						<tr>
							<td>${vs.index+1}</td>
							<td>${b.boardTitle}</td>
							<td>${b.boardContent}</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="3">게시글이 없습니다.</td>
					</tr>
				</c:otherwise>
			</c:choose>
				
	</table>
</body>
</html>