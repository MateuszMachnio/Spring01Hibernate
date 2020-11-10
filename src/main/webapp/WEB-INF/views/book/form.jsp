<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book form</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<form:form modelAttribute="book">
    <form:label path="title">Tytuł: </form:label>
    <form:input path="title" />
    <form:errors path="title" cssClass="error" />
    <br />

    <form:label path="rating">Ocena: </form:label>
    <form:input path="rating" />
    <form:errors path="rating" cssClass="error" />
    <br />

    <form:label path="description">Opis: </form:label>
    <form:textarea path="description" rows="10" cols="100" />
    <form:errors path="description" cssClass="error" />
    <br />

    <form:label path="pages">Strony: </form:label>
    <form:input path="pages" />
    <form:errors path="pages" cssClass="error" />
    <br />

    <form:label path="publisher">Wydawca: </form:label>
    <form:select path="publisher" items="${publishers}" itemLabel="name" itemValue="id"/>
    <form:errors path="publisher" cssClass="error" />
    <br />

    <form:label path="authors">Autorzy:</form:label>
    <form:select path="authors" multiple="true">
        <form:option value="0" label="--Select option--" />
        <form:options items="${authors}" itemLabel="fullName" itemValue="id" />
    </form:select>
    <form:errors path="authors" cssClass="error" />
    <br />

    <form:label path="category">Kategoria:</form:label>
    <form:select path="category">
        <form:option value="0" label="--Select option--" />
        <form:options items="${categories}" itemLabel="name" itemValue="id" />
    </form:select>
    <form:errors path="category" cssClass="error" />
    <br />
    <input type="submit" value="Prześlij">
</form:form>
</body>
</html>
