package com.quyeying.charity.report.controller;

import com.quyeying.charity.base.dto.DataTablesResp;
import com.quyeying.charity.domain.Goods;
import com.quyeying.charity.goods.service.GoodsRepository;
import com.quyeying.charity.report.dto.ReportDto;
import org.apache.commons.io.IOUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
import java.io.ByteArrayOutputStream;
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
    public ResponseEntity<byte[]> exportExcel(@PathVariable("goodsNum") String goodsNum) throws IOException, InvalidFormatException {
        List<Goods> list = repo.findByGoodsNum((null == goodsNum || "null".equals(goodsNum)) ? "" : goodsNum);
        InputStream inp = this.getClass().getClassLoader().getResourceAsStream("template/totalTemplate.xlsx");

        XSSFWorkbook wb = getXssfSheets(list, inp);

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        wb.write(stream);
        stream.flush();

        HttpHeaders headers = new HttpHeaders();
        String fileName = new String("爱心义卖销售报表.xlsx".getBytes("UTF-8"), "iso-8859-1");
        headers.setContentDispositionFormData("attachment", fileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        byte[] data = stream.toByteArray();
        IOUtils.closeQuietly(stream);
        return new ResponseEntity<byte[]>(data, headers, HttpStatus.CREATED);

    }

    /**
     * 获取XSSFWorkbook
     * @param list 数据源
     * @param inp InputStream
     * @return XSSFWorkbook
     * @throws IOException
     */
    @SuppressWarnings("ConstantConditions")
    private XSSFWorkbook getXssfSheets(List<Goods> list, InputStream inp) throws IOException {
        XSSFWorkbook wb = new XSSFWorkbook(inp);
        int a = 2, b = 2, c = 2, d = 2, e = 2;

        if (null != list && list.size() > 0) {
            for (Goods item : list) {
                Row row = null;

                switch (item.getGoodsType()) {
                    case "A":
                        row = getRow(wb, 1, a);
                        a++;
                        break;
                    case "B":
                        row = getRow(wb, 2, b);
                        b++;
                        break;
                    case "C":
                        row = getRow(wb, 3, c);
                        c++;
                        break;
                    case "D":
                        row = getRow(wb, 4, d);
                        d++;
                        break;
                    case "E":
                        row = getRow(wb, 5, e);
                        e++;
                        break;
                }

                if (null == row)
                    continue;

                buildCell(item, row);

            }
        }
        return wb;
    }

    /**
     * 构建单元格数据
     * @param item goods
     * @param row row
     */
    private void buildCell(Goods item, Row row) {
        int idx = 0;

        Cell cell = row.getCell(idx);
        if (null == cell)
            cell = row.createCell(idx);
        cell.setCellType(Cell.CELL_TYPE_STRING);
        cell.setCellValue(item.getGoodsNum());
        idx++;

        cell = row.getCell(idx);
        if (null == cell)
            cell = row.createCell(idx);
        cell.setCellType(Cell.CELL_TYPE_STRING);
        cell.setCellValue(item.getPersonName());
        idx++;

        cell = row.getCell(idx);
        if (null == cell)
            cell = row.createCell(idx);
        cell.setCellType(Cell.CELL_TYPE_STRING);
        cell.setCellValue(item.getPersonPhone());
        idx++;

        cell = row.getCell(idx);
        if (null == cell)
            cell = row.createCell(idx);
        cell.setCellType(Cell.CELL_TYPE_STRING);
        cell.setCellValue(item.getGoodsName());
        idx++;

        cell = row.getCell(idx);
        if (null == cell)
            cell = row.createCell(idx);
        cell.setCellType(Cell.CELL_TYPE_STRING);
        cell.setCellValue(item.getGoodsCount());
        idx++;

        if ("E".equals(item.getGoodsType())) {
            cell = row.getCell(idx);
            if (null == cell)
                cell = row.createCell(idx);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue(item.getGoodsPrice());
            idx++;
        }

        cell = row.getCell(idx);
        if (null == cell)
            cell = row.createCell(idx);
        cell.setCellType(Cell.CELL_TYPE_STRING);
        int saleCount = 0;
        if (null != item.getSaleInfos()) {
            for (Goods.SaleInfo saleInfo : item.getSaleInfos()) {
                saleCount += saleInfo.getSaleCount();
            }
        }
        cell.setCellValue(saleCount);
        idx++;

        cell = row.getCell(idx);
        if (null == cell)
            cell = row.createCell(idx);
        cell.setCellType(Cell.CELL_TYPE_STRING);
        int saleMoney = 0;
        if (null != item.getSaleInfos()) {
            for (Goods.SaleInfo saleInfo : item.getSaleInfos()) {
                saleMoney += saleInfo.getSaleMoney();
            }
        }
        cell.setCellValue(saleMoney);
        idx++;

        cell = row.getCell(idx);
        if (null == cell)
            cell = row.createCell(idx);
        cell.setCellType(Cell.CELL_TYPE_STRING);
        cell.setCellValue(item.getRemark());
        idx++;

        cell = row.getCell(idx);
        if (null == cell)
            cell = row.createCell(idx);
        cell.setCellType(Cell.CELL_TYPE_STRING);
        cell.setCellValue(item.getGoodsCount() - saleCount);
        idx++;
    }

    /**
     * 获取row
     * @param wb Workbook
     * @param idx idx
     * @param rowNum rowNum
     * @return
     */
    private Row getRow(Workbook wb, int idx, int rowNum) {
        Row row = wb.getSheetAt(idx).getRow(rowNum);
        if (null == row) {
            row = wb.getSheetAt(idx).createRow(rowNum);
        }
        return row;
    }

}
