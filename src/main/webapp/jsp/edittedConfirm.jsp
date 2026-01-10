<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/header.jsp"%>
<h1>会員情報編集</h1>
<hr>
<h2>編集確認</h2>
<table>
	<tbody>
		<tr>
			<th>利用者ID</th>
			<td>${"2600001"}</td>
		</tr>
		<tr>
			<th>パスワード</th>
			<td>${"abcdef"}</td>
		</tr>
		<tr>
			<th>氏名</th>
			<td>${"インテックス太郎"}</td>
		</tr>
		<tr>
			<th>住所</th>
			<td>${"愛知県"}</td>
		</tr>
	</tbody>
</table>
<div class="button_row">
	<form action="editInput.jsp"
		method="post">
		<input type="submit" value="戻る" class="button_submit">
	</form>
	<form action="<%=request.getContextPath()%>/UserEditServlet"
		method="post">
		<input type="submit" value="決定" class="button_submit">
	</form>
</div>
<%@include file="../common/footer.jsp"%>