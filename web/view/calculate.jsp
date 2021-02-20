<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Araz
  Date: 28.01.2021
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculate order</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css ">
    <link rel="stylesheet" href="/view/css/calcul.css">
</head>
<body>
<div class="tableInfo">
    <h3>Your order</h3>
    <h3>${user.login} ID ${user.id}</h3>
  <form action="/orders" method="post">

    <table class="table table-hover">
    <thead>
    <tr class="table-info">
        <th scope="col"></th>
        <th scope="col">From City</th>
        <th scope="col">To city</th>
        <th scope="col">Time</th>
        <th scope="col">Way</th>
        <th scope="col">Baggage weight</th>
        <th scope="col">Price</th>

    </tr>
    </thead>
    <tbody>
    <tr>
        <th scope="row">1</th>
        <td>${order.fromCity}</td>
        <td>${order.toCity}</td>
        <td>${order.time.hour} h ${order.time.minute} m</td>
        <td>${order.distance}</td>
        <td>${order.baggageWeight}</td>
        <td>${order.cost}</td>
    </tr>
    </tbody>
</table>
    <button type="submit" class="btn btn-primary btn-lg">Make order</button>
  </form>
</div>

<a href="<c:url value='/' />">Logout</a>
</body>
</html>
