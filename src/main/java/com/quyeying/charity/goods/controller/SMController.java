package com.quyeying.charity.goods.controller;

import com.quyeying.charity.goods.scheduler.SaleMoneyPoster;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * User: bysun
 * Date: 2014/8/5
 * Time: 0:25
 */
@Controller
@RequestMapping("/saleMoney")
public class SMController {
    @RequestMapping("/{goodsType}")
    @ResponseBody
    public DeferredResult<Integer> poll(@PathVariable("goodsType") String goodsType) {
        switch (goodsType) {
            case "A":
                break;
            case "B":
                break;
            case "C":
                break;
            case "D":
                break;
            case "E":
                break;
            case "ALL":
                break;
            default:
                goodsType = SaleMoneyPoster.NULL;
        }
        return SaleMoneyPoster.getInstance().register(goodsType);
    }
}
