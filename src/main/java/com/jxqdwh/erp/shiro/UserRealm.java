package com.jxqdwh.erp.shiro;

import com.jxqdwh.erp.entity.Users;
import com.jxqdwh.erp.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;



/**
 * 自定义Realm
 * @author lenovo
 *
 */
public class UserRealm extends AuthorizingRealm{

	/**
	 * 执行授权逻辑
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		System.out.println("执行授权逻辑");

		//给资源进行授权
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

		//添加资源的授权字符串
		//info.addStringPermission("user:add");

		//到数据库查询当前登录用户的授权字符串
		//获取当前登录用户
		Subject subject = SecurityUtils.getSubject();
		Users user = (Users)subject.getPrincipal();
		Users dbUser = userSerivce.findUserById((int)user.getUserId());

		info.addStringPermission("1");

		return info;
	}

	@Autowired
	private UserService userSerivce;

	/**
	 * 执行认证逻辑
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
		System.out.println("执行认证逻辑");

		//编写shiro判断逻辑，判断用户名和密码
		//1.判断用户名
		UsernamePasswordToken token = (UsernamePasswordToken)arg0;

		Users user = userSerivce.findUserById(Integer.parseInt(token.getUsername()));

		if(user==null){
			//用户名不存在
			return null;//shiro底层会抛出UnKnowAccountException
		}
		System.out.println("----------"+user.getPasswd());
		//2.判断密码
		return new SimpleAuthenticationInfo(user,user.getPasswd(),"");
	}

}
