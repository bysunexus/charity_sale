package com.charity.core.controller;

import com.charity.core.Const;
import com.charity.core.dto.JsonResult;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * User: bysun
 * Date: 2014/10/10
 * Time: 18:04
 * 实现异常的统一处理
 */
public class CustomExceptionResolve extends SimpleMappingExceptionResolver {

    protected final static Logger log = LoggerFactory.getLogger(CustomExceptionResolve.class);

    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        // 设置异常返回
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        log.error("request ["+request.getRequestURI()+"] error",ex);


        // 获取页面响应
        String viewName = determineViewName(ex, request);
        //判断是否是ajax请求
        if (viewName != null && !isAjax(request)) {// JSP格式返回
            Integer statusCode = determineStatusCode(request, viewName);
            if (statusCode != null) {
                applyStatusCodeIfPossible(request, response, statusCode);
            }
            return getModelAndView(viewName, ex);
        } else { // JSON格式返回
            MappingJackson2JsonView view = new MappingJackson2JsonView();
            view.setExtractValueFromSingleKeyModel(true);
            ModelAndView result = new ModelAndView(view);
            result.addObject(JsonResult.failure(Const.FAILURE_STR, ex.getMessage()));
            return result;
        }
    }

    private boolean isAjax(HttpServletRequest request) {
        return StringUtils.containsIgnoreCase(request.getHeader("accept"), "json")
            || StringUtils.containsIgnoreCase(request.getHeader("accept"), "javascript")
            || StringUtils.containsIgnoreCase(request.getHeader("X-Requested-With"), "XMLHttpRequest");
    }
}
