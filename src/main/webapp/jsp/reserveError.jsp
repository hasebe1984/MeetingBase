<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>reserveInput</title>
</head>
<body>
    <h1>会議室予約</h1>
    <hr>
    <h2>予約エラー</h2>
    {"時刻が過ぎているため予約できません。"}
    {"予約日"}
    {"会議室"}
    {"予約時刻"}
    {"予約者"}
    <form action="<%= request.getContextPath() %>/SearchServlet" method="get">
        英単語：<input type="text" name="confirmation">
        <input type="submit" value="確認"><br>
    </form>

</body>
</html>