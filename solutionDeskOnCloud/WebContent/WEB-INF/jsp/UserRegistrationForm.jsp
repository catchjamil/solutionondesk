<%@page import="com.sd.web.form.UserRegistrationForm"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%UserRegistrationForm userRegistrationForm = (UserRegistrationForm)request.getAttribute("userRegistration"); 
if(userRegistrationForm == null){
	userRegistrationForm = new UserRegistrationForm();
}

%>
<html>
<head>
<title>User Registration</title>
</head>
<script src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script type="text/javascript">
		var contexPath = "<%=request.getContextPath()%>";
</script>
<script src="<%=request.getContextPath()%>/js/WebUtil.js"></script>

<script type="text/javascript">
	 var url = contexPath + "/getUserRoleList.do";

function userOnload(){
	
	document.userRegistration.id.value = '<%=userRegistrationForm.getId() != null ? userRegistrationForm.getId() : ""%>';
	document.userRegistration.userName.value = '<%=userRegistrationForm.getUserName()  != null ? userRegistrationForm.getUserName() : ""%>';
	document.userRegistration.firstName.value = '<%=userRegistrationForm.getFirstName()  != null ? userRegistrationForm.getFirstName() : ""%>';
	document.userRegistration.lastName.value = '<%=userRegistrationForm.getLastName()  != null ? userRegistrationForm.getLastName() : ""%>';
	document.userRegistration.email.value = '<%=userRegistrationForm.getEmail()  != null ? userRegistrationForm.getEmail() : ""%>';
	document.userRegistration.phoneNumber.value = '<%=userRegistrationForm.getPhoneNumber()  != null ? userRegistrationForm.getPhoneNumber() : ""%>';
	document.userRegistration.userRole.value = '<%=userRegistrationForm.getRole()  != null ? userRegistrationForm.getRole() : ""%>';
	document.userRegistration.address.value = '<%=userRegistrationForm.getAddress()  != null ? userRegistrationForm.getAddress() : ""%>';
	document.userRegistration.userCountry.value = '<%=userRegistrationForm.getCountry()  != null ? userRegistrationForm.getCountry() : ""%>';
	document.userRegistration.state.value = '<%=userRegistrationForm.getState()  != null ? userRegistrationForm.getState() : ""%>';
	document.userRegistration.city.value = '<%=userRegistrationForm.getCity()  != null ? userRegistrationForm.getCity() : ""%>';
	document.userRegistration.password.value = '<%=userRegistrationForm.getPassword()  != null ? userRegistrationForm.getPassword() : ""%>';
	
	
	doAjaxCall(url,"","userRole");
	url = contexPath + "/getGeographyDetails.do";
	doAjaxCall(url,"","userCountry");
	
	if($('#userName').val().length > 0){
	  document.all.userName.readOnly = true;
	  document.all.actionButton.value = "Update";
	  
	  $('#passwordRow').hide();
	  $('#rePasswordRow').hide();
	}
}
function getStateList(){
		
	document.getElementById('country').value = $('#userCountry').val();

		if($('#userCountry').val() == "Other"){
	document.getElementById('country').type = 'text';
 	}
 		document.getElementById('country').type = 'hidden';
		var param = "countyName=" + $('#userCountry').val();
		doAjaxCall(url,param,"userState");
	
}

function getCityList(){
 
if($('#userState').val() == "Other"){
	document.getElementById('state').type = 'text';
 } 
 	document.getElementById('state').type = 'hidden';
 	var param = "countryName=" + $('#userCountry').val() + "&stateName=" + $('#userState').val();
	doAjaxCall(url,param,"userCity");
  document.getElementById('state').value = $('#userState').val();
 
 }

function onChangeCity(){

	if($('#userCity').val() == "Other"){
	  	 	document.getElementById('city').type = 'text';
	 } else{
	 		document.getElementById('city').value = $('#userCity').val();
	    	document.getElementById('city').type = 'hidden';
	 }	
}

function onChangeRole(){
	document.getElementById('role').value = $('#userRole').val();
}

function frmSubmit(){
   var status = true; 
   
	if(!validateAlphaNumric('userName')){
		
		status = false;
	}
	if(!validateAlphaNumric('firstName')){
		status = false;
	}
	if(!validateAlphaNumric('lastName')){
		status = false;
	}
	
	if(!validateEmail('email')){
		status = false;
	}
	if(!validatePhoneNo('phoneNumber')){
		status = false;
	}
	if(!checkNull('role')){
		status = false;
	}
	if(!checkNull('address')){
		status = false;
	}
	if(!checkNull('country')){
		status = false;
	}
	if(!checkNull('state')){
		status = false;
	}
	
	if(status){
			if(document.all.actionButton.value == "Update"){
				document.userRegistration.action = "<%=request.getContextPath()%>/userRegistrationUpdate.do"
			}else{
				url = contexPath + "/validateExistingUser.do";
				var param = "userName=" + $('#userName').val();
				var getResponseValue = doAjaxCall(url,param,"responseValue");
				if (getResponseValue == "false,"){
				$("#userName_spn").html("<font color='red'>User Name Already Exist. </font>");
				 return false;
				}
				if(!validatePwd('password')){
				status = false;
				}
				if(!confPwdCheck('password','rePassword')){
					status = false;
				}
				
				if(status){
	  				document.userRegistration.action = "<%=request.getContextPath()%>/userRegistration.do"
	  			}else{
	  				return false;
	  			}	
			}
	  			document.userRegistration.submit();
	  }	
}

function goBack()  {
  window.history.back();
  }

</script>
<body onload="userOnload()">



	<form method="post" name="userRegistration">
		<table width="600px">
			<tr>
				<td align="center" colspan="4"><b>User Registration</b></td>
			</tr>
			<tr>
				<td align="left" width="100px" height="3px" nowrap="nowrap"
					valign="top">User Name</td>
				<td align="left" width="50px" height="3px"><spring:bind
						path="UserRegistrationForm.userName">
						<input type="text" name="userName" id="userName" alt="User Name"
							maxlength="30" onChange="validateAlphaNumric('userName')" />
					</spring:bind></td>
				<td width="3px" height="3px"><font color="red">*</font></td>
				<td width="500px" height="3px"><span id="userName_spn" /></td>

			</tr>

			<tr>
				<td align="left" width="50px" height="3px" nowrap="nowrap"
					valign="top">First Name</td>
				<td align="left" width="50px" height="3px"><spring:bind
						path="UserRegistrationForm.firstName">
						<input type="text" name="firstName" alt="First Name"
							id="firstName" maxlength="30"
							onChange="validateAlphaNumric('firstName')">

					</spring:bind></td>
				<td width="3px" height="3px"><font color="red">*</font></td>
				<td width="500px" height="3px"><span id="firstName_spn" /></td>

			</tr>


			<tr>
				<td align="left" width="50px" height="3px" nowrap="nowrap"
					valign="top">Last Name</td>
				<td align="left" width="50px" height="3px"><spring:bind
						path="UserRegistrationForm.lastName">
						<input type="text" name="lastName" alt="Last Name" id="lastName"
							maxlength="30" onChange="validateAlphaNumric('lastName')" />
					</spring:bind></td>
				<td width="3px" height="3px"><font color="red">*</font></td>
				<td width="500px" height="3px"><span id="lastName_spn" /></td>

			</tr>

			<tr id="passwordRow">
				<td align="left" width="50px" height="3px" nowrap="nowrap"
					valign="top">Password</td>
				<td width="50px" align="left"><spring:bind
						path="UserRegistrationForm.password">
						<input type="password" name="password" id="password"
							maxlength="15" onchange="validatePwd('password')" />
					</spring:bind></td>
				<td width="3px" height="3px"><font color="red">*</font></td>
				<td width="500px" height="3px"><span id="password_spn" /></td>

			</tr>


			<tr id="rePasswordRow">
				<td align="left" width="50px" height="3px" nowrap="nowrap"
					valign="top">Re Password</td>
				<td align="left" width="50px" height="3px"><input
					type="password" name="rePassword" id="rePassword" maxlength="15"
					onchange="confPwdCheck('password','rePassword')" /></td>
				<td width="3px" height="3px"><font color="red">*</font></td>
				<td width="500px" height="3px"><span id="rePassword_spn" /> </span></td>
			</tr>


			<tr>
				<td align="left" width="50px" height="3px" nowrap="nowrap"
					valign="top">Email</td>
				<td align="left" width="50px" height="3px"><spring:bind
						path="UserRegistrationForm.email">
						<input type="text" name="email" id="email" alt="Email"
							maxlength="30" onchange="validateEmail('email')" />
					</spring:bind></td>
				<td width="3px" height="3px"><font color="red">*</font></td>
				<td width="500px" height="3px"><span id="email_spn" /></td>

			</tr>
			<tr>
				<td align="left" width="50px" height="3px" nowrap="nowrap"
					valign="top">Phone Number</td>
				<td align="left" width="50px" height="3px"><spring:bind
						path="UserRegistrationForm.phoneNumber">
						<input type="text" name="phoneNumber" id="phoneNumber"
							maxlength="15" onchange="validatePhoneNo('phoneNumber')" />
					</spring:bind></td>
				<td width="3px" height="3px"><font color="red">*</font></td>

				<td width="500px" height="3px"><span id="phoneNumber_spn"></td>

			</tr>


			<tr>
				<td align="left" width="50px" height="3px" nowrap="nowrap"
					valign="top">Role</td>
				<td align="left"><select id="userRole" 
					onchange="onChangeRole()">
				</select> <spring:bind path="UserRegistrationForm.role">
						<input type="hidden" name="role" id="role" alt="Role" />
					</spring:bind></td>
				<td width="3px" height="3px"><font color="red">*</font></td>
				<td width="500px" height="3px"><span id="role_spn"></span></td>

			</tr>

			<tr>
				<td align="left" width="50px" height="3px" nowrap="nowrap"
					valign="top">Address</td>
				<td align="left"><spring:bind
						path="UserRegistrationForm.address">
						<input type="text" name="address" id="address" alt="Address"
							maxlength="100" />
					</spring:bind></td>
				<td width="3px" height="3px"><font color="red">*</font></td>
				<td width="500px" height="3px"><span id="address_spn"></span></td>

			</tr>


			<tr>
				<td align="left" width="50px" height="3px" nowrap="nowrap"
					valign="top">Country</td>
				<td align="left"><select id="userCountry"
					onchange="getStateList()">
				</select> <spring:bind path="UserRegistrationForm.country">
						<input type="hidden" name="country" id="country" maxlength="30"
							alt="Country" />
					</spring:bind></td>
				<td width="3px" height="3px"><font color="red">*</font></td>
				<td width="500px" height="3px"><span id="country_spn"></span></td>

			</tr>
			<tr>
				<td align="left" width="50px" height="3px" nowrap="nowrap"
					valign="top">State</td>
				<td align="left">
				
				<!--  
				<select id="userState"
					onchange="getCityList()">
						<option>Select</option>
				</select> 
				 -->
				
				<spring:bind path="UserRegistrationForm.state">
						<input type="text" name="state" id="state" alt="State"
							maxlength="30" />
					</spring:bind></td>
				<td width="3px" height="3px"><font color="red">*</font></td>
				<td width="500px" height="3px"><span id="state_spn"></span></td>

			</tr>


			<tr>
				<td align="left" width="50px" height="3px" nowrap="nowrap"
					valign="top">City</td>
				<td align="left">
				
				<!-- 
				<select id="userCity"
					onchange="onChangeCity()">
						<option value="0">Select</option>
				</select>
				 -->
				 <spring:bind path="UserRegistrationForm.city">
						<input type="text" name="city" id="city" maxlength="30" />
					</spring:bind></td>
				<td width="3px" height="3px"></td>
				<td width="500px" height="3px"></td>

			</tr>



			<tr>
				<td colspan="4" align="center"><spring:hasBindErrors
						name="UserRegistrationForm">
						<font color="red"> </font>
					</spring:hasBindErrors></td>
			</tr>


			<tr>
				<td align="center" colspan="2" nowrap="nowrap"><input
					type="button" alignment="center" id="actionButton" value="Submit"
					onclick="frmSubmit()" /></td>
					
					<td colspan="2">
					 <input type="button" value="Back"
					onclick="goBack()" />
					
					</td>
			</tr>


		</table>
		<spring:bind path="UserRegistrationForm.id">
			<input type="hidden" name="id" />

		</spring:bind>
				<spring:bind path="UserRegistrationForm.password">
			<input type="hidden" name="password" />

		</spring:bind>
	</form>


</body>
</html>