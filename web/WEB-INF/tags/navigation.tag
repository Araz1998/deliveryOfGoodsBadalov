<%@ attribute name="path" required="true" %>

<%@ attribute name="page" type="java.lang.Integer" required="true" %>
<%@ attribute name="pageSize" type="java.lang.Integer" required="true" %>
<%@ attribute name="maxPage" type="java.lang.Integer" required="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav aria-label="Page navigation example">
    <ul class="pagination">
        <c:choose>
            <c:when test="${page == 1}"><li class="page-item"><a class="page-link" >Previous</a></li> </c:when>
            <c:otherwise>
                <li class="page-item"><a class="page-link" href="${path}?pageSize=${pageSize}&page=${page-1}">Previous</a></li>
                <li class="page-item"><a class="page-link" href="${path}?pageSize=${pageSize}&page=${page-1}">${page-1}</a></li>
            </c:otherwise>
        </c:choose>
        <li class="page-item active"><a class="page-link" href="${path}?pageSize=${pageSize}&page=${page}">${page}</a></li>
        <c:choose>
            <c:when test="${page == maxPage}"><li class="page-item"><a class="page-link">Next</a></li></c:when>
            <c:otherwise>
                <li class="page-item"><a class="page-link" href="${path}?pageSize=${pageSize}&page=${page+1}">${page+1}</a></li>
                <li class="page-item"><a class="page-link" href="${path}?pageSize=${pageSize}&page=${page+1}">Next</a></li>
            </c:otherwise>
        </c:choose>
    </ul>
</nav>