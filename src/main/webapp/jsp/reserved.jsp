<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/header.jsp"%>
    <h1>会議室予約</h1>
    <hr>
    <h2>予約完了</h2>
    <table>
		<tr>
			<th>予約日</th>
			<td>${"2023-02-02"}</td>
		</tr>
		<tr>
			<th>会議室</th>
			<td>${"大会議室"}</td>
		</tr>
		<tr>
			<th>予約時刻</th>
			<td>${"14:00～15:00"}</td>
		</tr>
		<tr>
			<th>予約者</th>
			<td>${"情報太郎"}</td>
		</tr>
	</table>
    <form action="<%= request.getContextPath() %>/SearchServlet" method="get">
        <input type="submit" value="完了">
    </form>
<%@include file="../common/footer.jsp"%>