<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<center><h1>ALL INFORMAITION</h1></center>

<script type="text/javascript">
function addUser() {
	
	document.fn.action="registerPage";
	document.fn.submit();
}
function deleteUser() {
	
	document.fn.action="delete";
	document.fn.submit();
}
function editUser() {

	document.fn.action="edit";
	document.fn.submit();
}
</script>
</head>
<body>
	<form name="fn">


		<table border="1" align="center">
			<th>SrNo</th>
			<th>Id</th>
			<th>FNAME</th>
			<th>LNAME</th>
			<th>PASSWORD</th>
			<th>USERNAME</th>
			<tr>
				<c:forEach items="${userlist}" var="user">
					<br>
					<td><input type="radio" name="id" value="${user.id}"></td>
					<td>${user.id}</td>
					<td>${user.fname}</td>
					<td>${user.lname}</td>
					<td>${user.password}</td>
					<td>${user.username}</td>
			</tr>
			</c:forEach>

		</table>

<table border="2" align="center">
<tr>
<td><input type="button" value="EDIT" onclick="editUser()"></td>
<td><input type="button" value="ADD" onclick="addUser()"></td>
<td><input type="button" value="DELETE" onclick="deleteUser()"></td>

</tr>
</table>
	</form>
</body>
</html>