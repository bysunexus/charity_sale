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
public class ReportDto extends DataTablesReq{

    private String goodsType;

    private String goodsNum;

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public String getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(String goodsNum) {
        this.goodsNum = goodsNum;
    }
}
