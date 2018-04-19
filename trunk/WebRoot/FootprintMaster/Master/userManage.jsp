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
	<link rel="stylesheet" type="text/css" href="<%=basePath %>Plugins/jQuery.datatables/datatables.min.css"/>
	<script type="text/javascript" src="<%=basePath %>Plugins/jQuery/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="<%=basePath %>FootprintMaster/Master/master.js"></script>
	<script type="text/javascript">
		$(document).bind("mobileinit", function() {
			//禁用jquery.mobile的ajax跳转
			$.mobile.ajaxEnabled=false;
		});
	</script>
	<script type="text/javascript" src="<%=basePath %>Plugins/jQuery.mobile/jquery.mobile-1.4.5.min.js"></script>
	<script type="text/javascript" src="<%=basePath %>Plugins/jQuery.datatables/datatables.min.js"></script>
</head>
<body>
	<div data-role="page" class="jqm-master jqm-home">
		<div data-role="header" class="jqm-header">
			<h2><img alt="footprint" src="<%=basePath %>Images/footprint-icon.png"></h2>
			<p>超级管理员页面</p>
			<a href="#" class="jqm-search-link ui-btn ui-btn-icon-notext ui-corner-all ui-icon-search ui-nodisc-icon ui-alt-icon ui-btn-right">搜索</a>
		</div>
		
		<div role="main" class="ui-content jqm-content" align="center">	
			<h3>用户列表</h3>
			<input id="table_data" type="hidden" value="<%=request.getAttribute("usersJsonString") %>" />
			<table id="table_users" class="table table-border table-bordered table-bg table-hover table-sort" style="width:100%">
				<thead>
					<tr>
						<th>标识</th>
						<th>头像</th>
						<th>姓名</th>
						<th>密码</th>
						<th>角色</th>
						<th>性别</th>
					</tr>
				</thead>
				<!-- 异步加载数据 -->
			</table>
		</div>
		<!-- 添加pannel，动态链接方式，需要jsp重新编译 -->
		<jsp:include page="pannel.jsp" flush="true"/>
		
		<div data-role="footer" data-position="fixed" data-tap-toggle="false" class="jqm-footer">
			<p>Footprint 1.0.1</p>
			<p>Copyright 2018 全空间信息系统实验室</p>
		</div><!-- /footer -->
	</div>
	<script type="text/javascript">		 		
		$(document).ready(function(){
			var tableData = '${usersJsonString}';
				
			$("#table_users").DataTable({
				"data":JSON.parse(tableData),
				"columns":[
					{"data":"userid"},
					{
						"data":"portrait",
						"render":function(data,type,row){
							if(data!=null){
								var img = '<img style="width:30px;height:30px" src="' + data + '"/>';
								return img;
							}
						}
					},
					{"data":"name"},
					{"data":"password"},
					{"data":"role.name"},
					{
						"data":"sex",
						"render":function(data,type,row){
							if(data == 1){
								return "男";
							}else
								return "女";
						}
					}
				]
			});
		});
	</script>
</body>
</html>
