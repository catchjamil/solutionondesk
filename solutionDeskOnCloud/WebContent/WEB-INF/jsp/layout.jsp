<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>

<link rel="stylesheet" type="text/css" href="css/style.css"
	media="screen">

<link rel="stylesheet" type="text/css" href="css/superfish.css"
	media="screen">
<script type="text/javascript" src="js/jquery-1.2.6.min.js"></script>
<script type="text/javascript" src="js/hoverIntent.js"></script>
<script type="text/javascript" src="js/superfish.js"></script>
<script type="text/javascript">

		// initialise plugins
		jQuery(function(){
			jQuery('ul.sf-menu').superfish();
		});

		</script>

</head>
<body>
	<div id="page_wrapper">
		<div id="header_wrapper">
			<div id="header">
				<tiles:insertAttribute name="header" />
			</div>


		</div>
		<div id="menu_wrapper">
			<tiles:insertAttribute name="menu" />

		</div>

		<div id="right_side">
			<tiles:insertAttribute name="rightMenu" />
		</div>


		<div id="content">


			<div class="featurebox_center">

				<tiles:insertAttribute name="body" />
			</div>
		</div>


		<div id="footer">
			<tiles:insertAttribute name="footer" />
		</div>

	</div>

</body>
</html>


