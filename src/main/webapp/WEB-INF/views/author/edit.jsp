<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit author</title>
</head>
<body>
<form:form modelAttribute="author" method="post" action="/author/edit">
    <form:hidden path="id" />
    <form:label path="firstName">First name:</form:label>
    <form:input path="firstName" /><br />

    <form:label path="lastName">Last name:</form:label>
    <form:input path="lastName" /><br />

    <form:label path="books" />
    <form:select path="books" multiple="true">
        <form:option value="0" label="--Select option--" />
        <form:options items="${books}" itemLabel="title" itemValue="id" />
    </form:select><br />
    <input type="submit" value="Edit">
</form:form>
</body>
</html>
