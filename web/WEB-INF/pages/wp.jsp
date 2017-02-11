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
</head>
<body>
<table border="1" width="100%">
    <tr>
        <td align="center"><b>ID</b></td>
        <%-- <td align="center"><b>Book Name</b></td>
         <td align="center"><b>ISDN</b></td>
         <td align="center"><b>AutorId</b></td>
         <td align="center"><b>Edit</b></td>
         <td align="center"><b>Delete</b></td>--%>
    </tr>
    <c:forEach items="${listWp}" var="wp">
        <tr>
            <td>${wp.userName}</td>
                <%--<td>${book.name}</td>
                <td>${book.isdn}</td>
                <td>${book.autor_id}</td>
        --%><%--
        <td><a href="<c:url value='/edit/${book.id}'/>">edit</a></td>
        <td><a href="<c:url value='/remove/${book.id}'/>">delete</a></td>--%>
        </tr>
    </c:forEach>
</table>
</body>
</html>