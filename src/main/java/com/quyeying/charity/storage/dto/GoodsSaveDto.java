package com.quyeying.charity.storage.dto;

/**
 * User: bysun
 * Date: 2014/6/23
 * Time: 20:15
 */
public class GoodsSaveDto {
    /**
     * 捐品编号
     */
    private String goodsNum;
    /**
     * 捐品名称
     */
    private String goodsName;
    /**
     * 捐品单价
     */
    private Integer goodsPrice;
    /**
     * 捐品数量
     */
    private Integer goodsCount;
    /**
     * 捐赠者
     */
    private String personName;
    /**
     * 捐赠者联系电话
     */
    private String personPhone;

    /**
     * 是否退回  0-不退回  1-退回
     */
    private Integer goodsReturn = 0;

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

    public Integer getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Integer goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonPhone() {
        return personPhone;
    }

    public void setPersonPhone(String personPhone) {
        this.personPhone = personPhone;
    }

    public Integer getGoodsReturn() {
        return goodsReturn;
    }

    public void setGoodsReturn(Integer goodsReturn) {
        this.goodsReturn = goodsReturn;
    }
}
