<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>






<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
         Change Password Here  !!!
         <br><br><br><br>
         
         
         <form:form commandName="changePassword"  action="changePassword.html" method="POST">
         Old Password : <form:password path="oldPassword" />
         <span class="errors"><form:errors path="oldPassword"></form:errors></span><br><br>
         New Password : <form:password path="password" />
         <span class="errors"><form:errors path="password"></form:errors></span><br><br>
         Re-Enter New Password : <form:password path="confirmPassword" />
         <span class="errors"><form:errors path="confirmPassword"></form:errors></span>
         <br><br>
         <input type="submit" value="submit" />
         
         </form:form>
         
</body>
</html>