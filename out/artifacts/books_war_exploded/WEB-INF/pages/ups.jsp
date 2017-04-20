<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: yasha
  Date: 12.03.2017
  Time: 13:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ups</title>
    <link href="<c:url value="/css/bootstrap.css" />" rel="stylesheet">
</head>
<body>
</br>
</br>

<div class ="container" <%--hidden="false"--%>>
    <form name="add" action="/addUps">
        <div class="form-group">
            <label for="invNumber"> Інв Номер №</label>
            <input type="input" name="invNumber" id="invNumber" value="${ups.invNumber}"class="form-control">
        </div>

        <div class="form-group">
            <label for="model"> Модель</label>
            <input type="input" name= "model" id="model" value="${ups.model}"class="form-control">
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
                id_ups
            </th>

            <th>
                inv Number
            </th>
            <th>
                Model
            </th>

            <%-- <th>
                 Edit
             </th>--%>
            <th>
                Delete
            </th>
        </tr>
        </thead>
        <c:forEach items="${listUps}" var="ups">
            <tr>
                <td>${ups.id}</td>
                <td>${ups.invNumber}</td>
                <td>${ups.model}</td>
                    <%--<td><a href="<c:url value='/edit/${computer.id}'/>">edit</a></td>--%>
                <td><a href="<c:url value='/remove/${ups.id}'/>">delete</a></td>
            </tr>
        </c:forEach>
    </table>
</div>


</body>
</html>

</html>
