<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Deleting book</title>
</head>
<body>
<h3>Czy na pewno chcesz usunąć tą książkę?</h3>
Book title: ${book.title}<br />
Book rating: ${book.rating}<br />
Book description: ${book.description}<br />
Book publisher: ${book.publisher}<br />

<form method="post">
    <input type="submit" value="Potwierdź" />

</form>
<a href="<c:url value="/book-bind/list"/>"><button>Anuluj</button></a>

</body>
</html>