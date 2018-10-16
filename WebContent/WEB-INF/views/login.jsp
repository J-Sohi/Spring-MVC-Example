<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login Page</title>
		<style type="text/css">
			.error {
				color:red;
			}
		</style>
	</head>
	<body>
		<h1>Login</h1>
		<h2 class="error">${errorMsg}</h2>
		
		<sf:form action="processLogin" method="post" modelAttribute="user">
			<sf:label path="username">Username</sf:label>
			<sf:input path="username"/>
			<sf:errors path="username" cssClass="error" />
			<br/>
			<sf:label path="password">Password</sf:label>
			<sf:input type="password" path="password"/>
			<sf:errors path="password" cssClass="error" /><br/>
			<input type="submit" value="Login" />
		</sf:form>				
	</body>
</html>