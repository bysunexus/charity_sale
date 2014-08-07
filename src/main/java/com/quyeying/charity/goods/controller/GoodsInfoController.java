package com.quyeying.charity.goods.controller;

import com.quyeying.charity.commons.IResultDto;
import com.quyeying.charity.commons.ResultDto;
import com.quyeying.charity.commons.ValidResultDto;
import com.quyeying.charity.domain.Goods;
import com.quyeying.charity.domain.User;
import com.quyeying.charity.goods.dto.GoodsInfoDto;
import com.quyeying.charity.goods.service.GoodsRepository;
import com.quyeying.charity.storage.dto.GoodsSaveDto;
import com.quyeying.framework.utils.Orders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * User: bysun
 * Date: 2014/8/7
 * Time: 20:53
 */
@Controller
@RequestMapping("/goodsRecord")
public class GoodsInfoController {

    protected Logger logger = LoggerFactory.getLogger(GoodsInfoController.class);

    @Resource(name = "goodsRepository")
    private GoodsRepository repo;

    @RequestMapping(value = "/check/{goodsNum}", method = RequestMethod.GET)
    @ResponseBody
    public IResultDto check(@PathVariable("goodsNum") String goodsNum) {
        ResultDto result;

        try {
            result = ResultDto.getSuccess(repo.findByNum(goodsNum.toUpperCase()));
        } catch (Exception e) {
            logger.info("查询捐品信息时发生错误,goodsNum=" + goodsNum, e);
            result = ResultDto.get("查询捐品信息时发生错误");
        }

        return result;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String main() {
        return "goodsinfo/goodsinfo";
    }


    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public IResultDto save(GoodsInfoDto dto) {
        ResultDto resultDto;
        try {
            Goods goods = repo.findByNum(dto.getGoodsNum());
            if (null != goods)
                goods = dto.build(goods);
            else
                goods = dto.build();

            goods.setGoodsNumOrder(Orders.longOrder(goods.getGoodsNum()));

            resultDto = ResultDto.getSuccess(repo.save(goods));

        } catch (Exception e) {
            logger.info("保存捐品信息时发生错误[" + dto.toString() + "]", e);
            resultDto = ResultDto.get("保存捐品信息时发生错误");
        }
        return resultDto;
    }
}
