<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<title>欢迎使用Footprint</title>

	<meta name="viewport" content="width=device-width, initial-scale=1">

	<link rel="stylesheet" type="text/css" href="Plugins/jQuery.mobile/jquery.mobile-1.4.5.min.css" />
	<script type="text/javascript" src="Plugins/jQuery/jquery-2.1.1.min.js"></script>
	<script type="text/javascript">
		$(document).bind("mobileinit", function() {
			// disable ajax nav
			$.mobile.ajaxEnabled=false;
		});
	</script>
	<script type="text/javascript" src="Plugins/jQuery.mobile/jquery.mobile-1.4.5.min.js"></script>
</head>
<body>
<div data-role="page">
	<div role="main" class="ui-content">
		<p>欢迎使用Footprint，点击<a href="enter.action">进入</a></p>	
	</div><!-- /content -->
</div><!-- /page -->
</body>
</html>