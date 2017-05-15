<%--
  Created by IntelliJ IDEA.
  User: yasha
  Date: 12.05.2017
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EditProcessor</title>
    <link href="<c:url value="/css/bootstrap.css" />" rel="stylesheet">
</head>
<body>
<div class ="container">
    <br>
    <br>
    <h1>Редактирование ИБП, введите новые данные</h1>
    <br>
    <br>

    <form  action="/updateProcessor" name="form" &lt;%&ndash;method ="POST"&ndash;%&gt;>
        <div class="form-group">
            <label for="id"> Id Processor</label>
            <input type="input" name="id" id="id" readonly="readonly" value="${tproc.id}"class="form-control">
        </div>

        <div class="form-group">
            <label for="model"> Model</label>
            <input type="input" name="model" id="model" value="${tproc.model}"class="form-control">
        </div>

        <div class="form-group">
            <label for="socket"> Socket</label>
            <input type="input" name= "socket" id="socket" value="${tproc.socket}"class="form-control">
        </div>

        <input type="submit"class="btn btn-primary" value="Edit">
    </form>
    <br>
    <br>
    <a  href="<c:url value='/processor'/>">Назад к списку</a>
    <%-- <ul>

             <li> Id Printer <input type="input" name="id" readonly="readonly" value="${printer.id}"></li></br>
             <li> Inv Number <input type="input" name = "invNumber"  value="${printer.invNumber}"></li></br>
             <li>Model<input type="input" name = "model" value = "${printer.model}"></li></br>
             <li> Cartridge<input type="input" name = "cartridge" value ="${printer.cartridge}"></li></br>
             <li> </li>
     </ul>
     --%>

</body>
</html>
