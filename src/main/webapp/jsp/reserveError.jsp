<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>予約エラー画面</title>
</head>
<body>
    <h1>会議室予約</h1>
    <hr>
    <h2>予約エラー</h2>
    ${"時刻が過ぎているため予約できません。"}<br>
    ${"予約日　2023-02-02"}<br>
    ${"会議室　大会議室"}<br>
    ${"予約時刻　10:00～11:00"}<br>
    ${"予約者　情報太郎"}<br>
    <hr>
    <form action="<%= request.getContextPath() %>/SearchServlet" method="get">
        <input type="submit" value="確認"><br>
    </form>

</body>
</html>