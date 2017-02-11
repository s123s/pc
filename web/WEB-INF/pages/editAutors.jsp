<%--
  Created by IntelliJ IDEA.
  User: yasha
  Date: 13.12.2016
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>editAutors</title>
</head>
<body>
EditAutors
<form  action="/updateAutor" name="form" method ="POST">
    <input type="input" hidden="hidden" name="id" value="${autor.id}">
     AutorName <input type="input" name="name"  value="${autor.name}">
    <input type="submit" value="Edit"/>
</form>
</body>
</html>
