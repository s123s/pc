<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%--
  Created by IntelliJ IDEA.
  User: yasha
  Date: 13.12.2016
  Time: 0:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EditBook</title>
</head>
<body>
Add or Edit Book
<ul>
    <form  action="/update" name="form" method ="POST">
    <li> Id Book <input type="input" name="id" readonly="readonly" value="${book.id}"></li></br>
    <li> Name Book <input type="input" name = "name"  value="${book.name}"></li></br>
    <li> Isdn<input type="input" name = "isdn" value = "${book.isdn}"></li></br>
    <li> Autor Book<input type="input" name = "autor_id" value ="${book.autor_id}"></li></br>
    <li><input type="submit" value="Edit"/></li>
    </form>
</ul>

</body>
</html>
