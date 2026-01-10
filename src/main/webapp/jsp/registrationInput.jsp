<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/header.jsp"%>
<h1>会員登録入力</h1>
<form action="registrationConfirm.jsp" method="post" class="form">
	<div class="input-wrap">
		<label for="userId">パスワード</label>
		<input type="password" name="userPw" class="form_input" required>
	</div>
	<div class="input-wrap">
		<label for="userId">氏名</label>
		<input type="text" name="name" class="form_input" required>
	</div>
	<div class="input-wrap">
		<label for="userId">住所</label>
		<input type="text" name="adress" class="form_input" required>
	</div>
	<div class="input-wrap input-wrap_check">
		<label for="userId">管理者</label>
		<input type="checkbox" name="userId" class="form_check" required>
	</div>
 	<div class="button_row">
	    <a href="menu.jsp"class="button_submit">戻る</a>
	    <input type="submit" value="登録" class="button_submit">
    </div>
</form>
<%@include file="../common/footer.jsp"%>