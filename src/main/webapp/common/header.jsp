<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title></title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<header>
	<div class="header">
		<a href="${pageContext.request.contextPath}/jsp/menu.jsp">
			<img src="${pageContext.request.contextPath}/images/logo.png" alt="MeetingBaseロゴ" class="header_logo">
		</a>
		<div class="header_button">
			<form action="${pageContext.request.contextPath}/clearSession" method="get">
	    		<input type="submit" value="セッション削除" class="button_small" 
	      	     onclick="return confirm('セッションをクリアしますか？');">
			</form>
			<form action="${pageContext.request.contextPath}/setSession" method="get">
				<input type="submit" value="セッション登録" class="button_small">
			</form>
		</div>
		<div class="header_button">
			<div>${session.name}さん</div>
			<form action="${pageContext.request.contextPath}/LogoutServlet" method="post">
				<input type="submit" value="ログアウト" class="button_small">
			</form>
		</div>
	</div>
	<div><p>デバッグ確認（利用日）：${meetingRoom.date}</p>
	</div>
</header>
<main>