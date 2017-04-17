<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: yasha
  Date: 21.02.2017
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Computer</title>
    <link href="<c:url value="/css/bootstrap.css" />" rel="stylesheet">
</head>
<body>
</br>
</br>

<div class ="container" <%--hidden="false"--%>>
    <form name="add" action="/addComputer">
        <div class="form-group">
            <label for="invNumber"> Інв Номер №</label>
            <input type="input" name="invNumber" id="invNumber" value="${computer.invNumber}"class="form-control">
        </div>

        <div class="form-group">
            <label for="buhName"> Бухг. Назва</label>
            <input type="input" name= "buhName" id="buhName" value="${computer.buhName}"class="form-control">
        </div>

        <div class="form-group">
            <label for="domainName"> Назва в домені</label>
            <input type="input" name= "domainName" id="domainName" value="${computer.domainName}" class="form-control">
        </div>

        <input type="submit"class="btn btn-primary" value="Додати">
        </form>
    </div>

<%--<div class ="container">
    <form name="add" action="/update">
        <div class="form-group">
            <label for="invNumber"> Інв Номер №</label>
            <input type="input" name="invNumber" id="invNumber" value="${computer.invNumber}"class="form-control">
        </div>

        <div class="form-group">
            <label for="buhName"> Бухг. Назва</label>
            <input type="input" name= "buhName" id="buhName" value="${computer.buhName}"class="form-control">
        </div>

        <div class="form-group">
            <label for="domainName"> Назва в домені</label>
            <input type="input" name= "domainName" id="domainName" value="${computer.domainName}" class="form-control">
        </div>

        <input type="submit"class="btn btn-primary" value="Edit">
    </form>
</div>--%>
<div class="container">
    <a href="<c:url value='/wp'/>">Workplace</a>
    <a href="<c:url value='/user'/>">User</a>
    <a href="<c:url value='/monitor'/>">Monitor</a>
    </div>
<div class="container">
<table class="table table-condensed table-striped table-bordered">
    <thead>
    <tr class="warning">
        <th>
            id_computer
        </th>

        <th>
           inv Number
        </th>
        <th>
            buh Name
        </th>
        <th>
            domain Name
        </th>
        <th>
            Motherboard
        </th>
        <th>
            Processor
        </th>
        <th>
            Hdd Model
        </th>
        <th>
            Hdd Capacity
        </th>
        <th>
            Ram Type
        </th>
        <th>
            Ram Capacity
        </th>

       <%-- <th>
            Edit
        </th>--%>
        <th>
            Delete
        </th>
        </tr>
    </thead>
<c:forEach items="${listComputer}" var="computer">
    <tr>
    <td>${computer.id}</td>
    <td>${computer.invNumber}</td>
    <td>${computer.buhName}</td>
    <td>${computer.domainName}</td>
    <td>${computer.tMother.model}</td>
    <td>${computer.tProc.model}</td>
    <td>${computer.thdd.model}</td>
    <td>${computer.thdd.capacity}</td>
    <td>${computer.tram.type}</td>
    <td>${computer.tram.capacity}</td>
   <%--<td><c:forEach items="${computer.tRams}" var="ram">${ram.capacity}</c:forEach></td>--%>
0        <%--<td><a href="<c:url value='/edit/${computer.id}'/>">edit</a></td>--%>
        <td><a href="<c:url value='/remove/${computer.id}'/>">delete</a></td>
    </tr>
</c:forEach>
</table>
        </div>
</body>
</html>
