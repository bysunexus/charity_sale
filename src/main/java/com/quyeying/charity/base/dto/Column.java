package com.quyeying.charity.base.dto;

import org.apache.commons.lang3.StringUtils;

/**
 * User: bysun
 * Date: 2014/7/29
 * Time: 22:38
 */
public class Column {
    private String data;
    private String name;
    private boolean searchable;
    private boolean orderable;
    private Search search;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = StringUtils.trimToNull(data);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = StringUtils.trimToNull(name);
    }

    public boolean isSearchable() {
        return searchable;
    }

    public void setSearchable(boolean searchable) {
        this.searchable = searchable;
    }

    public boolean isOrderable() {
        return orderable;
    }

    public void setOrderable(boolean orderable) {
        this.orderable = orderable;
    }

    public Search getSearch() {
        return search;
    }

    public void setSearch(Search search) {
        this.search = search;
    }
}
