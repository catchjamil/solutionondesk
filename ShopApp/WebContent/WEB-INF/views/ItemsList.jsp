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
			<th>Name</th>
			<th>Height</th>
			<th>Width</th>
			<th>Thikness</th>
			<th>Buy From</th>
			<th>Quantity</th>
			<th>Price</th>
			<th>Description</th>
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
			</tr>
		</c:forEach>
	</table>
</c:if>
</body>
</html>