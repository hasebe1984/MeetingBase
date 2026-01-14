<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	//テスト終わったら変える！！！！
<%@ page import="jp.co.sys.stub.asano.MeetingRoom"%>
<%@ page import="jp.co.sys.stub.asano.RoomBean"%>


	
<%@include file="../common/header.jsp"%>
<h1>会議室予約</h1>
<h2>利用日</h2>
<form action="${pageContext.request.contextPath}/ChangeDateServlet"
	method="post">
	<input type="date" name="date" value="${"disabled"}"> <input
		type="submit" value="日付変更" class="button_submit button_submit_small">
	<input type="hidden" name="page" value="reserveInput.jsp">
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

<%--会議室for文バージョン間違ってた ら教えてください！！！！！！--%>

<%
//meetingRoomをセッションから取得
MeetingRoom meetingRoom = (MeetingRoom) session.getAttribute("meetingRoom");
//なければ作る
if (meetingRoom == null) {
	meetingRoom = new MeetingRoom();
	session.setAttribute("meetingRoom", meetingRoom);
}
//部屋の一覧
RoomBean[] rooms = meetingRoom.getRooms();
//始まりの時間
String[] period = meetingRoom.getPeriod();
//本当はResevationBean型　予約情報の一覧
String[][] reservations = meetingRoom.getReservations();
%>
<form action="${pageContext.request.contextPath}/ChangeDateServlet"
	method="POST">
	<h1>利用日</h1>
	<input type="date" name="date" value="${meetingRoom.date}"> <input
		type="submit" value="日付変更"><br> <input type="hidden"
		name="page" value="reserveInput.jsp">
</form>

<%--後で復活タグ<h1>予約可能時間帯${meetingRoom.user.name}</h1>--%>

<table border="1">
	<tr>
		<th>会議室 / 時間</th>
		<%--始まりの時間を要素分取り出して順に表示--%>
		<%
		for (int j = 0; j < period.length; j++) {
		%>
		<th><%=period[j]%></th>
		<%
		}
		%>
	</tr>
	<%--二重for文　i=会議室名の表示--%>
	<%
	for (int i = 0; i < rooms.length; i++) {
	%>
	<tr>
		<td><%=rooms[i].getName()%></td>
		<%--二重for文　j=時間の表示（今は〇、×表示をここで判定）←これはどこがやるんだ？--%>
		<%
		for (int j = 0; j < period.length; j++) {
		%>
		<td>
			<%--配列の中身が〇だったらボタンを作る--%> <%
 if ("〇".equals(reservations[i][j])) {
 %>
			<form action="${pageContext.request.contextPath}/reserveCreateServlet"
				method="post">
				<input type="hidden" name="roomId" value="<%=rooms[i].getId()%>">
				<%--後に"value=<%= period[j] %>"へ変更+name=timeも追加--%>
				<input type="submit" value="〇">
				<%--仕様書にないから多分これはダメな設計 hiddenで送ってる仮の設定--%>
				<input type="hidden" name="time" value="<%=period[j]%>">

			</form> <%--配列の中身が×だったら×を直書き--%> <%
 } else {
 %> × <%
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
</table>

<a href="${pageContext.request.contextPath}/jsp/menu.jsp" class="button_submit">メニューへ</a>
<%@include file="../common/footer.jsp"%>