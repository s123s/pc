<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form"%>


<%@page import="java.util.ArrayList"%>
<%@page import="pc.model.WpSummView"%>


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

	<FORM method="post" name="theForm" action="wp">
		<input type="hidden" name="func" id="func">

		<%
			/* 			wpServiceService.initConnection();
			 */
		%>
		<a href="<c:url value='/logout'/>">Logout</a>
		<h3>Наявнiсть та розстановка ПК</h3>


		<table class="tg">
			<tr>
				<th nowrap rowspan="2">N п/п</th>
				<th colspan="3">Системный блок</th>
				<th colspan="2">Монитор(если по бух. монитор числится)</th>
				<th colspan="2">Информация по пользователю</th>
				<th colspan="6">Информация по мат. обеспечению</th>
				<th colspan="3"></th>		
			</tr>
		
			<tr>
				<th width="80">Инв. номер</th>
				<th width="120">Бухг. название</th>
				<th width="120">Тип компьютера</th>
				<th width="60">Инв. номер монитора</th>
				<th width="60">Название монитора</th>
				<th width="60">ФИО пользователя</th>
				<th>Логин пользователя.</th>
				<th>Имя ПК в сети</th>
				<th>Марка процессора</th>
				<th>Кол-во планок памяти</th>
				<th>Память</th>
				<th>Кол-во винчестеров</th>
				<th>Винчестера</th>
				<th>Операционная с-ма</th>
				
			</tr>
			<c:forEach items="${wps}" var="wp" varStatus="st">

				<tr>
					<td>${st.getIndex()+1}</td>
					<td>${wp.cInvNumber}</td>
					<td>${wp.cBuhName}</td>
					<td>${wp.cTypeComputer}</td>
					<td>${wp.monInvNumber}</td>
					<td>${wp.monName}</td>
					<td>${wp.userName}</td>
					<td>${wp.userLogin}</td>
					<td>${wp.cDomainName}</td>
					<td>${wp.model}</td>
					<td>${wp.ramCount}</td>
					<td>${wp.ramCapacityAll}</td>
					<td>${wp.hddCount}</td>
					<td>${wp.hddCapacityAll}</td>
					<td>${wp.osName}</td>

					<td><a href="<c:url value='/wp/edit/${wp.idWorkplace}'/>">EDIT</a></td>
					<td><a href="<c:url value='/wp/delete/${wp.idWorkplace}'/>">DELETE</a></td>
				</tr>

			</c:forEach>

		</table>
		<BR>Операции с рабочим местом <INPUT type="button" value="Новая"
			onclick="document.theForm.func.value='new_wp'; document.theForm.submit();">
		<br>
	</FORM>
</body>
</html>