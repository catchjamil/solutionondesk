<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<HTML>
<HEAD>
    <TITLE> Sell Items</TITLE>
 
 <style type="text/css">
 	.table {
width: 75%;
margin-bottom: 20px;
}

 </style>
</HEAD>
<BODY>

 <h3><a class="btn btn-info" href="sellItem.html">Sell Item</a></h3>
 <c:if test="${!empty listSellItems}">
	<table  class="table table-striped table-bordered" align="center">
	<caption><h3><b>Sold List Items</b></h3></caption>
		<tr>
			
			<th>Name</th>
			<th>Contact No</th>
			<th>Address</th>
			<th>Quation Slip</th>
			
			
		</tr>

		<c:forEach items="${listSellItems}" var="sellItems">
			<tr>
			
				<td><c:out value="${sellItems.customerName}"/></td>
				<td><c:out value="${sellItems.contactNo}"/></td>
				<td><c:out value="${sellItems.address}"/></td>
				<td><a href="<%=request.getContextPath()%>${sellItems.quationSlipPath}" target="_blank"><c:out value="${sellItems.quationSlipPath}"/> </a></td>
			</tr>	
			
			
			
		</c:forEach>
	</table>
</c:if>
 
 
 
 
 
 
 
 
 
</BODY>
</HTML>