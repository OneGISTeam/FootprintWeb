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
			<h3>添加管理员</h3>			
		  	<s:form method="post" namespace="/master" action="addAdmin" enctype="multipart/form-data" data-ajax="false">
		      <div data-role="fieldcontain">
		      	<div align="center">
		      		<img style="width:80px;height:80px;border-radius:50%" id="portrait_img" src="<%=basePath %>Images/default.gif">
		      		<input name="portrait" onchange="previewImage(this);" id="portrait_File" type="file" accept="image/*" capture="camera" multiple/>
		      	</div>
		      	<div class="ui-field-contain">
		      		<label for="name">用户名：</label>
		       		<input type="text" name="name" id="name" placeholder="请输入用户名">    
		      	</div>
		      	<div class="ui-field-contain">
		      		<label for="password">密码：</label>
		       		<input type="password" name="password" id="password" placeholder="请输入密码">
		      	</div>
		        <div class="ui-field-contain">
		        	<label for="repassword">确认密码：</label>
		        	<input type="password" name="repassword" id="repassword" placeholder="请再次输入密码">
		        </div>
		        <div class="ui-field-contain">
		        	<label for="controlgroup">请选择您的性别：</label>
			        <fieldset data-role="controlgroup">
			        	<label for="sex_male">男性</label>
				        <input type="radio" name="sex" id="sex_male" value="true">
				        <label for="sex_female">女性</label>
				        <input type="radio" name="sex" id="sex_female" value="false">	
			        </fieldset>
		      	</div>
		      </div>
		      <div class="ui-grid-a">
		      	<div class="ui-block-a">
		      		<button class="ui-shadow ui-btn ui-corner-all" type="submit">注册</button>
		      	</div>
		      	<div class="ui-block-b">
		      		<button class="ui-shadow ui-btn ui-corner-all">返回</button>
		      	</div>
		      </div>
		    </s:form>
		</div>
		<!-- 添加pannel，动态链接方式，需要jsp重新编译 -->
		<jsp:include page="pannel.jsp" flush="true"/>
		<div data-role="footer" data-position="fixed" data-tap-toggle="false" class="jqm-footer">
			<p>Footprint 1.0.1</p>
			<p>Copyright 2018 全空间信息系统实验室</p>
		</div><!-- /footer -->
		
		
	</div>
	<script type="text/javascript">
		$(function(){
			//获取浏览器的userAgent，并转化为小写
			var userAgent = navigator.userAgent.toLowerCase();
			//判断是否是苹果手机，是则为true
			var isIOS = (userAgent.indexOf('iphone') != -1) || (userAgent.indexOf('ipad') != -1);
			if(isIOS){
				$("#portrait_File").removeAttr("capture");
			} 
			
			$("#portrait_File").hide();
			
			$("#portrait_img").on("click", function(){	
				$("#portrait_File").click();
			});	
		});
		
		function previewImage(object){
			var objectURL = window.URL.createObjectURL(object.files[0]);
			document.getElementById("portrait_img").src = objectURL;
		}
		
		//构建存取file的URL
		function getObjectURL(file){
			var url = null;
			if(window.createObjectURL != undefined){ //basic
				url = window.createObjectURL(file);
			}else if(window.URL != undefined){ //mozilla(firefox)
				url = window.URL.createObjectURL(file);
			}else if(window.webkitURL != undefined){ //webkit or chrome
				url = window.webkitURL.createObjectURL(file);
			}
			return url;
		}
	</script>
</body>
</html>
