<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/header.jsp"%>
<h1>会員登録画面</h1>
<hr>
<h2>登録情報の完了</h2>
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
			<td>${user.admin}</td>
		</tr>
	</tbody>
</table>
<a href="${pageContext.request.contextPath}/AdminUserServlet" class="button_submit">メニューへ戻る</a>
<%@include file="../common/footer.jsp"%>