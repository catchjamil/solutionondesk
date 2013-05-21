
<%@page import="com.sd.web.enums.Roles"%>
<%@page import="com.sd.web.security.Ticket"%><%@ taglib prefix="core" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<html>
	<head>
		<title>Menu</title>
		<link rel="stylesheet" href="<%=request.getContextPath()%>/style/app.css" type="text/css" />
	</head>
	<script src="<%=request.getContextPath()%>/js/jquery.js"></script>
		
	
	<script type="text/javascript">

$(function(){
	$('.dropdown').mouseenter(function(){
		$('.sublinks').stop(false, true).hide();
	
		var submenu = $(this).parent().next();

		submenu.css({
			position:'absolute',
			top: $(this).offset().top + $(this).height() + 'px',
			left: $(this).offset().left + 'px',
			zIndex:1000
		});
		
		submenu.stop().slideDown(400);
		
		submenu.mouseleave(function(){
			$(this).slideUp(400);
		});
	});
});
</script>

	<body>
	
	 <div id="container" style="margin-top:40px;">
	
	<!-- First Menu Start -->
	<ul>
		<li><a href="#" class="dropdown">Home</a></li>
		
	</ul>
	<!-- First Menu End -->

	<!-- Second Menu Start -->
	
	<%try{ 

Ticket ticket = (Ticket)request.getSession().getAttribute("ticket");
if(ticket != null && Roles.ADMIN.toString().equalsIgnoreCase(ticket.getRole())){
%>	
	<ul>
		<li><a href="#" class="dropdown">Master</a></li>
		
		<li class="sublinks">
			<a href="userRegistrationList.do">User</a>
			<a href="technologyList.do">Technology</a>
			<a href="articleDisplay.do">Article</a>
			<a href="reSetPassword.do">Reset Pwd</a>
		</li>
		
	</ul>
<%
}
} catch(Exception e ){
e.printStackTrace();
}%>
	
	<!-- Second Menu End -->

	<!-- Third Menu Start -->
	<ul>
		<li><a href="#" class="dropdown">Java</a></li>
		
		<li class="sublinks">
			<a href="articleDisplay.do?entityName=J2SE&entityType=article&entityId=100">J2SE</a>
			<a href="#">J2EE</a>
			<a href="#">Framwork</a>
			<a href="#">ECS</a>
			<a href="#">Editor</a>
		</li>
		
	</ul>
	<!-- Third Menu End -->

	<!-- Fourth Menu Start -->
	<ul>
		<li><a href="#" class="dropdown">Database</a></li>
		
		<li class="sublinks">
			<a href="#">DBA</a>
			<a href="#">PL/SQL</a>
			<a href="#">Form & Report</a>
			
		</li>
		
	</ul>
	
	<ul>
		<li><a href="#" class="dropdown">Interveiw QA</a></li>
		
		<li class="sublinks">
			
			<a href="objectiveQAList.do?entityId=200">Java</a>
			
			<a href="#">Database</a>
			<a href="#">Form & Report</a>
			
		</li>
		
	</ul>
	
	
	<!-- Fourth Menu End -->

	<!-- Fifth Menu Start -->
	<ul>
		<li><a href="#" class="dropdown">Contact Us</a></li>
		
		<li class="sublinks">
			<a href="#">About Us</a>
			<a href="#">Leave Message</a>
		</li>
		
	</ul>
	<!-- Fifth Menu End -->
	
  
	<!-- Back to iShift link -->
	</div>
	
	</body>
</html>