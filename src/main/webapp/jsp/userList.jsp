<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員一覧画面</title>
</head>
<body>
	<h1>会員一覧</h1>
	<hr>
	<h2>会員</h2>
	<table border="1">
		<tr>
			<td>${"id"}</td>
			<td>${"password"}</td>
			<td>${"氏名"}</td>
			<td>${"住所"}</td>
			<td>
				<form action="<%=request.getContextPath()%>/SearchServlet"
					method="get">
					<input type="submit" value="会員情報編集">
				</form>
			</td>
			<td>
				<form action="<%=request.getContextPath()%>/SearchServlet"
					method="get">
					<input type="submit" value="会員情報削除">
				</form>
			</td>

		</tr>
		<tr>
			<td>${"id"}</td>
			<td>${"password"}</td>
			<td>${"氏名"}</td>
			<td>${"住所"}</td>
			<td>
				<form action="<%=request.getContextPath()%>/SearchServlet"
					method="get">
					<input type="submit" value="会員情報編集">
				</form>
			</td>
			<td>
				<form action="<%=request.getContextPath()%>/SearchServlet"
					method="get">
					<input type="submit" value="会員情報削除">
				</form>
			</td>

		</tr>
		<tr>
			<td>${"id"}</td>
			<td>${"password"}</td>
			<td>${"氏名"}</td>
			<td>${"住所"}</td>
			<td>
				<form action="<%=request.getContextPath()%>/SearchServlet"
					method="get">
					<input type="submit" value="会員情報編集">
				</form>
			</td>
			<td>
				<form action="<%=request.getContextPath()%>/SearchServlet"
					method="get">
					<input type="submit" value="会員情報削除">
				</form>
			</td>

		</tr>
	</table>
	<hr>
	<form action="<%=request.getContextPath()%>/SearchServlet" method="get">
		<input type="submit" value="戻る">
		<form action="<%=request.getContextPath()%>/SearchServlet"
			method="get">
			<input type="submit" value="会員追加">

		</form>

</body>
</html>