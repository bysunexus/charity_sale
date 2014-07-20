package com.quyeying.security;

import com.quyeying.charity.domain.Menu;
import com.quyeying.charity.domain.User;

import java.util.List;

/**
 * User: bysun
 * Date: 2014/7/20
 * Time: 21:39
 */
public interface UserMongoRepository {

    /**
     * 根据用户与名获取获取用户
     * @param username 用户名
     * @return 用户信息
     */
    User findUserByUserName(String username);

    /**
     * 根据用户id获取 权限
     * @param pkid 用户id
     * @return 权限列表
     */
    List<String> findPermissionsByUserId(String pkid);

    /**
     * 获取所有菜单信息
     * @return 所有菜单信息
     */
    List<Menu> findAllMenu();
}
