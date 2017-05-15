<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: yasha
  Date: 20.04.2017
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Producer</title>
    <link href="<c:url value="/css/bootstrap.css" />" rel="stylesheet">
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>

    <link href="<c:url value="/css/bootstrap.css" />" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Cuprum&subset=latin' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" type="text/css" href="jq/jquery.confirm/jquery.confirm.css" />

</head>
<body>
<div class ="container" <%--hidden="false"--%>>
    <form name="add" action="/addProducer">
        <div class="form-group">
            <label for="id"> ID</label>
            <input type="input" name="id" id="id" value="${producer.id}"class="form-control">
        </div>

        <div class="form-group">
            <label for="name"> Название</label>
            <input type="input" name="name" id="name" value="${producer.name}"class="form-control">
        </div>
        <input type="submit"class="btn btn-primary" value="Додати">
    </form>
</div>
<div class="container">
    <a href="<c:url value='/wp'/>">Workplace</a>
    <a href="<c:url value='/computer'/>">Computer</a>
    <a href="<c:url value='/user'/>">User</a>
    <a href="<c:url value='/monitor'/>">Monitor</a>
    <a href="<c:url value='/printers'/>">Printer</a>
</div>

<div class="container">
    <table class="table table-condensed table-striped table-bordered">
        <thead>
        <tr class="warning">
            <th>
                id_producer
            </th>

            <th>
                Name
            </th>

            <th nowrap>
               Operation
            </th>
        </tr>
        </thead>
        <c:forEach items="${listProducer}" var="producer">
            <tr>
                <td>${producer.id}</td>
                <td>${producer.name}</td>

                    <%--<td><a href="<c:url value='/edit/${computer.id}'/>">edit</a></td>--%>
                <td><%--<a href="<c:url value='/removeProducer/${producer.id}'/>">delete</a>--%>
                    <form action="/removeProducer/${producer.id}" name="delete${producer.id}" hidden="true" method="post">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                        <input type="submit">
                    </form>
                    <a  href="<c:url value='/editProducer/${producer.id}'/>"><span class="glyphicon glyphicon-pencil"></span></a>&nbsp;
                    <div class="item"> <a id="delete${producer.id}" class="delete"><span  class="glyphicon glyphicon-trash"></span></a></div>

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
