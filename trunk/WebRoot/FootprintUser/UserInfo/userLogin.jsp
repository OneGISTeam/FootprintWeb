<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<title>Footprint用户登录页面</title>
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
			<h1>登录Footprint</h1>
		</div>
		
		<div role="main" class="ui-content" align="center">				
			<img style="width:80px" id="footprint" src="Images/mark.png" />
			<s:form id="id_form" namespace="/userinfo" action="login" method="post">
				<div class="ui-field-contain">
					<table>
						<tbody>
							<tr>
								<td width="40">
									<img style="width:30px" class="icon" title="用户" alt="用户" src="Images/user-photo.png" />
								</td>
								<td width="460" class="tdinput" id="id_username">
									<input type="text" name="name" id="username" placeholder="用户名/账号" />
								</td>
							</tr>
							<tr>
								<td>
									<img style="width:30px" class="icon" title="密码" alt="密码" src="Images/pwd-photo.png" />
								</td>
								<td>
									<input type="password" name="password" id="password" placeholder="密码"  />
								</td>
							</tr>
						</tbody>
					</table>
					<select name="switch" id="switch" data-role="slider">
						<option value="on">保存</option>
						<option value="off">不保存</option>
					</select>
					<input type="submit" data-role="button" id="btn_submit" value="登     录"/>
				</div>
				<div class="bottom" align="center">
					<a class="register" href="FootprintUser/UserInfo/userRegister.jsp" data-transition="slide">注册账号</a>
					<a class="lastps" href="#" data-transition="slide">忘记密码</a>
				</div>
			</s:form>
		</div>
	</div>
</body>
</html>
