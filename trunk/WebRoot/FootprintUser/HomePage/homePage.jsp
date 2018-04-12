<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<title>Footprint首页</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<link rel="stylesheet" type="text/css" href="<%=basePath %>/Plugins/jQuery.mobile/jquery.mobile-1.4.5.min.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath %>/Plugins/SwipeSliders/swipeslider.css"/>
	<script type="text/javascript" src="<%=basePath %>/Plugins/jQuery/jquery-2.1.1.min.js"></script>
	<script type="text/javascript">
		$(document).bind("mobileinit", function() {
			//禁用jquery.mobile的ajax跳转
			$.mobile.ajaxEnabled=false;
		});
	</script>
	<script type="text/javascript" src="<%=basePath %>/Plugins/jQuery.mobile/jquery.mobile-1.4.5.min.js"></script>
	<script type="text/javascript" src="<%=basePath %>/Plugins/SwipeSliders/swipeslider.min.js"></script>
</head>
<body>
	<div data-role="page">
		<div data-role="header">
			<div data-role="navbar" data-iconpos="top">
				<ul>
					<li>
						<a href="HomePage.html" data-icon="home" class="ui-btn-active">动态</a>
					</li>
					<li>
						<a href="EventRecord.html" data-icon="carat-r">记录</a>
					</li>
					<li>
						<a href="EventBrowse.html" data-icon="navigation">浏览</a>
					</li>
					<li>
						<a href="UserInfo.html" data-icon="user">用户</a>
					</li>
				</ul>
			</div>
		</div>
		<div role="main" class="ui-content">
    		<figure id="carousel" class="swipslider" style="margin:0"><!-- 轮播图片 -->
				<ul class="sw-slides" style="margin:0">
					<li class="sw-slide">
						<img src="<%=basePath %>/Images/carousel_1.jpg" alt="First picture">
					</li>
					<li class="sw-slide">
						<img src="<%=basePath %>/Images/carousel_2.jpg" alt="Second picture">
					</li>
					<li class="sw-slide">
						<img src="<%=basePath %>/Images/carousel_3.jpg" alt="Third picture">
					</li>
					<li class="sw-slide">
						<img src="<%=basePath %>/Images/carousel_4.jpg" alt="Fourth picture">
					</li>
				</ul>
			</figure><!-- /轮播图片 -->
			<div>
				<input name="password" id="search" value="" placeholder="搜索用户足迹..." type="search">
			</div>
			<ul data-role="listview" data-split-icon="gear" data-split-theme="a" data-inset="true">
			    <li><a href="#">
			        <img style="height:100%" src="<%=basePath %>/Images/carousel_1.jpg">
			    <h2>Broken Bells</h2>
			    <p>Broken Bells</p></a>
			        <a href="#purchase" data-icon="info" data-rel="popup" data-position-to="window" data-transition="pop">Purchase album</a>
			    </li>
			    <li><a href="#">
			        <img style="height:100%" src="<%=basePath %>/Images/carousel_2.jpg">
			    <h2>Warning</h2>
			    <p>Hot Chip</p></a>
			        <a href="#purchase" data-icon="info" data-rel="popup" data-position-to="window" data-transition="pop">Purchase album</a>
			    </li>
			    <li><a href="#">
			        <img style="height:100%" src="<%=basePath %>/Images/carousel_3.jpg">
			    <h2>Wolfgang Amadeus Phoenix</h2>
			    <p>Phoenix</p></a>
			        <a href="#purchase" data-icon="info" data-rel="popup" data-position-to="window" data-transition="pop">Purchase album</a>
			    </li>
			    <!-- 弹出框 -->
			    <div data-role="popup" id="purchase" data-theme="a" data-overlay-theme="b" class="ui-content" style="max-width:340px; padding-bottom:2em;">
				    <h3>Purchase Album?</h3>
				<p>Your download will begin immediately on your mobile device when you purchase.</p>
				    <a href="index.html" data-rel="back" class="ui-shadow ui-btn ui-corner-all ui-btn-b ui-icon-check ui-btn-icon-left ui-btn-inline ui-mini">Buy: $10.99</a>
				    <a href="index.html" data-rel="back" class="ui-shadow ui-btn ui-corner-all ui-btn-inline ui-mini">Cancel</a>
				</div><!-- /弹出框 -->
			</ul>
		</div><!-- /content -->
		<script type="text/javascript">
		    $(window).load(function(){
		    	$("#carousel").swipeslider({
		    		transitionDuration: 1500, 
			        autoPlayTimeout: 4000, 
			        timingFunction: 'cubic-bezier(0.38, 0.96, 0.7, 0.07)'
		    	});
		    	
		    	$()
		    });
		</script>
	</div><!-- /page -->
</body>
</html>