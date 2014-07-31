package com.quyeying.charity.report.dto;

import com.quyeying.charity.base.dto.DataTablesReq;

/**
 * charity_sale
 * com.quyeying.charity.report.dto
 * Created with IntelliJ IDEA.
 * User: Watson
 * Date: 2014/6/21
 * Time: 14:57
 */
@SuppressWarnings("ALL")
public class GroupReportDto extends DataTablesReq{

    private String goodsType;

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }
}
