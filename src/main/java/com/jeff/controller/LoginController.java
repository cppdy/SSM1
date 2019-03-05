package com.jeff.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeff.entity.User;
import com.jeff.service.UserService;

/**
 * @description: 用户登陆controller类
 * @author: Jeff
 * @date: 2019年02月20日 23:04:20
 */
@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/", "index" })
	public String index(Model model) {

		Subject subject = SecurityUtils.getSubject();
		User user = (User) subject.getPrincipal();
		model.addAttribute("currentUser", user);

		return "index";
	}

	/**
	 * @description: 用户登陆界面
	 * @return Object
	 * @author: Jeff
	 * @date: 2019年02月20日 23:03:19
	 */
	@RequestMapping("toLogin")
	public Object toLogin() {

		return "login";
	}

	/**
	 * @description: 用户登陆
	 * @param user
	 * @param request
	 * @param response
	 * @return Object
	 * @author: Jeff
	 * @date: 2019年02月20日 23:04:37
	 */
	@RequestMapping("login")
	public Object login(HttpServletRequest request, Model model) {
		String className = (String) request.getAttribute("shiroLoginFailure");
		if (UnknownAccountException.class.getName().equals(className)) {
			model.addAttribute("msg", "用户名或密码错误");
		}
		return "login";
	}

	/**
	 * @description: 根据token获取用户信息
	 * @param token
	 * @return Object
	 * @author: Jeff
	 * @date: 2019年02月20日 23:04:48
	 */
	@RequestMapping("getUserInfo")
	@ResponseBody
	public Object getUserInfoByToken(String token) {

		return userService.getUserInfoByToken(token);
	}

}
