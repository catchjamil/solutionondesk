
<%@page import="java.util.List"%><%@ taglib prefix="core"
	uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
	<head>
		<title>Listing Page</title>
		<script type="text/javascript">
	
		function getSelectedId(){
			var sltChkList = "";
			$('input[name=sltChk]:checked').each(function(){
				sltChkList = sltChkList + $(this).val()+"-";
			})
			if(sltChkList != "" && sltChkList.length >0 ){
		    	document.all.deleteId.href = "<%=request.getAttribute("entityName") %>Delete.do?chklist="+sltChkList;
		    }else{
		    	alert("Please select check box to delete record.");
		    }
		 
		}
		
		</script>
	</head>
	
	<body>
<%try{ %>
		<table>
		<tr>
		<td colspan="2"><a onclick="getSelectedId()"  id="deleteId"> Delete</a></td>
		
		<td colspan="1"><a href="<%=request.getAttribute("entityName") %>.do"> Add New</a></td><td><a href="#"> Cancel</a></td></tr>
			<tr background="6699FF" >
				<%
					String []headerList = (String[]) request.getAttribute("headerList");
					%>
					<td bgcolor="6699FF" align="center" width="4">Select</td>
				<%	
					for (String headerName : headerList) {
				%>
				
				<td align="center" bgcolor="6699FF"><%=headerName%></td>
				<%
					}
				%>
			</tr>

			<%
				List<Object[]> dataList = (List<Object[]>) request.getAttribute("dataList");
				for (Object[] objects : dataList) {
			%>
			<tr>
				<%
				boolean status = true;
					for (Object object : objects) {
					
					if(status){
					status = false;
				%>
				<td><input type="checkbox" value="<%=object%>" name="sltChk" align="center" width="4"/></td>
				<%}else{ 
				object = object != null ? object : "-";
				
				%>
				<td><%=object%></td>
				<%
					}
				}
				%>

			</tr>
			<%
				}
			%>
		</table>
<%}catch(Exception e){
e.printStackTrace();
} %>

	</body>
</html>