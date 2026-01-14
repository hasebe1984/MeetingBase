<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/header.jsp"%>
<h1>${"会議室登録"}</h1>
<hr>
<h2>入力</h2>
<form action="${pageContext.request.contextPath}/jsp/conferenceRoomConfirm.jsp" method="post" class="form">
	<div class="input-wrap">
		<label for="userId">会議室名</label>
		<input type="text" name="name" class="form_input" required>
	</div>
	<div class="input-wrap">
		<label for="userId">会議室階数</label>
		<input type="text" name="id" class="form_input" required>
	</div>
 	<div class="button_row">
	    <a href="${pageContext.request.contextPath}/jsp/menu.jsp" class="button_submit">戻る</a>
	    <input type="submit" value="登録" class="button_submit">
    </div>
</form>
<%@include file="../common/footer.jsp"%>