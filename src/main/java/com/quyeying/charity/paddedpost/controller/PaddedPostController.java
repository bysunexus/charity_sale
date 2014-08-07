package com.quyeying.charity.paddedpost.controller;

import com.quyeying.charity.commons.IResultDto;
import com.quyeying.charity.commons.ResultDto;
import com.quyeying.charity.commons.ValidResultDto;
import com.quyeying.charity.domain.Goods;
import com.quyeying.charity.domain.User;
import com.quyeying.charity.goods.service.GoodsRepository;
import com.quyeying.charity.paddedpost.dto.PaddedPostDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * charity_sale
 * com.quyeying.charity.paddedpost.controller
 * Created with IntelliJ IDEA.
 * User: Watson
 * Date: 2014/8/7
 * Time: 20:19
 */
@Controller
@RequestMapping("/paddedPost")
public class PaddedPostController {

    protected Logger logger = LoggerFactory.getLogger(PaddedPostController.class);

    @Resource(name = "goodsRepository")
    private GoodsRepository repo;

    @RequestMapping
    public ModelAndView goPaddedPost() {
        return new ModelAndView("paddedpost/padded_post");
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public IResultDto save(@Valid PaddedPostDto dto, BindingResult result, @ModelAttribute("CURRENT_USER") User user) {

        // 校验数据对象
        if (result.hasErrors()) {
            ValidResultDto resultDto = ValidResultDto.get("校验失败");
            for (ObjectError oe : result.getAllErrors()) {
                resultDto.addValidMsg(oe.getObjectName(), oe.getDefaultMessage());
            }
            return resultDto;
        }

        Goods goods = repo.findByNum(dto.getGoodsNum().toUpperCase());

        if (null == goods) {
            ValidResultDto resultDto = ValidResultDto.get("商品编号不存在");
            for (ObjectError oe : result.getAllErrors()) {
                resultDto.addValidMsg(oe.getObjectName(), oe.getDefaultMessage());
            }
            return resultDto;
        } else {
            List<Goods.SaleInfo> sales = goods.getSaleInfos();
            if (null == sales)
                sales = new ArrayList<>();
            sales.add(dto.toSaleInfo(user));
            goods.setSaleInfos(sales);
            repo.save(goods);
            return ResultDto.get(true, "操作成功!");
        }

    }

}
