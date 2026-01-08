<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>予約確認画面</title>
</head>
<body>
    <h1>会議室予約</h1>
    <hr>
    <h2>予約確認</h2>
    ${"予約日　2023-02-02"}<br>
    ${"会議室　大会議室"}<br>
    ${"予約時刻　14:00～15:00"}<br>
    ${"予約者　情報太郎"}<br>
    <hr>
    <form action="<%= request.getContextPath() %>/SearchServlet" method="get">
        <input type="submit" value="戻る">
    
    <form action="<%= request.getContextPath() %>/SearchServlet" method="get">
        <input type="submit" value="決定">
    </form>

</body>
</html>