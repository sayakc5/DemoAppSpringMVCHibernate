<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>
</head>
<body>
<form action="changepassword" method="POST">
User Id: <input type="text"  name="userid"/><br/><br/>
Original Password:   <input type="text"  name="userpassword"/><br/><br/>
New Password:   <input type="text"  name="newpassword"/><br/><br/>
Confirm Password: <input type="text"  name="confirmpassword"/><br/><br/>
<input type="submit" name="ChangePassword" value="Change Password"/>
</body>
</html>