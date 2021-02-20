<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>Admin page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css ">
<%--    <link rel="stylesheet" href="/view/css/calcul.css">--%>

</head>
<body>

<div class="buttonMain">
    <h2>Hello admin</h2>
    <button class="btn btn-primary" type="button" onclick="location.href='/'">Back to main</button>
</div>
<div class="card d-block mx-auto shadow-lg p-3 mb-5 bg-body rounded" style="width: 80%;">
<div class="tableInfo">
    <h3>List of all orders</h3>
    <table class="table table-hover">
        <thead>
        <tr class="table-info">
            <th scope="col"></th>
            <th scope="col">User</th>
            <th scope="col">From City</th>
            <th scope="col">To city</th>
            <th scope="col">Time</th>
            <th scope="col">Way</th>
            <th scope="col">Baggage</th>
            <th scope="col">Price</th>
            <th scope="col">Status</th>
            <th scope="col">Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="order" items="${orderList}">
            <tr>
                <td>${order.userId}</td>
                <td>${order.id}</td>
                <td>${order.fromCity}</td>
                <td>${order.toCity}</td>
                <td>${order.time.hour} h ${order.time.minute} m</td>
                <td>${order.distance}</td>
                <td>${order.baggageWeight}</td>
                <td>${order.cost}</td>
                <td><util:status status="${order.status}"></util:status></td>
                <td>
                    <button type="button" class="btn btn-success"
                            onclick="location.href='/admit?id=<c:out value="${order.id}"/>'">Admit
                    </button>
                    <button type="button" class="btn btn-danger"
                            onclick="location.href='/delete?id=<c:out value="${order.id}"/>'">Delete
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
    <div class="container d-block mx-auto">
        <util:navigation path="admin" page="${page}" pageSize="${pageSize}" maxPage="${maxPage}"/>
    </div>

</div>


<%--TEST--%>
<div class="card d-block mx-auto shadow-lg p-3 mb-5 bg-body rounded" style="width: 80%;">
    <h3>Get report for day</h3>
    <form action="/day-report" method="get">
        <div class="form-group row">
            <div class="col-sm-12">
                <input class="form-control" type="date" name="calendar">
            </div>
        </div>
        <div>
            <button type="submit" class="btn btn-primary btn-lg btn-lg d-block mx-auto ">Calculate</button>
        </div>
    </form>
</div>

<a href="/">Back</a>
</body>
</html>
