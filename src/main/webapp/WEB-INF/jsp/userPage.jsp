<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Dino
  Date: 5/14/2018
  Time: 4:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table id="registrationFormTable">
    <tr>
        <td><spring:message code="registration.firstName"/></td>
        <td>${user.firstName}</td>
    </tr>
    <tr>
        <td><spring:message code="registration.lastName"/></td>
        <td>${user.lastName}</td>
    </tr>
    <tr>
        <td><spring:message code="registration.email"/></td>
        <td>${user.email}</td>
    </tr>
    <tr>
        <td><spring:message code="registration.password"/></td>
        <td>${user.password}</td>
    </tr>
    <tr>
    </tr>

</table>

</body>
</html>
