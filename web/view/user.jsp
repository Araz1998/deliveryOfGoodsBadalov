<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: Araz
  Date: 27.01.2021
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags" %>
<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="messages"/>
<html>
<head>
    <title>USER</title>
    <title>Calculate order</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css ">
<%--    <link rel="stylesheet" href="/view/css/calcul.css">--%>
</head>
<body>

<div class="shadow-lg p-3 mb-5 bg-body rounded">
    <div class="d-flex bd-highlight">
        <div class="p-2 flex-grow-1 bd-highlight"><h2><fmt:message key="cabinet.header.title"/>, ${user.login}</h2></div>
        <div class="p-2 bd-highlight">
            <button type="button" class="btn btn-primary" onclick="location.href='/'"><fmt:message key="cabinet.header.back"/> </button>
        </div>
        <div class="p-2 bd-highlight">
            <button type="button" class="btn btn-success" onclick="location.href='view/payCab.jsp'"><fmt:message key="cabinet.header.pay"/> </button>
        </div>
    </div>
</div>


<div class="card shadow-lg p-3 mb-5 bg-body rounded">

<table class="table table-hover">
    <thead>
    <tr class="table-info">
        <th scope="col"></th>
        <th scope="col"><fmt:message key="cabinet.table.from"/> </th>
        <th scope="col"><fmt:message key="cabinet.table.to"/></th>
        <th scope="col"><fmt:message key="cabinet.table.time"/></th>
        <th scope="col"><fmt:message key="cabinet.table.way"/></th>
        <th scope="col"><fmt:message key="cabinet.table.tariff"/></th>
        <th scope="col"><fmt:message key="cabinet.table.price"/></th>
        <th scope="col"><fmt:message key="cabinet.table.date"/></th>
        <th scope="col"><fmt:message key="cabinet.table.status"/></th>

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
            <td><util:status status="${order.status}"></util:status></td>
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
