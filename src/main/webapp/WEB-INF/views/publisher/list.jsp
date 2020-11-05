<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Publisher list</title>
</head>
<body>
<table>
    <tr>
        <th>Imię</th>
        <th>Edytuj</th>
        <th>Usuń</th>
    </tr>
    <c:forEach items="${publishers}" var="publisher">
        <tr>
            <td>${publisher.name}</td>
            <td><a href="/publisher/edit/${publisher.id}">Edit</a></td>
            <td><a href="/publisher/delete/${publisher.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table><br />
<a href="<c:url value="/publisher/form"/>"><button>Dodaj wydawcę</button></a>
</body>
</html>
