package com.quyeying.charity.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: bysun
 * Date: 2014/6/5 0005
 * Time: 13:57
 */
@Controller
@RequestMapping
public class MainController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/main")
    public String main(){
        return "main";
    }

}
