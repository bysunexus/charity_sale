package com.quyeying.charity.storage.controller;

import com.quyeying.charity.commons.IResultDto;
import com.quyeying.charity.commons.ResultDto;
import com.quyeying.charity.domain.Goods;
import com.quyeying.charity.goods.service.GoodsRepository;
import com.quyeying.charity.storage.dto.GoodsSaleDto;
import com.quyeying.framework.utils.JsonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * User: bysun
 * Date: 2014/7/19
 * Time: 15:44
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    protected Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Resource(name = "goodsRepository")
    private GoodsRepository repo;

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView sale(String salesStr) {
        JsonMapper mapper = JsonMapper.nonDefaultMapper();
        List<GoodsSaleDto> sales = mapper.fromJson(
            salesStr,
            mapper.contructCollectionType(List.class, GoodsSaleDto.class)
        );
        for (GoodsSaleDto sale : sales) {
            sale.setGoods(repo.findOne(sale.getId()));
        }
        ModelAndView result = new ModelAndView("storage/order");
        result.addObject("salesJson", JsonMapper.nonDefaultMapper().toJson(sales));
        result.addObject("sales", sales);
        return result;
    }

    @RequestMapping(value = "/sale",method = RequestMethod.POST)
    public @ResponseBody IResultDto confirm(@RequestBody List<GoodsSaleDto> datas) {

        for (GoodsSaleDto data : datas) {
            Goods goods = repo.findOne(data.getId());

            List<Goods.SaleInfo> sales = goods.getSaleInfos();
            if (null == sales)
                sales = new ArrayList<>();

            sales.add(data.toSaleInfo());

            goods.setSaleInfos(sales);

            repo.save(goods);
        }

        return ResultDto.get(true,"操作成功!");
    }

}
