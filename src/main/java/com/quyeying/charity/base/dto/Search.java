package com.quyeying.charity.base.dto;

import org.apache.commons.lang3.StringUtils;

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
        this.value = StringUtils.trimToNull(value);
    }

    public boolean isRegex() {
        return regex;
    }

    public void setRegex(boolean regex) {
        this.regex = regex;
    }
}
