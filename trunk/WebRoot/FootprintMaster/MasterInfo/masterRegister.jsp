<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html lang="zh-CN">
<head>
	<title>欢迎使用Footprint</title>

	<meta name="viewport" content="width=device-width, initial-scale=1">

	<link rel="stylesheet" type="text/css" href="<%=basePath %>Plugins/jQuery.mobile/jquery.mobile-1.4.5.min.css" />
	<script type="text/javascript" src="<%=basePath %>Plugins/jQuery/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="<%=basePath %>Plugins/jQuery.mobile/jquery.mobile-1.4.5.min.js"></script>
</head>
<body>
	<div data-role="page">

		<div data-role="header">
			<h1>超级管理员注册</h1>
		</div><!-- /header -->
	
		<div role="main" class="ui-content">
			<p>您的系统还没有超级管理员账号，请注册</p>
			<s:form method="post" namespace="/masterinfo" action="masterRegister">
				<label for="text-basic">名字:</label>
				<input name="name" id="text-basic" value="admin" type="text">
				<label for="text-basic">密码:</label>
				<input name="password" id="text-basic" value="" type="password">
				<button class="ui-shadow ui-btn ui-corner-all" type="submit">注册</button>
			</s:form>
		</div><!-- /content -->
	
	</div><!-- /page -->
</body>

</html>
