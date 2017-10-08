<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Application Details here</title>
</head>
<body>
	<h1>Create Application Details here</h1>
	
	<br>
	<form:form commandName="createApp" action="createApplicationDetails.html" method="POST">

Application Name:<form:input path="applicationName" />
		<br>
		<br>

Application Details:<form:input path="applicationDetails" />
		<br>
		<br>

Skill Set :<form:input path="skillSet" />
		<br>
		<br>
		
	
		Designation:<form:input path="designation" />
		<br>
		<br>
		Location:<form:input path="location" />
		<br>
		<br>

		<input type="submit" value="create">
	</form:form>

</body>
</html>