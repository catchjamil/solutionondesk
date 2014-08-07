<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>All Employees</title>
           <style>
	.table {
width: 60%;
margin-bottom: 20px;
}

 </style>

</head>
<body>
<a class="btn btn-info" href="add.html">Add Expenses</a>

<c:if test="${!empty employees}">
	<table class="table table-striped table-bordered" align="center">
	<caption><b><h3> Expenses List</h3></b></caption>
		<tr>
			<th> ID</th>
			<th> Name</th>
			<th> Age</th>
			<th> Salary</th>
			<th> Contact No</th>
			<th> Address</th>
			<th> Action</th>
		</tr>

		<c:forEach items="${employees}" var="employee">
			<tr>
				<td><c:out value="${employee.id}"/></td>
				<td><c:out value="${employee.name}"/></td>
				<td><c:out value="${employee.age}"/></td>
				<td><c:out value="${employee.salary}"/></td>
				<td><c:out value="${employee.contactNo}"/></td>
				<td><c:out value="${employee.address}"/></td>
				<td align="center"><a href="edit.html?id=${employee.id}">Edit</a> | <a href="delete.html?id=${employee.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
</body>
</html>