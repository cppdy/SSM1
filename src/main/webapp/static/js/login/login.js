document.onkeydown = function(event) {
	var e = event || window.event || arguments.callee.caller.arguments[0];
	if (e && e.keyCode == 13) {
		// enter 键
		login();
	}
};

function login() {
	var username = $("#username").val();
	var password = $("#password").val();
	if (username == null || username == "") {
		layer.tips('请输入用户名', '#username');
	} else {
		if (password == null || password == "") {
			layer.tips('请输入密码', '#password');
		} else {
			$("form").submit();
			/*$.ajax({
				type : "POST",
				url : "login",
				data : {
					username : username,
					password : password,
				},
				dataType : 'json',
				success : function(data) {
					if (data) {
						location.href = "user/manager";
					} else {
						layer.msg("用户名或密码错误，登录失败", {
							icon : 2,
							time : 2000
						});
					}
				},
				error : function(data) {
					layer.msg("用户名或密码错误，登录失败", {
						icon : 2,
						time : 2000
					});
				}
			});*/
		}
	}
}
