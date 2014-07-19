package com.quyeying.charity.base;

import com.quyeying.charity.domain.Goods;
import com.quyeying.charity.domain.User;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * User: bysun
 * Date: 2014/7/19
 * Time: 11:32
 */
@ControllerAdvice
public class ControllerPrepare {
    @ModelAttribute("CURRENT_USER")
    public User prepareCurrentUser(){
        User user = new User();
        user.setGroup(Goods.GoodsType.A.getCode());
        user.setLevel(User.UserLevel.ADMIN.getValue());
        user.setNickName("测试用户");
        user.setUserName("testUser");
        user.setPkid("1");
        user.setPassword("111111");
        return user;
    }
}
