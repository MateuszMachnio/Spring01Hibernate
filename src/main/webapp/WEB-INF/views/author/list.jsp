<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Author list</title>
</head>
<body>
<table>
    <tr>
        <th>Imię</th>
        <th>Nazwisko</th>
        <th>Edytuj</th>
        <th>Usuń</th>
    </tr>
    <c:forEach items="${authors}" var="author">
        <tr>
            <td>${author.firstName}</td>
            <td>${author.lastName}</td>
            <td><a href="/author/edit/${author.id}">Edit</a></td>
            <td><a href="/author/delete/${author.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table><br />
<a href="<c:url value="/author/form"/>"><button>Dodaj książkę</button></a>
</body>
</html>
