<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title><spring:message code="registration.title"/> </title>
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.css"/>
</head>
<body>
    <header>
        <jsp:include page="header.jsp"/>
    </header>

    <div class="container-fluid">
        <form:form modelAttribute="user">
            <div class="form-group row">
                <label for="firstNameInput" class="col-sm-2 col-form-label"><spring:message code="registration.firstName"/></label>
                <div class="col-sm-10">
                    <form:input id="firstNameInput" cssClass="form-control" path="firstName"/>
                </div>
            </div>

            <div class="form-group row">
                <label for="lastNameInput" class="col-sm-2 col-form-label"><spring:message code="registration.lastName"/></label>
                <div class="col-sm-10">
                    <form:input id="lastNameInput" cssClass="form-control" path="lastName"/>
                </div>
            </div>

            <div class="form-group row">
                <label for="emailInput" class="col-sm-2 col-form-label"><spring:message code="registration.email"/></label>
                <div class="col-sm-10">
                    <form:input id="emailInput" cssClass="form-control" path="email"/>
                </div>
            </div>

            <div class="form-group row">
                <label for="passwordInput" class="col-sm-2 col-form-label"><spring:message code="registration.password"/></label>
                <div class="col-sm-10">
                    <form:input id="passwordInput" type="password" cssClass="form-control" path="password"/>
                </div>
            </div>

            <div class="form-group row">
                <label for="passwordMatchInput" class="col-sm-2 col-form-label"><spring:message code="registration.passwordMatch"/></label>
                <div class="col-sm-10">
                    <form:input id="passwordMatchInput" type="password" cssClass="form-control" path="passwordMatch"/>
                </div>
            </div>

            <div class="form-group row">
                <div class="col-sm-12">
                    <button type="submit" class="btn btn-primary"><spring:message code="registration.submitButton"/></button>
                </div>
            </div>

        </form:form>
    </div>




</body>
</html>
