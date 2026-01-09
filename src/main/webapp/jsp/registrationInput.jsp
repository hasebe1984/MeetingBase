<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/header.jsp"%>
   <h1>会員登録入力</h1>
		<form action="registrationConfirm.jsp" method="POST">
		管理者: <input type="checkbox" name="userId" required><br>		
        パスワード:<input type="password" name="userPw" required><br>
        氏名:　　　<input type="text" name="name" required><br>
        住所:　　　<input type="text" name="adress" required><br>
        <input type="submit" value="登録">
		</form>
<%@include file="../common/footer.jsp"%>