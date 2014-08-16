package com.quyeying.charity.base.dto;

import org.apache.commons.lang3.StringUtils;

/**
 * User: bysun
 * Date: 2014/7/29
 * Time: 22:53
 */
public class Order {
    private Integer column;
    private String dir;

    public Integer getColumn() {
        return column;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }

    public String getDir() {
        return StringUtils.trimToNull(dir);
    }

    public void setDir(String dir) {
        this.dir = dir;
    }
}
