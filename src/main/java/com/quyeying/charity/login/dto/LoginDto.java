package com.quyeying.charity.login.dto;

import org.apache.commons.lang3.StringUtils;

/**
 * charity_sale
 * com.quyeying.charity.login.dto
 * Created with IntelliJ IDEA.
 * User: Watson
 * Date: 2014/7/21
 * Time: 21:23
 */
public class LoginDto {

    private String userName;

    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = StringUtils.trimToNull(userName);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
