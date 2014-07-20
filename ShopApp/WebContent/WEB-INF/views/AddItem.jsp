<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Add Items</title>
	</head>
	<body>
		<h2>Add Item Data</h2>
		<form:form method="POST" action="/sdnext/saveItem.html">
	   		<table>
			    <tr>
			        <td><form:label path="id" onclick="validatePhoneNumber()">Item ID:</form:label></td>
			        <td><form:input path="id" value="${item.id}" readonly="true"/></td>
			    </tr>
			    <tr>
			    					    
			        <td><form:label path="name"> Name:</form:label></td>
			        <td><form:input path="name" value="${item.name}"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="height">Height:</form:label></td>
			        <td><form:input path="height" value="${item.height}"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="width">Width:</form:label></td>
			        <td><form:input path="width" value="${item.width}"/></td>
			    </tr>
			    
			    <tr>
			        <td><form:label path="thikness">Thikness:</form:label></td>
                    <td><form:input path="thikness" value="${item.thikness}"/></td>
			    </tr>
			    
			    <tr>
			        <td><form:label path="buyFrom">Buy From:</form:label></td>
                    <td><form:input path="buyFrom" value="${item.buyFrom}"/></td>
			    </tr>
			    
			    <tr>
			        <td><form:label path="quantity">Quantity:</form:label></td>
                    <td><form:input path="quantity" value="${item.quantity}"/></td>
			    </tr>
			    
			    <tr>
			        <td><form:label path="price">Price:</form:label></td>
                    <td><form:input path="price" value="${item.price}"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="description">Description:</form:label></td>
                    <td><form:input path="description" value="${item.description}"/></td>
			    </tr>
			    
			    <tr>
			      <td colspan="2"><input type="submit" value="Submit"/></td>
		      </tr>
			</table> 
		</form:form>
		
  <c:if test="${!empty items}">
		<h2>List Items</h2>
	<table align="left" border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Height</th>
			<th>Width</th>
			<th>Thikness</th>
			<th>Buy From</th>
			<th>Quantity</th>
			<th>Price</th>
			<th>Description</th>
			<th>Actions on Row</th>
		</tr>

		<c:forEach items="${items}" var="item">
			<tr>
				<td><c:out value="${item.id}"/></td>
				<td><c:out value="${item.name}"/></td>
				<td><c:out value="${item.height}"/></td>
				<td><c:out value="${item.width}"/></td>
				<td><c:out value="${item.thikness}"/></td>
				<td><c:out value="${item.buyFrom}"/></td>
				<td><c:out value="${item.quantity}"/></td>
				<td><c:out value="${item.price}"/></td>
				
				<td><c:out value="${item.description}"/></td>
				<td align="center"><a href="editItem.html?id=${item.id}">Edit</a> | <a href="deleteItem.html?id=${item.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
	</body>
</html>