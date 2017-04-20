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
                name
            </th>
                        <%-- <th>
                 Edit
             </th>--%>
            <th>
                Delete
            </th>
        </tr>
        </thead>
        <c:forEach items="${listProducer}" var="producer">
            <tr>
                <td>${producer.id}</td>
                <td>${producer.name}</td>

                    <%--<td><a href="<c:url value='/edit/${computer.id}'/>">edit</a></td>--%>
                <td><a href="<c:url value='/removeProducer/${producer.id}'/>">delete</a></td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
