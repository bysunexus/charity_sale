package com.quyeying.charity.storage.controller;

import com.quyeying.charity.commons.IResultDto;
import com.quyeying.charity.commons.ResultDto;
import com.quyeying.charity.commons.ValidResultDto;
import com.quyeying.charity.domain.Goods;
import com.quyeying.charity.domain.User;
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
import java.util.List;

/**
 * charity_sale
 * com.quyeying.charity.storage.controller
 * Created with IntelliJ IDEA.
 * User: Watson
 * Date: 2014/6/16
 * Time: 14:50
 */
@Controller
@RequestMapping("/storage")
public class StorageController {

    protected Logger logger = LoggerFactory.getLogger(StorageController.class);

    @Resource(name = "goodsRepository")
    private GoodsRepository repository;

    @RequestMapping
    public String main() {
        return "storage/storage";
    }

    @RequestMapping(value = "/check/{goodsNum}", method = RequestMethod.POST)
    @ResponseBody
    public IResultDto check(@PathVariable("goodsNum") String goodsNum, @ModelAttribute("CURRENT_USER") User user) {
        ResultDto result;

        try {
            result = ResultDto.getSuccess(repository.findByNum(goodsNum.toUpperCase()));
        } catch (Exception e) {
            logger.info("查询捐品信息时发生错误,goodsNum=" + goodsNum, e);
            result = ResultDto.get("查询捐品信息时发生错误");
        }

        return result;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public IResultDto save(@Valid GoodsSaveDto dto, BindingResult result, @ModelAttribute("CURRENT_USER") User user) {
        // 校验数据对象
        if (result.hasErrors()) {
            ValidResultDto resultDto = ValidResultDto.get("校验失败");
            for (ObjectError oe : result.getAllErrors()) {
                resultDto.addValidMsg(oe.getObjectName(), oe.getDefaultMessage());
            }
            return resultDto;
        }
        ResultDto resultDto;
        try {
            Goods goods = repository.findByNum(dto.getGoodsNum());
            if (null != goods)
                goods = dto.build(goods);
            else
                goods = dto.build();
            Goods.GoodsType goodsType = Goods.GoodsType.getByCode(goods.getGoodsType());
            if (!Goods.GoodsType.E.equals(goodsType))
                goods.setGoodsPrice(goodsType.getPrice());

            goods.setGoodsNumOrder(Orders.longOrder(goods.getGoodsNum()));

            resultDto = ResultDto.getSuccess(repository.save(goods));

        } catch (Exception e) {
            logger.info("保存捐品信息时发生错误[" + dto.toString() + "]", e);
            resultDto = ResultDto.get("保存捐品信息时发生错误[" + dto.toString() + "]");
        }



        return resultDto;
    }


}
