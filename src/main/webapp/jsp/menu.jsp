<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/header.jsp"%>
<h1>会議室</h1>
<hr>
<h2>メニュー</h2>
<div class="menu_wrap">
	<a href="<%=request.getContextPath()%>/jsp/reserveInput.jsp" class="button_large">会議室予約</a>
	<a href="<%=request.getContextPath()%>/jsp/cancelInput.jsp" class="button_large">予約キャンセル</a>
	<a href="<%=request.getContextPath()%>/jsp/editInput.jsp" class="button_large">会員情報編集</a>
</div>
<div class="menu_wrap">
	<a href="<%=request.getContextPath()%>/jsp/userList.jsp" class="button_large">会員管理</a>
	<a href="<%=request.getContextPath()%>/jsp/conferenceRoomList.jsp" class="button_large">会議室管理</a>
</div>
<%@include file="../common/footer.jsp"%>