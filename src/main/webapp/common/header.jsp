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
			<a href="../jsp/login.jsp" class="button_small">ログイン</a>
			<form action="${pageContext.request.contextPath}/LogoutServlet" method="post">
				<input type="submit" value="ログアウト" class="button_small">
			</form>
		</div>
	</div>
</header>
<main>