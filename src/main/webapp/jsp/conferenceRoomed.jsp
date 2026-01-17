<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/header.jsp"%>
<h1>${title}</h1>
<hr>
<h2>完了</h2>
<table>
	<tbody>
		<tr>
			<th>会議室名</th>
			<td>${room.name}</td>
		</tr>
 		<tr class="${title == '会議室編集' ? 'hidden' : ''}">
			<th>会議室階</th>
			<td>${addRoom.id}</td>
		</tr>
	</tbody>
</table>
<form action="${pageContext.request.contextPath}/RoomAdminServlet"
	method="post">
	<input type="submit" name="action" value="一覧へ" class="button_submit">
</form>
<%@include file="../common/footer.jsp"%>