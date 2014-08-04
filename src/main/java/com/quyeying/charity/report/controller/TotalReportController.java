package com.quyeying.charity.report.controller;

import com.quyeying.charity.base.dto.DataTablesResp;
import com.quyeying.charity.domain.Goods;
import com.quyeying.charity.goods.service.GoodsRepository;
import com.quyeying.charity.report.dto.ReportDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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

    protected Logger logger = LoggerFactory.getLogger(TotalReportController.class);

    @Resource(name = "goodsRepository")
    private GoodsRepository repo;

    @Autowired
    private Environment appProperties;

    @RequestMapping
    public ModelAndView goTotalReport() {
        return new ModelAndView("report/total_report");
    }

    @RequestMapping(value = "/findTotalTable", method = RequestMethod.POST)
    public
    @ResponseBody
    DataTablesResp findTotalTable(@RequestBody ReportDto dto) {

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

    /**
     * 导出总报表 Excel
     *
     * @return ResponseEntity
     *
     * @throws IOException
     */
    @RequestMapping(value = "/exportExcel/{goodsNum}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> exportExcel(@PathVariable("goodsNum") String goodsNum) throws IOException {

        DataTablesResp result = new DataTablesResp();

        List<Goods> list = repo.findByGoodsNum(null == goodsNum ? "" : goodsNum);

        if(null != list && list.size() > 0) {

        }

        String filepath="/static/template/totalTemplate.xls";
        InputStream inp = new FileInputStream(filepath);
//        Workbook wb = WorkbookFactory.create(inp);
//        Sheet sheet = wb.getSheetAt(0);




        HttpHeaders headers = new HttpHeaders();
        String fileName = new String("爱心义卖销售报表.xls".getBytes("UTF-8"), "iso-8859-1");
        headers.setContentDispositionFormData("attachment", fileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        byte[] data = new byte[2];//要下载的数据流
        return new ResponseEntity<byte[]>(data, headers, HttpStatus.CREATED);


    }

    public static void print(Object o) {
        System.out.println(o);
    }

    public static void main(String[] args) {


    }


}
