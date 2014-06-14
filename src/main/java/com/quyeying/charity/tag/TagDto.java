package com.quyeying.charity.tag;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * User: bysun
 * Date: 2014/5/29 0029
 * Time: 12:00
 */
public class TagDto {
    @NotNull(message="类型不可为空")
    private String goodsType;
    @Max(value=500,message = "最大生成价签数:500")
    @Min(value=1,message = "最小生成价签数:1")
    private Integer total;
    private String base;

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

}
