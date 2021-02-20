<%--
  Created by IntelliJ IDEA.
  User: Araz
  Date: 27.01.2021
  Time: 18:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="messages"/>
<html>
<head>
    <title>Login</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css ">
    <link rel="stylesheet" href="/view/css/common.css">
</head>
<body class="text-center">
<div class="form-signin">
<form action="/login" method="post">
    <h1 class="h3 mb-3 fw-normal"><fmt:message key="sign.title"/></h1>
    <div class="form-group row">
        <div class="col-sm-12">
            <input type="text" name="login" class="form-control" placeholder="<fmt:message key="sign.logon"/>" required/>
        </div>
    </div>
    <div class="form-group row">
        <div class="col-sm-12">
            <input type="password" name="password" class="form-control" placeholder="<fmt:message key="sign.password"/>" required/>
        </div>
    </div>
        <button type="submit" class="btn btn-primary btn-lg"><fmt:message key="sign.button"/></button>
        <a href="/registration">Registration</a>

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
