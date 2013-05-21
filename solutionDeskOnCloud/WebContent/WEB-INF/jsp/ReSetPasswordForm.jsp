<%@ taglib prefix="core" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head><title>User Registration</title></head>
<script src="<%=request.getContextPath()%>/js/jquery.js"></script>
		<script type="text/javascript">
		var contexPath = "<%=request.getContextPath()%>";
</script>
		<script src="<%=request.getContextPath()%>/js/WebUtil.js"></script>

		<script type="text/javascript">


function frmSubmit(){
   var status = true; 
   

				if(!validatePwd('password')){
					status = false;
				}
				if(!confPwdCheck('password','rePassword')){
					status = false;
				}
				
				if(status){
	  				document.reSetPassword.action = "<%=request.getContextPath()%>/userRegistrationUpdate.do"
	  				document.reSetPassword.submit();
	  			}else{
	  				return false;
	  			}	
			
	  
}

function goBack()
  {
  window.history.back();
  }

</script>
<body >

<center>

	
	<br/>
	
	<form method="post" name="reSetPassword">
		<table width="75%" border="1">
			<tr>
				<td align="center" bgcolor="lightblue">Reset Password</td>
			</tr>
			<tr>
				<td align="left">
					<table border="0" width="100%">
							<tr id="passwordRow">
							<td width="20%" align="right">New Password </td>
							<td width="80%" align="left">
								<spring:bind path="UserRegistrationForm.password">
								<input type="password" 
								       name="password" id="password"
								         maxlength="15" onchange="validatePwd('password')"/><span id ="password_spn"/>		
								</spring:bind>
								<font color="red">*</font>
							</td>
							
						</tr>
						<tr id="rePasswordRow">
							<td width="20%" align="right">Re Password </td>
							<td width="80%" align="left">
								<input type="password" 
								       name="rePassword" id="rePassword"
								        maxlength="15" onchange="confPwdCheck('password','rePassword')"/><span id ="rePassword_spn"/>		
							<font color="red">*</font>	
							</td>
							
						</tr>
					
						
						<tr>
							<td colspan="2" align="center">
								<spring:hasBindErrors name="UserRegistrationForm">
								<font color="red"></font>
								</spring:hasBindErrors>
							</td>
						</tr>
						
						<tr>
							<td align="center" colspan="2">
								<input type="button" alignment="center"  id="actionButton" value="Submit" onclick ="frmSubmit()">
							</td>
							<td align="center" colspan="2">
							<input type="button" value="Back" onclick="goBack()">
							</td>
						</tr>
					</table>
					
				</td>
			</tr>
		</table>
	
	</form>

</center>

</body>
</html>