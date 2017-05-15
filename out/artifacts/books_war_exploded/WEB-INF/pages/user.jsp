<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>

<%--
  Created by IntelliJ IDEA.
  User: yasha
  Date: 22.02.2017
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
    <link href="<c:url value="/css/bootstrap.css" />" rel="stylesheet">
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>

    <link href="<c:url value="/css/bootstrap.css" />" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Cuprum&subset=latin' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" type="text/css" href="jq/jquery.confirm/jquery.confirm.css" />
</head>
<body>
</br>
</br>
<div class ="container">

    <form name="add" action="/addUser">

        <div class="form-group">
            <label for="position">Посада</label>
            <input type="input" name="position" id="position" value="${user.position}"class="form-control">
        </div>

        <div class="form-group">
            <label for="name"> Бухг. Назва</label>
            <input type="input" name= "name" id="name" value="${user.name}"class="form-control">
        </div>

        <div class="form-group">
            <label for="login"> Назва в домені</label>
            <input type="input" name= "login" id="login" value="${user.login}" class="form-control">
        </div>

        <div class="form-group">
            <label for="mail"> Поштова адреса</label>
            <input type="input" name= "mail" id="mail" value="${user.mail}" class="form-control">
        </div>

        <input type="submit"class="btn btn-primary" value="Додати">
    </form>
</div>
<div class="container">
    <a href="<c:url value='/wp'/>">Workplace</a>
    <a href="<c:url value='/computer'/>">Computer</a>
    <a href="<c:url value='/monitor'/>">Monitor</a>
</div>
<div class="container">
    <table class="table table-condensed table-striped table-bordered">
        <thead>
        <tr class="warning">
            <th>
                id_user
            </th>

            <th>
                Position
            </th>
            <th>
                 Name
            </th>
            <th>
                Login
            </th>
            <th>
               Mail
            </th>
            <%-- <th>
                 Edit
             </th>--%>
            <th nowrap>
               Operation
            </th>
        </tr>
        </thead>
        <c:forEach items="${listUser}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.position}</td>
                <td>${user.name}</td>
                <td>${user.login}</td>
                <td>${user.mail}</td>
                    <%--<td><a href="<c:url value='/edit/${computer.id}'/>">edit</a></td>--%>
                <td nowrap><%--<a href="<c:url value='/removeuser/${user.id}'/>">delete</a>--%>
                    <form action="/removeUser/${user.id}" name="delete${user.id}" hidden="true" method="post">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                        <input type="submit">
                    </form>
                        <%--<td><a href="<c:url value='/edit/${computer.id}'/>">edit</a></td>--%>
                        <%-- <td><a href="<c:url value='/removePrinter/${printer.id}'/>">delete</a></td>--%>
                    <a  href="<c:url value='/editUser/${user.id}'/>"><span class="glyphicon glyphicon-pencil"></span></a>&nbsp;
                    <div class="item"> <a id="delete${user.id}" class="delete"><span  class="glyphicon glyphicon-trash"></span></a></div>

                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js"></script>
<script src="jq/jquery.confirm/jquery.confirm.js"></script>
<script src="jq/js/script.js"></script>
</body>
</html>
