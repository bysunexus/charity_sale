package com.quyeying.charity.base.dto;

/**
 * User: bysun
 * Date: 2014/7/29
 * Time: 22:55
 */
public class Search {
    private String value;
    private boolean regex;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isRegex() {
        return regex;
    }

    public void setRegex(boolean regex) {
        this.regex = regex;
    }
}
