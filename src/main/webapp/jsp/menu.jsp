<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/header.jsp"%>
<h1>メニュー</h1>
<p class="message">${message}</p>
<div class="menu_wrap">
	<a href="${pageContext.request.contextPath}/jsp/reserveInput.jsp" class="button_large">会議室予約</a>
	<a href="${pageContext.request.contextPath}/jsp/cancelInput.jsp" class="button_large">予約キャンセル</a>
	<form action="${pageContext.request.contextPath}/UserEditServlet" method="post" class="button_large">
		<input type="submit" name="action" value="会員情報編集" class="button_large_inner">
	</form>
</div>
<div class="menu_wrap ${meetingRoom.user.isAdmin != '1' ? 'hidden' : ''}">
	<a href="${pageContext.request.contextPath}/AdminUserServlet" class="button_large">会員管理</a>
	<a href="${pageContext.request.contextPath}/RoomAdminServlet" class="button_large">会議室管理</a>
</div>
<%@include file="../common/footer.jsp"%>