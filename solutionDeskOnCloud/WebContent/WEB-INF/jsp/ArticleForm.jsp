<%@ taglib prefix="core" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
	<head>
		<meta http-equiv="Content-Type"
			content="text/html; charset=ISO-8859-1">
		<title>Article Form</title>
<script src="<%=request.getContextPath()%>/js/jquery.js"></script>
		<script type="text/javascript">
		var contexPath = "<%=request.getContextPath()%>";
</script>
		<script src="<%=request.getContextPath()%>/js/WebUtil.js"></script>

		<script type="text/javascript">
    var url = contexPath + "/technologyList.do";
	 window.onload = doAjaxCall(url,"","userTech");
	
	function getChapterList(){
		url = contexPath + "/technologyList.do";
		var param = "techName=" + $('#userTech').val();
		doAjaxCall(url,param,"userChapter");
	}

function getTopicList(){
	url = contexPath + "/technologyList.do";
	var param = "techName=" + $('#userTech').val() + "&chapterName=" + $('#userChapter').val();
	doAjaxCall(url,param,"userTopic");
}
</script>

	</head>
	<body>
		<center>

			<form method="post" action="/SolutionDesk/article.do">
				<table width="100%" border="1" height="100%">
					<tr height="5%">
						<td align="center" bgcolor="lightblue">
							Article
						</td>
					</tr>
					<tr>
						<td>
							<table border="0" width="100%">
								<tr>

									<td width="10%" align="center">
										Article
										<input type="radio" name="articleType" value="Article" />
									</td>
									<td width="10%" align="center">
										Objective Q & A
										<input type="radio" name="articleType" value="ObjectiveQA" />
									</td>

									<td width="10%" align="center">
										Subjective Q & A
										<input type="radio" name="articleType" value="SubjectiveQA" />

									</td>
								</tr>
								<tr>
									<td width="10%" align="center">
										Technology
										<select id="userTech" onchange="getChapterList()">
										</select>
										<spring:bind path="ArticleForm.techName">
											<input type="hidden" name="technology"
												value="<core:out value="${status.value}"/>" />
										</spring:bind>
									</td>

									<td width="10%" align="center">
										Chapter

										<spring:bind path="ArticleForm.chapterName">
											<select id="userChapter" onchange="getTopicList()">

											</select>
											<input type="hidden" name="chapter"
												value="<core:out value="${status.value}"/>" />
										</spring:bind>
									</td>

									<td width="10%" align="center">
										Topic

										<select id="userTopic">

										</select>
										<spring:bind path="ArticleForm.topicName">
											<input type="hidden" name="topic"
												value="<core:out value="${status.value}"/>" />
										</spring:bind>
									</td>

								</tr>
								<tr>
									<td>
										Description/Question
									</td>
									<td>

										<spring:bind path="ArticleForm.description">
											<textarea name="topic" rows="10" cols="70"
												value="<core:out value="${status.value}"/>"> </textarea>


										</spring:bind>


									</td>
								</tr>

								<tr>
									<td>
										Answer
									</td>
									<td>

										<spring:bind path="ArticleForm.answer">
											<textarea name="answer" rows="10" cols="70"
												value="<core:out value="${status.value}"/>"> </textarea>


										</spring:bind>


									</td>
								</tr>

								<tr>
									<td width="33%" align="right">
										Option 1

										<spring:bind path="ArticleForm.option1">

											<input type="text" name="option1"
												value="<core:out value="${status.value}"/>" />
										</spring:bind>
										Answer
										<input type="checkbox" name="1" value="1" />
									</td>

									<td width="33%" align="right">
										Option 2

										<spring:bind path="ArticleForm.option2">

											<input type="text" name="option2"
												value="<core:out value="${status.value}"/>" />
										</spring:bind>
										Answer
										<input type="checkbox" name="2" value="2" />
									</td>
									<td width="33%" align="right">
										Option 3

										<spring:bind path="ArticleForm.option3">

											<input type="text" name="option3"
												value="<core:out value="${status.value}"/>" />
										</spring:bind>
										Answer
										<input type="checkbox" name="3" value="3" />
									</td>
									<td width="33%" align="right">
										Option 4

										<spring:bind path="ArticleForm.option4">

											<input type="text" name="option4"
												value="<core:out value="${status.value}"/>" />
										</spring:bind>
										Answer
										<input type="checkbox" name="4" value="4" />
									</td>


								</tr>
								<tr>
									<td align="center" colspan="2">
										<input type="submit" alignment="center" value="Submit">
									</td>
									<td align="center" colspan="2">
										<a href="articleDisplay.do"> Cancel</a>
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