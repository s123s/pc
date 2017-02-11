<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Books</title>
</head>
<body>

privet!!!!<br/>

<table border="1" width="100%">
    <tr>
        <td align="center"><b>ID</b></td>
        <td align="center"><b>Book Name</b></td>
        <td align="center"><b>ISDN</b></td>
        <td align="center"><b>AutorId</b></td>
        <td align="center"><b>Edit</b></td>
        <td align="center"><b>Delete</b></td>
    </tr>
    <c:forEach items="${listBooks}" var="book">
        <tr>
            <td>${book.id}</td>
            <td>${book.name}</td>
            <td>${book.isdn}</td>
            <td>${book.autor_id}</td>

            <td><a href="<c:url value='/edit/${book.id}'/>">edit</a></td>
            <td><a href="<c:url value='/remove/${book.id}'/>">delete</a></td>
        </tr>
    </c:forEach>

    <form action="/add" name="add" method="get"> <br>
        Name Book <input type="input" name = "name"  value="${book.name}">
        Isdn<input type="input" name = "isdn" value = "${book.isdn}">
        Autor Book<input type="input" name = "autor_id" value ="${book.autor_id}">
        <input type="submit" value="Add"/>
    </form>
</table>
</body>
</html>
