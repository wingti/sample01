<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<c:choose>
    <c:when test="${ empty username or empty realname }">
    Login Faile!
    </c:when>
    <c:otherwise>
        Hallow ${realname}!
    </c:otherwise>
</c:choose>
</body>
</html>