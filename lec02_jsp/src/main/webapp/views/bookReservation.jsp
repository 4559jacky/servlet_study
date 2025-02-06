<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 대출하기</title>
</head>
<body>
	<h1>도서 대출 내역</h1>
	<form method="post" name="bookFrm" id="bookFrm" action="/borrow">
	<fieldset>
        <legend>고객 정보</legend>
        <label for="user_name">고객명 : </label>
        <input type="text" id="user_name" name="user_name"><br>
        <label for="user_phone">전화번호 : </label>
        <input type="text" id="user_phone" name="user_phone"><br>
        <label for="user_mail">E_mail : </label>
        <input type="email" id="user_mail" name="user_email">
    </fieldset>
    <fieldset>
        <legend>도서 선택</legend>
        <label for="book">도서 : </label>
        <select id="book" name="book">
            <option value="0">선택</option>
            <option value="1">자바 프로그래밍 입문</option>
            <option value="2">웹 개발의 기초</option>
            <option value="3">데이터베이스 시스템 </option>
        </select>
    </fieldset>
    <fieldset>
        <legend>대출 기간</legend>
        <label>대출 기간(일) : </label>
        <input type="number" name="rentDate">
    </fieldset>
    <button>대출하기</button>
    </form>
</body>
</html>