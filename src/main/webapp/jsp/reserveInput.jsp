<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="jp.co.sys.bean.MeetingRoom"%>
<%@ page import="jp.co.sys.bean.RoomBean"%>
<%@ page import="jp.co.sys.bean.ReservationBean"%>
<%@ page import="jp.co.sys.util.RoomList"%>
<%@ page import="jp.co.sys.dao.UserDao"%>

<%
//=====サーブレットから受け取る=====
MeetingRoom meetingRoom=(MeetingRoom)
session.getAttribute("meetingRoom");
session.setAttribute("meetingRoom", meetingRoom);
String[] period = meetingRoom.getPeriod();
RoomList rooms = meetingRoom.getRooms();
ReservationBean[][] reservations = meetingRoom.getReservations();
%>

<%@include file="../common/header.jsp"%>
	<h1>会議室予約</h1>
	<h2>日付 -day-</h2>
	<div class="section_box">
		<form action="${pageContext.request.contextPath}/ChangeDateServlet"
			method="POST" class="date_form_layout">
			
			<input type="date" name="date" class="form_input_date"
				value="${meetingRoom.date}"
				min="<%= new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()) %>">
			
			<input type="submit" value="変更する" class="button_submit button_date_change">
			<input type="hidden" name="page" value="reserveInput.jsp">
		</form>
	</div>

	<h2>時間 -time-</h2>

	<table class="input_table">
		<thead>
			<tr>
				<th>ROOM / TIME</th>
				<% for (int j = 0; j < period.length; j++) { %>
					<th><%=period[j]%></th>
				<% } %>
			</tr>
		</thead>
		<tbody>
			<% for (int i = 0; i < rooms.size(); i++) {
				String room = rooms.get(i).getName();
				request.setAttribute("room", room);
			%>
			<tr>
				<td><c:out value="${room }" /></td>
				<% for (int j = 0; j < period.length; j++) { %>
				<td>
					<% if (reservations[i][j] == null) { %>
						<form action="${pageContext.request.contextPath}/reserveCreateServlet" method="post" class="table_form_wrapper">
							<input type="hidden" name="roomId" value="<%=rooms.get(i).getId()%>">
							<input type="hidden" name="time" value="<%=period[j]%>">
							<button class="button_circle_orange"></button>
						</form>
					<% } else { %>
						<span class="status_hyphen">―</span>
					<% } %>
				</td>
				<% } %>
			</tr>
			<% } %>
		</tbody>
	</table>

    <div class="legend_area">
        <div class="legend_item">
            <span class="legend_dot_sample"></span> 予約可能
        </div>
        <div class="legend_item">
            <span class="legend_hyphen_sample">―</span> 予約不可
        </div>
    </div>

	<div class="button_row">
		<a href="${pageContext.request.contextPath}/jsp/menu.jsp" class="button_submit">メニューへ</a>
	</div>

<%@include file="../common/footer.jsp"%>