package com.jeff.service;

import java.util.List;

import com.jeff.entity.Permission;

/**
 * @description: 菜单service接口
 * @author: Jeff
 * @date: 2019年03月05日 22:55:08
 */
public interface PermissionService {

	/**
	 * @description: 获取菜单列表
	 * @param id
	 * @return List<Permission>
	 * @author: Jeff
	 * @date: 2019年03月05日 22:54:47
	 */
	List<Permission> findMenuByUserId(Long id);

	/**
	 * @description: 授权
	 * @param id
	 * @return List<Permission>
	 * @author: Jeff
	 * @date: 2019年03月05日 22:58:38
	 */
	List<Permission> findPermissionByUserId(Long id);

}
