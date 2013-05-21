<%@page import="java.util.List"%>
<%@page import="com.sd.web.util.EmailAttachment"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="com.sd.web.util.MessageDetails"%>
<%@page import="java.util.HashMap"%>
<%@ page isErrorPage="true"%>
<%@ taglib uri="/WEB-INF/displaytag.tld" prefix="display"%>
<%@ page import="java.util.ArrayList"%>


<%
String contextPath = request.getContextPath();
String  errorMessage = "We apologise, but the page you have specified cannot be found.";

LinkedHashMap<Integer, MessageDetails> messageInformation = (LinkedHashMap<Integer, MessageDetails>)session.getAttribute("messageInformation");
MessageDetails messageDetails = null;
Object object = request.getAttribute("messageId");
if(messageInformation != null && messageInformation.size() > 0 && object != null){
 messageDetails =  messageInformation.get(Integer.parseInt((String)object));
	
 }
// out.print(bodyMessage);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
	<title>::Send Mail::</title>
	    
	    
	    
<script src="<%=request.getContextPath()%>/js/WebUtil.js"></script>
<script type="text/javascript">


function onInitForm()
{
	// document.all.from.value = "catchjamil@gmail.com";

}

function openWin()
{
 myWindow=window.open('<%=contextPath%>/AttachmentForm.jsp','','width=550,height=400');
//myWindow.document.write("<p>This is 'myWindow'</p>");
myWindow.focus();
}

function frmSubmit()
{
// alert("test : "+document.all.pwd.value);
}
</script>
	    
</head>
<body class="bg" onload="onInitForm()">

<pre>

<%

if(messageDetails != null){ %>
	
		<table >
		
			<tr>
				<td>
					<h4>From :</h4>
					<%=messageDetails.getFrom()%>
				</td>
			</tr>
			<tr>
				<td>
					<B>To :</B><%=messageDetails.getToRecp()%>
				</td>
			</tr>

			<tr>
				<td>
					<B>CC :</B> <%=messageDetails.getCcRecp() != null ? messageDetails.getCcRecp() : "" %>
				</td>
			</tr>

			<tr>
				<td>
					<B>BCC :</B> <%=messageDetails.getBccRecp()  != null ? messageDetails.getBccRecp() : ""%>
				</td>
			</tr>

			<tr>
				<td>
					<B>Subject :</B>
					<%=messageDetails.getSubject()%>
				</td>
			</tr>
			
			<tr>
			<%
					List<EmailAttachment> emailAttachments = messageDetails.getAttachments();
					
			      if(null != emailAttachments && emailAttachments.size() > 0){ %>
			      <td>
					<B>Attached File :</B>
					
				</td>
			      <% 
			    	  
			    	  for(EmailAttachment emailAttachment : emailAttachments){
					%>
				<td>
					<a href ="<%=contextPath+emailAttachment.getPath() %>"><%=emailAttachment.getName() %> <b>Size </b>  <%=emailAttachment.getSize() %></a>
					
				</td>
				<%}} %>
			</tr>
		</table>
		<table>	
			<tr>
				<td>
					<h4>Message</h4>
					<br>
					<pre>
					<%=
						messageDetails.getBody()
					%>
					</pre>
				</td>
			</tr>


		</table>

<%} %>


<form action = "sendEmail.do" enctype="multipart/form-data" method="post">
		<table width="50%" cellpadding="0" cellspacing="1" class="tablebg">
			<tr class="tblRow">
				<td class="normal" align="left">
				From
				</td>
				<td class="normal" align="left">
				<input type="text" name="from" size="100"> 
				</td>
			</tr>
				<tr align="center" class="tblRow">
				<td class="normal" align="left">
				Password
				</td>
				<td class="normal" align="left">
				<input type="password" name="pwd"> 
				</td>
				
			</tr>
			<tr class="tblRow">
				<td class="normal" align="left">
				To
				</td>
				<td class="normal" align="left">
				<input type="text" name="to" size="100"> 
				</td>
				
			</tr>
			<tr class="tblRow">
				<td class="normal" align="left">
				CC
				</td>
				<td class="normal" align="left">
				<input type="text" name="cc" size="100"> 
				</td>
				
			</tr>
			<tr class="tblRow">
				<td class="normal" align="left">
				BCC
				</td>
				<td class="normal" align="left">
				<input type="text" name="bcc" size="100"> 
				</td>
				
			</tr>
			
			<tr class="tblRow">
				<td class="normal" align="left">
				Subject
				</td>
				<td class="normal" align="left">
				<input type="text" name="subject" size="100"> 
				</td>
				
			</tr>
			
			<tr class="tblRow">
				<td class="normal" align="left">
	
				<input type="button" value="Attachment" onclick="openWin()" />
				<span id="fileName"></span>
				</td>
				
			</tr>
		
			<tr class="tblRow">
				<td class="normal" align="left">
				Message Body
				</td>
				<td align="left">
				
				<textarea rows="16" cols="75" wrap="physical" name="msgBody" type="_moz">
				
				</textarea>

 
				</td>
				
			</tr>
			
			<tr >
				<td align="left">
				
				</td>
				<td class="normal" align="left">
				<input type="submit" value="Send" onclick="frmSubmit();">
				
				</td>
				
			</tr>
		
		</table>
	</form>
	
</body>
</html>
