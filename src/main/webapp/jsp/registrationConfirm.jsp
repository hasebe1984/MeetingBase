<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/header.jsp"%>
<h1>会員登録画面</h1>
<hr>
<h2>登録情報の確認</h2>
<table>
	<tbody>
<%-- 		<tr>
			<th>利用者ID</th>
			<td>${"2600001"}</td>
		</tr> --%>
		<tr>
			<th>パスワード</th>
			<td>${user.password}</td>
		</tr>
		<tr>
			<th>氏名</th>
			<td>${user.name}</td>
		</tr>
		<tr>
			<th>住所</th>
			<td>${user.address}</td>
		</tr>
		<tr>
			<th>会員区分</th>
			<td>${user.isAdmin}</td>
		</tr>
	</tbody>
</table>
<div class="button_row">
	<form action="${pageContext.request.contextPath}/RegistrationServlet"
		method="post">
		<input type="hidden" name="userPw" value="${user.password}">
		<input type="hidden" name="userName" value="${user.name}">
		<input type="hidden" name="userAddress" value="${user.address}">
		<input type="hidden" name="userAdmin" value="${user.isAdmin}">
		
		<input type="submit" name="action" value="戻る" class="button_submit">
		<input type="submit" name="action" value="登録" class="button_submit">
	</form>
</div>
<%@ include file="../common/footer.jsp"%>