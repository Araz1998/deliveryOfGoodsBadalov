<%@ page import="com.araz.entity.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Araz
  Date: 27.01.2021
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>USER</title>
    <title>Calculate order</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css ">
<%--    <link rel="stylesheet" href="/view/css/calcul.css">--%>
</head>
<body>
<h2>Hello ${user.login}</h2>
<%
    if (session != null) {
        if (session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");
            out.print("Hello, " + user.getLogin() + "  Welcome to ur Profile");
        } else {
            response.sendRedirect("login.html");
        }
    } else {
        response.sendRedirect("login.html");
    }
%>


<a href="logout.jsp">logout</a>

<a href="/">Back to main</a>

<button type="button" class="btn btn-primary btn-lg " onclick="location.href='view/payCab.jsp'">PayCab</button>

<div class="card shadow-lg p-3 mb-5 bg-body rounded">

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
        <th scope="col">Date</th>
        <th scope="col">Status</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach var="order" items="${orderList}">
    <tr>
            <td>${order.id}</td>
            <td>${order.fromCity}</td>
            <td>${order.toCity}</td>
            <td>${order.time.hour} h ${order.time.minute} m</td>
            <td>${order.distance}</td>
            <td>${order.baggageWeight}</td>
            <td>${order.cost}</td>
            <td>${order.date}</td>
            <td>${order.status}</td>
    </tr>
    </c:forEach>
    </tbody>
</table>

<%if(request.getAttribute("message") != null){%>
<br>
<div class="alert alert-danger">
    <span style="color: red">${errMessage}</span>
</div>
<%}%>
</div>
</body>
</html>
