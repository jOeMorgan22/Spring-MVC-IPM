<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    .error {color: darkred}
</style>
<head>
    <title>Register</title>
</head>
<h3 class="error">Username already exists</h3>
<%--@elvariable id="userRegistration" type="com.springdemo.dao.UserRegistrationRequest"--%>
<form:form action="processRegistration" modelAttribute="userRegistration">
    Username <form:input path="username"/>
    <form:errors path="username" cssClass="error"/>
    <br><br>
    Email <form:input path="email"/>
    <form:errors path="email" cssClass="error"/>
    <br><br>
    USDA Zone    <form:select path="usdaZone">
    <form:option value="1a" label="1a"/>
    <form:option value="1b" label="1b"/>
    <form:option value="2a" label="2a"/>
    <form:option value="2b" label="2b"/>
    <form:option value="3a" label="3a"/>
    <form:option value="3b" label="3b"/>
    <form:option value="4a" label="4a"/>
    <form:option value="4b" label="4b"/>
    <form:option value="5a" label="5a"/>
    <form:option value="5b" label="5b"/>
    <form:option value="6a" label="6a"/>
    <form:option value="6b" label="6b"/>
    <form:option value="7a" label="7a"/>
    <form:option value="7b" label="7b"/>
    <form:option value="8a" label="8a"/>
    <form:option value="8b" label="8b"/>
    <form:option value="9a" label="9a"/>
    <form:option value="9b" label="9b"/>
    <form:option value="10a" label="10a"/>
    <form:option value="10b" label="10b"/>
    <form:option value="11a" label="11a"/>
    <form:option value="11b" label="11b"/>
    <form:option value="12a" label="12a"/>
    <form:option value="12b" label="12b"/>
    <form:option value="13a" label="13a"/>
    <form:option value="13b" label="13b"/>
</form:select>
    <br><br>
    Password <form:input path="password"/>
    <form:errors path="password" cssClass="error"/>
    <br><br>
    <input type="submit" value="Submit">
</form:form>
</html>
