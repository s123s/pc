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
    <title>HDD Type</title>
    <link href="<c:url value="/css/bootstrap.css" />" rel="stylesheet">

    <link href="<c:url value="/css/bootstrap.css" />" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Cuprum&subset=latin' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" type="text/css" href="jq/jquery.confirm/jquery.confirm.css" />
</head>
<body>
</br>
</br>
<div class ="container">

    <form name="add" action="/addHdd">

        <div class="form-group">
            <label for="producer"> Производитель </label>
            <p><select id = "producer" name="producer.id" size="1">
                <option disabled>Выберите производителя</option>
                <c:forEach items="${listProducer}" var="producer">
                    <option>${producer.id}</option>
                </c:forEach>
            </select>
            </p>
        </div>
       <%-- <div class="form-group">
            <label for="model"> Model</label>
            <input type="input" name= "model" id="model" value="${thdd.model}"class="form-control">
        </div>--%>

        <div class="form-group">
            <label for="capacity"> Capacity</label>
            <input type="input" name= "capacity" id="capacity" value="${thdd.capacity}" class="form-control">
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
                Producer
            </th>
            <th>
               capacity
            </th>
            <th>
                Delete
            </th>
        </tr>
        </thead>
        <c:forEach items="${listThdd}" var="thdd">
            <tr>
                <td>${thdd.id}</td>
                <td>${thdd.producer.name}</td>
                <%--<td>${thdd.model}</td>--%>
                <td>${thdd.capacity}</td>
                    <%--<td><a href="<c:url value='/edit/${computer.id}'/>">edit</a></td>--%>
                <td><%--<a href="<c:url value='/removeHdd/${thdd.id}'/>">delete</a>--%>
                    <form action="/removeHdd/${thdd.id}" name="delete${thdd.id}" hidden="true" method="post">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                        <input type="submit">
                    </form>
                        <%--<td><a href="<c:url value='/edit/${computer.id}'/>">edit</a></td>--%>
                        <%-- <td><a href="<c:url value='/removePrinter/${printer.id}'/>">delete</a></td>--%>
                   <%-- <a  href="<c:url value='/editTmother/${tmother.id}'/>"><span class="glyphicon glyphicon-pencil"></span></a>&nbsp;--%>
                    <div class="item"> <a id="delete${thdd.id}" class="delete"><span  class="glyphicon glyphicon-trash"></span></a></div>
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
