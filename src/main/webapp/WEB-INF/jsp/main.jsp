<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
    <c:when test="${ empty username or empty realname }">
    Login Faile!
    </c:when>
    <c:otherwise>
        Hallow ${realname}!
    </c:otherwise>
</c:choose>