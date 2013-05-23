
<%@page import="com.sd.web.dto.ObjectiveQADTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sd.web.security.Ticket"%>
<%@page import="com.sd.web.enums.Roles"%><%@ taglib prefix="core" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
	<head>
		<meta http-equiv="Content-Type"
			content="text/html; charset=ISO-8859-1">
		<title>Article Form</title>
		<script src="<%=request.getContextPath()%>/js/jquery.js"></script>
		<script type="text/javascript">
		var contexPath = "<%=request.getContextPath()%>";
		<% List<ObjectiveQADTO> objectiveQAList = (List<ObjectiveQADTO>)request.getAttribute("ObjectiveQAList"); 
		Long entityId = 0l;
		if(objectiveQAList != null && objectiveQAList.size() > 0){
			entityId = objectiveQAList.get(0).getTechnologyId(); 
		}else{
		    objectiveQAList = new ArrayList<ObjectiveQADTO>(); 
		}
		
		%>
</script>
		<script src="<%=request.getContextPath()%>/js/WebUtil.js"></script>

		<script type="text/javascript">
		
		function imposeMaxLength(Object, MaxLen)
			{
			  return (Object.value.length <= MaxLen);
			}
		
		function frmSubmit(){
   var status = true; 
	if(2 > document.getElementById("question").value.length){
		$("#question_spn").html("<font color='red'>Please Write Question. </font>");
		 status = false;
	}else{
	  $("#question_spn").html("");
	}
		
	if(!checkNull('option1')){
		status = false;
	}
	if(!checkNull('option2')){
		status = false;
	}
	if(!checkNull('option3')){
		status = false;
	}
	if(!checkNull('option4')){
		status = false;
	}
	
	var answerChecked = false;
	var checkObj = document.getElementsByName("answer");
	for(var i = 0; i<checkObj.length; i++){
	  if(checkObj[i].checked){
	    	answerChecked = true;
	  }
	}
	if(!answerChecked)
	{
		$("#answer_spn").html("<font color='red'>Please at least select one answer. </font>");
		status = false;
	}else{
	$("#answer_spn").html("");
	}
	if(status){
		document.ObjectiveQAForm.action = "/SolutionDesk/saveObjectiveQAData.do";
 		document.ObjectiveQAForm.submit();
	 }	
}
function edit(Id){
    document.getElementById("editData"+Id).href = "editModeObjectiveQAData.do?Id="+Id;
	
}
function deleteData(Id){

	var r = confirm("Are you sure want to delete?");

	if (r == true)	  {   
		document.getElementById("deleteData"+Id).href  = "deleteObjectiveQAData.do?Id="+Id+"&entityId=<%=entityId%>";
	  }

}	
    
function checkAnswer(obj){

	var objValue = obj.value.split(",");
	var ansList = document.getElementsByName(obj.name);
	var checkValue = ""; 
	for(var i = 0; i<ansList.length; i++ ){
		if(ansList[i].checked){
			checkValue = checkValue + ansList[i].alt+",";
		}
	}
	
	var checkValueArray = checkValue.split(",");
	var checkValueArrayLen = checkValueArray.length - 1;

	if(checkValueArrayLen == objValue.length ){
	
		for(var i = 0; i<checkValueArrayLen; i++ ){
	
			if (obj.value.indexOf(checkValueArray[i]) == -1){
				
				$("#"+obj.name+"_answer_spn").html("<font color='red'>Oops, Wrong Answer </font><font color='green'>Correct Answer : "+obj.value+"</font>");
				
				for(var k = 0; k<ansList.length; k++ ){
					ansList[k].disabled = true;
				}
				
				return;
			}
			
		}
		 $("#"+obj.name+"_answer_spn").html("<font color='green'>Congratulation, Correct Answer </font>");
		 for(var j = 0; j<ansList.length; j++ ){
			 
			 ansList[j].disabled = true;	
			}
	}
}    
</script>

	</head>
	<body>
	
	
	<% 
Ticket ticket = (Ticket)request.getSession().getAttribute("ticket");
 if(ticket != null && (Roles.ADMIN.toString().equalsIgnoreCase(ticket.getRole()) ||  Roles.CONTRIBUTOR.toString().equalsIgnoreCase(ticket.getRole()))){
%>
	<a href="objectiveQAForm.do?entityId=<%=request.getAttribute("entityId")%>">Add New</a>
<%
}
%>	
	
	
		<center>
         <% 
         if(objectiveQAList != null && objectiveQAList.size() > 0){
         for( ObjectiveQADTO objectiveQADTO : objectiveQAList){
         
         %>
				<table width="100%" border="1" height="100%">
					
					<tr>
						<td>
							<table border="0" width="100%">
								<tr>
									<td >
										<b>Question <%= objectiveQADTO.getId()%>: <%=objectiveQADTO.getQuestion() %> </b>
									</td>

									
								</tr>


								<tr>
									<td width="33%" align="left" colspan="2">
									
										<input type="checkbox" name="<%=objectiveQADTO.getId()%>" value="<%=objectiveQADTO.getAnswer()%>" alt="1" onclick="checkAnswer(this)" />
										<%=objectiveQADTO.getOption1() %>
										<span id ="<%=objectiveQADTO.getId()%>_answer_spn"></span>
									</td>
								</tr>
								<tr>
									<td width="33%" align="left"  colspan="2">
											<input type="checkbox" name="<%=objectiveQADTO.getId()%>" value="<%=objectiveQADTO.getAnswer()%>" alt="2" onclick="checkAnswer(this)" /> 
										<%=objectiveQADTO.getOption2() %>
									</td>
								</tr>
								<tr>

									<td width="33%" align="left"  colspan="2">
										<input type="checkbox" name="<%=objectiveQADTO.getId()%>" value="<%=objectiveQADTO.getAnswer()%>" alt="3" onclick="checkAnswer(this)"/> 
										<%=objectiveQADTO.getOption3() %>
									</td>
								</tr>
								<tr>

									<td width="33%" align="left"  colspan="2">

										<input type="checkbox" name="<%=objectiveQADTO.getId()%>" value="<%=objectiveQADTO.getAnswer()%>" alt="4" onclick="checkAnswer(this)"/> 
										
										<%=objectiveQADTO.getOption4() %>
									</td>

								</tr>
								
					<% if(ticket != null && (Roles.ADMIN.toString().equalsIgnoreCase(ticket.getRole()) ||  (objectiveQADTO.getCreatedBy().equals( ticket.getId().toString())))){
									%>
								
								<tr>
									<td align="right" colspan="2">
										<a id="editData<%=objectiveQADTO.getId()%>" onclick ="edit('<%=objectiveQADTO.getId() %>')">Edit</a>
									
										<a id="deleteData<%=objectiveQADTO.getId()%>" onclick ="deleteData('<%=objectiveQADTO.getId()%>')">Delete</a>
									</td>
								</tr>
							<%} %>	
							</table>
                          
						</td>
					</tr>
				</table>
            <%}
         }
         %>

		</center>

	</body>
</html>