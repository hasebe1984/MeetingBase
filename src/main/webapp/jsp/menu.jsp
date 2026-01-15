<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/header.jsp"%>
<h1>会議室</h1>
<hr>
<h2>メニュー</h2>
<div class="menu_wrap">
	<a href="${pageContext.request.contextPath}/jsp/reserveInput.jsp" class="button_large">会議室予約</a>
	<a href="${pageContext.request.contextPath}/jsp/cancelInput.jsp" class="button_large">予約キャンセル</a>
	<a href="${pageContext.request.contextPath}/jsp/editInput.jsp" class="button_large">会員情報編集</a>
</div>
<div class="menu_wrap">
	<a href="${pageContext.request.contextPath}/AdminUserServlet" class="button_large">会員管理</a>
	<a href="${pageContext.request.contextPath}/RoomAdminServlet" class="button_large">会議室管理</a>
</div>
<%@include file="../common/footer.jsp"%>