package com.quyeying.charity.account.service;

import com.quyeying.charity.domain.Menu;
import com.quyeying.charity.domain.User;
import com.quyeying.charity.domain.UserMenu;
import com.quyeying.security.IShiroUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * User: bysun
 * Date: 2014/7/20
 * Time: 22:55
 */
@Service("shiroUserService")
public class ShiroUserService implements IShiroUserService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public User findUserByUserName(String username) {

        User user = mongoTemplate.findOne(
            new Query(Criteria.where("userName").is(username)),
            User.class
        );
        return user;
    }

    @Override
    public List<String> findPermissionsByUserId(String pkid) {
        UserMenu userMenu = mongoTemplate.findOne(
            new Query(Criteria.where("userId").is(pkid)),
            UserMenu.class
        );

        List<String> result = new ArrayList<>();
        if (null != userMenu && null != userMenu.getMenus()) {
            for (Menu menu : userMenu.getMenus()) {
                result.add(menu.getPath());
            }
        }
        return result;
    }

    @Override
    public List<Menu> findAllMenu() {
        return mongoTemplate.findAll(Menu.class);
    }
}
