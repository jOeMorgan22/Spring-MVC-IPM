<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<style>
    .error {color:darkred}
</style>
<head>
    <title>Login</title>
</head>
<h3>Login</h3>


<%--@elvariable id="loginRequest" type="com.springdemo.dao.UserLoginRequest"--%>
<form:form action="processLogin" modelAttribute="loginRequest">
    Username <form:input path="username"/>
    <form:errors path="username" cssClass="error"/>
    <br><br>
    Password: <form:input path="password"/>
    <form:errors path="password" cssClass="error"/>
    <br><br>
    <input type="submit" value="Submit">
</form:form>

</html>
