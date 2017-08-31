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
	<link href="css/type_hdd.css" rel="stylesheet" type="text/css"/>

	<script src="js/global.js"></script>
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
                        <h4>Тип винчестера</h4>
					</div>
					<div class="bottom">
						<a class="newPos"><span class="glyphicon glyphicon-asterisk"></span>&nbsp;Новый тип</a><br>



		<table class="tg">

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




						<table id="mtab" class="table table-striped">
							<thead>
								<tr>
								<tr>
									<th nowrap rowspan="2">N п/п</th>
									<th colspan="3">Системный блок</th>
									<th colspan="2">Монитор(если по бух. монитор числится)</th>
									<th colspan="2">Информация по пользователю</th>
									<th colspan="6">Информация по мат. обеспечению</th>
									<th colspan="3"></th>
									<th rowspan="2" style="width:70px" >Операция</th>		
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

									<!-- <th hidden="true" nowrap>п/п</th>
									<th>ID</th>
									<th>Производитель</th>
									<th>Емкость</th>
									<th style="width:70px" >Операция</th> -->

								</tr>
							</head>
							<tbody>

								<tr id="emptyTr" hidden="true">
										<!-- <td class="myIndex" hidden="true"></td>
										<td class="idTypeHdd"></td>
										<td class="producerName"></td>
										<td class="capacity"></td>

										<td><a class="editPos"><span class="glyphicon glyphicon-pencil"></span></a>&nbsp;
											<a class="deletePos"><span class="glyphicon glyphicon-trash"></span></a></td> -->
								</tr>
									
			<c:forEach items="${wps}" var="wp" varStatus="st">

				<tr>
					<tr id="id$${wp.id_workplace}">
					<td class="myIndex" hidden="true">${st.getIndex()+1}</td>
					<td class="">${wp.cInvNumber}</td>
					<td class="">${wp.cBuhName}</td>
					<td class="">${wp.cTypeComputer}</td>
					<td class="">${wp.monInvNumber}</td>
					<td class="">${wp.monName}</td>
					<td class="">${wp.userName}</td>
					<td class="">${wp.userLogin}</td>
					<td class="">${wp.cDomainName}</td>
					<td class="">${wp.model}</td>
					<td class="">${wp.ramCount}</td>
					<td class="">${wp.ramCapacityAll}</td>
					<td class="">${wp.hddCount}</td>
					<td class="">${wp.hddCapacityAll}</td>
					<td class="">${wp.osName}</td>

					<td><a class="editPos"><span class="glyphicon glyphicon-pencil"></span></a>&nbsp;
											<a class="deletePos"><span class="glyphicon glyphicon-trash"></span></a></td>
				</tr>

			</c:forEach>

								<c:forEach items="${typeHdds}" var="typeHdd" varStatus="st">

									<tr id="id${typeHdd.idTypeHdd}">
										<td class="myIndex" hidden="true">${st.getIndex()+1}</td>
										<td class="idTypeHdd">${typeHdd.idTypeHdd}</td>
										<td class="idProducer" hidden="true">${typeHdd.producer.idProducer}</td>
										<td class="producerName">${typeHdd.producer.shortname}</td>
										<td class="capacity">${typeHdd.capacity}</td>

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
 			<!-- <tr><td>Производитель</td><td><input type="text" id="producerName" name="producerName"></td></tr> -->
			<tr><td>Емкость</td><td><input type="text" id="capacity" name="capacity"></td></tr>
	  </table><br>
	</form>
	<button id="editDialogSave" class="ui-button ui-widget ui-corner-all">Сохранить</button>
</div>

<div id="newDialog" title="Создание типа" class="dialogWindow" hidden=true>
	<table>
		<tr><td>Производитель</td><td>
			<select id="idProducer" style="width:100%">
				<option value="">Select one...</option>
				<c:forEach items="${producers}" var="producer" varStatus="st">
					<option value="${producer.idProducer}">${producer.shortname}</option>
				</c:forEach>
			</select>
		</td></tr>

		<!--tr><td>Производитель</td><td><input type="text" id="producerName" name="producerName"></td></tr-->
		<tr><td>Емкость</td><td><input type="text" id="capacity" name="capacity"></td></tr>
	</table><br>
	<button id="newDialogSave" class="ui-button ui-widget ui-corner-all">Создать</button>
</div>


<div id="deleteDialog" title="Удаление типа" class="dialogWindow" hidden=true>
	<input type="text" id="idTr" hidden="true">
	<input type="text" id="id" hidden="true">
	Вы действительно хотите удалить?<br><br>
	<button  id="deleteDialogOk" class="ui-button ui-widget ui-corner-all">Да</button>
</div>

</body>
</html>



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
	
	
	
</div>
           </div>
       </div>
       <!--div class="right pane">Right</div-->
   </div>
</div>
</body>
</html>