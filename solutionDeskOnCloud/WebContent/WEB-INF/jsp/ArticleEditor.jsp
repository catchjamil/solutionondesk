<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Article Editor</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script src="<%=request.getContextPath()%>/js/WebUtil.js"></script>	
<script src="<%=request.getContextPath()%>/js/nicEdit.js"></script>
		
	
	

  </head>
  
  <body>
  

<div id="sample">&nbsp; 
  <script type="text/javascript">
  
  
  
//<![CDATA[
  
  	var filePath = "";
  	var entityId = "";
 
  bkLib.onDomLoaded(function(){
	new nicEditor({fullPanel : true, onSave : function(content, id, instance) {
  	var contexPath = "<%=request.getContextPath()%>";
  	var url = contexPath + "/saveArticleData.do";
	var param = "article=" + content+"&id=<%=request.getAttribute("getId")%>&filePath="+filePath;
   	var getResponseValue = doAjaxCall(url,param,"responseValue");
  	filePath = getResponseValue.split(",")[1];
  	entityId = getResponseValue.split(",")[2];
   	disp_confirm(getResponseValue.split(",")[0]);
  } }).panelInstance('textEditor');
});
  
  
  //]]>
  </script>
 <script type="text/javascript">
 function disp_confirm(responseData)
{
	var r=confirm(responseData+" Do you want to Continue Editing ?");

	if (r!=true)
	  {   
		  document.all.exit.href = "articleDisplay.do?entityId="+entityId;
		  document.all.exit.click();
	  }
}

function goBack()
  {
 	 window.history.back();
  }

function onDelete(obj){
	var r = confirm("Are you sure want to delete ?");
	if (r == true)
	  {
   		  var paramVal = "filePath=" + obj.name;
   		  document.all.exit.Methods = "POST";
		  document.all.exit.href = "deleteFile.do?"+paramVal;
		  document.all.exit.click();
		  
	  } 
   
  }

function frmSubmit(){  
if(checkNull('fileUrl')){
		document.uploadForm.action = "saveUploadForm.do";
		document.uploadForm.submit();
	}
}
</script>
 
 
<a id="exit" onclick="goBack()"><font color="blue">Cancel</font></a>

<br/>
  <textarea cols="80" rows="20" id="textEditor">
</textarea>

</div>
<br/>

<form method="post"  enctype="multipart/form-data" name="uploadForm" >
 
    <table id="fileTable">
        <tr>
            <td><input name="fileUrl" type="file" id="fileUrl" alt=" File Path" /><span id ="fileUrl_spn">
            <td><input type="button" value="Upload" onclick="frmSubmit()" />
            <%
            String message = (String)request.getAttribute("message");
            
            message = message != null ? message : "";
            
            out.println(message);
            %></td>
        </tr>
        <tr><th colspan="2"><center>Uploaded File List</center></th></tr>
       <%
       List<String> list = (List<String>)request.getAttribute("fileList");
       if(null!=list){
       String contextPath = request.getContextPath();
       for(String fileName : list){
       %>
       <tr>    
       <td>
       <a href="<%=contextPath+fileName%>"><%=contextPath+fileName%></a>
       
       </td>
       <td><a onclick="onDelete(this)" name="<%=fileName%>">Delete</a></td>
       </tr>
       <%} 
       }else{%>
        <tr>    
       <td colspan="2" align="center">
         No Record Found.
       </td></tr>
       <%} %>
       
       <tr><th colspan="2"><center>Article File List</center></th></tr>
       <%
       List<String> htmlFileList = (List<String>)request.getAttribute("htmlFileList");
       if(null!=htmlFileList){
       String contextPath = request.getContextPath();
       for(String htmlFile : htmlFileList){
       %>
       <tr>    
       <td>
       <a href="<%=contextPath+htmlFile%>"><%=contextPath+htmlFile%></a>
       
       </td>
       <td><a onclick="onDelete(this)" name="<%=htmlFile%>">Delete</a></td>
       </tr>
       <%} 
       }else{%>
        <tr>    
       <td colspan="2" align="center">
         No Record Found.
       </td></tr>
       <%} %>
       
       
    </table>
    
</form>



  </body>
</html>
