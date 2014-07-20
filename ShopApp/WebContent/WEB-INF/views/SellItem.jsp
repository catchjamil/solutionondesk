<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<HTML>
<HEAD>
    <TITLE> Sell Items</TITLE>
    <SCRIPT language="javascript">
    var currentRow = 0;
        
    function getRowNumber(obj){
    	currentRow = obj.rowIndex;
    	
    }
    
    function addRow(tableID) {
 
    	var table = document.getElementById(tableID);
        var tableRow = table.rows[2].innerHTML;
        var rowCount = table.rows.length;
        if(rowCount<17){
           table.insertRow(rowCount);
          	var t = table.rows.length;
          	table.rows[t-1].innerHTML = tableRow;
          	table.rows[t-1].setAttribute('onClick','getRowNumber(this)');
          	table.rows[t-1].cells[1].innerHTML = rowCount-1;
           }
        }
 
        function deleteRow(tableID) {
            var table = document.getElementById(tableID);
            var rowCount = table.rows.length;
 
            for(var i=0; i<rowCount; i++) {
                var row = table.rows[i];
                if(row.cells.length > 0){
                var chkbox = row.cells[0].childNodes[0];
                if(null != chkbox && true == chkbox.checked) {
                    table.deleteRow(i);
                    rowCount--;
                    i--;
                }
               }
            }
            
        }
 	
        
        function onchangeItem(obj) {
 			
        	
        	var pValue = obj.options[obj.selectedIndex].title;
        	var v= pValue.split(",");
        	document.getElementsByName("height")[currentRow-2].value =v[0];
        	document.getElementsByName("width")[currentRow-2].value =v[1];
        	document.getElementsByName("thikness")[currentRow-2].value =v[2];
        	document.getElementsByName("quantity")[currentRow-2].value =v[3];
        	document.getElementsByName("price")[currentRow-2].value =v[4];
        	document.getElementsByName("subTotal")[currentRow-2].value = v[3] * v[4];
        	
        }
 
        function onChangeValue(){
        	var q = document.getElementsByName("quantity")[currentRow-2].value;
        	var p = document.getElementsByName("price")[currentRow-2].value;
        	var t =p*q;
        	if(isNaN(t)){
        		t = 0.0;
        	}
        	document.getElementsByName("subTotal")[currentRow-2].value = t;
        	totalAmount();
        }
        
        
        function totalAmount(){
        	var stotal =document.getElementsByName("subTotal");	
        	var calc = 0.0;
        	for(var i =0; i<stotal.length; i++){
        		
        		var v = parseFloat(stotal[i].value);
        		if(!(isNaN(v))) 
        			calc = parseFloat(calc) + v;
        		
        	}
        	document.getElementsByName("totalAmount")[0].value=calc;
        }
        
    </SCRIPT>
</HEAD>
<BODY>
 <form:form method="POST" action="/sdnext/sellSaveItem.html">
 
 	<table><tr><TD>Customer Name <INPUT type="text" name="custName" /> </TD> <TD>Contact No <INPUT type="text" name="contactNo" /></tr></table>   
    <INPUT type="button" value="Add Row" onclick="addRow('dataTable')" />
    <INPUT type="button" value="Delete Row" onclick="deleteRow('dataTable')" />
 
    <TABLE id="dataTable" width="350px" border="1">
      
      <TR>
      		<TH>Select</TH>
      		<TH>Sr.No</TH>
			<TH>Name  ddd</TH>
			<TH>Height</TH>
			<TH>Width</TH>
			<TH>Thikness</TH>
			<TH>Quantity</TH>
			<TH>Price</TH>
			<TH>Sub Total</TH>
		<TR>
      
        <TR onclick="getRowNumber(this)">
            <TD><INPUT type="checkbox" name="chk"/></TD>
            <TD> 1 </TD>
            <td>
            
            
            <SELECT name="items" onchange="onchangeItem(this)" >
            
            <c:forEach items="${items}" varStatus="stat">
   			<OPTION value="${items[stat.index].id}" title="${items[stat.index].height},${items[stat.index].width}, ${items[stat.index].thikness},${items[stat.index].quantity},${items[stat.index].price}">${items[stat.index].name}</OPTION>
 
			</c:forEach>

            </SELECT>
            
            
             </TD>
			<TD> <INPUT type="text" name="height" readonly="readonly"/> </TD>
            <TD> <INPUT type="text" name="width" readonly="readonly"/> </TD>
            <TD> <INPUT type="text" name="thikness" readonly="readonly"/> </TD>
            <TD> <INPUT type="text" name="quantity" onchange="onChangeValue()"/> </TD>
            <TD> <INPUT type="text" name="price" onchange="onChangeValue()"/> </TD>
            <TD> <INPUT type="text" name="subTotal" readonly="readonly"/> </TD>
        </TR>
        
    </TABLE>
    <table><tr><TD align="right">Total<INPUT type="text" name="totalAmount" readonly="readonly"/></TD></tr></table>
 <input type="submit" value="Save" />
     
</form:form>
 
 
 
 
 
 
 <c:if test="${!empty listSellItems}">
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

		<c:forEach items="${listSellItems}" var="sellItems">
			<tr>
				<td><c:out value="${sellItems.id}"/></td>
				<td><c:out value="${sellItems.customerName}"/></td>
				<td><c:out value="${sellItems.contactNo}"/></td>
			</tr>	
			<!--  
			<c:forEach items="${listSellItems.items}" var="item">
			
			<tr>	
				<td><c:out value="${item.id}"/></td>
				<td><c:out value="${item.name}"/></td>
				<td><c:out value="${item.height}"/></td>
				<td><c:out value="${item.width}"/></td>
				<td><c:out value="${item.thikness}"/></td>
				<td><c:out value="${item.buyFrom}"/></td>
				<td><c:out value="${item.quantity}"/></td>
				<td><c:out value="${item.price}"/></td>
				<td><c:out value="${item.subTotal}"/></td>
				
			</tr>
			</c:forEach>
			-->
			
			
			<tr>
				<td><c:out value="${sellItems.totalAmount}"/></td>
			</tr>	
			
			
			
		</c:forEach>
	</table>
</c:if>
 
 
 
 
 
 
 
 
 
</BODY>
</HTML>