
<%@page import="com.sd.web.security.Ticket"%>
<table width="100%">
  <tr>
    <td colspan="2"><img src="images/logo.png" alt="logo"/></td>
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




