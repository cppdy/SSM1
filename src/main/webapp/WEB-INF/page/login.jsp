<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%--项目路径 --%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge"> 
<meta name="viewport" content="width=device-width, initial-scale=1"> 
<title>login</title>
<link rel="stylesheet" type="text/css" href="${path}/static/css/login/normalize.css" />
<link rel="stylesheet" type="text/css" href="${path}/static/css/login/demo.css" />
<!--必要样式-->
<link rel="stylesheet" type="text/css" href="${path}/static/css/login/component.css" />
<!--[if IE]>
<script src="${path}/static/js/login/html5.js"></script>
<![endif]-->
</head>
<body>
		<div class="container demo-1">
			<div class="content">
				<div id="large-header" class="large-header">
					<canvas id="demo-canvas"></canvas>
					<div class="logo_box">
						<h3>欢迎您</h3>
						<form action="login" name="form" method="post">
							<div class="input_outer">
								<span class="u_user"></span>
								<input id="username" name="username" class="text" style="color: #FFFFFF !important" type="text" placeholder="请输入账户">
							</div>
							<div class="input_outer">
								<span class="us_uer"></span>
								<input id="password" name="password" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;"value="" type="password" placeholder="请输入密码">
							</div>
							<input type="checkbox" name="rememberMe"><span>记住我</span>
							<div class="mb2"><a class="act-but submit" href="javascript:login();" style="color: #FFFFFF">登录</a></div>
						</form>
					</div>
				</div>
			</div>
		</div><!-- /container -->
		<script type="text/javascript" src="${path}/static/js/login/TweenLite.min.js"></script>
		<script type="text/javascript" src="${path}/static/js/login/EasePack.min.js"></script>
		<script type="text/javascript" src="${path}/static/js/login/rAF.js"></script>
		<script type="text/javascript" src="${path}/static/js/login/demo-1.js"></script>
		<script type="text/javascript" src="${path}/static/js/easyui/jquery.min.js"></script>  
		<script type="text/javascript" src="${path}/static/js/layer/layer.js"></script>
		<script type="text/javascript" src="${path}/static/js/login/login.js"></script>
	</body>
</html>