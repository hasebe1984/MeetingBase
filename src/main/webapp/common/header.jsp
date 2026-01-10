<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title></title>
	<link rel="stylesheet" href="../css/reset.css">
	<link rel="stylesheet" href="../css/style.css">
</head>
<body>
<header>
	<div class="header">
		<a href="menu.jsp" class="header_logo">MRR</a>
		<div class="header_button">
			<a href="../jsp/login.jsp" class="button_small">ログイン</a>
			<form action="<%=request.getContextPath()%>/LogoutServlet" method="post">
				<input type="submit" value="ログアウト" class="button_small">
			</form>
		</div>
	</div>
</header>
<main>