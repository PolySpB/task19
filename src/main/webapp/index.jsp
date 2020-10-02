<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<jsp:useBean id="params" class="webapp.EnvParameters" scope="session"/>

<html>
<head>
    <title> JSP Page </title>
</head>

<body>

<table>
    <h1 style="background-color: aquamarine; text-align: center" > JSP Page </h1>
    <c:forEach var="item" items="${params.paramsList}">
        <tr>
            <td> <c:out value="${item.key}"/> </td>
            <td> <c:out value="${item.value}"/> </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>