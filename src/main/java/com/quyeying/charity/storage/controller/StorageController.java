package com.quyeying.charity.storage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * charity_sale
 * com.quyeying.charity.storage.controller
 * Created with IntelliJ IDEA.
 * User: Watson
 * Date: 2014/6/16
 * Time: 14:50
 */
@Controller
public class StorageController {

    @RequestMapping(value = "goStorage")
    public ModelAndView goStorage() {
        return new ModelAndView("storage/storage");
    }

}
