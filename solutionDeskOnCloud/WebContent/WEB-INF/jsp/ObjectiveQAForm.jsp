<%@page import="com.sd.web.form.ObjectiveQAForm"%>
<%@page import="java.util.List"%>
<%@page import="com.sd.web.dto.ObjectiveQADTO"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Article Form</title>
<script src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script type="text/javascript">
		var contexPath = "<%=request.getContextPath()%>";
</script>
<script src="<%=request.getContextPath()%>/js/WebUtil.js"></script>
<%ObjectiveQAForm objectiveQAForm = (ObjectiveQAForm)request.getAttribute("objectiveQAForm"); 


%>


<script type="text/javascript">
		var mode = '<%=request.getAttribute("mode")%>';
	window.onload = function() {
		
		document.ObjectiveQAForm.id.value = '<%=objectiveQAForm.getId() != null ? objectiveQAForm.getId() : ""%>';
		document.ObjectiveQAForm.technologyId.value = '<%=objectiveQAForm.getTechnologyId()  != null ? objectiveQAForm.getTechnologyId() : ((ObjectiveQAForm)request.getAttribute("objectiveQAForm")).getTechnologyId() %>';
		document.ObjectiveQAForm.question.value = '<%=objectiveQAForm.getQuestion()  != null ? objectiveQAForm.getQuestion() : ""%>';
		document.ObjectiveQAForm.option1.value = '<%=objectiveQAForm.getOption1()  != null ? objectiveQAForm.getOption1() : ""%>';
		document.ObjectiveQAForm.option2.value = '<%=objectiveQAForm.getOption2()  != null ? objectiveQAForm.getOption2() : ""%>';
		document.ObjectiveQAForm.option3.value = '<%=objectiveQAForm.getOption3()  != null ? objectiveQAForm.getOption3() : ""%>';
		document.ObjectiveQAForm.option4.value = '<%=objectiveQAForm.getOption4()  != null ? objectiveQAForm.getOption4() : ""%>';
	
		if (mode == 'edit') {
			var checkedVal = '<%=objectiveQAForm.getAnswer()  != null ? objectiveQAForm.getAnswer() : ""%>';
			var checkVarArr = checkedVal.split(",");
			for ( var i = 0; i < checkVarArr.length; i++) {
				document.all.answer[checkVarArr[i] - 1].checked = "checked";
			}
		}
	}
	function imposeMaxLength(Object, MaxLen) {
		return (Object.value.length <= MaxLen);
	}

	function frmSubmit() {
		var status = true;
		if (2 > document.getElementById("question").value.length) {
			$("#question_spn").html(
					"<font color='red'>Please Write Question. </font>");
			status = false;
		} else {
			$("#question_spn").html("");
		}

		if (!checkNull('option1')) {
			status = false;
		}
		if (!checkNull('option2')) {
			status = false;
		}
		if (!checkNull('option3')) {
			status = false;
		}
		if (!checkNull('option4')) {
			status = false;
		}

		if (!checkAnswer()) {
			$("#answer_spn").html("<font color='red'>Please at least select one answer. </font>");
			status = false;
		} else {
			$("#answer_spn").html("");
		}
		if (status) {
			if ("edit" == mode) {
				document.ObjectiveQAForm.action = contexPath + "/editObjectiveQAData.do";
			} else {
				document.ObjectiveQAForm.action = contexPath + "/saveObjectiveQAData.do";
			}
			document.ObjectiveQAForm.submit();
		}
	}

	function checkAnswer() {
		var checkObj = document.getElementsByName("answer");
		for ( var i = 0; i < checkObj.length; i++) {
			if (checkObj[i].checked) {
				return true;
			}
		}
		return true;
	}
</script>

</head>
<body>

		<form method="post" name="ObjectiveQAForm">
			<table >
				<tr >
					<td align="center" colspan="3">Objective QA</td>
				</tr>

				<tr>
					<td>Question</td>
					<td colspan="2"><spring:bind path="objectiveQAForm.question">
							<textarea name="question" rows="3" cols="80" id="question"
								 onkeypress="return imposeMaxLength(this, 500);"> </textarea>
							<span id="question_spn"></span>
						</spring:bind></td>
						
				</tr>


				<tr>
					<td >Option 1</td><td>
					 <spring:bind path="objectiveQAForm.option1">

							<input type="text" name="option1" id="option1" alt="option1"
								maxlength="200" />
							<span id="option1_spn"></span>
						</spring:bind>
					</td><td valign="top" width="500">
					 <spring:bind path="objectiveQAForm.answer">
							
						</spring:bind> Answer <input type="checkbox" name="answer" value="1" /> <span id="answer_spn" ></span>
					
			<spring:bind path="objectiveQAForm.id">
				<input type="hidden" name="id" />
			</spring:bind>

			<spring:bind path="objectiveQAForm.technologyId">
				<input type="hidden" name="technologyId" />
			</spring:bind>

			</td>
			</tr>
			
			
				<tr>
					<td >Option 2</td><td>
					 <spring:bind path="objectiveQAForm.option2">

							<input type="text" name="option2" id="option2" alt="option2"
								maxlength="200" />
							<span id="option2_spn"></span>
						</spring:bind>
					</td><td valign="top" width="500">
					 <spring:bind path="objectiveQAForm.answer">
							
						</spring:bind> Answer <input type="checkbox" name="answer" value="2" /> <span id="answer_spn" ></span>
			</td></tr>
			
							<tr>
					<td >Option 3</td><td>
					 <spring:bind path="objectiveQAForm.option2">

							<input type="text" name="option3" id="option3" alt="option3"
								maxlength="200" />
							<span id="option3_spn"></span>
						</spring:bind>
					</td><td valign="top" width="500">
					 <spring:bind path="objectiveQAForm.answer">
							
						</spring:bind> Answer <input type="checkbox" name="answer" value="3" /> <span id="answer_spn" ></span>
			</td></tr>
			
							<tr>
					<td >Option 4</td><td>
					 <spring:bind path="objectiveQAForm.option4">

							<input type="text" name="option4" id="option4" alt="option4"
								maxlength="200" />
							<span id="option4_spn"></span>
						</spring:bind>
					</td><td valign="top" width="500">
					 <spring:bind path="objectiveQAForm.answer">
							
						</spring:bind> Answer <input type="checkbox" name="answer" value="4" /> <span id="answer_spn" ></span>
			</td></tr>
			
			
			<tr>
									<td align="right" colspan="2">
										<input type="button" alignment="center"  id="actionButton" value="Submit" onclick ="frmSubmit()">
									</td>
									<td align="left" >
										<input type="button" alignment="center"  id="cancelButton" value="Cancel" onclick ="window.history.back()">
									</td>
								</tr>
			
			
			</table>

		</form>


</body>
</html>
