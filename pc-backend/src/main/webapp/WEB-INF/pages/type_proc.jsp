<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form"%>

<!-- <%@page import="java.util.ArrayList"%> -->

<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ru">
<head>

<title>Наличие и расстановка ПК</title>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- X-CSRF-TOKEN -->
	<meta name="_csrf" content="${_csrf.token}"/>
	<meta name="_csrf_header" content="${_csrf.headerName}"/>


    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->



	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="js/jquery.validate.min.js"></script>
	<!-- <script src="http://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.validate.min.js"></script> -->
	<link 	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />
	<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
    <script src="js/bootstrap.min.js"></script>

	<link href="css/main.css" rel="stylesheet" type="text/css"/>
<!-- 	<link href="css/type_hdd.css" rel="stylesheet" type="text/css"/> -->

	<script src="js/global.js"></script>
	<script src="js/type_proc.js"></script>
</head>

<body>
	<div class="header"><%@include file="include/header.jsp"%></div>
	<div class="wrapper">
		<div class="inner-wrapper">
			<div class="left pane">
				<%@include file="include/left_menu.jsp"%>
			</div>
			<div class="center pane">

				<div class="inner">
					<div class="top">
                      <h4>Типы процессоров</h4>
					</div>
					<div class="bottom">
						<a class="newPos"><span class="glyphicon glyphicon-asterisk"></span>&nbsp;Новый тип</a><br>

						<table id="mtab" class="table table-striped">
							<thead>
								<tr>
									<th hidden="true" nowrap>п/п</th>
									<th class="col-xs-1">ID</th>
									<th class="col-xs-5">Производитель</th>
									<th class="col-xs-2">Модель</th>
									<th class="col-xs-2">Сокет</th>
									<th class="col-xs-1" title="Количество процессоров">Кол-во проц.</th>
									<th class="col-xs-1">Операция</th>

								</tr>
							</head>
							<tbody>

								<tr id="emptyTr" hidden="true">
										<td class="myIndex" hidden="true"></td>
										<td class="idTypeProc"></td>
										<td class="idProducer" hidden="true">
										<td class="producerName"></td>
										<td class="model"></td>
										<td class="socket"></td>
										<td class="numberOfProcs"></td>

										<td><a class="editPos"><span class="glyphicon glyphicon-pencil"></span></a>&nbsp;
											<a class="deletePos"><span class="glyphicon glyphicon-trash"></span></a></td>
								</tr>
									
								<c:forEach items="${typeProcs}" var="typeProc" varStatus="st">

									<tr id="id${typeProc.idTypeProc}">
										<td class="myIndex" hidden="true">${st.getIndex()+1}</td>
										<td class="idTypeProc">${typeProc.idTypeProc}</td>
										<td class="idProducer" hidden="true">${typeProc.producer.idProducer}</td>
										<td class="producerName">${typeProc.producer.shortname}</td>
										<td class="model">${typeProc.model}</td>
										<td class="socket">${typeProc.socket}</td>
										<td class="numberOfProcs">${typeProc.processors.size()}</td>

										<td><a class="editPos"><span class="glyphicon glyphicon-pencil"></span></a>&nbsp;
											<a class="deletePos"><span class="glyphicon glyphicon-trash"></span></a></td>
									</tr>

								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<!--div class="right pane">Right</div-->
		</div>
	</div>

<div id="editDialog" title="Редактирование типа" class="dialogWindow" hidden=true>
	<form id="editDialogForm" action="" method="post">
	  <table>
	  		<tr hidden="true"><td><input type="text"  id="idTr"></td></tr>
			<tr><td>ID</td><td><input type="text" id="id" readonly="readonly"></td></tr>
			
 			<tr><td>Производитель</td><td>
				<select id="idProducer" style="width:100%">
					<option value="">Select one...</option>
					<c:forEach items="${producers}" var="producer" varStatus="st">
						<option value="${producer.idProducer}">${producer.shortname}</option>
					</c:forEach>
				</select>
			</td></tr>
			<tr><td>Модель</td><td><input type="text" id="model" name="model"></td></tr>
			<tr><td>Сокет</td><td><input type="text" id="socket" name="socket"></td></tr>
	  </table><br>
	</form>
	<button id="editDialogSave" class="ui-button ui-widget ui-corner-all">Сохранить</button>
</div>

<div id="newDialog" title="Новый тип" class="dialogWindow" hidden=true>
	<table>
		<tr><td>Производитель</td><td>
			<select id="idProducer" style="width:100%">
				<option value="">Select one...</option>
				<c:forEach items="${producers}" var="producer" varStatus="st">
					<option value="${producer.idProducer}">${producer.shortname}</option>
				</c:forEach>
			</select>
		</td></tr>

			<tr><td>Модель</td><td><input type="text" id="model" name="model"></td></tr>
			<tr><td>Сокет</td><td><input type="text" id="socket" name="socket"></td></tr>
	</table><br>
	<button id="newDialogSave" class="ui-button ui-widget ui-corner-all">Создать</button>
</div>


<div id="deleteDialog" title="Удаление типа" class="dialogWindow" hidden=true>
	<input type="text" id="idTr" hidden="true">
	<input type="text" id="id" hidden="true">
	Вы действительно хотите удалить?<br><br>
	<button  id="deleteDialogOk" class="ui-button ui-widget ui-corner-all">Да</button>
</div>
<%@include file="include/global.jsp"%>
</body>
</html>
