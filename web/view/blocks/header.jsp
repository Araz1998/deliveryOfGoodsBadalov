<%--
  Created by IntelliJ IDEA.
  User: Araz
  Date: 28.01.2021
  Time: 18:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags" %>
<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="messages"/>
<html>
<head>
    <meta charset="UTF-8">
    <title>header</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css ">
    <link rel="stylesheet" href="/view/css/header.css">

</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light nav justify-content-end shadow-lg p-3 mb-5 bg-body rounded"
     style="background-color: #e3f2fd;">

    <div class="mr-auto p-2">
        <div class="btn-group-vertical btn-group-sm" aria-label="Basic outlined example">
            <button type="button" class="btn btn-outline-primary" onclick="location.href='language?language=en'">en
            </button>
            <button type="button" class="btn btn-outline-primary" onclick="location.href='language?language=ru'">ru
            </button>
        </div>
    </div>
    <ul class="nav justify-content-end">
        <li class="nav-item">
            <c:choose>
                <c:when test="${user.role == 'ADMIN'}">
                    <a class="h4 nav-link" href="/admin?pageSize=2&page=1"><fmt:message key="main.header.cabinet"/><br></a>
                </c:when>
                <c:otherwise>
                    <a class="h4 nav-link" href="/orders"><fmt:message key="main.header.cabinet"/><br></a>
                </c:otherwise>
            </c:choose>
        </li>
        <li class="nav-item">
            <a class="h4 nav-link" href="#calculator"><fmt:message key="main.header.order"/></a>
        </li>
    </ul>
    <c:choose>
        <c:when test="${empty user}">
            <button class="h4 btn btn-outline-success me-2" type="button" onclick="location.href='/login'">
                <h5><fmt:message
                        key="main.header.sign"/>
                    <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor"
                         class="bi bi-box-arrow-in-right" viewBox="0 0 16 16">
                        <path fill-rule="evenodd"
                              d="M6 3.5a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v9a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-2a.5.5 0 0 0-1 0v2A1.5 1.5 0 0 0 6.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2h-8A1.5 1.5 0 0 0 5 3.5v2a.5.5 0 0 0 1 0v-2z"/>
                        <path fill-rule="evenodd"
                              d="M11.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 1 0-.708.708L10.293 7.5H1.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z"/>
                    </svg>
                </h5>
            </button>
        </c:when>
        <c:otherwise>
            <button class="h4 btn btn-outline-success me-2" type="button" onclick="location.href='/view/logout.jsp'">
                <h5><fmt:message
                        key="main.sign.logout"/>
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-box-arrow-right" viewBox="0 0 16 16">
                    <path fill-rule="evenodd" d="M10 12.5a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v2a.5.5 0 0 0 1 0v-2A1.5 1.5 0 0 0 9.5 2h-8A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-2a.5.5 0 0 0-1 0v2z"/>
                    <path fill-rule="evenodd" d="M15.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 0 0-.708.708L14.293 7.5H5.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z"/>
                </svg>
                </h5>
            </button>
        </c:otherwise>
    </c:choose>
</nav>
</body>
</html>
