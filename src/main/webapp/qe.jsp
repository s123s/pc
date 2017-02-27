<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="scripts/jquery-ui.css">
	<script src="scripts/external/jquery/jquery.js"></script>
	<script src="scripts/jquery-ui.js"></script>
	
<style type="text/css">
#drag 
{
border:1px solid;
padding:15px;
width:140px; 
height:60px; 
}
#sortable 
{ 
list-style-type:none;
margin:0;
padding:0;
width:190px; 
}
#sortable li 
{
margin-bottom:3px;
padding:10px; 
font-size:20px;
height:22px; 
} 
</style>

<script>
	
	$(document).ready(function(){


		   $("#drag").draggable();
		   $("#sortable").sortable();
		   $("#sortable").disableSelection();
		   $("#datepicker").datepicker({ monthNames:
			      ["Январь","Февраль","Март","Апрель","Май","Июнь","Июль","Август",  
			      "Сентябрь","Октябрь","Ноябрь","Декабрь"],
			      dayNamesMin: ["Пн", "Вт", "Ср", "Чт", "Пт", "Сб", "Вс"]});

		});
</script>
</head>
<body>a
	<h1>qe.jsp</h1>
	<input type="text" name="date" id="date">
	
	<p>Вы можете перетаскивать элемент мышкой:</p>
<div id="drag" class="ui-corner-all ui-widget ui-widget-header">Попробуйте перетащить меня</div>
<hr />
<p>Вы можете расставлять пункты списка в желаемом порядке: </p>
<ul id="sortable">
<li class="ui-widget ui-state-default">Пункт списка 1</li>
<li class="ui-widget ui-state-default">Пункт списка 5</li>
<li class="ui-widget ui-state-default">Пункт списка 2</li>
<li class="ui-widget ui-state-default">Пункт списка 4</li>
<li class="ui-widget ui-state-default">Пункт списка 3</li>
</ul>
<hr />
<p>Щелкните в текстовое поле ниже для того, чтобы выбрать дату.</p>
Введите дату: <input id="datepicker" type="text">
</body>
</html>