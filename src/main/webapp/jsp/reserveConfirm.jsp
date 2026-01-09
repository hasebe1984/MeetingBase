<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/header.jsp"%>
    <h1>会議室予約</h1>
    <hr>
    <h2>予約確認</h2>
    <div>予約日 ${"2023-02-02"}</div>
    <div>会議室 ${"大会議室"}</div>
    <div>予約時刻 ${"14:00～15:00"}</div>
    <div>予約者 ${"情報太郎"}</div>
    <hr>
    <form action="<%= request.getContextPath() %>/SearchServlet" method="get">
        <input type="submit" value="戻る">
    </form>
    <form action="<%= request.getContextPath() %>/SearchServlet" method="get">
        <input type="submit" value="決定">
    </form>
<%@include file="../common/footer.jsp"%>