<%@ taglib prefix="core" uri="http://java.sun.com/jstl/core"%>

<html>
	<head>
		<title>LogOn</title>
	</head>

	<script src="js/jquery.js" type="text/javascript"></script>

	<script src="<%=request.getContextPath()%>/js/WebUtil.js"></script>

	<script type="text/javascript">
        $(document).ready(function() {

            $(".signin").click(function(e) {
                e.preventDefault();
                $("fieldset#signin_menu").toggle();
                $(".signin").toggleClass("menu-open");
            });

            $("fieldset#signin_menu").mouseup(function() {
                return false
            });
            $(document).mouseup(function(e) {
                if($(e.target).parent("a.signin").length==0) {
                    $(".signin").removeClass("menu-open");
                    $("fieldset#signin_menu").hide();
                }
            });            

        });
        
function forgotPassword(){
	if(!validateAlphaNumric('userName')){
		return false;
	}        
	var contexPath = "<%=request.getContextPath()%>";
	url = contexPath + "/validateExistingUser.do";
	var param = "userName=" + $('#userName').val()+"&forgotPassword=true";
	var getResponseValue = doAjaxCall(url,param,"responseValue");
	if (getResponseValue == "false,"){
		$("#forgotPassword_spn").html("<font color='green'><BR>Password is send to your registered email. </font>");
	}else{
		$("#forgotPassword_spn").html("<font color='red'><BR>Issue while sending password. </font>");
	}        
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
	  		document.logonForm.action = "<%=request.getContextPath()%>/logonPage.do";
	  		document.logonForm.submit();
	  		return false;
		}
			 
}				      
        
</script>


	<body>


		<%
			try {
		%>


		<form method="post" name="logonForm">

			<table border="0">
				<tr >
					<td align="center" colspan="2" >
						<b>Log on</b>
					</td>
				</tr>
				<tr>

					<td align="left" nowrap="nowrap">
						User Name
					</td>
					<td align="left">
						<spring:bind path="LogonForm.userName">
							<input type="text" name="userName"
								 id="userName"
								maxlength="30" alt="User Name"
								onChange="validateAlphaNumric('userName')" />
							<span id="userName_spn" />
						</spring:bind>
					</td>

				</tr>
				
				<tr>
					<td align="left">
						Password
					</td>
					<td align="left">
						<spring:bind path="LogonForm.password">
							<input type="password" name="password" id="password"
								alt="Password" onchange="validatePwd('password')" />
							<span id="password_spn" />
						</spring:bind>
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
				<tr>
					<td colspan="2">
						<span id="forgotPassword_spn"> </span>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<a onclick="forgotPassword()" id="resend_password_link">Forgot
							your password?</a>

					</td>
				</tr>
			</table>


		</form>


		<%
			} catch (Exception e) {
				e.printStackTrace();
			}
		%>
	</body>
</html>