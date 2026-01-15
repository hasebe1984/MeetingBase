<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="jp.co.sys.bean.RoomBean"%>
<%@ page import="jp.co.sys.util.RoomList"%>
<%@ page import="jp.co.sys.dao.RoomDao"%>
<%@include file="../common/header.jsp"%>
<h1>会議室一覧</h1>
<hr>
<p class="message">${message}</p>
<table class="list_table">
	<thead>
		<tr>
			<th>ID</th>
			<th>会議室名</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>${"0501"}</td>
			<td>${"大会議室"}</td>
			<td class="list_td_small">
				<form action="${pageContext.request.contextPath}/RoomEditServlet"
					method="post">
					<input type="submit" name="action" value="編集" class="button_list">
				</form>
			</td>
			<td class="list_td_small">
				<form action="${pageContext.request.contextPath}/RoomAdminServlet"
					method="post">
					<input type="submit" name="action" value="削除" class="button_list">
				</form>
			</td>
		</tr>
		<% 
			RoomList list = (RoomList)request.getAttribute("list");
			if (list != null) {
			for (RoomBean l : list) {
		%>
		<tr>
			<td><%= l.getId() %></td>
			<td><%= l.getName() %></td>
			<td class="list_td_small">
				<form action="${pageContext.request.contextPath}/RoomEditServlet"
					method="post">
					<input type="submit" name="action" value="編集" class="button_list">
				</form>
			</td>
			<td class="list_td_small">
				<form action="${pageContext.request.contextPath}/RoomAdminServlet"
					method="post">
					<input type="submit" name="action" value="削除" class="button_list">
				</form>
			</td>
		</tr>
		<% }} %>
	</tbody>
</table>
<hr>
<div class="button_row">
	<a href="${pageContext.request.contextPath}/jsp/menu.jsp" class="button_submit">戻る</a>
	<form action="${pageContext.request.contextPath}/RoomEditServlet"
		method="post">
		<input type="submit" name="action" value="追加" class="button_submit">
	</form>
</div>
<%@include file="../common/footer.jsp"%>