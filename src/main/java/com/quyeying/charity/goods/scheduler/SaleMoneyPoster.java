package com.quyeying.charity.goods.scheduler;

import com.quyeying.charity.goods.dto.SaleMoneyDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * User: bysun
 * Date: 2014/8/4
 * Time: 23:07
 */
public class SaleMoneyPoster {

    private volatile Map<String, Double> smMap = new ConcurrentHashMap<>();
    public final static String ALL = "ALL";
    public final static String NULL = "NULL";


    private SaleMoneyPoster() {
    }

    private static SaleMoneyPoster instance = new SaleMoneyPoster();

    public static SaleMoneyPoster getInstance() {
        return instance;
    }


    public Double getSaleMoney(String type){
        if (StringUtils.isBlank(type))
            return smMap.get(NULL);

        return smMap.get(type.toUpperCase());
    }

    public Map<String, Double> getSmMap() {
        return smMap;
    }

    protected void publish(SaleMoneyDto dto) {

        for (Map.Entry<String, Double> entry : dto.getGroupSaleMoney().entrySet()) {
            smMap.put(entry.getKey().toUpperCase(),entry.getValue());
        }
        smMap.put(ALL,dto.getTotalSaleMoney());
        smMap.put(NULL,0.0);
    }
}

