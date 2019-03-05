package com.jeff.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeff.entity.Attributes;
import com.jeff.entity.Permission;
import com.jeff.mapper.PermissionMapper;
import com.jeff.service.PermissionService;

/**
 * @description: 菜单service实现类
 * @author: Jeff
 * @date: 2019年03月05日 22:55:35
 */
@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private PermissionMapper permissionMapper;

	@Override
	public List<Permission> findPermissionByUserId(Long id) {

		return permissionMapper.findPermissionByUserId(id);
	}

	@Override
	public List<Permission> findMenuByUserId(Long id) {
		Map<String, Object> map = new HashMap<>();
		map.put("userId", id);
		map.put("pid", 0);
		List<Permission> list = permissionMapper.findMenuByUserId(map);
		for (Permission permission : list) {
			map.put("pid", permission.getId());
			List<Permission> listChildren = permissionMapper.findMenuByUserId(map);
			for (Permission child : listChildren) {
				Attributes att = new Attributes();
				att.setUrl(child.getUrl());
				child.setAttributes(att);
			}
			permission.setChildren(listChildren);
		}
		return list;
	}

}
