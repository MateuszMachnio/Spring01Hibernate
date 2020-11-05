<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book form</title>
</head>
<body>
<form:form modelAttribute="book">
    <form:label path="title">Tytuł: </form:label>
    <form:input path="title" /><br />

    <form:label path="rating">Ocena: </form:label>
    <form:input path="rating" /><br />

    <form:label path="description">Opis: </form:label>
    <form:textarea path="description" rows="10" cols="100" /><br />

    <form:label path="publisher">Wydawca: </form:label>
    <form:select path="publisher" items="${publishers}" itemLabel="name" itemValue="id"/><br />

    <form:label path="authors">Autorzy:</form:label>
    <form:select path="authors" multiple="true">
        <form:option value="0" label="--Select option--" />
        <form:options items="${authors}" itemLabel="firstName" itemValue="id" />
    </form:select><br />
    <input type="submit" value="Prześlij">
</form:form>
</body>
</html>
