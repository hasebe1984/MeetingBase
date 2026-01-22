<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../common/header.jsp"%>
<h1>会員登録画面</h1>
<hr>
<h2>登録情報の失敗</h2>
<p class="message">${"エラーメッセージ"}</p>
<table>
	<tbody>
		<tr>
			<th>利用者ID</th>
			<td>${user.id}</td>
		</tr>
		<tr>
			<th>パスワード</th>
			<td><c:out value="${user.password}" /></td>
		</tr>
		<tr>
			<th>氏名</th>
			<td><c:out value="${user.name}" /></td>
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
<a href="${pageContext.request.contextPath}/jsp/menu.jsp" class="button_submit">メニューへ</a>
<%@include file="../common/footer.jsp"%>