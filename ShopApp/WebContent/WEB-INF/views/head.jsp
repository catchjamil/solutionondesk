<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<body>

<div class="container-fluid">
   <div class="row">
      <div class="col-md-4"><img alt="Logo" class="img-rounded" src="resources/images/Logo.png" width="200" height="80" /></div>
      <div class="col-md-3">
      	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<h3>Welcome : ${pageContext.request.userPrincipal.name} | <a href="<c:url value="/j_spring_security_logout" />" > Logout</a></h3>  
	</c:if>
      
      
      </div>      
   </div>
</div>

</body>
</html>