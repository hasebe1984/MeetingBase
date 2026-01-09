<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/header.jsp"%>
<h1>会員情報編集入力</h1>
<form action="registrationConfirm.jsp" method="post">
	<label>パスワード:</label><input type="password" name="userPw" required><br>
    <label>氏名:</label><input type="text" name="name" required><br>
    <label>住所:</label><input type="text" name="adress" required><br>
    <input type="submit" value="登録">
</form>
<%@include file="../common/footer.jsp"%>