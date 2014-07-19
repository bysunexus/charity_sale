package com.quyeying.charity.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

/**
 * User: bysun
 * Date: 2014/5/28 0028
 * Time: 11:01
 * 捐品表
 */
@Document(collection = "goods")
public class Goods {

    /**
     * 主键
     */
    @Id
    private String pkid;

    /**
     * 捐品类型
     */
    private String goodsType;

    public static enum GoodsType {
        A("A", "2元区",2),
        B("B", "5元区",5),
        C("C", "10元区",10),
        D("D", "25元区",25),
        E("E", "50元及以上",true);

        GoodsType(String code, String name,int price) {
            this.code = code;
            this.name = name;
            this.price = price;
        }

        GoodsType(String code, String name, boolean ext) {
            this.code = code;
            this.name = name;
            this.ext = ext;
        }

        private String code;
        private String name;
        private int price = 0;
        private boolean ext;

        public String getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        public int getPrice() {
            return price;
        }

        public boolean isExt() {
            return ext;
        }

        public static GoodsType getByCode(String code) {

            for (GoodsType type : GoodsType.values()) {
                if (type.getCode().equalsIgnoreCase(code)) {
                    return type;
                }
            }
            throw new NullPointerException("未知的捐品类型[" + code + "]");
        }
    }

    /**
     * 捐品编号
     */
    private String goodsNum;

    /**
     * 捐赠者
     */
    private String personName;

    /**
     * 捐赠者联系电话
     */
    private String personPhone;

    /**
     * 捐品名称
     */
    private String goodsName;

    /**
     * 捐品数量
     */
    private Integer goodsCount;

    /**
     * 捐品单价
     */
    private Integer goodsPrice;

    /**
     * 是否退回  0-不退回  1-退回
     */
    private Integer goodsReturn = 0;

    /**
     * 售货信息
     */
    private List<SaleInfo> saleInfos;

    /**
     * 备注信息
     */
    private String remark;

    public Goods() {
    }

    public String getPkid() {
        return pkid;
    }

    public void setPkid(String pkid) {
        this.pkid = pkid;
    }

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

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public Integer getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Integer goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public List<SaleInfo> getSaleInfos() {
        return saleInfos;
    }

    public void setSaleInfos(List<SaleInfo> saleInfos) {
        this.saleInfos = saleInfos;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getGoodsReturn() {
        return goodsReturn;
    }

    public void setGoodsReturn(Integer goodsReturn) {
        this.goodsReturn = goodsReturn;
    }

    /**
     * User: bysun
     * Date: 2014/5/28 0028
     * Time: 11:11
     * 售货信息
     */
    public static class SaleInfo {

        /**
         * 售出件数
         */
        private Integer saleCount;

        /**
         * 售出总价
         */
        private Integer saleMoney;

        /**
         * 0-补差订单   1-正常订单
         */
        private Integer saleType = 1;

        /**
         * 备注
         */
        private String remark;

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

        public Integer getSaleType() {
            return saleType;
        }

        public void setSaleType(Integer saleType) {
            this.saleType = saleType;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }


    }

    /**
     * 订单类型
     */
    public static enum SaleType{
        NORMAL(1),MAKEUP(0);
        private int value;

        SaleType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
