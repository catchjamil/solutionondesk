<%@ taglib prefix="core" uri="http://java.sun.com/jstl/core" %>

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
		<table width="100%" border="3">
			<tr>
				<td align="center" colspan="2"><b>Reset Password</b></td>
			</tr>
			<tr>
				<td align="left">
					<table border="0" width="100%" border="5">
							<tr id="passwordRow">
							<td width="30%" align="right">New Password </td>
							<td width="20%" align="left">
								<spring:bind path="UserRegistrationForm.password">
								<input type="password" 
								       name="password" id="password"
								         maxlength="15" onchange="validatePwd('password')"/> <td><font color="red">*</font> </td><td><span id ="password_spn"/></td>		
								</spring:bind>
								
							</td>
							
						</tr>
						<tr id="rePasswordRow">
							<td width="30%" align="right">Re Password </td>
							<td width="20%" align="left">
								<input type="password" 
								       name="rePassword" id="rePassword"
								        maxlength="15" onchange="confPwdCheck('password','rePassword')"/> <td><font color="red">*</font></td><td>	<span id ="rePassword_spn"/></td>		
							
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
							<td align="center" >
								<input type="button" alignment="center"  id="actionButton" value="Submit" onclick ="frmSubmit()">
							</td>
							<td align="center">
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