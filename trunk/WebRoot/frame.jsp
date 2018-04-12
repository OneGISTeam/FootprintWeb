<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<title>XXX</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>/Plugins/jQuery.mobile/jquery.mobile-1.4.5.min.css" />
	<script type="text/javascript" src="<%=basePath %>/Plugins/jQuery/jquery-2.1.1.min.js"></script>
	<script type="text/javascript">
		$(document).bind("mobileinit", function() {
			//禁用jquery.mobile的ajax跳转
			$.mobile.ajaxEnabled=false;
		});
	</script>
	<script type="text/javascript" src="<%=basePath %>/Plugins/jQuery.mobile/jquery.mobile-1.4.5.min.js"></script>
</head>
<body>
	<div data-role="page">
		<div data-role="header">
			<h1>XXX</h1>
		</div>
		
		<div role="main" class="ui-content" align="center">				
			
		</div>
	</div>
</body>
</html>
