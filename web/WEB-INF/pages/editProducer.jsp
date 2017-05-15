<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: yasha
  Date: 12.05.2017
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EditProducer</title>
    <link href="<c:url value="/css/bootstrap.css" />" rel="stylesheet">
</head>
<body>

<div class ="container">
    <br>
    <br>
    <h1>Редактирование Производителя, введите новые данные</h1>
    <br>
    <br>

    <form  action="/updateProducer" name="form" &lt;%&ndash;method ="POST"&ndash;%&gt;>
        <div class="form-group">
            <label for="id"> Id Producer</label>
            <input type="input" name="id" id="id" readonly="readonly" value="${producer.id}"class="form-control">
        </div>

        <div class="form-group">
            <label for="name"> Производитель</label>
            <input type="input" name="name" id="name" value="${producer.name}"class="form-control">
        </div>


        <input type="submit"class="btn btn-primary" value="Edit">
    </form>
    <br>
    <br>
    <a  href="<c:url value='/producer'/>">Назад к списку</a>
</body>
</html>
