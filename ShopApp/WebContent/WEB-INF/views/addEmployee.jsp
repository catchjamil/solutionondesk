<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Spring MVC Form Handling</title>
		
		           <style>
	.table {
width: 25%;
margin-bottom: 20px;
}

 </style>
		
	</head>
	<body>
		<form:form method="POST" action="/ShopApp/save.html">
	   		<table class="table table-bordered " align="center">
	   		<caption><h3><b>Add Expense</b></h3></caption>
			    
			    <tr>
			        <td><form:label path="id" > ID:</form:label></td>
			        <td><form:input path="id" value="${employee.id}" readonly="true"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="name"> Name:</form:label></td>
			        <td><form:input path="name" value="${employee.name}"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="age"> Age:</form:label></td>
			        <td><form:input path="age" value="${employee.age}"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="salary"> Amount:</form:label></td>
			        <td><form:input path="salary" value="${employee.salary}"/></td>
			    </tr>
			    
			      <tr>
			        <td><form:label path="contactNo"> Contact No:</form:label></td>
			        <td><form:input path="contactNo" value="${employee.contactNo}"/></td>
			    </tr>
			    
			    <tr>
			        <td><form:label path="address"> Address:</form:label></td>
                    <td><form:input path="address" value="${employee.address}"/></td>
			    </tr>
			    <tr>
			      <td colspan="2" align="center"><input type="submit" value="Submit" /></td>
		      </tr>
			</table> 
		</form:form>
	</body>
</html>