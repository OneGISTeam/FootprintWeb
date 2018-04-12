<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<title>超级管理员登录页面</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>Plugins/jQuery.mobile/jquery.mobile-1.4.5.min.css" />
	<script type="text/javascript" src="<%=basePath %>Plugins/jQuery/jquery-2.1.1.min.js"></script>
	<script type="text/javascript">
		$(document).bind("mobileinit", function() {
			//禁用jquery.mobile的ajax跳转
			$.mobile.ajaxEnabled=false;
		});
	</script>
	<script type="text/javascript" src="<%=basePath %>Plugins/jQuery.mobile/jquery.mobile-1.4.5.min.js"></script>
</head>
<body>
	<div data-role="page">
		<div data-role="header">
			<h1>超级管理员登录</h1>
		</div>
		
		<div data-role="main" class="ui-content">				
			<s:form method="post" namespace="/masterinfo" action="login">
				<label for="text-basic">名字:</label>
				<input name="name" id="text-basic" value="" type="text">
				<label for="text-basic">密码:</label>
				<input name="password" id="text-basic" value="" type="password">
				<button class="ui-shadow ui-btn ui-corner-all" type="submit">登录</button>
			</s:form>
		</div>
	</div>
</body>
</html>
