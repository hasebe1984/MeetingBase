<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報編集入力</title>
</head>
<body>

<h1>会員情報編集入力</h1>
		<form action="registrationConfirm.jsp" method="POST">		
        パスワード: <input type="password" name="userPw" required><br>
        氏名: <input type="text" name="name" required><br>
        住所: <input type="text" name="adress" required><br>
        <input type="submit" value="登録">
		</form>



</body>
</html>