<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<h2>Welcome to Our Login Page! Please Login here!</h2>
<form action="login" method="POST">
UserId:   <input type="text"  name="userid"/><br/><br/>
Password:   <input type="password"  name="userpassword"/><br/><br/>
<input type="submit" name="Login" value="Login"/>
<a href="ChangePassword">Change Password?</a><br/><br/>
<a href="insert">Register Here!!</a><br/><br/>

</body>
</html>