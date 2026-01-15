<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="jp.co.sys.bean.MeetingRoom"%>
<%@ page import="jp.co.sys.bean.RoomBean"%>
<%@ page import="jp.co.sys.bean.ReservationBean"%>
<%@ page import="jp.co.sys.util.RoomList"%>
String[] period = meetingRoom.getPeriod();
    RoomList rooms  = meetingRoom.getRooms();
    ReservationBean[][] reservations = meetingRoom.getReservations();


<%@include file="../common/header.jsp"%>
<h1>会議室予約</h1>
<h2>利用日</h2>
<form action="${pageContext.request.contextPath}/ChangeDateServlet"
	method="post">
	<input type="date" name="date" value=""> <input type="submit"
		value="日付変更" class="button_submit button_submit_small"> <input
		type="hidden" name="page" value="reserveInput.jsp">
</form>
<h2>予約可能時間帯（名前取得：M.Rから）</h2>
<form action="${pageContext.request.contextPath}/reserveCreateServlet"
	method="post" class="input_table">
	<table class="table">
		<thead>
			<tr>
				<th>会議室/時間</th>
				<%
				for (int i = 9; i <= 16; i++) {
				%>
				<th><%=i%>:00</th>
				<%
				}
				%>
			</tr>
		</thead>
		<%--会議室1 （後にfor文へ変更--%>
		<tbody>
			<tr>
				<td>大会議室</td>
				<td>
					<button type="submit" name="time" value="09:00"
						class="button_submit button_submit_small button_submit_blue">〇</button>
				</td>
				<td>
					<button type="submit" name="time" value="09:00"
						class="button_submit button_submit_small button_submit_blue">〇</button>
				</td>
				<td>
					<button type="submit" name="time" value="09:00"
						class="button_submit button_submit_small button_submit_blue ${'button_submit_impossible'}"
						${"disabled"}>×</button>
				</td>
				<td>
					<button type="submit" name="time" value="09:00"
						class="button_submit button_submit_small button_submit_blue">〇</button>
				</td>
				<td>
					<button type="submit" name="time" value="09:00"
						class="button_submit button_submit_small button_submit_blue">〇</button>
				</td>
				<td>
					<button type="submit" name="time" value="09:00"
						class="button_submit button_submit_small button_submit_blue ${'button_submit_impossible'}"
						${"disabled"}>×</button>
				</td>
				<td>
					<button type="submit" name="time" value="09:00"
						class="button_submit button_submit_small button_submit_blue">〇</button>
				</td>
				<td>
					<button type="submit" name="time" value="09:00"
						class="button_submit button_submit_small button_submit_blue ${'button_submit_impossible'}"
						${"disabled"}>×</button>
				</td>
			</tr>
			<%--3A会議室 （後にfor文へ変更--%>
			<tr>
				<td>3A会議室</td>
				<td>
					<button type="submit" name="time" value="09:00"
						class="button_submit button_submit_small button_submit_blue">〇</button>
				</td>
				<td>
					<button type="submit" name="time" value="09:00"
						class="button_submit button_submit_small button_submit_blue">〇</button>
				</td>
				<td>
					<button type="submit" name="time" value="09:00"
						class="button_submit button_submit_small button_submit_blue ${'button_submit_impossible'}"
						${"disabled"}>×</button>
				</td>
				<td>
					<button type="submit" name="time" value="09:00"
						class="button_submit button_submit_small button_submit_blue">〇</button>
				</td>
				<td>
					<button type="submit" name="time" value="09:00"
						class="button_submit button_submit_small button_submit_blue">〇</button>
				</td>
				<td>
					<button type="submit" name="time" value="09:00"
						class="button_submit button_submit_small button_submit_blue ${'button_submit_impossible'}"
						${"disabled"}>×</button>
				</td>
				<td>
					<button type="submit" name="time" value="09:00"
						class="button_submit button_submit_small button_submit_blue">〇</button>
				</td>
				<td>
					<button type="submit" name="time" value="09:00"
						class="button_submit button_submit_small button_submit_blue ${'button_submit_impossible'}"
						${"disabled"}>×</button>
				</td>
			</tr>
			<%--3B会議室 （後にfor文へ変更--%>
			<tr>
				<td>3B会議室</td>
				<td>
					<button type="submit" name="time" value="09:00"
						class="button_submit button_submit_small button_submit_blue">〇</button>
				</td>
				<td>
					<button type="submit" name="time" value="09:00"
						class="button_submit button_submit_small button_submit_blue">〇</button>
				</td>
				<td>
					<button type="submit" name="time" value="09:00"
						class="button_submit button_submit_small button_submit_blue ${'button_submit_impossible'}"
						${"disabled"}>×</button>
				</td>
				<td>
					<button type="submit" name="time" value="09:00"
						class="button_submit button_submit_small button_submit_blue">〇</button>
				</td>
				<td>
					<button type="submit" name="time" value="09:00"
						class="button_submit button_submit_small button_submit_blue">〇</button>
				</td>
				<td>
					<button type="submit" name="time" value="09:00"
						class="button_submit button_submit_small button_submit_blue ${'button_submit_impossible'}"
						${"disabled"}>×</button>
				</td>
				<td>
					<button type="submit" name="time" value="09:00"
						class="button_submit button_submit_small button_submit_blue">〇</button>
				</td>
				<td>
					<button type="submit" name="time" value="09:00"
						class="button_submit button_submit_small button_submit_blue ${'button_submit_impossible'}"
						${"disabled"}>×</button>
				</td>
			</tr>
		</tbody>
	</table>
</form>

<%
    // ===== サーブレットから受け取る =====
    MeetingRoom meetingRoom = (MeetingRoom) session.getAttribute("meetingRoom");

     //null対策（初回表示用）
    if (meetingRoom == null) {
        meetingRoom = new MeetingRoom();
        session.setAttribute("meetingRoom", meetingRoom);
    }
    

    String[] period = meetingRoom.getPeriod();
    RoomList rooms  = meetingRoom.getRooms();
    ReservationBean[][] reservations = meetingRoom.getReservations();
%>



<%--会議室for文バージョン間違ってた ら教えてください！！！！！！--%>


<form action="${pageContext.request.contextPath}/ChangeDateServlet"
	method="POST">
	<h1>利用日</h1>
	<input type="date" name="date" value="${meetingRoom.date}"> <input
		type="submit" value="日付変更" class="button_submit button_submit_small"><br> <input type="hidden"
		name="page" value="reserveInput.jsp">
</form>

<%--後で復活タグ<h1>予約可能時間帯${meetingRoom.user.name}</h1>--%>

<table class="table">
		<thead>
			<tr>
				<th>会議室/時間</th>
		<%--始まりの時間を要素分取り出して順に表示--%>
		<%
		for (int j = 0; j < period.length; j++) {
		%>
		<th><%=period[j]%></th>
		<%
		}
		%>
	</tr>
	</thead>
	<%--二重for文　i=会議室名の表示--%>
	<%
	for (int i = 0; i < rooms.size(); i++) {
		
	%>
	<tbody>
	<tr>
		<td><%=rooms.get(i).getName()%></td>
		<%--二重for文　j=時間の表示（今は〇、×表示をここで判定）--%>
		<%
		for (int j = 0; j < period.length; j++) {
		%>
		<td>
			<%--配列の中身が〇だったらボタンを作る--%> 
			<%--MeetingRoom対応：if (reservations[i][j]==null)だったら予約の空きあり=〇表示)  ("〇".equals(reservations[i][j]))--%>
			<%
			if (reservations[i][j]==null) {
			%>
			<form action="${pageContext.request.contextPath}/reserveCreateServlet"
				method="post">
				<input type="hidden" name="roomId" value="<%=rooms.get(i).getName()%>">

				<button 
					class="button_submit button_submit_small button_submit_blue">〇</button>
				<%--仕様書はsubmit送信ですが、〇×表示になったので hiddenで送ってます--%>
				<input type="hidden" name="time" value="<%=period[j]%>">
			</form> <%--配列の中身が×だったら×を直書き--%> <%
 } else {
 %>
			<button 
				class="button_submit button_submit_small button_submit_blue ${'button_submit_impossible'}"
				${"disabled"}>×</button> <%
 }
 %>
		</td>
		<%
		}
		%>
	</tr>
	<%
	}
	%>
	</tbody>
</table>

<a href="${pageContext.request.contextPath}/jsp/menu.jsp"
	class="button_submit">メニューへ</a>
<%@include file="../common/footer.jsp"%>