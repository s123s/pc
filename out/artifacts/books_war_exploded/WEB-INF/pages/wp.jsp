<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%--
  Created by IntelliJ IDEA.
  User: yasha
  Date: 11.02.2017
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MNT workplace</title>
    <link href="<c:url value="/css/bootstrap.css" />" rel="stylesheet">
</head>
<body>
<div class ="container">
    <h1>MNT computer workplace </h1>

    </br>
    <a href="<c:url value='/workplace'/>">Workplace</a>
    <a href="<c:url value='/computer'/>">Computer</a>
    <a href="<c:url value='/user'/>">User</a>
    <a href="<c:url value='/monitor'/>">Monitor</a>
    <a href="<c:url value='/printers'/>">Printer</a>
    <a href="<c:url value='/ups'/>">Ups</a>
    <a href="<c:url value='/processor'/>">Processor</a>
    <a href="<c:url value='/motherboard'/>">Motherboard</a>
    <a href="<c:url value='/hdd'/>">HDD</a>
    <a href="<c:url value='/ram'/>">RAM</a>
    <a href="<c:url value='/producer'/>">Producer</a>
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
    <c:forEach items="${listWp}" var="wp">
        <tr>
            <td>${wp.idWorkplace}</td>
            <td>${wp.cInvNumber}</td>
            <td>${wp.cBuhName}</td>
            <td>${wp.monInvNumber}</td>
            <td>${wp.monModel}</td>
            <td>${wp.userName}</td>
            <td>${wp.userLogin}</td>
            <td>${wp.cDomainName}</td>
            <td>${wp.processor}</td>
            <td>${wp.ramCount}</td>
            <td>${wp.ramAll}</td>
            <td>${wp.hddCount}</td>
            <td>${wp.hddAll}</td>
            <td>${wp.os}</td>
            <td>${wp.description}</td>


        </tr>
    </c:forEach>
</table>
    </div>
</body>
</html>