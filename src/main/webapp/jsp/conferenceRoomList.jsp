<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/header.jsp"%>
<h1>会議室一覧</h1>
<hr>
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
				<form action="<%=request.getContextPath()%>/RoomEditServlet"
					method="post">
					<input type="submit" value="編集" class="button_list">
				</form>
			</td>
			<td class="list_td_small">
				<form action="<%=request.getContextPath()%>/RoomAdminServlet"
					method="post">
					<input type="submit" value="削除" class="button_list">
				</form>
			</td>
		</tr>
		<tr>
			<td>${"0501"}</td>
			<td>${"大会議室"}</td>
			<td class="list_td_small">
				<form action="<%=request.getContextPath()%>/RoomEditServlet"
					method="post">
					<input type="submit" value="編集" class="button_list">
				</form>
			</td>
			<td class="list_td_small">
				<form action="<%=request.getContextPath()%>/RoomAdminServlet"
					method="post">
					<input type="submit" value="削除" class="button_list">
				</form>
			</td>
		</tr>
		<tr>
			<td>${"0501"}</td>
			<td>${"大会議室"}</td>
			<td class="list_td_small">
				<form action="<%=request.getContextPath()%>/RoomEditServlet"
					method="post">
					<input type="submit" value="編集" class="button_list">
				</form>
			</td>
			<td class="list_td_small">
				<form action="<%=request.getContextPath()%>/RoomAdminServlet"
					method="post">
					<input type="submit" value="削除" class="button_list">
				</form>
			</td>
		</tr>
		<tr>
			<td>${"0501"}</td>
			<td>${"大会議室"}</td>
			<td class="list_td_small">
				<form action="<%=request.getContextPath()%>/RoomEditServlet"
					method="post">
					<input type="submit" value="編集" class="button_list">
				</form>
			</td>
			<td class="list_td_small">
				<form action="<%=request.getContextPath()%>/RoomAdminServlet"
					method="post">
					<input type="submit" value="削除" class="button_list">
				</form>
			</td>
		</tr>
		<tr>
			<td>${"0501"}</td>
			<td>${"大会議室"}</td>
			<td class="list_td_small">
				<form action="<%=request.getContextPath()%>/RoomEditServlet"
					method="post">
					<input type="submit" value="編集" class="button_list">
				</form>
			</td>
			<td class="list_td_small">
				<form action="<%=request.getContextPath()%>/RoomAdminServlet"
					method="post">
					<input type="submit" value="削除" class="button_list">
				</form>
			</td>
		</tr>
	</tbody>
</table>
<hr>
<div class="button_row">
	<a href="menu.jsp" class="button_submit">戻る</a>
	<form action="<%=request.getContextPath()%>/RoomEditServlet"
		method="post">
		<input type="submit" value="追加" class="button_submit">
	</form>
</div>
<%@include file="../common/footer.jsp"%>