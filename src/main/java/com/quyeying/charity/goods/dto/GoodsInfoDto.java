package com.quyeying.charity.goods.dto;

import com.quyeying.charity.domain.Goods;
import com.quyeying.framework.utils.BeanMapper;
import org.apache.commons.lang3.StringUtils;

/**
 * User: bysun
 * Date: 2014/8/7
 * Time: 23:49
 */
public class GoodsInfoDto {

    private String goodsNum;
    private String goodsName;
    private String personName;
    private Integer goodsReturn;
    private String personPhone;
    private String remark;

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

    public Integer getGoodsReturn() {
        return goodsReturn;
    }

    public void setGoodsReturn(Integer goodsReturn) {
        this.goodsReturn = goodsReturn;
    }

    public String getPersonPhone() {
        return personPhone;
    }

    public void setPersonPhone(String personPhone) {
        this.personPhone = personPhone;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


    public Goods build(){
        Goods g = new Goods();
        BeanMapper.copy(this, g);
        g.setGoodsType(this.goodsNum.toUpperCase().substring(0,1));
        return g;
    }

    public Goods build(Goods source){
        BeanMapper.copy(this,source);
        source.setGoodsType(this.goodsNum.toUpperCase().substring(0,1));
        return source;
    }
}
