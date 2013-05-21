<html>
<head>
<title>Attachment</title>
</head>

<script src="<%=request.getContextPath()%>/js/WebUtil.js"></script>
<script type="text/javascript">

function frmSubmit(){  
// if(checkNull('fileUrl')){
		document.uploadForm.action = "emailAttachment.do";
		document.uploadForm.submit();
		opener.document.getElementById("fileName").innerHTML = document.getElementById("fileUrl").value;
		
	    self.close();
	    return false;
		
	// }
}

</script>


<body>
	<form method="post" enctype="multipart/form-data" name="uploadForm">

		<table id="fileTable">
			<tr>
				<td><input name="fileUrl" type="file" id="fileUrl"
					alt=" File Path" /><span id="fileUrl_spn"></span>
				<td><input type="button" value="Upload" onclick="frmSubmit()" />
				</td>

			</tr>
		</table>
	</form>
</body>
</html>