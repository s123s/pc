<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form"%>


<%@page import="java.util.ArrayList"%>
<%@page import="pc.model.Book"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #ccc;
}

.tg td {
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	border-color: #ccc;
}

.tg th {
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	border-color: #ccc;
	color: #333;
}
</style>
</head>
<body>

	<FORM method="post" name="theForm" action="book">
		<input type="hidden" name="func" id="func">

		<%
			/* 			bookService.initConnection();
			 */
		%>
		<a href="<c:url value='/logout'/>">Logout</a>
		<h3>Собственно, книги:</h3>
		<h2>Book List</h2>


		<table class="tg">
			<tr>
				<th width="80">ID</th>
				<th width="120">Title</th>
				<th width="120">ISDN</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${books}" var="book">

				<tr>
					<td>${book.id}</td>
					<td>${book.name}</td>
					<td>${book.isdn}</td>

					<td><a href="<c:url value='/book/edit/${book.id}'/>">EDIT</a></td>
					<td><a href="<c:url value='/book/delete/${book.id}'/>">DELETE</a></td>
				</tr>

			</c:forEach>

		</table>
		<BR>Операции с книгами <INPUT type="button" value="Новая"
			onclick="document.theForm.func.value='new_book'; document.theForm.submit();">
		<br>
	</FORM>
</body>
</html>