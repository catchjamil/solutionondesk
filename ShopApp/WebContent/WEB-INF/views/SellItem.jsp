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
        	document.getElementsByName("size")[currentRow-2].value =v[0];
        	var temp = v[1] - v[2]; 
        	document.getElementsByName("quantity")[currentRow-2].value =temp;
        	document.getElementsByName("price")[currentRow-2].value =v[3];
        	document.getElementsByName("subTotal")[currentRow-2].value = v[3] * temp;
        	totalAmount();
        	
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
               <style>
	.table {
width: 60%;
margin-bottom: 2px;
}

 </style>

    
    
</HEAD>
<BODY>
 <form:form method="POST" action="/ShopApp/sellSaveItem.html">
 <table class="table table-bordered">
 <caption><h3><b>Sell Items</b></h3></caption>
 <tr>
 	<TD> Customer Name <INPUT type="text" name="custName" /> </TD> <TD> Contact No <INPUT type="text" name="contactNo" /> <TD> Address <INPUT type="text" name="address" /></TD></tr>   
    <tr><td colspan="3">    <INPUT type="button" value="Add Row" onclick="addRow('dataTable')" /> 
    <INPUT type="button" value="Delete Row" onclick="deleteRow('dataTable')" /></tr>
 <tr><td colspan="3">
    <TABLE id="dataTable" class="table table-bordered" >
      
      <TR >
      		<TH>Select</TH>
      		<TH>Sr.No</TH>
			<TH>Name</TH>
			
			<TH>Size</TH>
			<TH>Quantity</TH>
			<TH>Price</TH>
			<TH>Sub Total</TH>
		<TR>
      
        <TR onclick="getRowNumber(this)">
            <TD><INPUT type="checkbox" name="chk"/></TD>
            <TD> 1 </TD>
            <td>
            
            
            <SELECT name="items" onchange="onchangeItem(this)" >
            
            <option selected="selected" disabled="disabled">-Select-</option> 
            <c:forEach items="${itemMasters}"  var="itemMaster" varStatus="stat">
   			<OPTION value="${itemMaster.items[0].id}" title="${itemMaster.items[0].size},${itemMaster.items[0].quantity},${itemMaster.items[0].soldQuantity},${itemMaster.items[0].price}">${itemMaster.items[0].name}</OPTION>
			</c:forEach>
            
            </SELECT>
            
            
             </TD>
			
            <TD> <INPUT type="text" name="size" /> </TD>
            <TD> <INPUT type="text" name="quantity" onchange="onChangeValue()"/> </TD>
            <TD> <INPUT type="text" name="price" onchange="onChangeValue()"/> </TD>
            <TD> <INPUT type="text" name="subTotal" readonly="readonly"/> </TD>
        </TR>
    </TABLE>
    </td></tr>
    <tr><td align="right" colspan="3">
    Total&nbsp;&nbsp;<INPUT type="text" name="totalAmount" readonly="readonly"/>&nbsp;&nbsp;
    </td>
    </tr>
    <tr><td colspan="3" align="center">
 <input type="submit" value="Save" />
 </td></tr>
    </table> 
</form:form>
 
 
 
</BODY>
</HTML>