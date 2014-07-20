package com.quyeying.charity.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

/**
 * User: bysun
 * Date: 2014/7/19
 * Time: 11:22
 */
@Document(collection = "users")
public class User {
    @Id
    private String pkid;
    private String userName;
    private String nickName;
    private String password;
    private String group;
    private String level;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("pkid", pkid)
            .append("userName", userName)
            .append("nickName", nickName)
            .append("password", password)
            .append("group", group)
            .append("level", level)
            .toString();
    }

    public static enum UserLevel{
        ADMIN("A"),SALES("S"),BOOKEEPER("B");
        private String value;

        UserLevel(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public static UserLevel getByValue(String value) {

            for (UserLevel type : UserLevel.values()) {
                if (type.getValue().equalsIgnoreCase(value)) {
                    return type;
                }
            }
            throw new NullPointerException("未知的捐品类型[" + value + "]");
        }
    }

    public String getPkid() {
        return pkid;
    }

    public void setPkid(String pkid) {
        this.pkid = pkid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
