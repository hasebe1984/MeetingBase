<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/header.jsp"%>
<h1>会議室予約キャンセル</h1>
<hr>
<h2>キャンセルエラー</h2>
<p>${"すでにキャンセルされています"}</p>
<table>
	<tr>
		<td>予約日</td>
		<td>${"2025-01-31"}</td>
	</tr>
	<tr>
		<td>会議室</td>
		<td>${"大会議室"}</td>
	</tr>
	<tr>
		<td>予約時刻</td>
		<td>${"14:00～15:00"}</td>
	</tr>
	<tr>
		<td>予約者</td>
		<td>${"情報太郎"}</td>
	</tr>
</table>
<hr>
<form action="<%=request.getContextPath()%>/jsp/menu.jsp"
	method="POST">
	<input type="submit" value="確認">
</form>
<%@include file="../common/footer.jsp"%>