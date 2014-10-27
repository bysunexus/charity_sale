package com.quyeying.charity.paddedpost.dto;

import com.quyeying.charity.domain.Goods;
import com.quyeying.charity.domain.User;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * charity_sale
 * com.quyeying.charity.paddedpost.dto
 * Created with IntelliJ IDEA.
 * User: Watson
 * Date: 2014/8/7
 * Time: 22:11
 */
@SuppressWarnings("UnusedDeclaration")
public class PaddedPostDto {

    @NotBlank(message = "编号不能为空")
    @Pattern(regexp = "^[A-E|a-e][1-9][0-9]{0,2}$", message = "编号必须为[A-E]+[1-999]形式")
    private String goodsNum;

    @NotNull(message = "不能为空")
    private Double paddedPostValue;
    @NotNull(message = "不能为空")
    private Integer paddedPostRadios;

    public String getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(String goodsNum) {
        this.goodsNum = goodsNum;
    }

    public Double getPaddedPostValue() {
        return paddedPostValue;
    }

    public void setPaddedPostValue(Double paddedPostValue) {
        this.paddedPostValue = paddedPostValue;
    }

    public Integer getPaddedPostRadios() {
        return paddedPostRadios;
    }

    public void setPaddedPostRadios(Integer paddedPostRadios) {
        this.paddedPostRadios = paddedPostRadios;
    }

    @Override
    public String toString() {
        return "PaddedPostDto{" +
            "goodsNum='" + goodsNum + '\'' +
            ", paddedPostValue=" + paddedPostValue +
            ", paddedPostRadios=" + paddedPostRadios +
            '}';
    }

    public Goods.SaleInfo toSaleInfo(User user) {

        Goods.SaleInfo saleInfo = new Goods.SaleInfo();

        if (this.paddedPostRadios == 0) {
            saleInfo.setSaleCount(0);
            saleInfo.setSaleMoney(this.getPaddedPostValue());
        }
        if (this.paddedPostRadios == 1) {
            saleInfo.setSaleMoney(0.0);
            saleInfo.setSaleCount(this.getPaddedPostValue().intValue()*(-1));
        }

        saleInfo.setSaleType(0);
        saleInfo.setRemark("补差备忘:" + "用户id=" + user.getPkid() + "用户姓名:" + user.getNickName() + "补差数据:" + this.toString());

        return saleInfo;
    }
}
