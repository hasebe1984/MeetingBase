<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/header.jsp"%>
<h1>${title}</h1>
<hr>
<h2>完了</h2>
<table>
	<tbody>
		<tr>
			<th>会議室名</th>
			<td>${room.name}</td>
		</tr>
		<tr>
			<th>会議室階</th>
			<td>${room.id}</td>
		</tr>
	</tbody>
</table>
<a href="${pageContext.request.contextPath}/jsp/menu.jsp"class="button_submit">メニューへ</a>
<%@include file="../common/footer.jsp"%>