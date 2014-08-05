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
		<form:form method="POST" action="/ShopApp/saveItem.html">
	   		<table>
			    <tr>
			        <td><form:label path="id" onclick="validatePhoneNumber()">Item ID:</form:label></td>
			        <td><form:input path="id" value="${id}" readonly="true"/></td>
			    </tr>
			     <tr>
			        <td><form:label path="customerName">Customer Name:</form:label></td>
                    <td><form:input path="customerName" value="${customerName}"/></td>
			    </tr>
			    <tr>
			    					    
			        <td><form:label path="contactNo"> Contact No:</form:label></td>
			        <td><form:input path="contactNo" value="${contactNo}"/></td>
			    </tr>
			    <tr>
			    					    
			        <td><form:label path="address"> Address:</form:label></td>
			        <td><form:input path="address" value="${address}"/></td>
			    </tr>
			    
			    <tr>
			        <td><form:label path="items[0].name">Item Name:</form:label></td>
			        <td><form:input path="items[0].name" value="${items[0].name}"/></td>
			    </tr>
			    
			    <tr>
			        <td><form:label path="items[0].size">Size:</form:label></td>
			        <td><form:input path="items[0].size" value="${items[0].size}"/></td>
			    </tr>
			    
			   
			    
			    <tr>
			        <td><form:label path="items[0].quantity">Quantity:</form:label></td>
                    <td><form:input path="items[0].quantity" value="${items[0].quantity}"/></td>
			    </tr>
			    
			    <tr>
			        <td><form:label path="items[0].price">Price:</form:label></td>
                    <td><form:input path="items[0].price" value="${items[0].price}"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="items[0].description">Description:</form:label></td>
                    <td><form:input path="items[0].description" value="${items[0].description}"/></td>
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
			<th>Size</th>
			<th>Buy From</th>
			<th>Quantity</th>
			<th>Price</th>
			<th>Description</th>
			<th>Actions on Row</th>
		</tr>
<!--  
		<c:forEach items="${items}" var="item">
			<tr>
				<td><c:out value="${item.id}"/></td>
				<td><c:out value="${item.name}"/></td>
				<td><c:out value="${item.size}"/></td>
				<td><c:out value="${item.buyFrom}"/></td>
				<td><c:out value="${item.quantity}"/></td>
				<td><c:out value="${item.price}"/></td>
				
				<td><c:out value="${item.description}"/></td>
				<td align="center"><a href="editItem.html?id=${item.id}">Edit</a> | <a href="deleteItem.html?id=${item.id}">Delete</a></td>
			</tr>
		</c:forEach>
		
	-->	
	</table>
</c:if>
	</body>
</html>