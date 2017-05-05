<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>

<%--
  Created by IntelliJ IDEA.
  User: yasha
  Date: 05.05.2017
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EditPrinter</title>

    <link href="<c:url value="/css/bootstrap.css" />" rel="stylesheet">

</head>
<body>

<div class ="container">
    <br>
    <br>
    <h1>Редактирование принтера, введите новые данные</h1>
    <br>
    <br>

    <form  action="/updatePrinter" name="form" &lt;%&ndash;method ="POST"&ndash;%&gt;>
    <div class="form-group">
        <label for="id"> Id Принтера</label>
        <input type="input" name="id" id="id" readonly="readonly" value="${printer.id}"class="form-control">
    </div>

    <div class="form-group">
        <label for="invNumber"> Інв Номер №</label>
        <input type="input" name="invNumber" id="invNumber" value="${printer.invNumber}"class="form-control">
    </div>

    <div class="form-group">
        <label for="model"> Модель</label>
        <input type="input" name= "model" id="model" value="${printer.model}"class="form-control">
    </div>

    <div class="form-group">
        <label for="cartridge"> Тип картриджу</label>
        <input type="input" name= "cartridge" id="cartridge" value="${printer.cartridge}" class="form-control">
    </div>
    <input type="submit"class="btn btn-primary" value="Edit">
    </form>
    <br>
    <br>
    <a  href="<c:url value='/printers'/>">Назад к списку</a>
   <%-- <ul>

            <li> Id Printer <input type="input" name="id" readonly="readonly" value="${printer.id}"></li></br>
            <li> Inv Number <input type="input" name = "invNumber"  value="${printer.invNumber}"></li></br>
            <li>Model<input type="input" name = "model" value = "${printer.model}"></li></br>
            <li> Cartridge<input type="input" name = "cartridge" value ="${printer.cartridge}"></li></br>
            <li> </li>
    </ul>
    --%>

</div>
</body>
</html>
