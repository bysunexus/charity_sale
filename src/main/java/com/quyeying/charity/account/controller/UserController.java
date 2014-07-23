package com.quyeying.charity.account.controller;

import com.quyeying.charity.account.dto.UserDto;
import com.quyeying.charity.account.dto.UserMenuDto;
import com.quyeying.charity.commons.IResultDto;
import com.quyeying.charity.commons.ResultDto;
import com.quyeying.charity.domain.Menu;
import com.quyeying.charity.domain.User;
import com.quyeying.charity.domain.UserMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

/**
 * charity_sale
 * com.quyeying.charity.account
 * Created with IntelliJ IDEA.
 * User: Watson
 * Date: 2014/6/13
 * Time: 13:20
 */
@Controller()
@RequestMapping("/user")
public class UserController {

    @Autowired
    MongoTemplate template;

    @RequestMapping(method = RequestMethod.GET)
    public String goAdminAccountManager() {
        return "account/user";
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public IResultDto saveUser(UserDto user) {
        try {
            User u =  user.get();
            template.save(u);
            return ResultDto.getSuccess(u);
        } catch (Exception e) {
            return ResultDto.get("保存用户失败");
        }
    }


    @RequestMapping(value="/menu",method = RequestMethod.GET)
    @ResponseBody
    public IResultDto menuTree() {
        try {
            return ResultDto.getSuccess(template.findAll(Menu.class));
        } catch (Exception e) {
            return ResultDto.get("菜单数据查询失败");
        }
    }

    @RequestMapping(value="/menu",method = RequestMethod.POST)
    @ResponseBody
    public IResultDto saveMenu(Menu menu) {
        try {
            template.save(menu);
            return ResultDto.getSuccess(menu);
        } catch (Exception e) {
            return ResultDto.get("保存菜单失败");
        }
    }

    @RequestMapping(value="/userMenu",method = RequestMethod.POST)
    @ResponseBody
    public IResultDto savUserMenu(UserMenuDto dto) {
        try {

            User u = template.findOne(
                new Query(Criteria.where("userName").is(dto.getUserName())),
                User.class
            );

            if(null == u)
                return ResultDto.get("没有找到用户名为["+dto.getUserName()+"]的用户,添加失败!");

            UserMenu userMenu = template.findOne(
                new Query(Criteria.where("userId").is(u.getPkid())),
                UserMenu.class
            );

            if(null == userMenu)
                userMenu = new UserMenu();
            userMenu.setUserId(u.getPkid());
            if(null == userMenu.getMenus())
                userMenu.setMenus(new ArrayList<Menu>());

            Menu menu = template.findOne(
                new Query(Criteria.where("pkid").is(dto.getMenuId())),
                Menu.class
            );

            userMenu.getMenus().add(menu);
            template.save(userMenu);
            return ResultDto.getSuccess(userMenu);
        } catch (Exception e) {
            return ResultDto.get("保存用户菜单失败");
        }
    }


}
