package com.quyeying.charity.goods.controller;

import com.quyeying.charity.commons.ResultDto;
import com.quyeying.charity.goods.scheduler.SaleMoneyPoster;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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


    /**
     * @param goodsType 卷品类型
     * @return 销售额
     */
    @RequestMapping(value = "/{goodsType}",method = RequestMethod.GET)
    @ResponseBody
    public ResultDto poll(@PathVariable("goodsType") String goodsType) {
        switch (goodsType) {
            case "A":
            case "B":
            case "C":
            case "D":
            case "E":
                return ResultDto.getSuccess(SaleMoneyPoster.getInstance().getSaleMoney(goodsType));
            case "ALL":
                return ResultDto.getSuccess(SaleMoneyPoster.getInstance().getSmMap());
            default:
                return ResultDto.getSuccess(SaleMoneyPoster.getInstance().getSaleMoney(SaleMoneyPoster.NULL));
        }
    }
}
