package com.quyeying.charity.report.dto;

/**
 * charity_sale
 * com.quyeying.charity.report.dto
 * Created with IntelliJ IDEA.
 * User: Watson
 * Date: 2014/6/21
 * Time: 14:57
 */
@SuppressWarnings("ALL")
public class GroupReportDto {

    /**
     * 捐品编号
     */
    private String goodsNum;

    /**
     * 捐品名称
     */
    private String goodsName;

    /**
     * 捐赠者
     */
    private String personName;


    /**
     * 捐品单价
     */
    private Integer goodsPrice;

    /**
     * 售出总价
     */
    private Integer saleMoney;

    /**
     * 捐品数量--总件数
     */
    private Integer goodsCount;


    /**
     * 售出件数
     */
    private Integer saleCount;

    /**
     * 库存
     */
    private Integer reserve;

    public String getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(String goodsNum) {
        this.goodsNum = goodsNum;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Integer getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Integer goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Integer getSaleMoney() {
        return saleMoney;
    }

    public void setSaleMoney(Integer saleMoney) {
        this.saleMoney = saleMoney;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public Integer getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(Integer saleCount) {
        this.saleCount = saleCount;
    }

    public Integer getReserve() {
        return reserve;
    }

    public void setReserve(Integer reserve) {
        this.reserve = reserve;
    }
}
