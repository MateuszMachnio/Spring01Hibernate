<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit book</title>
</head>
<body>
<form:form modelAttribute="book" action="/book-bind/edit" method="post">

    <form:hidden path="id" />
    <form:label path="title">Tytuł: </form:label>
    <form:input path="title" /><br />

    <form:label path="rating">Ocena: </form:label>
    <form:input path="rating" /><br />

    <form:label path="description">Opis: </form:label>
    <form:textarea path="description" rows="10" cols="100" /><br />

    <form:label path="publisher">Wydawca: </form:label>
    <form:select path="publisher" items="${publishers}" itemLabel="name" itemValue="id"/><br />
    <input type="submit" value="Edytuj">
</form:form>
</body>
</html>
