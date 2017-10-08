<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Employee Details here</title>
</head>
<body>
	<h1>Employee Details here</h1>
	<br>
	<br>
	<br>
	<br>
	<form:form commandName="empBean" action="addEmpDetails.html">

First Name:<form:input path="firstName" />
		<br>
		<br>

Middle Name:<form:input path="middleName" />
		<br>
		<br>

Last Name :<form:input path="lastName" />
		<br>
		<br>
		
		Employee ID:<form:input path="empId" />
		<br>
		<br>
		Employee Number:<form:input path="empNo" />
		<br>
		<br>
		Designation:<form:input path="designation" />
		<br>
		<br>
		Location:<form:input path="location" />
		<br>
		<br>

		<input type="submit" value="submit">
	</form:form>

</body>
</html>