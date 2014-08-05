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

    private volatile Map<String, DeferredResult<Integer>> saleMoneyMap = new ConcurrentHashMap<>();
    private volatile Map<String, Integer> smMap = new ConcurrentHashMap<>();
    public final static String ALL = "ALL";
    public final static String NULL = "NULL";


    private SaleMoneyPoster() {
    }

    private static SaleMoneyPoster instance = new SaleMoneyPoster();

    public static SaleMoneyPoster getInstance() {
        return instance;
    }


    public Integer getSaleMoney(String type){
        if (StringUtils.isBlank(type))
            return smMap.get(NULL);

        return smMap.get(type.toUpperCase());
    }


    public DeferredResult<Integer> register(String type) {
        if (StringUtils.isBlank(type))
            return saleMoneyMap.get(NULL);

        return saleMoneyMap.get(type.toUpperCase());
    }

    protected void publish(SaleMoneyDto dto) {

        for (Map.Entry<String, Integer> entry : dto.getGroupSaleMoney().entrySet()) {
            DeferredResult<Integer> result = saleMoneyMap.get(entry.getKey());
            if (null == result) {
                result = new DeferredResult<>();
                saleMoneyMap.put(entry.getKey().toUpperCase(), result);
            }
            result.setResult(entry.getValue());
            smMap.put(entry.getKey().toUpperCase(),entry.getValue());
        }

        DeferredResult<Integer> result = saleMoneyMap.get(ALL);
        if (null == result) {
            result = new DeferredResult<>();
            saleMoneyMap.put(ALL, result);
            smMap.put(ALL,dto.getTotalSaleMoney());
        }
        result.setResult(dto.getTotalSaleMoney());
        result = saleMoneyMap.get(NULL);
        if (null == result) {
            result = new DeferredResult<>();
            saleMoneyMap.put(NULL, result);
            smMap.put(NULL,0);
        }
    }

}

