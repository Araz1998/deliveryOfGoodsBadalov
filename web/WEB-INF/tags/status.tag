<%@ attribute name="status" type="java.lang.String" required="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="messages"/>

<c:choose>
    <c:when test="${status == 'new'}">
        <button type="button" class="rounded-pill btn btn-primary"><fmt:message key="status.new"/></button>
    </c:when>
    <c:when test="${status == 'confirmed'}">
        <button type="button" class="rounded-pill btn btn-warning"><fmt:message key="status.confirmed"/></button>
    </c:when>
    <c:when test="${status == 'paid'}">
        <button type="button" class="rounded-pill btn btn-success"><fmt:message key="status.paid"/></button>
    </c:when>
</c:choose>