package com.quyeying.charity.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * charity_sale
 * com.quyeying.charity.login.controller
 * Created with IntelliJ IDEA.
 * User: Watson
 * Date: 2014/6/12
 * Time: 10:56
 */
@Controller
public class LoginController {

    /**
     * 登录方法
     *
     * @param userName 用户名
     * @param passWord 密码
     *
     * @return 返回首页
     */
    @RequestMapping(value = "checkLogin", method = RequestMethod.POST)
    public ModelAndView login(String userName, String passWord) {
        if (this.checkParams(new String[]{userName, passWord})) {
            ModelAndView mav = new ModelAndView("index");
//            mav.addObject("userName",userName);
//            mav.addObject("passWord", passWord);
            return mav;
        }
        return new ModelAndView("login/login");
    }

    @RequestMapping(value = "login")
    public ModelAndView toLogin() {
        return new ModelAndView("login/login");
    }

    /**
     * 验证参数是否为空
     *
     * @param params 校验参数
     *
     * @return 失败返回false 成功返回true
     */
    private boolean checkParams(String[] params) {
        for (String param : params) {
            if (param.equals("") || param.isEmpty()) {
                return false;
            }
        }
        return true;
    }

}
