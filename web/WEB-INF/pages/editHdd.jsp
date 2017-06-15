<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
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
    <title>Edit HDD</title>
    <link href="<c:url value="/css/bootstrap.css" />" rel="stylesheet">
</head>
<body>
<div class ="container">
    <br>
    <br>
    <h1>Редактирование HDD, введите новые данные</h1>
    <br>
    <br>

    <form  action="/updateHdd" name="form" &lt;%&ndash;method ="POST"&ndash;%&gt;>
        <div class="form-group">
            <label for="id"> Id HDD</label>
            <input type="input" name="id" id="id" readonly="readonly" value="${thdd.id}"class="form-control">
        </div>

        <div class="form-group">
            <label for="producer"> Производитель </label>
            <p><select id = "producer" name="producer.id" size="1">
                <option disabled>Выберите производителя</option>
                <c:forEach items="${listProducer}" var="producer">
                    <option value="${producer.id}">${producer.name}</option>
                </c:forEach>
                </select>
            </p>
        </div>

        <div class="form-group">
            <label for="capacity"> Capacity</label>
            <input type="input" name= "capacity" id="capacity" value="${thdd.capacity}" class="form-control">
        </div>

        <input type="submit"class="btn btn-primary" value="Edit">
    </form>
    <br>
    <br>
    <a  href="<c:url value='/hdd'/>">Назад к списку</a>
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
