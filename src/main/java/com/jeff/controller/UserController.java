package com.jeff.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jeff.commons.ActionType;
import com.jeff.commons.Result;
import com.jeff.entity.EasyUIDatagrid;
import com.jeff.entity.User;
import com.jeff.service.UserService;
import com.jeff.utils.ResultUtil;

/**
 * @description: 用户controller类
 * @author: Jeff
 * @date: 2019年02月20日 22:54:47
 */
@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * @description: 用户列表页面
	 * @return String
	 * @author: Jeff
	 * @date: 2019年02月20日 22:55:17
	 */
	@RequestMapping("manager")
	public String manager() {

		return "user/userList";
	}

	/**
	 * @description: 获取用户列表数据
	 * @param user
	 * @param rows
	 * @param page
	 * @return
	 * @throws IOException EasyUIDatagrid
	 * @author: Jeff
	 * @date: 2019年02月20日 22:55:30
	 */
	@RequestMapping("dataGrid")
	@ResponseBody
	public EasyUIDatagrid dataGrid(User user, int rows, int page) throws IOException {

		PageHelper.startPage(page, rows);
		// 查询全部
		List<User> list = userService.selByPage(user);
		// 设置分页条件
		PageInfo<User> pi = new PageInfo<>(list);
		EasyUIDatagrid datagrid = new EasyUIDatagrid();
		datagrid.setRows(pi.getList());
		datagrid.setTotal(pi.getTotal());

		return datagrid;
	}

	/**
	 * @description: 新增用户页面
	 * @return String
	 * @author: Jeff
	 * @date: 2019年02月20日 22:56:06
	 */
	@RequestMapping("addPage")
	public String addPage() {

		return "user/userAdd";
	}

	/**
	 * @description: 新增用户
	 * @param user
	 * @return Result
	 * @author: Jeff
	 * @date: 2019年02月20日 22:56:19
	 */
	@RequestMapping("add")
	@ResponseBody
	public Result add(User user) {

		user.setCreateTime(new Date());
		user.setCreatedBy("jeff");
		user.setUpdateTime(new Date());
		user.setUpdatedBy("jeff");

		boolean flag = userService.insUser(user);

		return ResultUtil.renderActionResult(flag, ActionType.ADD);
	}

	/**
	 * @description: 编辑用户页面
	 * @param model
	 * @param id
	 * @return
	 * @throws ServletException
	 * @throws IOException      String
	 * @author: Jeff
	 * @date: 2019年02月20日 22:56:33
	 */
	@RequestMapping("editPage")
	public String editPage(Model model, int id) throws ServletException, IOException {

		User user = userService.selUserById(id);
		model.addAttribute("user", user);

		return "user/userEdit";
	}

	/**
	 * @description: 编辑用户
	 * @param user
	 * @return Result
	 * @author: Jeff
	 * @date: 2019年02月20日 22:56:45
	 */
	@RequestMapping("edit")
	@ResponseBody
	public Result edit(User user) {

		user.setUpdateTime(new Date());
		user.setUpdatedBy("jeff");

		boolean flag = userService.updUser(user);

		return ResultUtil.renderActionResult(flag, ActionType.EDIT);
	}

	/**
	 * @description: 删除用户
	 * @param id
	 * @return Result
	 * @author: Jeff
	 * @date: 2019年02月20日 22:56:57
	 */
	@RequestMapping("delete")
	@ResponseBody
	public Result delete(int id) {

		boolean flag = userService.delUser(id);

		return ResultUtil.renderActionResult(flag, ActionType.DELETE);
	}

	/**
	 * @description: 查看用户
	 * @param model
	 * @param id
	 * @return String
	 * @author: Jeff
	 * @date: 2019年02月20日 22:57:13
	 */
	@RequestMapping("viewPage")
	public String viewPage(Model model, int id) {

		User user = userService.selUserById(id);
		model.addAttribute("user", user);

		return "user/userView";
	}

}
