<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>




<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forgot Password !!!</title>
</head>
<body>

Hi forgotPassword<br><br><br>
<form:form action="forgotPassword.html" commandName="forgotPassword" method="POST">
User Name : <form:input path="userName" />
<span class="errors"><form:errors path="userName"></form:errors> </span>
<br><br>
E-Mail :<form:input path="email"/>
<span class="errors"><form:errors path="email"></form:errors></span><br><br>
<input type="submit" value="submit"/>

</form:form>


</body>
</html>