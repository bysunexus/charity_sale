package com.quyeying.charity.tag.controller;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Properties;

/**
 * User: bysun
 * Date: 2014/6/14
 * Time: 20:21
 */
@Controller
@RequestMapping
public class DownloadController {
    protected final static Logger log = LoggerFactory.getLogger(DownloadController.class);
    @Autowired
    private Environment appProperties;

    @RequestMapping(value = "/download/{path}/{file:.*}", method = RequestMethod.GET)
    public void download(@PathVariable("path") String path, @PathVariable("file") String file, HttpServletResponse resp) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        String basePath = appProperties.getProperty("file.path." + path);

        String downFile = basePath+"/"+path+"/" + file;
        log.debug("下载文件:[" + downFile + "]");
        try {
            long fileLength = new File(downFile).length();
            resp.setContentType("application/x-msdownload;");
            resp.setHeader("Content-disposition", "attachment; filename=" + file);
            resp.setHeader("Content-Length", String.valueOf(fileLength));
            bis = new BufferedInputStream(new FileInputStream(downFile));
            bos = new BufferedOutputStream(resp.getOutputStream());
            byte[] buff = new byte[4096];
            int bytesRead;
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
        } catch (IOException e) {
            log.debug("找不到文件[" + downFile + "]", e);
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        } finally {
            IOUtils.closeQuietly(bis);
            IOUtils.closeQuietly(bos);
        }
    }

}
