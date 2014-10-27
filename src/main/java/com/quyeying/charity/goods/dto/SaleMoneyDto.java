package com.quyeying.charity.goods.dto;

import java.util.HashMap;
import java.util.Map;

/**
 * User: bysun
 * Date: 2014/8/3
 * Time: 19:14
 */
public class SaleMoneyDto {

    private Map<String,Double> groupSaleMoney = new HashMap<>();

    private Double totalSaleMoney;

    public Map<String, Double> getGroupSaleMoney() {
        return groupSaleMoney;
    }

    public void setGroupSaleMoney(Map<String, Double> groupSaleMoney) {
        this.groupSaleMoney = groupSaleMoney;
    }

    public Double getTotalSaleMoney() {
        return totalSaleMoney;
    }

    public void setTotalSaleMoney(Double totalSaleMoney) {
        this.totalSaleMoney = totalSaleMoney;
    }
}
