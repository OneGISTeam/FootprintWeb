<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- pannel -->
<div data-role="panel" class="jqm-navmenu-panel" data-position="left" data-display="overlay" data-theme="a">
	<ul class="jqm-list ui-alt-icon ui-nodisc-icon">
		<li data-filtertext="master homepage" data-icon="home"><a href="<%=basePath %>masterinfo/login.action?name=<%=request.getAttribute("name")%>&password=<%=request.getAttribute("password") %>">超管主页</a></li>
		<li data-role="collapsible" data-enhanced="true" data-collapsed-icon="carat-d" data-expanded-icon="carat-u" data-iconpos="right" data-inset="false" class="ui-collapsible ui-collapsible-themed-content ui-collapsible-collapsed">
			<h3 class="ui-collapsible-heading ui-collapsible-heading-collapsed">
				<a href="#" class="ui-collapsible-heading-toggle ui-btn ui-btn-icon-right ui-btn-inherit ui-icon-carat-d">
				    管理<span class="ui-collapsible-heading-status"> click to expand contents</span>
				</a>
			</h3>
			<div class="ui-collapsible-content ui-body-inherit ui-collapsible-content-collapsed" aria-hidden="true">
				<ul>
					<li data-filtertext="form checkboxradio widget checkbox input checkboxes controlgroups"><a href="<%=basePath %>master/users.action?name=<%=request.getAttribute("name")%>&password=<%=request.getAttribute("password") %>" data-ajax="false">用户列表</a></li>
					<li data-filtertext="form checkboxradio widget radio input radio buttons controlgroups"><a href="../checkboxradio-radio/" data-ajax="false">管理员列表</a></li>
				</ul>
			</div>
		</li>
	</ul>
</div>