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
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="messages"/>
<html>
<head>
    <title>Selected day</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css ">
</head>
<body>
<div class="card d-block mx-auto shadow p-3 mb-5 bg-body rounded " style="width: 80%;">
    <div class="d-flex bd-highlight">
        <div class="p-2 flex-grow-1 bd-highlight">
            <button class="btn btn-primary" type="button" onclick="location.href='/admin?pageSize=2&page=1'">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-reply" viewBox="0 0 16 16">
                    <path d="M6.598 5.013a.144.144 0 0 1 .202.134V6.3a.5.5 0 0 0 .5.5c.667 0 2.013.005 3.3.822.984.624 1.99 1.76 2.595 3.876-1.02-.983-2.185-1.516-3.205-1.799a8.74 8.74 0 0 0-1.921-.306 7.404 7.404 0 0 0-.798.008h-.013l-.005.001h-.001L7.3 9.9l-.05-.498a.5.5 0 0 0-.45.498v1.153c0 .108-.11.176-.202.134L2.614 8.254a.503.503 0 0 0-.042-.028.147.147 0 0 1 0-.252.499.499 0 0 0 .042-.028l3.984-2.933zM7.8 10.386c.068 0 .143.003.223.006.434.02 1.034.086 1.7.271 1.326.368 2.896 1.202 3.94 3.08a.5.5 0 0 0 .933-.305c-.464-3.71-1.886-5.662-3.46-6.66-1.245-.79-2.527-.942-3.336-.971v-.66a1.144 1.144 0 0 0-1.767-.96l-3.994 2.94a1.147 1.147 0 0 0 0 1.946l3.994 2.94a1.144 1.144 0 0 0 1.767-.96v-.667z"/>
                </svg>
            </button>
        </div>
    </div>
</div>


<div class="card d-block mx-auto shadow-lg p-3 mb-5 bg-body rounded" style="width: 80%;">
    <div>
        <h5 class="card-title"><fmt:message key="report.title"/> ${list[0]}</h5>
    </div>
    <table class="table table-bordered border-primary">
        <thead>
        <tr class="table-info">
            <th scope="col"><fmt:message key="report.table.new"/></th>
            <th scope="col"><fmt:message key="report.table.confirmed"/></th>
            <th scope="col"><fmt:message key="report.table.paid"/></th>
            <th scope="col"><fmt:message key="report.table.road"/></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${list[1]}</td>
            <td>${list[2]}</td>
            <td>${list[3]}</td>
            <td>${list[4]}</td>
        </tr>
        </tbody>
    </table>
</div>

<form action="/pdfGenerate" method="get">
    <c:choose>
        <c:when test="${empty list[0]}">
            <button type="submit" class="btn btn-primary btn-lg btn-lg d-block mx-auto " disabled><fmt:message key="report.pdf.button"/></button>
        </c:when>
        <c:otherwise>
            <button type="submit" class="btn btn-outline-danger btn-lg btn-lg d-block mx-auto ">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-download" viewBox="0 0 16 16">
                    <path d="M.5 9.9a.5.5 0 0 1 .5.5v2.5a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1v-2.5a.5.5 0 0 1 1 0v2.5a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2v-2.5a.5.5 0 0 1 .5-.5z"/>
                    <path d="M7.646 11.854a.5.5 0 0 0 .708 0l3-3a.5.5 0 0 0-.708-.708L8.5 10.293V1.5a.5.5 0 0 0-1 0v8.793L5.354 8.146a.5.5 0 1 0-.708.708l3 3z"/>
                </svg> <fmt:message key="report.pdf.button"/></button>
        </c:otherwise>
    </c:choose>
</form>
</body>
</html>
