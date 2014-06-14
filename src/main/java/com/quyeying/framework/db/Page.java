package com.quyeying.framework.db;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * User: bysun
 * Date: 13-11-15
 * Time: 上午10:29
 */
public class Page<T> {
    /**
     * 当前页数
     */
    private int current = 0;
    /**
     * 分页大小
     */
    private int pageSize = 10;
    /**
     * 总量
     */
    private int total = 0;
    /**
     * 总页数
     */
    private int totalPage = 1;
    /**
     * 当前页数据
     */
    private List<T> content;

    public Page() {
    }

    public Page(int current, int pageSize) {
        this.current = current;
        if (pageSize > 0) {
            this.pageSize = pageSize;
        }
    }

    /**
     * @return the value for the field current (当前页数).
     */
    public int getCurrent() {
        return current;
    }

    /**
     * Setter for field current (当前页数).
     *
     * @param current (当前页数) the value to set for the field.
     */
    public void setCurrent(int current) {
        this.current = current < 0 ? 0 : current;
    }

    /**
     * @return the value for the field pageSize (分页大小).
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * Setter for field pageSize (分页大小).
     *
     * @param pageSize (分页大小) the value to set for the field.
     */
    public void setPageSize(int pageSize) {

        this.pageSize = pageSize < 1 ? 1 : pageSize;
    }

    /**
     * @return the value for the field total (总量).
     */
    public int getTotal() {
        return total;
    }

    /**
     * Setter for field total (总量).
     *
     * @param total (总量) the value to set for the field.
     */
    public void setTotal(int total) {
        this.total = total < 0 ? 0 : total;
        this.totalPage = this.total / this.pageSize + ((this.total % this.pageSize > 0) ? 1 : 0);
    }

    /**
     * @return the value for the field totalPage (总页数).
     */
    public int getTotalPage() {
        return totalPage;
    }

    /**
     * @return the value for the field content (当前页数据).
     */
    public List<T> getContent() {
        return content;
    }

    /**
     * Setter for field content (当前页数据).
     *
     * @param content (当前页数据) the value to set for the field.
     */
    public void setContent(Collection<T> content) {
        this.content = new ArrayList<T>(content);
    }

    public int getFirst() {
        return current * pageSize;
    }

    @Override
    public String toString() {
        return "Page{" +
            "current=" + current +
            ", pageSize=" + pageSize +
            ", total=" + total +
            ", totalPage=" + totalPage +
            ", content=" + content +
            '}';
    }
}
