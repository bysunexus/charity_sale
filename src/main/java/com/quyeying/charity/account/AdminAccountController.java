package com.quyeying.charity.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * charity_sale
 * com.quyeying.charity.account
 * Created with IntelliJ IDEA.
 * User: Watson
 * Date: 2014/6/13
 * Time: 13:20
 */
@Controller
public class AdminAccountController {

    @RequestMapping(value = "goAdminAccountManager")
    public ModelAndView goAdminAccountManager() {
        return new ModelAndView("account/admin_account_manager");
    }

}
