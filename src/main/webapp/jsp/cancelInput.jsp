<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/header.jsp"%>
<h1>会議室予約キャンセル</h1>
<h2>利用日</h2>
<form action="<%=request.getContextPath()%>/ChangeDateServlet" method="post">
	<input type="date" name="date" value="ミーティングルームから取得">
	<input type="submit" value="日付変更"  class="button_submit button_submit_small">
	<input type="hidden" name="page" value="cancelInput.jsp">
</form>
<h2>キャンセル可能時間帯（名前取得：M.Rから）</h2>
<form action="<%=request.getContextPath()%>/CancelCreateServlet" method="post" class="input_table">
	<table class="table">
		<thead>
			<tr>
				<th>会議室/時間</th>
				<% for(int i=9; i<=16; i++) {  %>
				    <th><%= i %>:00</th>
				<% } %>
			</tr>
		</thead>
		<%--会議室1 （後にfor文へ変更--%>
		<tbody>
			<tr>
				<th>大会議室</th>
				<td>
					<button type="submit" name="time" value="09:00" class="button_submit button_submit_small button_submit_blue ${'button_submit_impossible'}" ${"disabled"}>×</button>
				</td>
				<td>
					<button type="submit" name="time" value="09:00" class="button_submit button_submit_small button_submit_blue">〇</button>
				</td>
				<td>
					<button type="submit" name="time" value="09:00" class="button_submit button_submit_small button_submit_blue ${'button_submit_impossible'}" ${"disabled"}>×</button>
				</td>
				<td>
					<button type="submit" name="time" value="09:00" class="button_submit button_submit_small button_submit_blue">〇</button>
				</td>
				<td>
					<button type="submit" name="time" value="09:00" class="button_submit button_submit_small button_submit_blue ${'button_submit_impossible'}" ${"disabled"}>×</button>
				</td>
				<td>
					<button type="submit" name="time" value="09:00" class="button_submit button_submit_small button_submit_blue ${'button_submit_impossible'}" ${"disabled"}>×</button>
				</td>
				<td>
					<button type="submit" name="time" value="09:00" class="button_submit button_submit_small button_submit_blue ${'button_submit_impossible'}" ${"disabled"}>×</button>
				</td>
				<td>
					<button type="submit" name="time" value="09:00" class="button_submit button_submit_small button_submit_blue ${'button_submit_impossible'}" ${"disabled"}>×</button>
				</td>
			</tr>
			<%--3A会議室 （後にfor文へ変更--%>
			<tr>
				<th>3A会議室</th>
				<td>
					<button type="submit" name="time" value="09:00" class="button_submit button_submit_small button_submit_blue ${'button_submit_impossible'}" ${"disabled"}>×</button>
				</td>
				<td>
					<button type="submit" name="time" value="09:00" class="button_submit button_submit_small button_submit_blue">〇</button>
				</td>
				<td>
					<button type="submit" name="time" value="09:00" class="button_submit button_submit_small button_submit_blue ${'button_submit_impossible'}" ${"disabled"}>×</button>
				</td>
				<td>
					<button type="submit" name="time" value="09:00" class="button_submit button_submit_small button_submit_blue">〇</button>
				</td>
				<td>
					<button type="submit" name="time" value="09:00" class="button_submit button_submit_small button_submit_blue ${'button_submit_impossible'}" ${"disabled"}>×</button>
				</td>
				<td>
					<button type="submit" name="time" value="09:00" class="button_submit button_submit_small button_submit_blue ${'button_submit_impossible'}" ${"disabled"}>×</button>
				</td>
				<td>
					<button type="submit" name="time" value="09:00" class="button_submit button_submit_small button_submit_blue ${'button_submit_impossible'}" ${"disabled"}>×</button>
				</td>
				<td>
					<button type="submit" name="time" value="09:00" class="button_submit button_submit_small button_submit_blue ${'button_submit_impossible'}" ${"disabled"}>×</button>
				</td>
			</tr>
			<%--3B会議室 （後にfor文へ変更--%>
			<tr>
				<th>3B会議室</th>
				<td>
					<button type="submit" name="time" value="09:00" class="button_submit button_submit_small button_submit_blue ${'button_submit_impossible'}" ${"disabled"}>×</button>
				</td>
				<td>
					<button type="submit" name="time" value="09:00" class="button_submit button_submit_small button_submit_blue">〇</button>
				</td>
				<td>
					<button type="submit" name="time" value="09:00" class="button_submit button_submit_small button_submit_blue ${'button_submit_impossible'}" ${"disabled"}>×</button>
				</td>
				<td>
					<button type="submit" name="time" value="09:00" class="button_submit button_submit_small button_submit_blue">〇</button>
				</td>
				<td>
					<button type="submit" name="time" value="09:00" class="button_submit button_submit_small button_submit_blue ${'button_submit_impossible'}" ${"disabled"}>×</button>
				</td>
				<td>
					<button type="submit" name="time" value="09:00" class="button_submit button_submit_small button_submit_blue ${'button_submit_impossible'}" ${"disabled"}>×</button>
				</td>
				<td>
					<button type="submit" name="time" value="09:00" class="button_submit button_submit_small button_submit_blue ${'button_submit_impossible'}" ${"disabled"}>×</button>
				</td>
				<td>
					<button type="submit" name="time" value="09:00" class="button_submit button_submit_small button_submit_blue ${'button_submit_impossible'}" ${"disabled"}>×</button>
				</td>
			</tr>
		</tbody>
	</table>
</form>
<a href="menu.jsp" class="button_submit">メニューへ</a>
<%@include file="../common/footer.jsp"%>