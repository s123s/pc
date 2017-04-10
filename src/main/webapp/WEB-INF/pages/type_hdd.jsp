<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form"%>


<%@page import="java.util.ArrayList"%>
<%@page import="pc.model.WpSummView"%>


<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ru">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>
<link
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css"
	rel="stylesheet" type="text/css" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>

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




<style>
html, body {
	height: 100%;
}

.header {
	position: fixed;
	top: 0;
	left: 0;
	right: 0;
	height: 20px;
	background-color: moccasin;
}

.wrapper {
	position: absolute;
	top: 21px;
	right: 0;
	bottom: 0;
	left: 0;
	background-color: fuchsia;
}

.inner-wrapper, .center.pane .inner {
	display: table;
	width: 100%;
	height: 100%;
}

.pane {
	display: table-cell;
}

.left.pane {
	background-color: olivedrab;
	width: 110px;
	height: 100%;
}

.center.pane {
	background-color: lightblue;
	height: 100%;
}

.center.pane .inner .top, .center.pane .inner .bottom {
	display: table-row;
}

.center.pane .inner .top {
	background-color: lightcoral;
}

.center.pane .inner .bottom {
	background-color: orange;
	height: 100%;
	width: 100%;
}

.right.pane {
	background-color: #999;
}

#menu1 a:link, #menu1 a:visited {
	color: blue;
}

#menu1 {
	padding-left: 5px;
	padding-right: 5px;
}
</style>

<script>
	$(function() {
		$(".left.pane").resizable({
			handles : "e, w"
		});
		$(".right.pane").resizable({
			handles : "e, w"
		});
		$(".center.pane .inner .bottom").resizable({
			handles : "n, s"
		});
	});
</script>

</head>

<body>


	<div class="header">Fixed header</div>
	<div class="wrapper">
		<div class="inner-wrapper">
			<div class="left pane">
				<%@include file="include/left_menu.jsp"%>
			</div>
			<div class="center pane">
				<div class="inner">
					<div class="top">
						Center top<br>
						<a href="<c:url value='/logout'/>">Logout</a>
						<h3>Тип винчестера</h3>

					</div>
					<div class="bottom">
						Center bottom<br>

							<table class="tg">
								<tr>
									<th nowrap>N п/п</th>
									<th>ID</th>
									<th>Модель</th>
									<th>Емкость</th>
								</tr>

								<c:forEach items="${typeHdds}" var="typeHdd" varStatus="st">

									<tr>
										<td>${st.getIndex()+1}</td>
										<td>${typeHdd.idTypeHdd}</td>
										<td>${typeHdd.model}</td>
										<td>${typeHdd.capacity}</td>

										<td><a
											href="<c:url value='/type_hdd/edit/${typeHdd.idTypeHdd}'/>">EDIT</a></td>
										<td><a
											href="<c:url value='/type_hdd/delete/${typeHdd.idTypeHdd}'/>">DELETE</a></td>
									</tr>

								</c:forEach>

							</table>
				
					</div>
				</div>
			</div>
			<!--div class="right pane">Right</div-->
		</div>
	</div>
</body>
</html>