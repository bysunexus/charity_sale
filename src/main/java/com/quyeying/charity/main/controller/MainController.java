package com.quyeying.charity.main.controller;

import com.quyeying.charity.commons.IResultDto;
import com.quyeying.charity.commons.ResultDto;
import com.quyeying.charity.domain.Menu;
import com.quyeying.charity.domain.User;
import com.quyeying.charity.domain.UserMenu;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * User: bysun
 * Date: 2014/6/5 0005
 * Time: 13:57
 */
@Controller
@RequestMapping
public class MainController {

    @Autowired
    private MongoTemplate template;

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/unauthorized")
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public String unauthorized(){return "unauthorized";}

    @RequestMapping(value = "/main/menu",method = RequestMethod.GET)
    @ResponseBody
    public IResultDto menu(@ModelAttribute("CURRENT_USER") User user){
        if(null == user)
            return ResultDto.get("无有效登录用户");
        String userId = user.getPkid();

        if(StringUtils.isBlank(userId))
            return ResultDto.get("无有效登录用户");
        if("admin".equals(user.getUserName())){
            List<Menu> menus = template.findAll(Menu.class);
            return ResultDto.getSuccess(menus);
        }else{
            UserMenu menu = template.findOne(
                new Query(Criteria.where("userId").is(userId)),
                UserMenu.class
            );
            return ResultDto.getSuccess(menu.getMenus());
        }
    }
}
