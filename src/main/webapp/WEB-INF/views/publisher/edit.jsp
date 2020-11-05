<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit publisher</title>
</head>
<body>
<form:form modelAttribute="publisher">
    <form:hidden path="id" />
    <form:label path="name">Name:</form:label>
    <form:input path="name" /><br />

    <input type="submit" value="Edit">
</form:form>
</body>
</html>
