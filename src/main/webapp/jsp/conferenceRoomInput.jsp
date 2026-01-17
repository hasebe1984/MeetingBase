<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/header.jsp"%>
<h1>${title}</h1>
<hr>
<h2>入力</h2>
<form action="${pageContext.request.contextPath}/RoomEditServlet" method="post" class="form">
	<div class="input-wrap">
		<label for="roomName">会議室名</label>
		<input type="text" name="roomName" value="${room.name}" id="roomName" class="form_input" required>
	</div>
	<div class="input-wrap ${title == '会議室編集' ? 'hidden' : ''}">
		<label for="roomFloor">会議室階数</label>
		<input type="number" name="roomFloor" value="${addRoom.id}" id="roomFloor" class="form_input" ${title == '会議室編集' ? '' : 'required'}>
	</div>
 	<div class="button_row">
	    <input type="hidden" name="title" value="${title}">
	    <input type="hidden" name="roomId" value="${room.id}">
		<a href="${pageContext.request.contextPath}/RoomAdminServlet" class="button_submit">戻る</a>
	    <input type="submit" name="action" value="決定" class="button_submit">
    </div>
</form>
<%@include file="../common/footer.jsp"%>