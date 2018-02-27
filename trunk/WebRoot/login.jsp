<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no">
        <meta name="format-detection" content="telephone=no">
        <title>Footprint登录页面</title>
        <link rel="stylesheet" href="plugins/frozenUI/css/frozen.css">
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
        <script src="plugins/frozenUI/lib/zepto.min.js"></script>
        <script src="plugins/frozenUI/js/frozen.js"></script>
        <script>
        
        	function showPos(value){
        		var longitude = value.coords.longitude;
        		var latitude = value.coords.latitude;
        		alert(longitude + "," + latitude);
        	}
        	
        	function handleError(value){
        		switch (value.code){
        			case 1:
        				alert("位置服务被拒绝");break;
        			case 2:
        				alert("暂时获取不到位置信息");break;
        			case 3:
        				alert("获取信息超时");break;
        			case 4:
        				alert("未知错误");break;
        		}
        	}
        	
        	(function getLocation(){
        		if(navigator.geolocation){
        			navigator.geolocation.getCurrentPosition(showPos, handleError, {
        				enableHighAccuracy: true,
        				maximumAge: 1000
        			});
        		}else{
        			alert("您的浏览器不支持使用HTML5来获取地理位置服务");
        		}
        	})();
        
        </script>
    </body>
</html>