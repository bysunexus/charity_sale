package com.quyeying.charity.report.controller;

import com.quyeying.charity.commons.ResultDto;
import com.quyeying.charity.domain.Goods;
import com.quyeying.charity.domain.User;
import com.quyeying.charity.goods.service.GoodsRepository;
import com.quyeying.charity.report.dto.DataTableResultDto;
import com.quyeying.charity.report.dto.GroupReportDto;
import com.quyeying.charity.report.dto.TotalReportDto;
import com.quyeying.security.CharitySecurityUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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
    public @ResponseBody ResultDto findTotalTable(String sSearch, Integer iDisplayLength, Integer iDisplayStart, @ModelAttribute("CURRENT_USER") User user) {
        ResultDto result;
        DataTableResultDto tableResultDto = new DataTableResultDto();

        Page<Goods> list = repo.findByGoodsType(user.getGroup(), sSearch.toUpperCase(), new PageRequest((iDisplayStart / iDisplayLength), iDisplayLength));
        tableResultDto.setData(list.getContent());
        tableResultDto.setiTotalRecords(list.getTotalPages());
        tableResultDto.setiTotalDisplayRecords(list.getTotalElements());


        result = ResultDto.getSuccess(tableResultDto);
        return result;
    }

}
