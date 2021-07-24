<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="/admin/manageUser">Back</a>
	<form action="/admin/createUser" method="POST">
	<h1>Create User</h1>
	Email:
	<input type="text" name="email" placeholder="enter email" autofocus="autofocus"/>
	<br> 
	Password:
	<input type="password" name="password" placeholder="enter password" pattern="[A-z-0-9]{6,15}" title="length password than 5"/>
	<br>
	ConFirm Password:
	<input type="password" name="confirmPass" placeholder="enter password" pattern="[A-z-0-9]{6,15}" title="length password than 5"/>
	<br>
	 Role:
	 <input type="radio" name="role" value="GV" checked="checked"/>Teacher
	  <input type="radio" name="role" value="HS"/>Student
	<br>
	 status:
	<input type="text" name="status" value="Default True" disabled="disabled" />
	<br>
	<input type="submit" value="Create" /><br>
	
	<span style="color: red">${ERROR_CREATE }</span>
	
	</form>
</body>
</html>