
<%@page import="com.sd.web.security.Ticket"%>
<table width="100%">
  <tr>
    <td ><img src="images/logo.png" alt="logo"/></td>
     <td align="right"><img src="images/pics.jpg" alt="logo" height="90" width="120"/></td>
  </tr>
  <tr>
    <td>
    
	<%try{ 

Ticket ticket = (Ticket)request.getSession().getAttribute("ticket");
if(ticket != null){%>
 Welcome : <%= ticket.getUserName()%>
     </td>
    <td align="right">
 
		<a href="logOut.do">Log Out</a>
		
    </td>

<% }else{
	%>
	<td align="right">
	<a href="logonPage.do">Sign In</a>
	</td>
	<% 
}
} catch(Exception e ){
e.printStackTrace();
}%>
	    
    
  </tr>
  
</table>




