<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: yasha
  Date: 22.02.2017
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Monitor</title>
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

    <form name="add" action="/addMonitor">

        <div class="form-group">
            <label for="invNumber">Інв Номер №</label>
            <input type="input" name="invNumber" id="invNumber" value="${monitor.invNumber}"class="form-control">
        </div>

        <div class="form-group">
            <label for="name"> Бухгалтерська назва</label>
            <input type="input" name= "name" id="name" value="${monitor.name}"class="form-control">
        </div>

        <div class="form-group">
            <label for="model"> Модель</label>
            <input type="input" name= "model" id="model" value="${monitor.model}" class="form-control">
        </div>

        <div class="form-group">
            <label for="size"> Розмір</label>
            <input type="input" name= "size" id="size" value="${monitor.size}" class="form-control">
        </div>

        <input type="submit"class="btn btn-primary" value="Додати">
    </form>
</div>
<div class="container">
    <a href="<c:url value='/wp'/>">Workplace</a>
    <a href="<c:url value='/computer'/>">Computer</a>
    <a href="<c:url value='/user'/>">User</a>
</div>
<div class="container">
    <table class="table table-condensed table-striped table-bordered">
        <thead>
        <tr class="warning">
            <th>
                id_monitor
            </th>

            <th>
                inv_number
            </th>
            <th>
                name
            </th>
            <th>
                model
            </th>
            <th>
               size
            </th>
            <%-- <th>
                 Edit
             </th>--%>
            <th nowrap>
               Operation
            </th>
        </tr>
        </thead>
        <c:forEach items="${listMonitor}" var="monitor">
            <tr>
                <td>${monitor.id}</td>
                <td>${monitor.invNumber}</td>
                <td>${monitor.name}</td>
                <td>${monitor.model}</td>
                <td>${monitor.size}</td>
                    <%--<td><a href="<c:url value='/edit/${computer.id}'/>">edit</a></td>--%>
                <td><%--<a href="<c:url value='/removemonitor/${monitor.id}'/>">delete</a>--%>
                    <form action="/removeMonitor/${monitor.id}" name="delete${monitor.id}" hidden="true" method="post">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                        <input type="submit">
                    </form>
                        <%--<td><a href="<c:url value='/edit/${computer.id}'/>">edit</a></td>--%>
                        <%-- <td><a href="<c:url value='/removePrinter/${printer.id}'/>">delete</a></td>--%>
                    <a  href="<c:url value='/editMonitor/${monitor.id}'/>"><span class="glyphicon glyphicon-pencil"></span></a>&nbsp;
                    <div class="item"> <a id="delete${monitor.id}" class="delete"><span  class="glyphicon glyphicon-trash"></span></a></div>

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
