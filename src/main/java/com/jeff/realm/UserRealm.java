package com.jeff.realm;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeff.entity.Permission;
import com.jeff.entity.User;
import com.jeff.service.PermissionService;
import com.jeff.service.UserService;

/**
 * @description: 认证授权
 * @author: Jeff
 * @date: 2019年03月05日 22:57:10
 */
public class UserRealm extends AuthorizingRealm {

	@Autowired
	private UserService userService;
	@Autowired
	private PermissionService permissionService;

	// 认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 从token 中获取身份信息
		String username = token.getPrincipal().toString();
		// 根据用户名到数据库中取出用户信息如果查询不到返回null
		User user = userService.findUserByName(username);
		// 返回认证信息
		return new SimpleAuthenticationInfo(user, user.getPassword(), ByteSource.Util.bytes(user.getSalt()),
				this.getName());
	}

	// 授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// 获取身份信息--该身份信息在认证时已设置
		User user = (User) principals.getPrimaryPrincipal();
		if (user == null) {
			return null;
		}
		// 根据身份信息获取权限数据
		List<Permission> permissions = permissionService.findPermissionByUserId(user.getId());
		// 将权限信息保存到AuthorizationInfo 中
		if (permissions == null || permissions.size() == 0) {
			return null;
		}
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		for (Permission permission : permissions) {
			simpleAuthorizationInfo.addStringPermission(permission.getPercode());
		}
		return simpleAuthorizationInfo;
	}

	/**
	 * @description:清理缓存
	 * @author: Jeff
	 * @date: 2019年03月05日 23:26:56
	 */
	protected void clearCache() {
		Subject subject = SecurityUtils.getSubject();
		super.clearCache(subject.getPrincipals());
	}

}
