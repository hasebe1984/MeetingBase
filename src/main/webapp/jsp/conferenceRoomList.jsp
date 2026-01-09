<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/header.jsp"%>
<h1>会議室一覧</h1>
<hr>
<h2>会議室</h2>
<table class="table">
	<tr>
		<td>${"ID1"}</td>
		<td>${"大会議室"}</td>
		<td>
			<form action="<%=request.getContextPath()%>/SearchServlet"
				method="post">
				<input type="submit" value="会議室情報編集">
			</form>
		</td>
		<td>
			<form action="<%=request.getContextPath()%>/SearchServlet"
				method="post">
				<input type="submit" value="会議室情報削除">
			</form>
		</td>

	</tr>
	<tr>
		<td>${"ID2"}</td>
		<td>${"小会議室"}</td>
		<td>
			<form action="<%=request.getContextPath()%>/SearchServlet"
				method="post">
				<input type="submit" value="会議室情報編集">
			</form>
		</td>
		<td>
			<form action="<%=request.getContextPath()%>/SearchServlet"
				method="post">
				<input type="submit" value="会議室情報削除">
			</form>
		</td>

	</tr>
	<tr>
		<td>${"ID3"}</td>
		<td>${"中会議室"}</td>
		<td>
			<form action="<%=request.getContextPath()%>/SearchServlet"
				method="post">
				<input type="submit" value="会議室情報編集">
			</form>
		</td>
		<td>
			<form action="<%=request.getContextPath()%>/SearchServlet"
				method="post">
				<input type="submit" value="会議室情報削除">
			</form>
		</td>

	</tr>
</table>
<hr>
<div class="button_row">
	<a href="conferenceRoomList.jsp">戻る</a>
	<form action="<%=request.getContextPath()%>/SearchServlet" method="post">
		<input type="submit" value="会議室追加">
	</form>
</div>
<%@include file="../common/footer.jsp"%>