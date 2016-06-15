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
<title>NewUser</title>
</head>
<body>
<h2>Welcome to Our Site! Please Register here!</h2>
<form action="add" method="POST">
Name:   <input type="text"  name="username"/><br/><br/>
Type:   <input type="text"  name="usertype"/><br/><br/>
Gender: <input type="text"  name="usergender"/><br/><br/>
Address:<input type="text"  name="useraddress"/><br/><br/>
Password:<input type="password"  name="userpassword"/><br/><br/>
<input type="submit" name="insert" value="Submit"/>
</form>
</body>
</html>