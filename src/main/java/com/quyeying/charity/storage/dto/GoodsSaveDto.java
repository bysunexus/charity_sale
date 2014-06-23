package com.quyeying.charity.storage.dto;

import com.quyeying.charity.domain.Goods;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

/**
 * User: bysun
 * Date: 2014/6/23
 * Time: 20:15
 */
public class GoodsSaveDto {
    /**
     * 捐品编号
     */
    @NotBlank(message = "编号不能为空")
    @Pattern(regexp="^[A-E|a-e][1-9][0-9]{0,2}$",message = "编号必须为[A-E]+[1-999]形式")
    private String goodsNum;

    /**
     * 捐品单价
     */
    @NotBlank(message = "单价不能为空")
    @Pattern(regexp="^(2|5|10|25|\\d{3,}|5[0-9]|[6-9]\\d)$",message = "单价必须为2,5,10,25或50以上(含50)")
    private Integer goodsPrice;
    /**
     * 捐品数量
     */
    @NotBlank(message = "数量不能为空")
    @Min(value = 1,message = "数量至少为1")
    private Integer goodsCount;

    public String getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(String goodsNum) {
        this.goodsNum = goodsNum;
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

    public Goods build(){
        Goods g = new Goods();
        g.setGoodsCount(this.goodsCount);
        g.setGoodsNum(this.goodsNum.toUpperCase());
        g.setGoodsType(this.goodsNum.toUpperCase().substring(0,1));
        g.setGoodsPrice(this.goodsPrice);
        return g;
    }

    @Override
    public String toString() {
        return "GoodsSaveDto{" +
            "goodsNum='" + goodsNum + '\'' +
            ", goodsPrice=" + goodsPrice +
            ", goodsCount=" + goodsCount +
            '}';
    }
}
