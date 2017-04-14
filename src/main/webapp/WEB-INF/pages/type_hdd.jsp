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
	<link href="css/type_hdd.css" rel="stylesheet" type="text/css"/>

	<script src="js/type_hdd.js"></script>
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
                                             <%@include file="include/top.jsp"%>
					</div>
					<div class="bottom">
						<h4>Тип винчестера</h4>

							<table id="mtab" class="tg table table-striped">
								<tr>
									<th nowrap>п/п</th>
									<th>ID</th>
									<th>Модель</th>
									<th>Емкость</th>
									<th colspan="2 col-xs-1" >Операция</th>

								</tr>

								<c:forEach items="${typeHdds}" var="typeHdd" varStatus="st">

									<tr id="id${typeHdd.idTypeHdd}">
										<td>${st.getIndex()+1}</td>
										<td class="idTypeHdd">${typeHdd.idTypeHdd}</td>
										<td class="model">${typeHdd.model}</td>
										<td class="capacity">${typeHdd.capacity}</td>

										<td><a class="editPos">EDIT</a></td>
										<td><a id="deletePos"
											href="<c:url value='type_hdd/delete/${typeHdd.idTypeHdd}'/>">DELETE</a></td>
									</tr>

								</c:forEach>

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
	  		<tr hidden="=true"><td><input type="text"  id="idTr"></td></tr>
			<tr><td>id</td><td><input type="text" id="id" readonly="readonly"></td></tr>
 			<tr><td>Модель</td><td><input type="text" id="model" name="model"></td></tr>
			<tr><td>Емкость</td><td><input type="text" id="capacity" name="capacity"></td></tr>
	  </table><br>
</form>

		<button id="editDialogSave" class="ui-button ui-widget ui-corner-all">Сохранить</button>
	</div>

	<div id="deleteDialog" title="Удаление" class="dialogWindow" hidden=true>
	  Вы действительно хотите удалить?<br><br>
		<button  id="deleteDialogOk" class="ui-button ui-widget ui-corner-all">Да</button>

	</div>

</body>
</html>