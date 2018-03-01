<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html lang="zh-CN">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no">
        <meta name="format-detection" content="telephone=no">
        <title>Footprint登录页面</title>
        <link rel="stylesheet" href="Plugins/FrozenUI/css/frozen.css">
    </head>
    <body>
        <header class="ui-header ui-header-positive ui-border-b">
            <h1>登录</h1>
        </header>
        <section class="ui-container" align="center">
	        <section id="avatar">
		        <div class="demo-block" align="center">
					<ul class="ui-list ui-list-pure">
						<li class="ui-border-t">
							<div class="ui-avatar-lg">
						     	<span style="background-image:url(http://placeholder.qiniudn.com/140x140)"></span>
						 	</div>
						</li>
					</ul>
		        </div>
		        <div class="demo-block">
		            <div class="ui-form ui-border-t">
		                <form action="#" >
		                    <div class="ui-form-item ui-form-item-show ui-border-b">
		                        <label for="#">用户名</label>
		                        <input type="text">
		                    </div>
		                    <div class="ui-form-item ui-form-item-show ui-border-b">
		                        <label for="#">登录密码</label>
		                        <input type="text">
		                    </div>
		                </form>
		            </div>
		        </div>
	        </section>
	    </section>  
        <div class="ui-footer ui-footer-stable ui-btn-group ui-border-t">
             <button class="ui-btn-lg">
             	注册
             </button>
             <button class="ui-btn-lg">
             	忘记密码
             </button>
         </div>
        <script src="Plugins/FrozenUI/lib/zepto.min.js"></script>
        <script src="Plugins/FrozenUI/js/frozen.js"></script>
        <script>
        
        </script>
    </body>
</html>