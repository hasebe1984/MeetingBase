<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログインテスト</title>
</head>
<body>
    <h2>ログイン画面（コンテキストパス対応版）</h2>
    
    <%-- 動的にパスを取得するため、プロジェクト名が変わっても修正不要です --%>
    <form action="<%= request.getContextPath() %>/LoginServlet" method="POST">
        ID: <input type="text" name="user_id" required><br>
        PW: <input type="password" name="password" required><br>
        <input type="submit" value="Servletへ送信">
    </form>
</body>
</html>