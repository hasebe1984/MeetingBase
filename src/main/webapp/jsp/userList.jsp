<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ page import="jp.co.sys.bean.UserBean"%>
<%@ page import="jp.co.sys.util.UserList"%>
<%@include file="../common/header.jsp"%>
<h1>会員一覧</h1>
<hr>
<p class="message">${message}</p>
<table class="list_table">
	<thead>
		<tr>
			<th>ID</th>
			<th>パスワード</th>
			<th>氏名</th>
			<th>住所</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td class="list_td_small">${"2584746"}</td>
			<td class="list_td_middle">${"675frd"}</td>
			<td>${"仲野太賀"}</td>
			<td class="list_td_large">${"愛知県名古屋市１０１−０３"}</td>
			<td class="list_td_small">${"管理者"}</td>
			<td class="list_td_small">
				<form action="${pageContext.request.contextPath}/jsp/editInput.jsp" method="post">
					<input type="hidden" name="id" value="${'2584746'}">
					<input type="submit" value="編集" class="button_list">
				</form>
			</td>
			<td class="list_td_small">
				<form action="${pageContext.request.contextPath}/AdminUserServletServlet"
					method="post">
					<input type="hidden" name="id" value="${'2584746'}">
					<input type="submit" name="action" value="削除" class="button_list" onclick="return confirm('本当に削除してよろしいですか？');">
				</form>
			</td>
		</tr>
		<% 
		UserList list = (UserList)request.getAttribute("list");
		if (list != null) {
		for (UserBean l : list) {
		%>
			<tr>
				<td class="list_td_small"><%= l.getId() %></td>
				<td class="list_td_middle"><%= l.getPassword() %></td>
				<td><%= l.getName() %></td>
				<td class="list_td_large"><%= l.getAddress() %></td>
				<td class="list_td_small"><%= l.getAdmin() %></td>
				<td class="list_td_small">
					<form action="${pageContext.request.contextPath}/jsp/editInput.jsp" method="post">
						<input type="hidden" name="id" value="<%= l.getId() %>">
						<input type="submit" value="編集" class="button_list">
					</form>
				</td>
				<td class="list_td_small">
					<form action="${pageContext.request.contextPath}/AdminUserServletServlet"
						method="post">
						<input type="hidden" name="id" value="<%= l.getId() %>">
						<input type="submit" name="action" value="削除" class="button_list" onclick="return confirm('本当に削除してよろしいですか？');">
					</form>
				</td>
			</tr>
		<% }} %>
	</tbody>
</table>
<div class="button_row">
	<a href="${pageContext.request.contextPath}/jsp/menu.jsp" class="button_submit">メニューへ</a>
	<a href="${pageContext.request.contextPath}/jsp/registrationInput.jsp" class="button_submit">会員追加</a>
</div>
<%@include file="../common/footer.jsp"%>