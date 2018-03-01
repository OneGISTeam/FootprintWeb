<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html lang="zh-CN">
<head>
	<meta charset="utf-8">
        <meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no">
        <meta name="format-detection" content="telephone=no">
        <title>欢迎使用Footprint</title>
        <link rel="stylesheet" type="text/css" href="Plugins/FrozenUI/css/frozen.css"></link>
        <style>
			body, html {
				position: absolute;
				top: 0;
				bottom: 0;
				left: 0;
				right: 0;
				margin: 0;
				padding: 0;
			}
			#background {
				position: fixed;
				top: 0;
				left: 0;
				z-index: -100;
			}
			.session-content{
				padding:20% 10% 5% 5%;
				text-align:center; 
			}
		</style>
</head>
<body onload="showBubbleEffect()">
	<canvas id="background"></canvas>
	<header class="ui-header ui-header-positive ui-border-b">
		<h1>欢迎使用Footprint</h1>
	</header>
	<section class="session-content">
		<p class="ui-txt-white">
			Footprint是一款提供用户记录其旅行足迹的在线应用系统，通过它你可以记录自己在各个景点的旅游情况，分享拍摄的照片、发布的评论等,
			它可以记录你的实时旅行轨迹，并通过多层次、多方面的可视化效果展现自己所有的旅行轨迹，将你在各个景点的旅行串联，形成故事性的旅行游记，并显示在地图上.
		</p>
	</section>
	<footer class="ui-footer ui-footer-btn">
		<ul class="ui-tiled ui-border-t">
        	<li onclick="window.location = 'enter.action';" class="ui-border-r">开始使用</li>
        </ul>
	</footer>
	
	<script async type="text/javascript" src="Plugins/BubbleEffect/js/bubble.js"></script>
	<script>
		function showBubbleEffect(){
			Bubble("background");
		}
	</script>
</body>
</html>