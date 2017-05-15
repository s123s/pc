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
    <title>edit User</title>
    <link href="<c:url value="/css/bootstrap.css" />" rel="stylesheet">
</head>
<body>

<div class ="container">
    <br>
    <br>
    <h1>Редактирование Пользователя, введите новые данные</h1>
    <br>
    <br>

    <form  action="/updateUser" name="form" &lt;%&ndash;method ="POST"&ndash;%&gt;>
        <div class="form-group">
            <label for="id"> Id User</label>
            <input type="input" name="id" id="id" readonly="readonly" value="${user.id}"class="form-control">
        </div>

        <div class="form-group">
            <label for="position"> Посада</label>
            <input type="input" name="position" id="position" value="${user.position}"class="form-control">
        </div>

        <div class="form-group">
            <label for="name"> ПІБ</label>
            <input type="input" name= "name" id="name" value="${user.name}"class="form-control">
        </div>


        <div class="form-group">
            <label for="login"> Логін</label>
            <input type="input" name= "login" id="login" value="${user.login}"class="form-control">
        </div>

        <div class="form-group">
            <label for="mail"> Пошта</label>
            <input type="input" name= "mail" id="mail" value="${user.mail}"class="form-control">
        </div>

        <input type="submit"class="btn btn-primary" value="Edit">
    </form>
    <br>
    <br>
    <a  href="<c:url value='/user'/>">Назад к списку</a>
</div>
</body>
</html>
