<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<title>キャンセル入力画面</title>
	</head>

	<body>

		<h1>会議室予約キャンセル</h1>
		<form action="<%=request.getContextPath()%>/ChangeDateServlet" method="POST">
			<h1>利用日</h1>
			<input type="date" name="date" value="ミーティングルームから取得"> <input type="submit" value="日付変更"><br>
			<input type="hidden" name="page" value="cancelInput.jsp">


		</form>


		<h1>キャンセル可能時間帯（名前取得：M.Rから）</h1>



		<form action="<%=request.getContextPath()%>/CancelCreateServlet" method="POST">
			<table border="1">
				<tr>
					<th>会議室/時間</th>
					<th>09:00</th>
					<th>10:00</th>
					<th>11:00</th>
					<th>12:00</th>
					<th>13:00</th>
					<th>14:00</th>
					<th>15:00</th>
					<th>16:00</th>
				</tr>


				<%--会議室1 （後にfor文へ変更--%>
					<tr>
						<th>大会議室</th>
						<td><button type="submit" name="time" value="09:00">〇
							</button></td>
						<td>×</td>
						<td><button type="submit" name="time" value="11:00">〇
							</button></td>
						<td><button type="submit" name="time" value="11:00">〇
							</button></td>
						<td><button type="submit" name="time" value="12:00">〇
							</button></td>
						<td><button type="submit" name="time" value="13:00">〇
							</button></td>
						<td><button type="submit" name="time" value="14:00">〇
							</button></td>
						<td><button type="submit" name="time" value="15:00">〇
							</button></td>

					</tr>

					<%--3A会議室 （後にfor文へ変更--%>
						<tr>
							<th>3A会議室</th>
							<td><button type="submit" name="time" value="09:00">〇
								</button></td>
							<td>×</td>
							<td><button type="submit" name="time" value="11:00">〇
								</button></td>
							<td><button type="submit" name="time" value="11:00">〇
								</button></td>
							<td><button type="submit" name="time" value="12:00">〇
								</button></td>
							<td><button type="submit" name="time" value="13:00">〇
								</button></td>
							<td><button type="submit" name="time" value="14:00">〇
								</button></td>
							<td><button type="submit" name="time" value="15:00">〇
								</button></td>

						</tr>

						<%--3B会議室 （後にfor文へ変更--%>
							<tr>
								<th>3B会議室</th>
								<td><button type="submit" name="time" value="09:00">〇
									</button></td>
								<td>×</td>
								<td><button type="submit" name="time" value="11:00">〇
									</button></td>
								<td><button type="submit" name="time" value="11:00">〇
									</button></td>
								<td><button type="submit" name="time" value="12:00">〇
									</button></td>
								<td><button type="submit" name="time" value="13:00">〇
									</button></td>
								<td><button type="submit" name="time" value="14:00">〇
									</button></td>
								<td><button type="submit" name="time" value="15:00">〇
									</button></td>

							</tr>
			</table>
		</form><br>
		<form action="menu.jsp" method="POST">
			<input type="submit" value="戻る"><br>



		</form>

	</body>

	</html>