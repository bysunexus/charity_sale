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
    public final static String ALL = "ALL";
    public final static String NULL = "NULL";


    private SaleMoneyPoster() {
    }

    private static SaleMoneyPoster instance = new SaleMoneyPoster();

    public static SaleMoneyPoster getInstance() {
        return instance;
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
        }

        DeferredResult<Integer> result = saleMoneyMap.get(ALL);
        if (null == result) {
            result = new DeferredResult<>();
            saleMoneyMap.put(ALL, result);
        }
        result.setResult(dto.getTotalSaleMoney());
        result = saleMoneyMap.get(NULL);
        if (null == result) {
            result = new DeferredResult<>();
            saleMoneyMap.put(NULL, result);
        }
    }

}

