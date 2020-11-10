<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Not valid</title>
</head>
<body>
<h3>Errors</h3>
<c:forEach items="${violations}" var="violation">
    ${violation.getPropertyPath()} : ${violation.getMessage()}<br />
</c:forEach>
</body>
</html>
