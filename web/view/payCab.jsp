<%--
  Created by IntelliJ IDEA.
  User: Araz
  Date: 11.02.2021
  Time: 1:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="messages"/>

<html>
<head>
    <title>Pay cabinet</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css ">
</head>
<body>
<form action="/codeCheck" method="post">
    <div class="card text-center d-block mx-auto shadow-lg p-3 mb-5 bg-body rounded" style="width: 25rem;">
        <a href="/orders"><fmt:message key="pay.back"/> </a>

        <div class="card-header">
            <fmt:message key="pay.title"/>
        </div>
        <div class="card-body">
            <div class="form-floating mb-3">
                <input class="form-control" name="code" placeholder="<fmt:message key="pay.code"/>">
            </div>
            <div class="form-floating mb-3">
                <input class="form-control" name="orderId" placeholder="<fmt:message key="pay.order.id"/>">
            </div>
            <button type="submit" class="btn btn-primary btn-lg d-block mx-auto"><fmt:message key="pay.button"/></button>
        </div>
        <util:statusPay error="${errorMessage}" successful="${successful}"/>
    </div>
</form>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>
