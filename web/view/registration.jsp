<%--
  Created by IntelliJ IDEA.
  User: Araz
  Date: 27.01.2021
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <h1 class="h3 mb-3 fw-normal">Registration</h1>
        <div class="form-group row">
            <div class="col-sm-12">
                <input type="text" name="login" class="form-control" placeholder="Login" required/>
            </div>
        </div>
        <div class="form-group row">
            <div class="col-sm-12">
                <input type="password" name="password" class="form-control" placeholder="Password" required/>
            </div>
        </div>
        <div class="form-group row">
            <div class="col-sm-12">
                <input type="email" name="email" class="form-control" placeholder="Email" required/>
            </div>
        </div>
        <button type="submit" class="btn btn-primary btn-lg">Sign in</button>
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
