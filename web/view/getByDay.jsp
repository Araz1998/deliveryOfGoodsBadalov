<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>getBayDay</title>
</head>
<body>
<div class="card-body">

    <h5 class="card-title">Weeks order</h5>
    <h3>List of all orders</h3>
    <div class="col-sm-12">
        <input class="form-control" type="date" name="calendar">
    </div>
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
            <th scope="col">Day</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="order" items="${orderListCurrentWeek}">
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
                <td>${order.date}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
<div class="container d-block mx-auto">
    <util:navigation path="" page="${page}" pageSize="${pageSize}" maxPage="${maxPage}"/>
</div>
</form>
</div>
</body>
</html>
