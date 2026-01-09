<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/header.jsp"%>
<h1>会議室登録</h1>
<hr>
<h2>登録確認</h2>
<table>
	<tr>
		<th>会議室名</th>
		<td>${"大会議室"}</td>
	</tr>
	<tr>
		<th>会議室階</th>
		<td>${"4階"}</td>
	</tr>
</table>
<hr>
<div class="button_row">
	<form action="<%=request.getContextPath()%>/jsp/conferenceRoomInput.jsp"
		method="post">
		<input type="submit" value="戻る">
	</form>
	<form action="<%=request.getContextPath()%>/RoomEditServlet"
		method="post">
		<input type="submit" value="決定">
	</form>
</div>
<%@include file="../common/footer.jsp"%>