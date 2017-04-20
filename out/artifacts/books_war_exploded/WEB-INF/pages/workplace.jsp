<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%--
  Created by IntelliJ IDEA.
  User: yasha
  Date: 14.03.2017
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Workplace</title>
    <link href="<c:url value="/css/bootstrap.css" />" rel="stylesheet">
</head>
<body>
<div class ="container">
    <h1>Workplace </h1>

    </br>
    <a href="<c:url value='/wp'/>">MainWorkplace</a>
    <a href="<c:url value='/computer'/>">Computer</a>
    <a href="<c:url value='/user'/>">User</a>
    <a href="<c:url value='/monitor'/>">Monitor</a>
    <a href="<c:url value='/printers'/>">Printer</a>
    <a href="<c:url value='/ups'/>">Ups</a>
    </br>
    <table class="table table-condensed table-striped table-bordered">
        <thead>
        <tr class="success">
            <th>
                id_workplace
            </th>

            <th>
                comp_inv_#
            </th>
            <th>
                comp_buh_name
            </th>
            <th>
                monitor_inv_#
            </th>
            <th>
                monitor_model
            </th>
            <th>
                user_name
            </th>
            <th>
                user_login
            </th>
            <th>
                computer_domain_name
            </th>
            <th>
                processor
            </th>
            <th>
                ram_count
            </th>
            <th>
                ram_capacity
            </th>

            <th>
                hdd_count
            </th>
            <th>
                hdd_capacity
            </th>
            <th>
                os_name
            </th>
            <th>
                description
            </th>
        </thead>
        <%-- <td align="center"><b>Book Name</b></td>
         <td align="center"><b>ISDN</b></td>
         <td align="center"><b>AutorId</b></td>
         <td align="center"><b>Edit</b></td>
         <td align="center"><b>Delete</b></td>--%>
        </tr>
        <c:forEach items="${listWorkplace}" var="workplace">
            <tr>
                <td>${workplace.idWorkplace}</td>
                <td>${workplace.computer.invNumber}</td>
                <td>${workplace.computer.buhName}</td>
                <td>${workplace.monitor.model}</td>
                <td>${workplace.user.name}</td>

            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
