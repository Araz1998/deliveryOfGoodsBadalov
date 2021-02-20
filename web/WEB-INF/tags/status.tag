<%@ attribute name="status" type="java.lang.String" required="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
    <c:when test="${status == 'new'}">
        <button type="button" class="rounded-pill btn btn-primary">${status}</button>
    </c:when>
    <c:when test="${status == 'confirmed'}">
        <button type="button" class="rounded-pill btn btn-warning">${status}</button>
    </c:when>
    <c:when test="${status == 'paid'}">
        <button type="button" class="rounded-pill btn btn-success">${status}</button>
    </c:when>
</c:choose>