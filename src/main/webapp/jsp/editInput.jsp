<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../common/header.jsp"%>
<h1>会員情報編集</h1>
<hr>
<h2>入力</h2>
<p class="message">${message}</p>
<form action="${pageContext.request.contextPath}/UserEditServlet" method="post" class="form">
	<div class="input-wrap">
		<label for="userPw">パスワード</label>
		<input type="text" name="userPw" value="${user.password}" id="userPw" class="form_input" required>
	</div>
	<div class="input-wrap">
		<label for="userName">氏名</label>
		<input type="text" name="userName" value="${user.name}" id="userName" class="form_input" required>
	</div>
	<div class="input-wrap">
		<label for="userAddress">住所</label>
		<input type="text" name="userAddress" <c:out value="${user.address}" /> id="userAddress" class="form_input" required>
	</div>
	<div class="input-wrap input-wrap_check ${'1'.equals(adminFlag) ? '' : 'hidden' || meetingRoom.user.isAdmin == '0' ? '' : 'hidden'}">
		<label for="userAdmin">管理者</label>
		<input type="checkbox" name="userAdmin" id="userAdmin" class="form_check" ${checked}>
	</div>
    <div class="button_row">
	    <a href="${pageContext.request.contextPath}/jsp/menu.jsp" class="button_submit">戻る</a>
	    <input type="hidden" name="userId" value="${user.id}">
	    <input type="hidden" name="cancelFlag" value="${cancelFlag}">
	    <input type="hidden" name="adminFlag" value="${adminFlag}">
	    <input type="submit" name="action" value="決定" class="button_submit">
    </div>
</form>
<form action="${pageContext.request.contextPath}/AdminUserServlet" method="post" class="form ${cancelFlag == '1' ? '' : 'hidden'}">
    <input type="hidden" name="userId" value="${user.id}">
    <input type="hidden" name="userPw" value="${user.password}">
    <input type="hidden" name="userName" value="${user.name}">
    <input type="hidden" name="userAddress" value="${user.address}">
	<input type="hidden" name="userAdmin" value="${user.isAdmin == 1 ? 'on' : ''}">
    <input type="hidden" name="cancelFlag" value="${cancelFlag}">
    <input type="hidden" name="adminFlag" value="${adminFlag}">
    <input type="submit" name="action" value="退会する" class="button_submit" onclick="return confirm('本当に退会してよろしいですか？');">
</form>
<%@include file="../common/footer.jsp"%>