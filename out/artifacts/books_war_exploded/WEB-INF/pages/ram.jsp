<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: yasha
  Date: 19.03.2017
  Time: 6:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>RAM Type</title>
    <link href="<c:url value="/css/bootstrap.css" />" rel="stylesheet">

    <link href="<c:url value="/css/bootstrap.css" />" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Cuprum&subset=latin' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" type="text/css" href="jq/jquery.confirm/jquery.confirm.css" />
</head>
<body>
</br>
</br>
<div class ="container">

    <form name="add" action="/addRam">

        <div class="form-group">
            <label for="type"> Type</label>
            <input type="input" name= "type" id="type" value="${tram.type}"class="form-control">
        </div>

        <div class="form-group">
            <label for="capacity"> Capacity</label>
            <input type="input" name= "capacity" id="capacity" value="${tram.capacity}" class="form-control">
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
                id
            </th>

            <th>
               type
            </th>
            <th>
                capacity
            </th>
            <th>
                Delete
            </th>
        </tr>
        </thead>
        <c:forEach items="${listTram}" var="tram">
            <tr>
                <td>${tram.id}</td>
                <td>${tram.type}</td>
                <td>${tram.capacity}</td>
                    <%--<td><a href="<c:url value='/edit/${computer.id}'/>">edit</a></td>--%>
                <td><%--<a href="<c:url value='/removeRam/${tram.id}'/>">delete</a>--%>
                    <form action="/removeRam/${tram.id}" name="delete${tram.id}" hidden="true" method="post">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                        <input type="submit">
                    </form>
                        <%--<td><a href="<c:url value='/edit/${computer.id}'/>">edit</a></td>--%>
                        <%-- <td><a href="<c:url value='/removePrinter/${printer.id}'/>">delete</a></td>--%>
                  <%--  <a  href="<c:url value='/editTmother/${tmother.id}'/>"><span class="glyphicon glyphicon-pencil"></span></a>&nbs--%><%--p;--%>
                    <div class="item"> <a id="delete${tram.id}" class="delete"><span  class="glyphicon glyphicon-trash"></span></a></div>
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
