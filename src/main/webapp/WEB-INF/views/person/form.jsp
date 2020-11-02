<%--
  Created by IntelliJ IDEA.
  User: machn
  Date: 01.11.2020
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Person form</title>
</head>
<body>
<form method="post">
    <label>Login:
        <input type="text" name="login" />
    </label>
    <label>Hasło:
        <input type="password" name="password" />
    </label>
    <label>Email:
        <input type="email" name="email" />
    </label>
    <input type="submit" value="Wyślij" />
</form>
</body>
</html>
