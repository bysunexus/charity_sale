package com.quyeying.charity.base;

import com.quyeying.charity.domain.Goods;
import com.quyeying.charity.domain.User;
import com.quyeying.security.CharitySecurityUtils;
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
        return CharitySecurityUtils.getCurrentUser();
    }
}
