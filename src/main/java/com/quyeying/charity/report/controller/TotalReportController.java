package com.quyeying.charity.report.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * charity_sale
 * com.quyeying.charity.report.controller
 * Created with IntelliJ IDEA.
 * User: Watson
 * Date: 2014/6/16
 * Time: 15:38
 */
@Controller
public class TotalReportController {

    @RequestMapping(value = "goTotalReport")
    public ModelAndView goTotalReport() {
        return new ModelAndView("report/total_report");
    }

}
