<%@ attribute name="User" type="com.araz.entity.User" required="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<c:if test="${empty User}">
    <button class="h4 btn btn-outline-success me-2" type="button" onclick="location.href='/login'"><h4><fmt:message
            key="main.header.sign"/></h4></button>
</c:if>
<c:choose>
    <c:when test="${empty User}">
        <button class="h4 btn btn-outline-success me-2" type="button" onclick="location.href='/login'"><h4><fmt:message
                key="main.header.sign"/></h4></button>
    </c:when>
    <c:otherwise>
        <button class="h4 btn btn-outline-success me-2" type="button" onclick="location.href='/view/logout.jsp'"><h4><fmt:message
                key="sign.logout"/></h4></button>
    </c:otherwise>
</c:choose>