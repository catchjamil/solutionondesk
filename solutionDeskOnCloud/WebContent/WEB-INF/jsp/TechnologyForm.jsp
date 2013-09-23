<%@ taglib prefix="core" uri="http://java.sun.com/jstl/core" %>


<html>
	<head>
		<title>Technology</title>
	</head>
	
	<script src="<%=request.getContextPath()%>/js/jquery.js"></script>
		<script type="text/javascript">
		var contexPath = "<%=request.getContextPath()%>";
</script>
		<script src="<%=request.getContextPath()%>/js/WebUtil.js"></script>

		<script type="text/javascript">
    var url = contexPath + "/technologyList.do";
	
	// window.onload = techOnload();
	
		function techOnload(){
		
		$('#userTech').hide(1);
	    $('#userChapter').hide(1);
		}
		
	  function onClickTopic(){
	  $('#userTech').show(1);
	  $('#userChapter').show(1);
	  
	  
		$('#chapterName').hide(1);
		$('#techName').hide(1);
	  
	  doAjaxCall(url,"","userTech");
	  }
	
	function onClickChapter(){
	
		$('#userTech').show(1);
		$('#techName').hide(1);
		
		doAjaxCall(url,"","userTech");
		
		
	}
	
	function onChangeTech(){
	url = contexPath + "/technologyList.do";
		var param = "techName=" + $('#userTech').val();
		doAjaxCall(url,param,"userChapter");
	}
	
	function onClickTech(){
		$('#userTech').hide(1);
	    $('#userChapter').hide(1);
	    
		$('#chapterName').show(1);
		$('#techName').show(1);
	}

function onFrmSubmit(){
	checkNullTextBox(document.forms.techName);
	checkNullTextBox(document.forms.chapterName);
	checkNullTextBox(document.forms.topicName);
}
</script>
	
	
	
	<body onload="techOnload()">
		<center>
			<br />

			<form method="post" action="/SolutionDesk/technology.do" onsubmit="onFrmSubmit()">
				<table width="100%" border="1">
					<tr>
						<td align="center" bgcolor="lightblue">
							Technology
						</td>
					</tr>
					<tr>
						<td>
							<table border="0" width="100%">
								<tr>
									<td width="33%" align="right">
										Technology
										<input type="radio" name="type" onclick="onClickTech()"/>
										
									</td>

									<td width="33%" align="right">
										Chapter
										<input type="radio" name="type" onclick="onClickChapter()" />
										

									</td>

									<td width="33%" align="right">
										Topic
										<input type="radio" name="type" onclick="onClickTopic()"/>
									</td>

								</tr>
								<tr>
									<td width="33%" align="right">
										Technology

										<spring:bind path="TechnologyForm.techName">
											<input type="text" name="techName" id="techName"
												value="<core:out value="${status.value}"/>" />
										</spring:bind>
										<font color="red">*</font>
										<select id="userTech" onchange="onChangeTech()">
										</select>
									
										
									</td>

									<td width="33%" align="right">
										Chapter

										<spring:bind path="TechnologyForm.chapterName">
											<input type="text" name="chapterName" id="chapterName"
												value="<core:out value="${status.value}"/>" />
										</spring:bind>
										<font color="red">*</font>
											<select id="userChapter" >

											</select>
									</td>

									<td width="33%" align="right">
										Topic

										<spring:bind path="TechnologyForm.topicName">
											<input type="text" name="topicName"
												value="<core:out value="${status.value}"/>" />
										</spring:bind>
										<font color="red">*</font>
									</td>

								</tr>

								<tr>
									<td align="center" colspan="2">
										<input type="submit" alignment="center" value="Submit">
									</td>
									<td align="center" colspan="2">
										<a href="technologyList.do">Cancel</a>
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