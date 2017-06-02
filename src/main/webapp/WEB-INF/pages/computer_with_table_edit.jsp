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
	<!-- <link href="css/computer_with_table_edit.css" rel="stylesheet" type="text/css"/> -->

	<script src="js/global.js"></script>
	<script src="js/computer_with_table_edit.js"></script>
</head>

<body> 
	<div class="header"><%@include file="include/header.jsp"%>
	</div>
	<div class="wrapper">
		<div class="inner-wrapper">
			<div class="left pane">
				<%@include file="include/left_menu.jsp"%>
			</div>
			<div class="center pane">

				<div class="inner">
					<div class="top">
                        <h4>компьютеры</h4>
					</div>
					<div class="bottom">
						<a class="newPos"><span class="glyphicon glyphicon-plus"></span>&nbsp;Добавить мат. плату</a><br>

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

								<tr id="emptyTr" class="emptyTrClass" hidden="true">
										<td class="myIndex" hidden="true"></td>
										<td class="idComputer"></td>
										<td class="workplaceSize" hidden="true"></td>
 										<td class="idTypeComputer">
										  <select class="form-control">
												<option value="">Select one...</option>
 												<c:forEach items="${typeComputers}" var="typeComputer" varStatus="st">
													<option value="${typeComputer.idTypeComputer}">
															${typeComputer.description}
													</option>
												</c:forEach>
											</select>
										</td>
										<td class="invNumberComputer"></td>
										<td class="buhName"></td>
										<td class="domainName"></td>
										<td><a class="okPos"><span class="glyphicon glyphicon-ok"></span></a>
											<a class="deletePos" hidden="true"><span class="glyphicon glyphicon-trash"></span></a>
										</td>
								</tr>
									
								<c:forEach items="${computers}" var="computer" varStatus="st">

									<tr id="id${computer.idComputer}">
										<td class="myIndex" hidden="true">${st.getIndex()+1}</td>
										<td class="idComputer">${computer.idComputer}</td>
										<td class="workplaceSize" hidden="true">${computer.workplace.size()}</td>
 										<td class="idTypeComputer">
 											<select class="form-control" >

											  <option value="">Select one...</option>
												<c:forEach items="${typeComputers}" var="typeComputer" varStatus="st">
													<option value="${typeComputer.idTypeComputer}" 
														${(computer.typeComputer.idTypeComputer == null || computer.typeComputer.idTypeComputer != typeComputer.idTypeComputer) ? "": "selected"} >
															${typeComputer.description}
													</option>
												</c:forEach>
											</select>
										</td>
										
l										<td class="invNumberComputer">${computer.invNumber}</td>
										<td class="buhName">${computer.buhName}</td>
										<td class="domainName">${computer.domainName}</td>
 										<td class="idTypeMother">
 											<%-- <select class="form-control" >
 											
											  <option value="">Select one...</option>
												<c:forEach items="${typeMothers}" var="typeMother" varStatus="st">
													<option value="${typeMother.idTypeMother}" 
														${((computer.noMother() || computer.fetchFirstMother().noTypeMother()) || computer.fetchFirstMother().idTypeMother != typeMother.idTypeMother) ? "": "selected"} >
														${( computer.fetchFirstMother().idTypeMother != typeMother.idTypeMother) ? "": "selected"} >
															${typeMother.producer.shortname}, Model:&nbsp;${typeMother.model},&nbsp;Socket:${typeMother.socket}
													</option>
												</c:forEach>
											</select> --%>
										</td>
										<td><a class="deletePos"><span class="glyphicon glyphicon-trash"></span></a></td>
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

<div id="deleteDialog" title="Удаление компьютера" class="dialogWindow" hidden=true>
	<input type="text" id="idTr" hidden="true">
	<input type="text" id="id" hidden="true">
	Вы действительно хотите удалить?<br><br>
	<button  id="deleteDialogOk" class="ui-button ui-widget ui-corner-all">Да</button>
</div>
<%@include file="include/global.jsp"%>
</body>
</html>
