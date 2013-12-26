
<%@page import="com.sd.web.security.Ticket"%>
<div  style="width:190px; height:90px;float: left;" >

<img src="images/logo.png" alt="logo" width="150" height="70"/>
<br>
<%try{ 

Ticket ticket = (Ticket)request.getSession().getAttribute("ticket");
if(ticket != null){%>
Welcome :
<%= ticket.getUserName()%>

<a href="logOut.do">Log Out</a>

<% }else{
	%>
<a href="logonPage.do">Sign In</a>

<% 
}
} catch(Exception e ){
e.printStackTrace();
}%>

</div>
<div style="width:900px; height:90px;float: left;">
<center>
<img src="images/javaCertification.gif" width="250" height="30"/>
<img src="images/databaseCertification.gif" width="250" height="30"/>
<img src="images/liveProject.gif" width="150" height="30"/>
<img src="images/contact.gif"/>
</center>
</div>


<div  style="width:50px; height:62px;float: right;" >
<img src="images/pics.jpg" alt="logo" height="70" width="60" />
</div>
