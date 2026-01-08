<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会議室登録完了画面</title>
</head>
<body>
	<h1>会議室登録</h1>
	<hr>
	<h2>登録完了</h2>
	<table>
		<tr>
			<td>会議室ID</td>
			<td>${"0401"}</td>
		</tr>
		<tr>
			<td>会議室名</td>
			<td>${"大会議室"}</td>
		</tr>
	</table>
	<hr>
	<form action="<%=request.getContextPath()%>/jsp/menu.jsp" method="POST">
		<input type="submit" value="完了">
	</form>
</body>
</html>