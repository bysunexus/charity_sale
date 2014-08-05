package com.quyeying.charity.goods.dto;

import java.util.HashMap;
import java.util.Map;

/**
 * User: bysun
 * Date: 2014/8/3
 * Time: 19:14
 */
public class SaleMoneyDto {

    private Map<String,Integer> groupSaleMoney = new HashMap<>();

    private Integer totalSaleMoney;

    public Map<String, Integer> getGroupSaleMoney() {
        return groupSaleMoney;
    }

    public void setGroupSaleMoney(Map<String, Integer> groupSaleMoney) {
        this.groupSaleMoney = groupSaleMoney;
    }

    public Integer getTotalSaleMoney() {
        return totalSaleMoney;
    }

    public void setTotalSaleMoney(Integer totalSaleMoney) {
        this.totalSaleMoney = totalSaleMoney;
    }
}
