<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会議室登録入力</title>
</head>
<body>

<h1>会議室登録入力</h1>
		<form action="conferenceRoomConfirm.jsp" method="POST">
		会議室名: <input type="text" name="name" required><br>
		会議室階数: <input type="text" name="id" required><br>
        
        
        <input type="submit" value="登録">
		</form>

</body>
</html>