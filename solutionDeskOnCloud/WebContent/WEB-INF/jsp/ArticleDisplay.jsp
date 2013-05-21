<%@page import="com.sd.web.security.Ticket"%>
<%@page import="com.sd.web.enums.Roles"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%List<String> totalFileList = (List<String>) request.getAttribute("totalFileNames"); 
if(null == totalFileList){
	totalFileList = new ArrayList<String>();
}
%>
<script type="text/javascript">
            var totalPage = '<%=totalFileList.size()%>';
            var fileNames = new Array();
		    var currentPage = 0;

		    window.onload = function(){
		    var i=0;
		    <% for(String fileName : totalFileList){%>
		       fileNames[i]='<%=fileName%>';
		       i++;
		    <%}%>
		    if(totalPage > 1){
		        var startTag = "<table><tr><td><a onclick=previousPage() id='previous'>Previous</a></td>";
		        var midTag = "";
		    	  for(var i=1; i<totalPage; i++){
		    	  	midTag += "<td><a onclick=getPage('"+(i - 1)+"')>"+i+"</a></td>";
		    	  }  
		        var endTag = "<td>...<a onclick=getPage('"+(fileNames.length - 1)+"')>"+fileNames.length+"</a></td><td><a onclick=nextPage() id='next'>Next</a></td></tr></table>";
		        document.all.pagination.innerHTML = startTag + midTag + endTag;
		        document.all.previous.disabled = true;
		        }
		      } 
		     function getPage(pageNo){
		     	currentPage = pageNo;
				
				if(currentPage <(fileNames.length - 1) ){
		     		document.all.next.disabled = false;
		     	}else{
		     		document.all.next.disabled = true;
		     	}
		     	
		     	if(currentPage >0 ){
		     		document.all.previous.disabled = false;
		     	}else{
		     	  document.all.previous.disabled = true;
		     	}
		     	
			 	document.all.pageFrm.src = fileNames[pageNo];
			 }
		
		 function nextPage(){
			 		currentPage = parseInt(currentPage) + 1;
			 	 	document.all.pageFrm.src = fileNames[currentPage];
		 		if(currentPage <(fileNames.length - 1) ){
		     		document.all.next.disabled = false;
		     	}else{
		     		document.all.next.disabled = true;
		     	}
		     	if(currentPage >0 ){
		     		document.all.previous.disabled = false;
		     	}else{
		     	  	document.all.previous.disabled = true;
		     	}
		 		
			 }
		 function previousPage(){
		 		currentPage = (parseInt(currentPage) - 1);
		     	document.all.pageFrm.src = fileNames[currentPage];
		 		if(currentPage >0 ){
		     		document.all.previous.disabled = false;
		     	}else{
		     	  document.all.previous.disabled = true;
		     	}
		     	
		     	if(currentPage <(fileNames.length - 1) ){
		     		document.all.next.disabled = false;
		     	}else{
		     		document.all.next.disabled = true;
		     	}	
			 }	 
</script>

<% 
Ticket ticket = (Ticket)request.getSession().getAttribute("ticket");
 if(ticket != null && (Roles.ADMIN.toString().equalsIgnoreCase(ticket.getRole()) ||  Roles.CONTRIBUTOR.toString().equalsIgnoreCase(ticket.getRole()))){
%>
<a
	href="articleEditor.do?entityId=<%=request.getAttribute("entityId")%>">Add
	New</a>
	

<%
}
	if (null != request.getAttribute("fileURL") && !("null".equals(request.getAttribute("fileURL")))) {
%>
<Div id="pagination" align="right"></Div>
<iframe src="<%=request.getAttribute("fileURL")%>" seamless
	height="1500" width="800" id="pageFrm"  frameBorder="0" scrolling="no"></iframe>
<%
	}
%>
