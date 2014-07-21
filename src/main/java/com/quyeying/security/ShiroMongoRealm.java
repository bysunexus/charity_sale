package com.quyeying.security;

import com.quyeying.charity.domain.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * User: bysun
 * Date: 2014/7/20
 * Time: 21:36
 */
public class ShiroMongoRealm extends AuthorizingRealm {
    @Autowired
    IShiroUserService repo;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User se = CharitySecurityUtils.getCurrentUser();
        // 为当前用户设置角色和权限
        SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();
        if (null != se) {
            // 用户的的角色信息
            List<String> permissions = repo.findPermissionsByUserId(se.getPkid());
            simpleAuthorInfo.addRoles(permissions);
            // 获取权限
        }
        return simpleAuthorInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user = repo.findUserByUserName(token.getUsername());
        CharitySecurityUtils.setCurrentUser(user);
        if (user != null) {
            return new SimpleAuthenticationInfo(user.getUserName(), user.getPassword(), getName());
        } else {
            return null;
        }
    }

}
