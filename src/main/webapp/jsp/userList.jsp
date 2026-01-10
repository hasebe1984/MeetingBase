<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/header.jsp"%>
<h1>会員一覧</h1>
<hr>
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
			<td class="list_td_middle">${"2584746"}</td>
			<td class="list_td_middle">${"675frd"}</td>
			<td>${"仲野太賀"}</td>
			<td class="list_td_large">${"愛知県名古屋市１０１−０３"}</td>
			<td class="list_td_small">
				<form action="editInput.jsp" method="post">
					<input type="submit" value="編集" class="button_list">
				</form>
			</td>
			<td class="list_td_small">
				<form action="<%=request.getContextPath()%>/AdminUserServlet"
					method="post">
					<input type="hidden" name="id" value="${'2584746'}">
					<input
						type="submit" value="削除" class="button_list">
				</form>
			</td>
		</tr>
		<tr>
			<td class="list_td_middle">${"2584746"}</td>
			<td class="list_td_middle">${"675frd"}</td>
			<td>${"仲野太賀"}</td>
			<td class="list_td_large">${"愛知県名古屋市１０１−０３"}</td>
			<td class="list_td_small">
				<form action="editInput.jsp" method="post">
					<input type="submit" value="編集" class="button_list">
				</form>
			</td>
			<td class="list_td_small">
				<form action="<%=request.getContextPath()%>/AdminUserServlet"
					method="post">
					<input type="hidden" name="id" value="${'2584746'}">
					<input
						type="submit" value="削除" class="button_list">
				</form>
			</td>
		</tr>
		<tr>
			<td class="list_td_middle">${"2584746"}</td>
			<td class="list_td_middle">${"675frd"}</td>
			<td>${"仲野太賀"}</td>
			<td class="list_td_large">${"愛知県名古屋市１０１−０３"}</td>
			<td class="list_td_small">
				<form action="editInput.jsp" method="post">
					<input type="submit" value="編集" class="button_list">
				</form>
			</td>
			<td class="list_td_small">
				<form action="<%=request.getContextPath()%>/AdminUserServlet"
					method="post">
					<input type="hidden" name="id" value="${'2584746'}">
					<input
						type="submit" value="削除" class="button_list">
				</form>
			</td>
		</tr>
		<tr>
			<td class="list_td_middle">${"2584746"}</td>
			<td class="list_td_middle">${"675frd"}</td>
			<td>${"仲野太賀"}</td>
			<td class="list_td_large">${"愛知県名古屋市１０１−０３"}</td>
			<td class="list_td_small">
				<form action="editInput.jsp" method="post">
					<input type="submit" value="編集" class="button_list">
				</form>
			</td>
			<td class="list_td_small">
				<form action="<%=request.getContextPath()%>/AdminUserServlet"
					method="post">
					<input type="hidden" name="id" value="${'2584746'}">
					<input
						type="submit" value="削除" class="button_list">
				</form>
			</td>
		</tr>
		<tr>
			<td class="list_td_middle">${"2584746"}</td>
			<td class="list_td_middle">${"675frd"}</td>
			<td>${"仲野太賀"}</td>
			<td class="list_td_large">${"愛知県名古屋市１０１−０３"}</td>
			<td class="list_td_small">
				<form action="editInput.jsp" method="post">
					<input type="submit" value="編集" class="button_list">
				</form>
			</td>
			<td class="list_td_small">
				<form action="<%=request.getContextPath()%>/AdminUserServlet"
					method="post">
					<input type="hidden" name="id" value="${'2584746'}">
					<input
						type="submit" value="削除" class="button_list">
				</form>
			</td>
		</tr>
	</tbody>
</table>
<div class="button_row">
	<a href="menu.jsp" class="button_submit">戻る</a>
	<a href="registrationInput.jsp" class="button_submit">会員追加</a>
</div>
<%@include file="../common/footer.jsp"%>