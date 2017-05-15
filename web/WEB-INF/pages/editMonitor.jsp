<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>

<%--
  Created by IntelliJ IDEA.
  User: yasha
  Date: 13.05.2017
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Monitor</title>
    <link href="<c:url value="/css/bootstrap.css" />" rel="stylesheet">
</head>
<body>

<div class ="container">
    <br>
    <br>
    <h1>Редактирование Монитора, введите новые данные</h1>
    <br>
    <br>

    <form  action="/updateMonitor" name="form" &lt;%&ndash;method ="POST"&ndash;%&gt;>
        <div class="form-group">
            <label for="id"> Id Monitor</label>
            <input type="input" name="id" id="id" readonly="readonly" value="${monitor.id}"class="form-control">
        </div>

        <div class="form-group">
            <label for="invNumber"> Інв Номер №</label>
            <input type="input" name="invNumber" id="invNumber" value="${monitor.invNumber}"class="form-control">
        </div>

        <div class="form-group">
            <label for="name"> Буз. назва</label>
            <input type="input" name= "name" id="name" value="${monitor.name}"class="form-control">
        </div>


        <div class="form-group">
            <label for="model"> Модель</label>
            <input type="input" name= "model" id="model" value="${monitor.model}"class="form-control">
        </div>

        <div class="form-group">
            <label for="size"> Размер</label>
            <input type="input" name= "size" id="size" value="${monitor.size}"class="form-control">
        </div>

        <input type="submit"class="btn btn-primary" value="Edit">
    </form>
    <br>
    <br>
    <a  href="<c:url value='/monitor'/>">Назад к списку</a>
</div>
</body>
</html>
