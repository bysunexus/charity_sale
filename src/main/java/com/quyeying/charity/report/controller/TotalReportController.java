package com.quyeying.charity.report.controller;

import com.quyeying.charity.base.dto.DataTablesResp;
import com.quyeying.charity.commons.ResultDto;
import com.quyeying.charity.domain.Goods;
import com.quyeying.charity.domain.User;
import com.quyeying.charity.goods.service.GoodsRepository;
import com.quyeying.charity.report.dto.GroupReportDto;
import com.quyeying.charity.report.dto.TotalReportDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * charity_sale
 * com.quyeying.charity.report.controller
 * Created with IntelliJ IDEA.
 * User: Watson
 * Date: 2014/6/16
 * Time: 15:38
 */
@Controller
@RequestMapping("/totalReport")
public class TotalReportController {

    @Resource(name = "goodsRepository")
    private GoodsRepository repo;

    @RequestMapping
    public ModelAndView goTotalReport() {
        return new ModelAndView("report/total_report");
    }

    @RequestMapping(value = "/findTotalTable", method = RequestMethod.POST)
    public
    @ResponseBody
    DataTablesResp findTotalTable(@RequestBody GroupReportDto dto) {

        dto.setGoodsType("");

        DataTablesResp result = new DataTablesResp();
        result.setDraw(dto.getDraw());

        Page<Goods> list = repo.findByDto(dto);
        result.setData(list.getContent());
        int total = Long.valueOf(list.getTotalElements()).intValue();
        result.setRecordsTotal(total);
        result.setRecordsFiltered(total);

        return result;
    }

}
