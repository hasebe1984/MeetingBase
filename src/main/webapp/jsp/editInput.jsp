<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/header.jsp"%>
<h1>会員情報編集</h1>
<hr>
<h2>入力</h2>
<form action="${pageContext.request.contextPath}/UserEditServlet" method="post" class="form">
	<div class="input-wrap">
		<label>パスワード</label>
		<input type="password" name="userPw" class="form_input" required>
    </div>
    <div class="input-wrap">
	    <label>氏名</label>
	    <input type="text" name="name" class="form_input" required>
    </div>
    <div class="input-wrap">
	    <label>住所</label>
	    <input type="text" name="adress" class="form_input" required>
    </div>
    <div class="button_row">
	    <a href="${pageContext.request.contextPath}/jsp/menu.jsp" class="button_submit">戻る</a>
	    <input type="submit" value="登録" class="button_submit">
    </div>
</form>
<%@include file="../common/footer.jsp"%>