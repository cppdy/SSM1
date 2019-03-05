<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge"> 
<meta name="viewport" content="width=device-width, initial-scale=1"> 
<title>login</title>
<script type="text/javascript" src="${path}/static/js/easyui/jquery.min.js"></script> 
<script type="text/javascript" src="${path}/static/js/jquery.cookie.js"></script> 
</head>
<body>
<script type="text/javascript">

checkLogin();

function checkLogin(){
	var _ticket = $.cookie("TT_TOKEN");
	if(!_ticket){
		location.href = "loginPage";
	}else{
		$.ajax({
			url : "getUserInfo?token=" + _ticket,
			dataType : "json",
			type : "GET",
			success : function(data){
				alert(data.id+"-->"+data.loginName);
				location.href = "user/manager";
			}
		});
	}
}
</script>
</body>
</html>