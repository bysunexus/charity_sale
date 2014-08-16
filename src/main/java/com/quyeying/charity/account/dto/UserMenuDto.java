package com.quyeying.charity.account.dto;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * User: bysun
 * Date: 2014/7/23
 * Time: 23:52
 */
public class UserMenuDto {
    private String userName;
    private String menuId;
    private List<String> menuIds;

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = StringUtils.trimToNull(menuId);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = StringUtils.trimToNull(userName);
    }


    public List<String> getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(List<String> menuIds) {
        this.menuIds = menuIds;
    }
}
