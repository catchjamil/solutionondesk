	<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="com.sd.web.util.MessageDetails"%>
<%@page import="java.util.HashMap"%>
	
<script src="<%=request.getContextPath()%>/js/WebUtil.js"></script>

<% 

LinkedHashMap<Integer, MessageDetails> messageInformation =(LinkedHashMap<Integer, MessageDetails>)session.getAttribute("messageInformation");
Integer pageNo = (Integer)request.getAttribute("pageNo");
Integer totalMsg = (Integer)request.getAttribute("totalMsg");

if(pageNo == null){
	pageNo = 1;
}

%>
<script src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script type="text/javascript">



window.onload = function(){ 
	document.getElementById("numberOfRecord").value = 15;
	var userInfo = "";
	for(i =1 ; i <= 50 ; i++){
	userInfo += "<option value='" +i+"'>"+ i +"</option>";
	}
	$('#pageNo').html(userInfo);
	document.getElementById("pageNo").value = <%=pageNo%>;
}





function frmSubmit(){     

 var status = true; 
	if(!validateAlphaNumric('userName')){
		status = false;
	}
	if(!validatePwd('password')){
				status = false;
	}
		if(status){
	  		document.logonForm.action = "<%=request.getContextPath()%>/emailInbox.do";
	  		document.logonForm.submit();
	  		return false;
		}
			 
}				      
   
function onChangePage(){
	var numberOfRecord =  $('#numberOfRecord').val();
	var pageNo = $('#pageNo').val();
			
	  document.all.logout.href = "emailInbox.do?numberOfRecord="+numberOfRecord+"&pageNo="+pageNo;
	  document.all.logout.click();
}


</script>
 
 <%

if (null != request.getAttribute("msg") && !("null".equalsIgnoreCase(request.getAttribute("msg").toString())) && !("".equalsIgnoreCase(request.getAttribute("msg").toString()))){ %>

<table align="center" bgcolor="yellow"><tr><td>
<B><%= request.getAttribute("msg") %></B>
</td></tr></table>
<% 
}
%>
 
 <% 
 
 
 if(messageInformation == null || messageInformation.size() == 0 ){
 %>
 
 
 		<form method="post" name="logonForm">

			<table border="0">
				<tr >
					<td align="center" colspan="2" >
						<b>Please Enter Gmail User Name and Password</b>
					</td>
				</tr>
				<tr>

					<td align="left" nowrap="nowrap">
						User Name
					</td>
					<td align="left">
						
							<input type="text" name="userName"
								 id="userName"
								maxlength="30" alt="User Name"
								onChange="validateAlphaNumric('userName')" />
							<span id="userName_spn" />
						
					</td>

				</tr>
				
				<tr>
					<td align="left">
						Password
					</td>
					<td align="left">
						
							<input type="password" name="password" id="password"
								alt="Password" onchange="validatePwd('password')" />
							<span id="password_spn" />
						
					</td>
				</tr>
					<tr>
					<td align="center" colspan="2">
						<input type="button" alignment="center" id="actionButton"
							value="Logon" onclick="frmSubmit()">

						<input id="remember" name="remember_me" value="1" tabindex="7"
							type="checkbox">
						<label for="remember">
							Remember me
						</label>
					</td>
				</tr>
				</table>
 <% }
 else{
  
 %>
 
 			<table border="0" >
 			<tr><td colspan="1"> <a href="composePage.do"> Compose </a> </td>
 			Total Message <%=totalMsg %>
 			<td>
 			<input type="text" id="numberOfRecord" size="6" maxlength="3">
 			<select id="pageNo" onchange="onChangePage()"></select>
 			
 			</td>
 			<td> <a href="logoutFromEmail.do" id="logout" >Log out From Email </a>   </td>
				</tr>
				<tr >
					<th align="center" >
						Name
					</th>
					
					<th align="center" >
						Subject
					</th>
					
					<th align="center" >
						Date
					</th>
				</tr>
				
				<%for(Map.Entry<Integer, MessageDetails> entry : messageInformation.entrySet()){ 
					MessageDetails messageDetails = entry.getValue();
				%>
				<tr >
					<td align="left" >
						<%if(messageDetails.getAttachments() != null && messageDetails.getAttachments().size() > 0){ %>
						<img src="images/attachment.jpg" height="16" width="18"/>
						<%}%>
						<a href="composePage.do?messageId=<%=entry.getKey()%>"><%=messageDetails.getFrom() %></a> 
					</td>
					
					<td align="left" >
						<a href="composePage.do?messageId=<%=entry.getKey()%>"><%=messageDetails.getSubject() %></a> 
					</td>
					
					<td align="left" >
						<%=messageDetails.getReceived() %>
					</td>
				</tr>

				<%} %>	
					
									</table>
 <% }%>