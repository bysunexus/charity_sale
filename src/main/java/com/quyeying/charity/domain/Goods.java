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
        A("A", "2元区"),
        B("B", "5元区"),
        C("C", "10元区"),
        D("D", "25元区"),
        E("E", "50元及以上",true);

        GoodsType(String code, String name) {
            this.code = code;
            this.name = name;
        }

        GoodsType(String code, String name, boolean ext) {
            this.code = code;
            this.name = name;
            this.ext = ext;
        }

        private String code;
        private String name;
        private boolean ext;

        public String getCode() {
            return code;
        }

        public String getName() {
            return name;
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
     * 单号
     */
    private String goodsNum;

    /**
     * 捐赠者id
     */
    private String personCode;

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

    public String getPersonCode() {
        return personCode;
    }

    public void setPersonCode(String personCode) {
        this.personCode = personCode;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Goods)) return false;

        Goods goods = (Goods) o;

        if (goodsCount != null ? !goodsCount.equals(goods.goodsCount) : goods.goodsCount != null) return false;
        if (goodsName != null ? !goodsName.equals(goods.goodsName) : goods.goodsName != null) return false;
        if (goodsNum != null ? !goodsNum.equals(goods.goodsNum) : goods.goodsNum != null) return false;
        if (goodsPrice != null ? !goodsPrice.equals(goods.goodsPrice) : goods.goodsPrice != null) return false;
        if (personCode != null ? !personCode.equals(goods.personCode) : goods.personCode != null) return false;
        if (personPhone != null ? !personPhone.equals(goods.personPhone) : goods.personPhone != null) return false;
        if (pkid != null ? !pkid.equals(goods.pkid) : goods.pkid != null) return false;
        if (remark != null ? !remark.equals(goods.remark) : goods.remark != null) return false;
        if (saleInfos != null ? !saleInfos.equals(goods.saleInfos) : goods.saleInfos != null) return false;

        return true;
    }

    @Override
    public String toString() {
        return "Goods{" +
            "pkid='" + pkid + '\'' +
            ", goodsNum='" + goodsNum + '\'' +
            ", personCode='" + personCode + '\'' +
            ", personPhone='" + personPhone + '\'' +
            ", goodsName='" + goodsName + '\'' +
            ", goodsCount=" + goodsCount +
            ", goodsPrice=" + goodsPrice +
            ", saleInfos=" + saleInfos +
            ", remark='" + remark + '\'' +
            '}';
    }

    @Override
    public int hashCode() {
        int result = pkid != null ? pkid.hashCode() : 0;
        result = 31 * result + (goodsNum != null ? goodsNum.hashCode() : 0);
        result = 31 * result + (personCode != null ? personCode.hashCode() : 0);
        result = 31 * result + (personPhone != null ? personPhone.hashCode() : 0);
        result = 31 * result + (goodsName != null ? goodsName.hashCode() : 0);
        result = 31 * result + (goodsCount != null ? goodsCount.hashCode() : 0);
        result = 31 * result + (goodsPrice != null ? goodsPrice.hashCode() : 0);
        result = 31 * result + (saleInfos != null ? saleInfos.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        return result;
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof SaleInfo)) return false;

            SaleInfo saleInfo = (SaleInfo) o;

            if (saleCount != null ? !saleCount.equals(saleInfo.saleCount) : saleInfo.saleCount != null) return false;
            if (saleMoney != null ? !saleMoney.equals(saleInfo.saleMoney) : saleInfo.saleMoney != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = saleCount != null ? saleCount.hashCode() : 0;
            result = 31 * result + (saleMoney != null ? saleMoney.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "SaleInfo{" +
                "saleCount=" + saleCount +
                ", saleMoney=" + saleMoney +
                '}';
        }
    }

}
