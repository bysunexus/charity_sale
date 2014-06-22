package com.quyeying.charity.report.dto;

/**
 * charity_sale
 * com.quyeying.charity.report.dto
 * Created with IntelliJ IDEA.
 * User: Watson
 * Date: 2014/6/21
 * Time: 18:11
 */
public class DataTableResultDto {

    private Object data;

    private int iTotalRecords;

    private int iTotalDisplayRecords;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getiTotalRecords() {
        return iTotalRecords;
    }

    public void setiTotalRecords(int iTotalRecords) {
        this.iTotalRecords = iTotalRecords;
    }

    public int getiTotalDisplayRecords() {
        return iTotalDisplayRecords;
    }

    public void setiTotalDisplayRecords(int iTotalDisplayRecords) {
        this.iTotalDisplayRecords = iTotalDisplayRecords;
    }
}
