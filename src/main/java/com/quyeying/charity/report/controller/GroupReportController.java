package com.quyeying.charity.report.controller;

import com.quyeying.charity.base.dto.DataTablesResp;
import com.quyeying.charity.domain.Goods;
import com.quyeying.charity.domain.User;
import com.quyeying.charity.goods.service.GoodsRepository;
import com.quyeying.charity.report.dto.GroupReportDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * charity_sale
 * com.quyeying.charity.report.controller
 * Created with IntelliJ IDEA.
 * User: Watson
 * Date: 2014/7/23
 * Time: 21:01
 */
@Controller
@RequestMapping("/groupReport")
public class GroupReportController {

    @Resource(name = "goodsRepository")
    private GoodsRepository repo;


    @RequestMapping
    public ModelAndView goGroupReport() {
        return new ModelAndView("report/group_report");
    }


    @RequestMapping(value = "/findTotalTable", method = RequestMethod.POST)
    public
    @ResponseBody
    DataTablesResp findTotalTable(@RequestBody GroupReportDto dto, @ModelAttribute("CURRENT_USER") User user) {

        dto.setGoodsType(user.getGroup());

        DataTablesResp result = new DataTablesResp();

        Page<Goods> list = repo.findByGoodsType(user.getGroup(), dto.getPageRequest());
        result.setData(list.getContent());
        int total = Long.valueOf(list.getTotalElements()).intValue();
        result.setRecordsTotal(total);
        result.setRecordsFiltered(total);

        return result;
    }

}
