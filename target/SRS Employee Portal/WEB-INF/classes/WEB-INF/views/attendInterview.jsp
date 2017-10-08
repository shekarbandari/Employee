<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Attend Interview Details</title>
</head>
<body>
<h1>Attend Interview Details here</h1>

	<br>
	<form:form commandName="createApp" action="attendInterviewDetails.html" method="POST">

Application Name:  <form:hidden path="applicationName" value="${createApplicationBean.applicationName}"/>${createApplicationBean.applicationName}
		<br>
		<br>

Application Details:<form:hidden path="applicationDetails" value="${createApplicationBean.applicationDetails}"/>${createApplicationBean.applicationDetails}
		<br>
		<br>

Skill Set :<form:hidden path="skillSet" value="${createApplicationBean.skillSet}"/>${createApplicationBean.skillSet}
		<br>
		<br>
		
	
		Designation:<form:hidden path="designation" value="${createApplicationBean.designation}" />${createApplicationBean.designation}
		<br>
		<br>
		Location:<form:hidden path="location" value="${createApplicationBean.location}"/>${createApplicationBean.location}
		<br>
		<br>
	Qualified Interview:	 <form:checkbox path="selectedInterview" value="selectedInterview" />
		
		<br>
		<br>

		<input type="submit" value="submit">
	</form:form>

</body>
</html>