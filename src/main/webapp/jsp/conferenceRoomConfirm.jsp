<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/header.jsp"%>
<h1>${title}</h1>
<hr>
<h2>確認</h2>
<table>
	<tbody>
		<tr>
			<th>会議室名</th>
			<td>${room.name}</td>
		</tr>
		<tr>
			<th>会議室階</th>
			<td>${room.id}</td>
		</tr>
	</tbody>
</table>
<div class="button_row">
	<form action="${pageContext.request.contextPath}/RoomEditServlet"
		method="post">
		<input type="hidden" name="roomName" value="${room.name}">
		<input type="hidden" name="roomFloor" value="${room.id}">
		<input type="hidden" name="title" value="${title}">
		
		<input type="submit" name="action" value="戻る" class="button_submit">
		<input type="submit" name="action" value="登録" class="button_submit">
	</form>
</div>
<%@include file="../common/footer.jsp"%>