<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: yasha
  Date: 19.03.2017
  Time: 6:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Motherboard Type</title>
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

    <form name="add" action="/addMotherboard">

        <div class="form-group">
            <label for="producer"> Производитель </label>
            <p><select id = "producer" name="producer.id" size="1">
                <option disabled>Выберите производителя</option>
                <c:forEach items="${listProducer}" var="producer">
                    <option value="${producer.id}">${producer.name}</option>
                </c:forEach>
            </select>
            </p>
        </div><%--  <div class="form-group">
               <label for="producer.id"> Producer</label>
               <input type="input" name="producer.id" id="producer.id" value="${tmother.producer.id}"class="form-control">
               <input type="input" name="producer.shortname" id="producer.shortname" value="Samsung"class="form-control">
           </div>--%>


        <div class="form-group">
            <label for="model"> Model</label>
            <input type="input" name= "model" id="model" value="${tmother.model}"class="form-control">
        </div>

        <div class="form-group">
            <label for="socket"> Socket</label>
            <input type="input" name= "socket" id="socket" value="${tmother.socket}" class="form-control">
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
                model
            </th>
            <th>
                socket
            </th>
            <th nowrap>
               Operation
            </th>
        </tr>
        </thead>
        <c:forEach items="${listTmother}" var="tmother">
            <tr>
                <td>${tmother.id}</td>
                <td>${tmother.producer.name}</td>
                <td>${tmother.model}</td>
                <td>${tmother.socket}</td>
                    <%--<td><a href="<c:url value='/edit/${computer.id}'/>">edit</a></td>--%>
                <td><%--<a href="<c:url value='/removeMotherboard/${tmother.id}'/>">delete</a>--%><
                    <form action="/removeMotherboard/${tmother.id}" name="delete${tmother.id}" hidden="true" method="post">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                        <input type="submit">
                    </form>
                        <%--<td><a href="<c:url value='/edit/${computer.id}'/>">edit</a></td>--%>
                        <%-- <td><a href="<c:url value='/removePrinter/${printer.id}'/>">delete</a></td>--%>
                    <a  href="<c:url value='/editMother/${tmother.id}'/>"><span class="glyphicon glyphicon-pencil"></span></a>&nbsp;
                    <div class="item"> <a id="delete${tmother.id}" class="delete"><span  class="glyphicon glyphicon-trash"></span></a></div>

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
