<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="my"  uri="/WEB-INF/mytags.tld" %>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="messages"/>
<html>
<head>
    <title>Admin page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css ">
<%--    <link rel="stylesheet" href="/view/css/calcul.css">--%>

</head>
<body>
<h1>Today is <my:Hello/></h1>
<div class="card d-block mx-auto shadow p-3 mb-5 bg-body rounded " style="width: 80%;">
    <div class="d-flex bd-highlight">
        <div class="p-2 flex-grow-1 bd-highlight"><h2><fmt:message key="admin.hello"/></h2></div>
        <div class="p-2 bd-highlight">
            <button class="btn btn-primary" type="button" onclick="location.href='/'"><fmt:message
                    key="admin.button.back"/></button>
        </div>
    </div>
</div>


<div class="card d-block mx-auto shadow-lg p-2 mb-5 bg-body rounded" style="width: 80%;">
<div class="tableInfo">
    <h3><fmt:message key="admin.table.title"/></h3>
    <table class="table table-hover">
        <thead>
        <tr class="table-info">
            <th scope="col"></th>
            <th scope="col"><fmt:message key="admin.table.user"/></th>
            <th scope="col"><fmt:message key="admin.table.from"/></th>
            <th scope="col"><fmt:message key="admin.table.to"/></th>
            <th scope="col"><fmt:message key="admin.table.time"/></th>
            <th scope="col"><fmt:message key="admin.table.way"/></th>
            <th scope="col"><fmt:message key="admin.table.tariff"/></th>
            <th scope="col"><fmt:message key="admin.table.price"/></th>
            <th scope="col"><fmt:message key="admin.table.status"/></th>
            <th scope="col"><fmt:message key="admin.table.action"/></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="order" items="${orderList}">
            <tr>
                <td>${order.id}</td>
                <td>${order.userId}</td>
                <td>${order.fromCity}</td>
                <td>${order.toCity}</td>
                <td>${order.time.hour} h ${order.time.minute} m</td>
                <td>${order.distance}</td>
                <td>${order.baggageWeight}</td>
                <td>${order.cost}</td>
                <td><util:status status="${order.status}"></util:status></td>
                <td>
                    <button type="button" class="btn btn-success"
                            onclick="location.href='/admit?id=<c:out value="${order.id}"/>'"><fmt:message key="action.admit"/>
                    </button>
                    <button type="button" class="btn btn-danger"
                            onclick="location.href='/delete?id=<c:out value="${order.id}"/>'"><fmt:message key="action.delete"/>
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


<div class="card d-block mx-auto shadow-lg p-3 mb-5 bg-body rounded" style="width: 80%;">
    <h3><fmt:message key="admin.report.title"/></h3>
    <form action="/admin/day-report" method="get">
        <div class="form-group row">
            <div class="col-sm-12">
                <input class="form-control" type="date" name="calendar">
            </div>
        </div>
        <div>
            <button type="submit" class="btn btn-primary btn-lg btn-lg d-block mx-auto "><fmt:message key="admin.report.button"/></button>
        </div>
    </form>
</div>

</body>
</html>
