<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/header.jsp"%>
<h1>会議室予約キャンセル</h1>
<hr>
<h2>キャンセル確認</h2>
<table>
	<tr>
		<th>予約日</th>
		<td>${reservation.date}</td>
	</tr>
	<tr>
		<th>会議室</td>
		<td>${room.name}</td>
	</tr>
	<tr>
		<th>予約時刻</th>
		<td>${""}</td>
	</tr>
	<tr>
		<th>予約者</th>
		<td>${meetingRoom.user.name}</td>
	</tr>
</table>
<hr>
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