<%--
  Created by IntelliJ IDEA.
  User: Araz
  Date: 29.01.2021
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>logout</title>
</head>
<body>
<%
    session.invalidate();
    response.sendRedirect("/index.jsp");
%>
</body>
</html>
