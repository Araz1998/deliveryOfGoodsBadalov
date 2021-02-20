<%@ attribute name="error" type="java.lang.String" required="true" %>
<%@ attribute name="successful" type="java.lang.String" required="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:if test="${not empty error}">
    <div class="alert alert-danger">
        <span >${error}</span>
    </div>
</c:if>
<c:if test="${not empty successful}">
    <div class="alert alert-success">
        <span>${successful}</span>
    </div>
</c:if>

