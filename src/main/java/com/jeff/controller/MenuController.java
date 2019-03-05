package com.jeff.controller;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeff.entity.Permission;
import com.jeff.entity.User;
import com.jeff.service.PermissionService;

/**
 * @description: 菜单controller类
 * @author: Jeff
 * @date: 2019年03月05日 22:53:51
 */
@Controller
@RequestMapping("menu")
public class MenuController {

	@Autowired
	private PermissionService permissionService;

	/**
	 * @description: 获取菜单列表
	 * @return List<Permission>
	 * @author: Jeff
	 * @date: 2019年03月05日 22:54:15
	 */
	@RequestMapping("/showMenu")
	@ResponseBody
	public List<Permission> showMenu() {
		Subject subject = SecurityUtils.getSubject();
		User user = (User) subject.getPrincipal();
		return permissionService.findMenuByUserId(user.getId());
	}

}
