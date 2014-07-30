package com.quyeying.charity.base.dto;

import org.springframework.data.domain.PageRequest;

/**
 * User: bysun
 * Date: 2014/7/29
 * Time: 22:29
 */
public class DataTablesReq {

    private Integer draw;
    private Integer start;
    private Integer length;
    private Search search;

    private Order[] order;

    private Column[] columns;

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Search getSearch() {
        return search;
    }

    public void setSearch(Search search) {
        this.search = search;
    }

    public Order[] getOrder() {
        return order;
    }

    public void setOrder(Order[] order) {
        this.order = order;
    }

    public Column[] getColumns() {
        return columns;
    }

    public void setColumns(Column[] columns) {
        this.columns = columns;
    }

    public PageRequest getPageRequest(){
        return new  PageRequest((start / length), length);
    }
}
