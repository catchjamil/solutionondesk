<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<link rel="stylesheet" type="text/css" href="css/common.css"	media="screen">
</head>
<body>
<table align="center">
	<%try{ %>
	<tr>
		<td height="50" colspan="2"><tiles:insertAttribute name="header" />
		</td>
	</tr>
	<tr ><td colspan="2"><tiles:insertAttribute name="menu" /></td></tr>
	<tr valign="top">
		
		<td width="500" height="500"><tiles:insertAttribute name="body" /></td>
		<td width="75" align="right" ><tiles:insertAttribute name="rightMenu" /></td>
	</tr>
	<tr>
		<td height="30" colspan="2"><tiles:insertAttribute name="footer" />
		</td>
	</tr>
	<%}catch(Exception e){
		e.printStackTrace();
	}
	 %>
</table>
</body>
</html>
