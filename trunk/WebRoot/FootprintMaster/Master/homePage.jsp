<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<title>超级管理员页面</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>Plugins/jQuery.mobile/jquery.mobile-1.4.5.min.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath %>FootprintMaster/Master/master.css" />
	<script type="text/javascript" src="<%=basePath %>Plugins/jQuery/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="<%=basePath %>FootprintMaster/Master/master.js"></script>
	<script type="text/javascript">
		$(document).bind("mobileinit", function() {
			//禁用jquery.mobile的ajax跳转
			$.mobile.ajaxEnabled=false;
		});
	</script>
	<script type="text/javascript" src="<%=basePath %>Plugins/jQuery.mobile/jquery.mobile-1.4.5.min.js"></script>
</head>
<body>
	<div data-role="page" class="jqm-master jqm-home">
		<div data-role="header" class="jqm-header">
			<h2><img alt="footprint" src="<%=basePath %>Images/footprint-icon.png"></h2>
			<p>超级管理员页面</p>
			<a href="#" class="jqm-search-link ui-btn ui-btn-icon-notext ui-corner-all ui-icon-search ui-nodisc-icon ui-alt-icon ui-btn-right">搜索</a>
		</div>
		
		<div role="main" class="ui-content jqm-content" align="center">				
			<h3>超级管理员主界面</h3>
		</div>
		<!-- 添加pannel，动态链接方式，需要jsp重新编译 -->
		<jsp:include page="pannel.jsp" flush="true"/>
		<div data-role="footer" data-position="fixed" data-tap-toggle="false" class="jqm-footer">
			<p>Footprint 1.0.1</p>
			<p>Copyright 2018 全空间信息系统实验室</p>
		</div><!-- /footer -->
		
		
	</div>
</body>
</html>
