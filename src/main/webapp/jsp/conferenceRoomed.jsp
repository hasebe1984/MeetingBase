<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/header.jsp"%>
<h1>会議室登録</h1>
<hr>
<h2>登録完了</h2>
<table>
	<tr>
		<th>会議室ID</th>
		<td>${"0401"}</td>
	</tr>
	<tr>
		<th>会議室名</th>
		<td>${"大会議室"}</td>
	</tr>
</table>
<hr>
<form action="<%=request.getContextPath()%>/jsp/menu.jsp" method="POST">
	<input type="submit" value="完了">
</form>
<%@include file="../common/footer.jsp"%>