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
    private Integer saleMoney;
    private String remark;
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

    public Integer getSaleMoney() {
        return saleMoney;
    }

    public void setSaleMoney(Integer saleMoney) {
        this.saleMoney = saleMoney;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Goods.SaleInfo toSaleInfo(){
        Goods.SaleInfo  saleInfo = new Goods.SaleInfo();
        BeanMapper.copy(this,saleInfo);
        saleInfo.setSaleType(1);
        return saleInfo;
    }
}