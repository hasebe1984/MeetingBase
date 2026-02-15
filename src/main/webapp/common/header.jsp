<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>${tab}</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<header>
    <div class="header">
        <a href="${pageContext.request.contextPath}/jsp/menu.jsp" class="header_logo_group">
            <span class="header_logo_main">MeetingBase</span>
        </a>
        <div class="header_button <c:if test='${empty meetingRoom.user}'>hidden</c:if>">
            <div class="user_name">User: <c:out value="${meetingRoom.user.name}" /></div>
            <form action="${pageContext.request.contextPath}/LogoutServlet" method="post" class="table_form_wrapper">
                <input type="submit" value="ログアウト" class="button_logout">
            </form>
        </div>
    </div>
</header>
<main>