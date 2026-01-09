<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/header.jsp"%>
<h1>会議室登録</h1>
<hr>
<h2>登録エラー</h2>
<p class="message">すでに登録されています</p>
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
<form action="<%=request.getContextPath()%>/jsp/menu.jsp" method="POST">
	<input type="submit" value="確認">
</form>
<%@include file="../common/footer.jsp"%>