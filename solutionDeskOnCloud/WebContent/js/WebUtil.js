/**
 * 
 */
function doAjaxPost() {  
	  // get the form values  
	  var name = $('#name').val();
	  var education = $('#education').val();
	   
	  $.ajax({  
	    type: "POST",  
	    url: contexPath + "/AddUser.htm",  
	    data: "name=" + name + "&education=" + education,  
	    success: function(response){
	      // we have the response 
	      if(response.status == "SUCCESS"){
	    	  userInfo = "<ol>";
	    	  for(i =0 ; i < response.result.length ; i++){
	    		  userInfo += "<br><li><b>Name</b> : " + response.result[i].name + 
	    		  ";<b> Education</b> : " + response.result[i].education;
	    	  }
	    	  userInfo += "</ol>";
	    	  $('#info').html("User has been added to the list successfully. " + userInfo);
	    	  $('#name').val('');
		      $('#education').val('');
		      $('#error').hide('slow');
		      $('#info').show('slow');
	      }else{
	    	  errorInfo = "";
	    	  for(i =0 ; i < response.result.length ; i++){
	    		  errorInfo += "<br>" + (i + 1) +". " + response.result[i].code;
	    	  }
	    	  $('#error').html("Please correct following errors: " + errorInfo);
	    	  $('#info').hide('slow');
	    	  $('#error').show('slow');
	      }	      
	    },  
	    error: function(e){  
	      alert('Error: ' + e);  
	    }  
	  });  
	}  
	
	function doAjaxCall(url,param,componentId) {  
	   var responseValue = "";
	  $.ajax({  
	    type: "POST",  
	    url: url,  
	    data: param, 
	    async: false, 
	    success: function(response){
	      // we have the response 
	      if(response.status == "SUCCESS"){
	      
			if(componentId == "responseValue"){
	    	  	for(i =0 ; i < response.result.length ; i++){
	    		  	responseValue +=  response.result[i]+",";
	    	  	}
	    	}else{	      
	    	  userInfo = "<option value=''>Select</option>";
	    	  	for(i =0 ; i < response.result.length ; i++){
	    		  	userInfo += "<option value='" + response.result[i]+"'>"+ response.result[i]+"</option>";
	    	  	}
	    		$('#'+componentId+'').html(userInfo);
	    	}
	    	
	      }else{
	    // alert("   Errroorrr... ");
	      }	      
	    },  
	    error: function(e){  
	      alert('Error: ' + e);  
	    }  
	  });
	  return responseValue;  
	}  
	
	function checkNull(compId){

	var compValue = $('#'+compId+'').val();
	var altValue = $('#'+compId+'').attr("alt");
	if(null == compValue || ""==compValue || compValue.length == 0){
		$('#'+compId+'_spn').empty();
		$('#'+compId+'_spn').html("<font color='red'>Please Enter "+altValue+".</font>");
		$('#'+compId+'').focus();
			return false;
		}else{
			$('#'+compId+'_spn').empty();
			return true;
		}
	}
	
function validateAlphaNumric(compId){

	 if(!checkNull(compId)){
	  	return false;
	 }
    var TCode = $('#'+compId+'').val();
    if( /[^a-zA-Z0-9]/.test( TCode ) ) {
        $('#'+compId+'_spn').empty();
		$('#'+compId+'_spn').html("<font color='red'>Input is not alphanumeric</font>");
		$('#'+compId+'').focus();
       return false;
    }else{
	    $('#'+compId+'_spn').empty();
	    return true;
    }
}	
	
function validateEmail(compId){
      if(!checkNull(compId)){
	  	return false;
	 }
		var sEmail = $('#'+compId+'').val();
        if (!emailFilter(sEmail)) {
	        $('#'+compId+'_spn').empty();
			$('#'+compId+'_spn').html("<font color='red'>Invalid Email Address</font>");
			$('#'+compId).focus();
			return false;
        }else{
        	$('#'+compId+'_spn').empty();
        	return true;
        }
}
	
function emailFilter(sEmail){
    var filter = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
    
    if (filter.test(sEmail)) {
        return true;
    }
    else {
        return false;
    }
 }	
	
function validatePhoneNo(phId){
        var x = $("#"+phId+"").val();
        if (x==null || x=="")
            {
               	$("#"+phId+"_spn").empty();
				$("#"+phId+"_spn").html("<font color='red'>Phone no. cannot be left blank</font>");
                return false;
            }

             if(isNaN(x)|| x.indexOf(" ")!=-1)
            {
			    $("#"+phId+"_spn").empty();
				$("#"+phId+"_spn").html("<font color='red'>Enter numeric value</font>");
               return false;
                }
           if (x.length > 12 || x.length < 10)
             {
    		$("#"+phId+"_spn").empty();
			$("#"+phId+"_spn").html("<font color='red'>Invalid Phone Number</font>");
                 return false;
            }
			$("#"+phId+"_spn").empty();
		return true;
}	
	
function validatePwd(pwdId){
	var pwd1= $("#"+pwdId+"").val();
	if(pwd1.length<8){
		$("#"+pwdId+"_spn").empty();
		$("#"+pwdId+"_spn").html("<font color='red'>Length should not less than 8 character </font>");
		return false;
		}else{
		$("#"+pwdId+"_spn").empty();
	return true;
	}
}

function confPwdCheck(pwdId1,pwdId2){
    var pwd1= $("#"+pwdId1+"").val();
    var pwd2= $("#"+pwdId2+"").val();
    if(pwd2 != pwd1) {
	    $("#"+pwdId2+"_spn").empty();
		$("#"+pwdId2+"_spn").html("<font color='red'>Mismatch password</font>");
	       return false;
	  }
    $("#"+pwdId2+"_spn").empty();
    return true;
}

	

		