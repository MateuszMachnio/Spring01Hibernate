<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book list</title>
</head>
<body>
<table>
    <tr>
        <th>Tytuł</th>
        <th>Ocena</th>
        <th>Opis</th>
        <th>Wydawca</th>
        <th>Edytuj</th>
        <th>Usuń</th>
    </tr>
    <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.title}</td>
            <td>${book.rating}</td>
            <td>${book.description}</td>
            <td>${book.publisher.name}</td>
            <td><a href="/book-bind/edit/${book.id}">Edit</a></td>
            <td><a href="/book-bind/delete/${book.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
