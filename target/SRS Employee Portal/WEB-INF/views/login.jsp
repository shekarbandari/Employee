<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>



<form id="userForm" name="userForm" method="post"
									action="j_spring_security_check">
									<font color="red">${failure}</font><br><br>
								User Name :	<input id="j_username" name="j_username" type="text" value=""class="Large_Text_Box"> <br><br>
										
								Password  :		 <input id="j_password" name="j_password"type="password" value="" > <br><br>
										
										  <input name="Login" type="submit" value="Login" class="LoginButton">
								</form>
								
								<br><a href="forgotPassword.html">Forgot Password !!!</a>








</body>
</html>