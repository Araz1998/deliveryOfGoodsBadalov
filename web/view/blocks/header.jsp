<%--
  Created by IntelliJ IDEA.
  User: Araz
  Date: 28.01.2021
  Time: 18:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
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
            <a class="h4 nav-link" href="/orders"><fmt:message key="main.header.cabinet"/><br></a>
        </li>
        <li class="nav-item">
            <a class="h4 nav-link" href="#calculator"><fmt:message key="main.header.order"/></a>
        </li>
    </ul>
    <button class="h4 btn btn-outline-success me-2" type="button" onclick="location.href='/login'"><h4><fmt:message
            key="main.header.sign"/></h4></button>
</nav>
</body>
</html>
