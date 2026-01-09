<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/header.jsp"%>
<h1>会員登録画面</h1>
<hr>
<h2>登録情報の確認</h2> 
<table>
	<tr>
		<th>利用者ID:</th>
		<td>${"2600001"}</td>
	</tr>
	<tr>
		<th>パスワード:</th>
		<td>${"abcdef"}</td>
	</tr>
	<tr>
		<th>氏名:</th>
		<td>${"インテックス太郎"}</td>
	</tr>
	<tr>
		<th>住所:</th>
		<td>${"愛知県"}</td>
	</tr>
</table>
<div class="button_row">
	<form action="<%=request.getContextPath()%>/jsp/cancelInput.jsp"
		method="post">
		<input type="submit" value="戻る">
	</form>
	<form action="<%=request.getContextPath()%>/CancelServlet"
		method="post">
		<input type="submit" value="決定">
	</form>
</div>
<%@include file="../common/footer.jsp"%>