<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete author</title>
</head>
<body>
<h3>Czy na pewno chcesz usunąć tego Autora?</h3>
Imię autora: ${author.firstName}<br />
Nazwisko autora: ${author.lastName}<br />
Książki autora: ${author.books}<br />
<form method="post">
    <input type="submit" value="Potwierdź">
</form>
<a href="<c:url value="/author/list"/>"><button>Anuluj</button></a>
</body>
</html>
