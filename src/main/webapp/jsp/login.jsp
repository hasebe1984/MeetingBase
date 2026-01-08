<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
</head>
<body>
    <h1>会議室予約</h1>
    <hr>
    <%-- 動的にパスを取得するため、プロジェクト名が変わっても修正不要です --%>
    <h2>ログイン</h2>
    <form action="<%= request.getContextPath() %>/LoginServlet" method="POST">
        利用者ID: <input type="text" name="userId" required><br>
        パスワード: <input type="password" name="userPw" required><br>
        <input type="submit" value="ログイン">
    </form>
</body>
</html>