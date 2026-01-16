<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/header.jsp"%>
<h1>会議室予約キャンセル</h1>
<hr>
<h2>キャンセル完了</h2>
<table>
	<tbody>
		<tr>
			<th>予約日</th>
			<td>${reservation.date}</td>
		</tr>
		<tr>
			<th>会議室</th>
			<td>${room.name}</td>
		</tr>
		<tr>
			<th>予約時刻</th>
			<td>${reservation.start}～${reservation.end}</td>
		</tr>
		<tr>
			<th>予約者</th>
			<td>${meetingRoom.user.name}</td>
		</tr>
	</tbody>
</table>
<hr>
<a href="${pageContext.request.contextPath}/jsp/menu.jsp" class="button_submit">メニューへ戻る</a>
<%@include file="../common/footer.jsp"%>