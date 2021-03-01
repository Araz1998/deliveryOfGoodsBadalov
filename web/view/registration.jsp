<%--
  Created by IntelliJ IDEA.
  User: Araz
  Date: 27.01.2021
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="messages"/>
<html>
<head>
    <title>Registration</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css ">
    <link rel="stylesheet" href="/view/css/common.css">
</head>
<body class="text-center">
<div class="form-signin">
    <form action="/registration" method="post">
        <h1 class="h3 mb-3 fw-normal"><fmt:message key="registration.title"/> </h1>
        <div class="form-group row">
            <div class="col-sm-12">
                <input type="text" name="login" class="form-control" placeholder="<fmt:message key="registration.login"/>" required/>
            </div>
        </div>
        <div class="form-group row">
            <div class="col-sm-12">
                <input type="password" name="password" class="form-control" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" placeholder="<fmt:message key="registration.password"/>" required/>
            </div>
        </div>
        <div class="form-group row">
            <div class="col-sm-12">
                <input type="email" name="email" class="form-control" placeholder="<fmt:message key="registration.email"/>" required/>
            </div>
        </div>
        <button type="submit" class="btn btn-primary btn-lg"><fmt:message key="registration.sign-up"/></button>
    </form>
    <%if(request.getAttribute("errMessage") != null){%>
    <br>
    <div class="alert alert-danger">
        <span style="color: red">${errMessage}</span>
    </div>
    <%}%>
</div>
</body>
</html>
