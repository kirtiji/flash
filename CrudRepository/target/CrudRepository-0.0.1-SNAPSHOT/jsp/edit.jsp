<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<h1 align="center">EDIT DATA</h1>
</head>
<body>
<form action="update">
<table border="1">
<c:forEach items="${data}" var="user">
<input type="hidden" name="id" value="${user.id}">


<tr>
<td>FNAME:-</td>
<td><input type="text" name="fname" value="${user.fname}"></td>
</tr>
<tr>
<td>LNAME:-</td>
<td><input type="text" name="lname" value="${user.lname}"></td>
</tr>
<tr>
<td>PASSWORD:-</td>
<td><input type="text" name="password" value="${user.password}"></td>
</tr>
<tr>
<td>USERNAME:-</td>
<td><input type="text" name="username" value="${user.username}"></td>
</tr>
<tr>
</c:forEach>
<td><input type="submit" value="UPDATE"></td>
</tr>
</table>
</form>
</body>
</html>