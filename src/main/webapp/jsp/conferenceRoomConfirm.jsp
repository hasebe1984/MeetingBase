<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会議室登録確認画面</title>
</head>
<body>
	<h1>会議室登録</h1>
	<hr>
	<h2>登録確認</h2>
	<table>
		<tr>
			<td>会議室名</td>
			<td>${"大会議室"}</td>
		</tr>
		<tr>
			<td>登録者</td>
			<td>${"情報太郎"}</td>
		</tr>
	</table>
	<hr>
	<form action="<%=request.getContextPath()%>/jsp/conferenceRoomInput.jsp"
		method="POST">
		<input type="submit" value="戻る">
	</form>
	<form action="<%=request.getContextPath()%>/RoomEditServlet"
		method="POST">
		<input type="submit" value="決定">
</body>
</html>