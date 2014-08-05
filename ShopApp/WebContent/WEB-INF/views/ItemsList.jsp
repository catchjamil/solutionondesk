<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>All Items</title>
</head>
<body>
<h1>List Items</h1>
<h3><a href="addItem.html">Add More Item</a></h3>

<c:if test="${!empty items}">
	<table align="left" border="1">
		<tr>
			<th>ID</th>
			<th>Customer Name</th>
			<th>Contact No</th>
			<th>Address</th>
			<th>Name</th>
			<th>Size</th>
			<th>Quantity</th>
			<th>Price</th>
			<th>Total</th>
			<th>Description</th>
			<th>Actions</th>
		</tr>

		<c:forEach items="${items}" var="item">
			<tr>
				<td><c:out value="${item.id}"/></td>
				<td><c:out value="${item.customerName}"/></td>
				<td><c:out value="${item.contactNo}"/></td>
				<td><c:out value="${item.address}"/></td>
				<td><c:out value="${item.items[0].name}"/></td>
				<td><c:out value="${item.items[0].size}"/></td>
				<td><c:out value="${item.items[0].quantity}"/></td>
				<td><c:out value="${item.items[0].price}"/></td>
				<td><c:out value="${item.items[0].price * item.items[0].quantity}"/></td>
				<td><c:out value="${item.items[0].description}"/></td>
				<td align="center"> <a href="deleteItem.html?id=${item.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
</body>
</html>