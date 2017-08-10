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
<!-- 	<link href="css/computer.css" rel="stylesheet" type="text/css"/> -->

	<script src="js/global.js"></script>
	<script src="js/computer.js"></script>
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
                      <h4>Компьютеры</h4>
					</div>
					<div class="bottom">
						<a class="newPos"><span class="glyphicon glyphicon-asterisk"></span>&nbsp;Новый компьютер</a><br>

						<table id="mtab" class="table table-striped">
							<thead>
								<tr>
									<th hidden="true" nowrap>п/п</th>
									<th class="col-lg-1">ID</th>
									<th class="col-lg-1" title="Модель">Модель</th>
									<th class="col-lg-1" title="Инвертарный номер компьютера">Инв.№ комп.</th>
									<th class="col-lg-2" title="Бухгалтерское название">Бухг. назв.</th>
									<th class="col-lg-2" title="Доменное имя">Доменное имя</th>
									<th class="col-lg-1" title="Материнская плата">Мат. плата</th>
									<th class="col-lg-1" title="Процессор">Процессор</th>
									<th class="col-lg-1" title="Память">Память</th>
									<th class="col-lg-1" title="Винчестер">Винчестер</th>
									<th class="col-lg-1">Операция</th>

								</tr>
							</head>
							<tbody>
	
								<tr id="emptyTr" hidden="true">
										<td class="myIndex" hidden="true"></td>
										<td class="idComputer"></td>
										<td class="workplaceCount" hidden="true"></td>
 										<td class="idTypeComputer"></td>
 										<td class="invNumberComputer"></td>
										<td class="buhName"></td>
										<td class="domainName"></td>

										<td><a class="editPos"><span class="glyphicon glyphicon-pencil"></span></a>&nbsp;
											<a class="deletePos"><span class="glyphicon glyphicon-trash"></span></a></td>
								</tr>
									
								<c:forEach items="${computers}" var="computer" varStatus="st">

									<tr id="id${computer.idComputer}">
										<td class="myIndex" hidden="true">${st.getIndex()+1}</td>
										<td class="idComputer">${computer.idComputer}</td>
										<td class="workplaceCount" hidden="true">${computer.workplace.size()}</td>
 										<td class="typeComputerDescription">${computer.typeComputer.description}</td>
 										<td class="invNumberComputer">${computer.invNumber}</td>
										<td class="buhName">${computer.buhName}</td>
										<td class="domainName">${computer.domainName}</td>
										<td class="idMother" hidden="true">${computer.mother.idMother}</td>
										<td class="displayNameMother">${computer.mother.combineDisplayName()}</td>
										<td class="idProcessor" hidden="true">${computer.processor.idProcessor}</td>
										<td class="displayNameProcessor">${computer.processor.combineDisplayName()}</td>
										<%-- <td class="idRam" hidden="true">${computer.ram.idRam}</td> --%>
										<%-- <td class="displayNameRam">${computer.ram.combineDisplayName()}</td> --%>
										<td class="rams">
											<ul>
												<c:forEach items="${computer.rams}" var="ram" varStatus="st1">
												<li>
													<span class="idRam" hidden="true">${ram.idRam}</span>
													<span  class="displayNameRam">${ram.combineDisplayName()}</span>
												</li>
												</c:forEach>
											</ul>
										</td>
										<td class="hdds">
											<ul>
												<c:forEach items="${computer.hdds}" var="hdd" varStatus="st1">
												<li>
													<span class="idHdd" hidden="true">${hdd.idHdd}</span>
													<span  class="displayNameHdd">${hdd.combineDisplayName()}</span>
												</li>
												</c:forEach>
											</ul>
										</td>
										
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

<div id="editDialog" title="Редактирование компьютера" class="dialogWindow" hidden=true>
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

<div id="newDialog" title="Новый компьютер" class="dialogWindow" hidden=true>
	<table>
		<tr><td>Тип</td><td>
			<select id="idTypeComputers" style="width:100%">
				<option value="">Select one...</option>
				<c:forEach items="${typeComputers}" var="tc" varStatus="st">
					<option value="${tc.idTypeComputer}">${tc.description}</option>
				</c:forEach>
			</select>
		</td></tr>

			<tr><td>Инв.№ комп.</td><td><input type="text" id="invNumberComputer" name="invNumberComputer"></td></tr>
			<tr><td>Буг. назв.</td><td><input type="text" id="buhName" name="buhName"></td></tr>
			<tr><td>Доменное имя</td><td><input type="text" id="domainName" name="domainName"></td></tr>
 			<tr><td>Мат. плата</td><td>
 					<select id="idTypeComputer" style="width:100%">
						<option value="">Select one...</option>
						<c:forEach items="${FreeMothers}" var="fm" varStatus="st">
							<option value="${fm.idMother}">${fm.combineDisplayName()}</option>
						</c:forEach>
					</select>
				</td></tr>
 			<tr><td>Процессор</td><td>
 					<select id="idProcessor" style="width:100%">
						<option value="">Select one...</option>
						<c:forEach items="${FreeProcessors}" var="fp" varStatus="st">
							<option value="${fp.idProcessor}">${fp.combineDisplayName()}</option>
						</c:forEach>
					</select>
				</td></tr>
 			
			<tr><td>Память</td><td><input type="text" id="idRam1" name="idRam1"></td></tr>
			<tr hidden=true><td>Память</td><td><input type="text" id="idRam2" name="idRam2"></td></tr>
			<tr hidden=true><td>Память</td><td><input type="text" id="idRam3" name="idRam3"></td></tr>
			<tr hidden=true><td>Память</td><td><input type="text" id="idRam4" name="idRam4"></td></tr>
			<tr><td>Винчестер</td><td><input type="text" id="idHdd1" name="idHdd1"></td></tr>
			<tr hidden=true><td>Винчестер</td><td><input type="text" id="idHdd2" name="idHdd2"></td></tr>
			<tr hidden=true><td>Винчестер</td><td><input type="text" id="idHdd3" name="idHdd3"></td></tr>
			<tr hidden=true><td>Винчестер</td><td><input type="text" id="idHdd4" name="idHdd4"></td></tr>
	</table><br>
	<button id="newDialogSave" class="ui-button ui-widget ui-corner-all">Создать</button>
</div>

<!--  -->
<div id="deleteDialog" title="Удаление компьютера" class="dialogWindow" hidden=true>
	<input type="text" id="idTr" hidden="true">
	<input type="text" id="id" hidden="true">
	Вы действительно хотите удалить?<br><br>
	<button  id="deleteDialogOk" class="ui-button ui-widget ui-corner-all">Да</button>
</div>
<%@include file="include/global.jsp"%>
</body>
</html>
