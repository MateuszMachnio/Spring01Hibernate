<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete publisher</title>
</head>
<body>
<h3>Czy na pewno chcesz usunąć tego wydawcę?</h3>
Imię wydawcy: ${publisher.name}<br />
<form method="post">
    <input type="submit" value="Potwierdź">
</form>
<a href="<c:url value="/publisher/list"/>"><button>Anuluj</button></a>
</body>
</html>
