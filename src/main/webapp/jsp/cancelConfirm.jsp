<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/header.jsp"%>
<h1>会議室予約キャンセル</h1>
<hr>
<h2>キャンセル確認</h2>
<table>
	<tbody>
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
<hr>
<div class="button_row">
	<form action="cancelInput.jsp"
		method="post">
		<input type="submit" value="戻る" class="button_submit">
	</form>
	<form action="<%=request.getContextPath()%>/CancelServlet"
		method="post">
		<input type="submit" value="決定" class="button_submit">
	</form>
</div>
<%@include file="../common/footer.jsp"%>