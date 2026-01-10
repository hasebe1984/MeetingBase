<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/header.jsp"%>
<h1>会議室予約</h1>
<hr>
<h2>予約完了</h2>
<table>
	<tbody>
		<tr>
			<th>予約ID</th>
			<td>${"4"}</td>
		</tr>
		<tr>
			<th>予約日</th>
			<td>${"2025-01-31"}</td>
		</tr>
		<tr>
			<th>会議室</th>
			<td>${"大会議室"}</td>
		</tr>
		<tr>
			<th>予約時刻</th>
			<td>${"14:00～15:00"}</td>
		</tr>
		<tr>
			<th>予約者</th>
			<td>${"情報太郎"}</td>
		</tr>
	</tbody>
</table>
<a href="menu.jsp"class="button_submit">メニューへ戻る</a>
<%@include file="../common/footer.jsp"%>