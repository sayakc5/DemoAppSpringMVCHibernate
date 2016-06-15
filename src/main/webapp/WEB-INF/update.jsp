<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ page import="org.sayak.tutorial.entity.User"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Profile</title>
</head>
<body>
<h1>Update Profile</h1>
<form action="edit" method="POST">
Your Id:<input type="text"  name="userid" value="${user.userid}" readonly/><br/><br/>
Name:   <input type="text"  name="username" value="${user.username}"/><br/><br/>
Type:   <input type="text"  name="usertype" value="${user.usertype}"/><br/><br/>
Gender: <input type="text"  name="usergender" value="${user.gender}"/><br/><br/>
Address:<input type="text"  name="useraddress" value="${user.address}"/><br/><br/>
<%-- <c:set var="userid"      value="${user.userid}"/>
<c:set var="username"    value="${user.username}"/>
<c:set var="usertype"    value="${user.usertype}"/>
<c:set var="usergender"  value="${user.gender}"/>
<c:set var="useraddress" value="${user.address}"/> --%>
<%-- <%
User u=new User();
		//u.setUserid(Integer.parseInt(request.getParameter("userid").trim()));
		u.setUserid(3);
		u.setUsername((String)pageContext.getAttribute("username"));
		u.setUsertype((String)pageContext.getAttribute("usertype"));
		u.setGender((String)pageContext.getAttribute("usergender"));
		u.setAddress((String)pageContext.getAttribute("useraddress"));
		request.setAttribute("user",u);
%> --%>
<input type="submit" name="update" value="Save"/>
<p>"${error}"</p>
</form>
</body>
</html>