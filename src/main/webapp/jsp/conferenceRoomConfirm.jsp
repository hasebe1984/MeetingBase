<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/header.jsp"%>
<h1>会議室登録</h1>
<hr>
<h2>登録確認</h2>
<table>
	<tr>
		<td>会議室名</td>
		<td>${"大会議室"}</td>
	</tr>
	<tr>
		<td>会議室階</td>
		<td>${"4階"}</td>
	</tr>
</table>
<hr>
<form action="<%=request.getContextPath()%>/jsp/conferenceRoomInput.jsp"
	method="post">
	<input type="submit" value="戻る">
</form>
<form action="<%=request.getContextPath()%>/RoomEditServlet"
	method="post">
	<input type="submit" value="決定">
</form>
<%@include file="../common/footer.jsp"%>