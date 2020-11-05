<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student form</title>
</head>
<body>
<form:form modelAttribute="student" method="post">
    <label>Name:
        <form:input path="firstName" /><br />
    </label>
    <label>Surname:
        <form:input path="lastName" /><br />
    </label>
        Male: <form:radiobutton path="gender" value="M" />
        Female: <form:radiobutton path="gender" value="F" /><br />
    <label>Country:
        <form:select path="country" multiple="false">
            <form:option value="-" label="--Please Select--"/>
            <form:options items="${countries}"/>
        </form:select><br />
    </label>
    <label>Notes:<br />
        <form:textarea path="notes" rows="3" cols="20"/><br />
    </label>
    <label>Mailing list:
        <form:checkbox path="mailingList"/><br />
    </label>
    <label>Programming skills:<br />
        <form:select path="programmingSkills" multiple="true">
            <form:option value="-" label="--Please select--"/>
            <form:options items="${programmingSkills}" />
        </form:select><br />
    </label>
    Hobbies:<br />
    <form:checkboxes items="${hobbies}" path="hobbies" /><br />
<%--                      itemLabel="name" itemValue="id"--%>

    <button type="submit">Prześlij</button>
</form:form>
</body>
</html>
