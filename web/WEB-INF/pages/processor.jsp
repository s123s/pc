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
    <title>Processor Type</title>
    <link href="<c:url value="/css/bootstrap.css" />" rel="stylesheet">
</head>
<body>
</br>
</br>
<div class ="container">

    <form name="add" action="/addProcessor">


        <div class="form-group">
            <label for="model"> Model</label>
            <input type="input" name= "model" id="model" value="${tproc.model}"class="form-control">
        </div>

        <div class="form-group">
            <label for="socket"> Socket</label>
            <input type="input" name= "socket" id="socket" value="${tproc.socket}" class="form-control">
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
        <c:forEach items="${listTproc}" var="tproc">
            <tr>
                <td>${tproc.id}</td>
                <td>${tproc.model}</td>
                <td>${tproc.socket}</td>
               <%--<td><a href="<c:url value='/edit/${computer.id}'/>">edit</a></td>--%>
                <td><a href="<c:url value='/removeProcessor/${tproc.id}'/>">delete</a></td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
