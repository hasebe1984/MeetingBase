<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/header.jsp"%>
    <h1>会議室予約</h1>
    <hr>
    <h2>予約完了</h2>
    ${"予約ID　8"}<br>
    ${"予約日　2023-02-02"}<br>
    ${"会議室　大会議室"}<br>
    ${"予約時刻　14:00～15:00"}<br>
    ${"予約者　情報太郎"}<br>
    <hr>
    <form action="<%= request.getContextPath() %>/SearchServlet" method="get">
        <input type="submit" value="完了">
    </form>
<%@include file="../common/footer.jsp"%>