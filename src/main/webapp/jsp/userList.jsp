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
			<th>区分</th>
		</tr>
	</thead>
	<tbody>
		<% 
			UserList list = (UserList)request.getAttribute("list");
			if (list != null) {
			for (UserBean l : list) {
				String name = l.getName();
				request.setAttribute("name", name);
				String address = l.getAddress();
				request.setAttribute("address", address);
		%>
			<tr>
				<td class="list_td_small"><%= l.getId() %></td>
				<td class="list_td_middle"><%= l.getPassword() %></td>
				<td><c:out value="${name}" /></td>
				<td class="list_td_large"><c:out value="${address}" /></td>
				<td class="list_td_small"><%= l.getIsAdmin() == 0 ? "一般" : "管理者" %></td>				
				<td class="list_td_small">
					<form action="<%= request.getContextPath() %>/UserEditServlet" method="post">
						<input type="hidden" name="userAddress" value="<c:out value="${address}" />">
						<input type="hidden" name="userId" value="<%= l.getId() %>">
						<input type="hidden" name="userName" value="<c:out value="${name}" />">
						<input type="hidden" name="userPw" value="<%= l.getPassword() %>">
						<input type="hidden" name="userAdmin" value="<%= l.getIsAdmin() %>">
						<input type="submit" value="編集" class="button_list">
					</form>
				</td>
				<td class="list_td_small">
					<form action="<%= request.getContextPath() %>/AdminUserServlet" method="post">
						<input type="hidden" name="userAddress" value="<c:out value="${address}" />">
						<input type="hidden" name="userId" value="<%= l.getId() %>">
						<input type="hidden" name="userName" value="<c:out value="${name}" />">
						<input type="hidden" name="userPw" value="<%= l.getPassword() %>">
						<input type="hidden" name="userAdmin" value="<%= l.getIsAdmin() %>">
						<input type="submit" name="action" value="削除" class="button_list" onclick="return confirm('本当に削除してよろしいですか？');">
					</form>
				</td>
			</tr>
		<% }} %>
	</tbody>
</table>
<div class="button_row">
	<a href="${pageContext.request.contextPath}/jsp/menu.jsp" class="button_submit">戻る</a>
	<a href="${pageContext.request.contextPath}/jsp/registrationInput.jsp" class="button_submit">会員追加</a>
</div>
<%@include file="../common/footer.jsp"%>