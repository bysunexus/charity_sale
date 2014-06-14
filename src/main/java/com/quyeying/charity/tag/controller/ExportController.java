package com.quyeying.charity.tag.controller;

import com.quyeying.charity.commons.ResultDto;
import com.quyeying.charity.tag.PriceTagCreator;
import com.quyeying.charity.tag.TagDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Properties;

/**
 * User: bysun
 * Date: 2014/6/5 0005
 * Time: 16:20
 */
@Controller
@RequestMapping("/priceTag")
public class ExportController {
    protected final static Logger log = LoggerFactory.getLogger(ExportController.class);

    @Resource(name = "appProperties")
    private Properties appProperties;

    @RequestMapping
    public String main() {
        return "tag/main";
    }

    @RequestMapping("/export")
    public
    @ResponseBody
    ResultDto export(@Valid TagDto dto, BindingResult br) {
        // 验证
        ResultDto result;
        if (br.hasErrors()) {
            StringBuilder errs = new StringBuilder();
            for (ObjectError oe : br.getAllErrors()) {
                errs.append(oe.getDefaultMessage()).append("<br/>");
            }
            return ResultDto.get(errs.toString());
        }

        // 创建pdf文件
        dto.setBase(appProperties.getProperty("file.path.pdf"));
        try {
            PriceTagCreator creator = new PriceTagCreator(dto);
            String file = creator.create();
            result = ResultDto.getSuccess(file);
        } catch (Exception e) {
            log.info("生成导出文件失败", e);
            result = ResultDto.get("生成导出文件失败");
        }
        return result;
    }
}
