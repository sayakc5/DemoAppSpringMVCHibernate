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
<title>All Users</title>
</head>
<body>

<table border="2">
                <thead>
                    <tr>
                        <th>User Id</th>
                        <th>User Name</th>
                        <th>User Type</th>
                        <th>Gender</th>
                        <th>Address</th>
                        <th>Action</th>
                       </tr>
                </thead>
                <tbody>
                    <c:forEach var="user" items="${users}">
                        <tr>
                        	<td>${user.userid}</td>
<%--                         	<c:set var uid="${user.userid}"/>
 --%>                            <td>${user.username}</td>
                            <td>${user.usertype}</td>
                            <td>${user.gender}</td>
                            <td>${user.address}</td>
                             
                            <td>
	                            <a href="update?id=${user.userid}">Edit</a>|
	                            <a href="delete?id=${user.userid}">Delete</a>
	                        </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>  
           <!--  <inputvalue=""/> -->  
</body>
</html>