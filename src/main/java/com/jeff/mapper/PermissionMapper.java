package com.jeff.mapper;

import java.util.List;
import java.util.Map;

import com.jeff.entity.Permission;

/**
 * @description: 菜单mapper接口
 * @author: Jeff
 * @date: 2019年03月05日 22:56:31
 */
public interface PermissionMapper {

	/**
	 * @description: 获取菜单列表
	 * @param map
	 * @return List<Permission>
	 * @author: Jeff
	 * @date: 2019年03月05日 22:56:24
	 */
	List<Permission> findMenuByUserId(Map<String, Object> map);

	/**
	 * @description: 授权
	 * @param id
	 * @return List<Permission>
	 * @author: Jeff
	 * @date: 2019年03月05日 22:59:05
	 */
	List<Permission> findPermissionByUserId(Long id);

}
