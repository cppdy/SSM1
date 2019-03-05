<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%--项目路径 --%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <title>Jeff管理系统</title>
	<link rel="stylesheet" type="text/css" href="${path}/static/js/easyui/themes/default/easyui.css">   
	<link rel="stylesheet" type="text/css" href="${path}/static/js/easyui/themes/icon.css">   
	<script type="text/javascript" src="${path}/static/js/easyui/jquery.min.js"></script>   
	<script type="text/javascript" src="${path}/static/js/easyui/jquery.easyui.min.js"></script> 
	<script type="text/javascript" src="${path}/static/js/easyui/locale/easyui-lang-zh_CN.js"></script>  
	<script type="text/javascript">
	$(function(){
		$('#main_tree').tree({    
		    url:'menu/showMenu',
		    onClick:function(node){
		    	if($("#main_tabs").tabs("getTab",node.text)==null){
			    	$('#main_tabs').tabs('add',{
			    		title: node.text,
			    		href:node.attributes.url,
			    		closable:true
			    	});
				}else{
					$("#main_tabs").tabs("select",node.text);
				}
		    }
		}); 
	})
	</script>
</head>
<body class="easyui-layout">   
    <div data-options="region:'north'" style="height:100px;">
    	<div style="width:400px;height:70px; float:left;font-size:20px; font-weight:bold;line-height: 70px;padding-left:20px;">
    		Jeff管理系统
    	</div>
    	<div style="width:200px;height:70px;float:right;line-height: 70px;">
    		您好,${currentUser.name},欢迎登录!<a href="logout">退出</a>
    	</div>
    </div>   
    <div data-options="region:'south'" style="height:100px;">
    	<div style="height:70px; line-height: 70px; text-align:center;color:gray">
    		Copyright &copy; 2019 Jeff
    	</div>
    </div>   
    <div data-options="region:'west',title:'菜单'" style="width:200px;">
    	<ul id="main_tree"></ul> 
    </div>   
    <div data-options="region:'center',title:'内容'" style="padding:5px;background:#eee;">
    	<div id="main_tabs" class="easyui-tabs" style="width:500px;height:250px;" data-options="fit:true">   
		    <div title="首页" style="padding:20px;">   
		        	欢迎您
		    </div>  
		</div>
    </div>   
</body>
</html>