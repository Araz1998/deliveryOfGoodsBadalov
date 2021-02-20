<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags" %>

<%--
  Created by IntelliJ IDEA.
  User: Araz
  Date: 15.02.2021
  Time: 3:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Current week order</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css ">
</head>
<body>
<div class="card shadow-lg p-3 mb-5 bg-body rounded">
    <button class="btn btn-primary" type="button" onclick="location.href='/admin?pageSize=2&page=1'">Back to main</button>
</div>

<div class="card d-block mx-auto shadow-lg p-3 mb-5 bg-body rounded" style="width: 80%;">
        <div>
            <h5 class="card-title">Report for date ${date}</h5>
        </div>
    <table class="table table-bordered border-primary">
        <thead>
        <tr class="table-info">
            <th scope="col">New </th>
            <th scope="col">Confirmed</th>
            <th scope="col">Paid</th>
            <th scope="col">Avg road</th>
        </tr>
        </thead>
<tbody>
    <tr>
    <td>${list[0]}</td>
    <td>${list[1]}</td>
    <td>${list[2]}</td>
    <td>${avg}</td>
    </tr>
</tbody>
    </table>
</div>

<form action="/pdf" method="get">
        <button type="submit" class="btn btn-primary btn-lg btn-lg d-block mx-auto ">Calculate</button>
</form>
</body>
</html>
