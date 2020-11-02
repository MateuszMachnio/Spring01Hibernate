<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Person form bind</title>
</head>
<body>
<form:form modelAttribute="person">
    <label>Login:
    <form:input path="login" />
    </label>
    <form:label path="password" for="password">Password:</form:label>
    <form:password path="password" />
    <form:input path="email" />
    <input type="submit" value="Prześlij" />
</form:form>
</body>
</html>
