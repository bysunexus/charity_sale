package com.quyeying.charity.report.controller;

import com.quyeying.charity.commons.ResultDto;
import com.quyeying.charity.report.dto.DataTableResultDto;
import com.quyeying.charity.report.dto.TotalReportDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping
    public ModelAndView goTotalReport() {
        return new ModelAndView("report/total_report");
    }

    @RequestMapping("/findTotalTable")
    public @ResponseBody ResultDto findTotalTable(String iDisplayLength, String iDisplayStart) {
        ResultDto result;
        List<TotalReportDto> list = new ArrayList<>();

        DataTableResultDto tableResultDto = new DataTableResultDto();

        for(int i = 0; i <= 10; i++) {
            TotalReportDto totalReportDto = new TotalReportDto();
            totalReportDto.setBscode("A0" + i);
            totalReportDto.setAge(String.valueOf(i));
            totalReportDto.setAmount(String.valueOf(i));
            totalReportDto.setName("金砖");
            totalReportDto.setPkid(String.valueOf(i));
            totalReportDto.setSex("男");
            totalReportDto.setTel("010-" + i);
            list.add(totalReportDto);
        }

        tableResultDto.setData(list);
        tableResultDto.setiTotalRecords(1);
        tableResultDto.setiTotalDisplayRecords(20);


        result = ResultDto.getSuccess(tableResultDto);
        return result;
    }

}
