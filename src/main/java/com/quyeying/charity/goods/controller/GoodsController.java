package com.quyeying.charity.goods.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: bysun
 * Date: 2014/6/15
 * Time: 8:30
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {

    @RequestMapping
    public String goods(){
        return "goods/goods_main";
    }
}
