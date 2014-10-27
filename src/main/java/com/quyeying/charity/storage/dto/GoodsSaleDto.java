package com.quyeying.charity.storage.dto;

import com.quyeying.charity.domain.Goods;
import com.quyeying.framework.utils.BeanMapper;

/**
 * User: bysun
 * Date: 2014/7/19
 * Time: 15:25
 */
public class GoodsSaleDto {
    private String id;
    private Integer saleCount;
    private Double saleMoney;
    private String remark;
    private Goods goods;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(Integer saleCount) {
        this.saleCount = saleCount;
    }

    public Double getSaleMoney() {
        return saleMoney;
    }

    public void setSaleMoney(Double saleMoney) {
        this.saleMoney = saleMoney;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Goods.SaleInfo toSaleInfo(){
        Goods.SaleInfo  saleInfo = new Goods.SaleInfo();
        BeanMapper.copy(this,saleInfo);
        saleInfo.setSaleType(1);
        return saleInfo;
    }
}
