package com.quyeying.charity.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

/**
 * User: bysun
 * Date: 2014/7/20
 * Time: 21:57
 */
@Document(collection = "userMenus")
public class UserMenu {
    @Id
    private String userId;

    @DBRef
    @Field("menus")
    private List<Menu> menus;

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
