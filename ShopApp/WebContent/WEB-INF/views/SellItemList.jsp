<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<HTML>
<HEAD>
    <TITLE> Sell Items</TITLE>
 
</HEAD>
<BODY>

 <a href="sellItem.html">Sell Item</a></h4>
 
 <c:if test="${!empty listSellItems}">
		<h2>List Items</h2>
	<table align="left" border="1">
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