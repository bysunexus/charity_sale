package com.quyeying.charity.login.controller;

import com.quyeying.security.CharitySecurityUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * User: bysun
 * Date: 2014/8/3
 * Time: 16:57
 */
@Controller
@RequestMapping("/logout")
public class LogoutController {
    private final static Logger LOGGER = LoggerFactory.getLogger(LogoutController.class);
    /**
     * 登录方法
     *
     * @param dto dto
     * @return 返回首页
     */
    @RequestMapping(method = RequestMethod.GET)
    public String logout() {
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.logout();
            CharitySecurityUtils.removeCurrentUser();
        } catch (Exception e) {
            LOGGER.info("用户登出时发生错误",e);
        }
        return "redirect:/login";
    }
}
