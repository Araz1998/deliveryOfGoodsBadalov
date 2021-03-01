<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Araz
  Date: 28.01.2021
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="messages"/>
<html>
<head>
    <title>Calculate order</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css ">
    <link rel="stylesheet" href="/view/css/calcul.css">
</head>
<body>


<div class="card d-block mx-auto shadow p-3 mb-2 bg-body rounded " style="width: 80%;">
    <div class="d-flex bd-highlight">
        <div class="p-2 flex-grow-1 bd-highlight"><h2><fmt:message key="order.title"/></h2></div>
        <div class="p-2 bd-highlight">
            <button class="btn btn-primary" type="button" onclick="location.href='/'"><fmt:message
                    key="admin.button.back"/></button>
        </div>
    </div>
</div>
<div class="tableInfo" id="order">
  <form action="/orders" method="post">

    <table class="table table-hover">
    <thead>
    <tr class="table-info">
        <th scope="col"><fmt:message key="top.table.fromCity"/></th>
        <th scope="col"><fmt:message key="top.table.toCity"/></th>
        <th scope="col"><fmt:message key="top.table.time"/></th>
        <th scope="col"><fmt:message key="top.table.way"/></th>
        <th scope="col"><fmt:message key="top.table.tariff"/></th>
        <th scope="col"><fmt:message key="top.table.price"/></th>
        <th scope="col"><fmt:message key="top.table.date"/></th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${order.fromCity}</td>
        <td>${order.toCity}</td>
        <td>${order.time.hour} h ${order.time.minute} m</td>
        <td>${order.distance}</td>
        <td>${order.baggageWeight}</td>
        <td>${order.cost}</td>
        <td>${order.date}</td>
    </tr>
    </tbody>
</table>
    <button type="submit" class="btn btn-primary btn-lg"><fmt:message key="order.button"/></button>
  </form>
</div>
</body>
</html>
