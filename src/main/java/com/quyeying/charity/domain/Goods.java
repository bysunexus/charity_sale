package com.quyeying.charity.domain;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
        A("A", "2元区", 2),
        B("B", "5元区", 5),
        C("C", "10元区", 10),
        D("D", "30元区", 30),
        E("E", "50元及以上", true);

        GoodsType(String code, String name, int price) {
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
        private double price = 0.0;
        private boolean ext;

        public String getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
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
    private Double goodsPrice;

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

    private long goodsNumOrder;

    public Goods() {
    }

    public String getPkid() {
        return pkid;
    }

    public void setPkid(String pkid) {
        this.pkid = StringUtils.trimToNull(pkid);
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        if (null == goodsType)
            return;
        this.goodsType = StringUtils.trimToNull(goodsType.toUpperCase());
    }

    public String getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(String goodsNum) {
        if (null == goodsNum)
            return;
        this.goodsNum = StringUtils.trimToNull(goodsNum.toUpperCase());
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = StringUtils.trimToNull(personName);
    }

    public String getPersonPhone() {
        return personPhone;
    }

    public void setPersonPhone(String personPhone) {
        this.personPhone = StringUtils.trimToNull(personPhone);
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = StringUtils.trimToNull(goodsName);
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
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
        this.remark = StringUtils.trimToNull(remark);
    }

    public Integer getGoodsReturn() {
        return goodsReturn;
    }

    public void setGoodsReturn(Integer goodsReturn) {
        this.goodsReturn = goodsReturn;
    }

    public long getGoodsNumOrder() {
        return goodsNumOrder;
    }

    public void setGoodsNumOrder(long goodsNumOrder) {
        this.goodsNumOrder = goodsNumOrder;
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
        private Double saleMoney;

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

        public Double getSaleMoney() {
            return saleMoney;
        }

        public void setSaleMoney(Double saleMoney) {
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

        @Override
        public String toString() {
            return "SaleInfo{" +
                "saleCount=" + saleCount +
                ", saleMoney=" + saleMoney +
                ", saleType=" + saleType +
                ", remark='" + remark + '\'' +
                '}';
        }
    }

    @Override
    public String toString() {
        return "Goods{" +
            "pkid='" + pkid + '\'' +
            ", goodsType='" + goodsType + '\'' +
            ", goodsNum='" + goodsNum + '\'' +
            ", personName='" + personName + '\'' +
            ", personPhone='" + personPhone + '\'' +
            ", goodsName='" + goodsName + '\'' +
            ", goodsCount=" + goodsCount +
            ", goodsPrice=" + goodsPrice +
            ", goodsReturn=" + goodsReturn +
            ", saleInfos=" + saleInfos +
            ", remark='" + remark + '\'' +
            '}';
    }

    /**
     * 订单类型
     */
    public static enum SaleType {
        NORMAL(1), MAKEUP(0);
        private int value;

        SaleType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
