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
</head>
<body>
</br>
</br>
<div class ="container">

    <form name="add" action="/addMotherboard">


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
                model
            </th>
            <th>
                socket
            </th>
            <th>
                Delete
            </th>
        </tr>
        </thead>
        <c:forEach items="${listTmother}" var="tmother">
            <tr>
                <td>${tmother.id}</td>
                <td>${tmother.model}</td>
                <td>${tmother.socket}</td>
                    <%--<td><a href="<c:url value='/edit/${computer.id}'/>">edit</a></td>--%>
                <td><a href="<c:url value='/removeMotherboard/${tmother.id}'/>">delete</a></td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
