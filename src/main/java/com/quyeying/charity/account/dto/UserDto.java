package com.quyeying.charity.account.dto;

import com.quyeying.charity.domain.User;
import com.quyeying.framework.utils.BeanMapper;
import org.apache.commons.lang3.StringUtils;

/**
 * User: bysun
 * Date: 2014/7/23
 * Time: 22:32
 */
public class UserDto {
    private String userName;
    private String nickName;
    private String password;
    private String group;
    private String level;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = StringUtils.trimToNull(userName);
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = StringUtils.trimToNull(nickName);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = StringUtils.trimToNull(password);
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = StringUtils.trimToNull(group);
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = StringUtils.trimToNull(level);
    }

    public User get(){
        User u = new User();
        BeanMapper.copy(this,u);
        return u;
    }
}
