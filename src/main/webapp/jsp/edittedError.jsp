<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/header.jsp"%>
<h1>会員情報編集</h1>
<hr>
<h2>編集エラー</h2>
<p class="message">${"エラーメッセージ"}</p>
<table>
	<tbody>
		<tr>
			<th>利用者ID</th>
			<td>${"2600001"}</td>
		</tr>
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
<a href="${pageContext.request.contextPath}/jsp/menu.jsp" class="button_submit">メニューへ</a>
<%@include file="../common/footer.jsp"%>