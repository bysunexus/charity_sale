package com.charity.core.dto;

import com.charity.core.Const;

/**
 * User: bysun
 * Date: 2014/10/8
 * Time: 20:56
 * json 响应数据统一封装
 */
public class JsonResult {
    private String msg;
    private boolean success;
    private Object data;

    public JsonResult() {
    }

    public JsonResult(String msg, boolean success, Object data) {
        this.msg = msg;
        this.success = success;
        this.data = data;
    }

    /**
     * 成功消息
     *
     * @param data 查询数据
     * @return 响应数据
     */
    public static JsonResult success(Object data) {
        return success(data, Const.SUCCESS_STR);
    }

    /**
     * 成功消息
     *
     * @param msg 成功消息
     * @return 响应数据
     */
    public static JsonResult successMsg(String msg) {
        return success(null, msg);
    }

    /**
     * 成功消息
     *
     * @param data 查询数据
     * @param msg  成功消息
     * @return 响应数据
     */
    public static JsonResult success(Object data, String msg) {
        return new JsonResult(msg, true, data);
    }

    /**
     * 失败消息
     *
     * @param msg 失败消息
     * @return 响应数据
     */
    public static JsonResult failure(String msg) {
        return new JsonResult(msg, false, null);
    }

    /**
     * 失败消息
     *
     * @param msg 失败消息
     * @param ex  异常信息
     * @return 响应数据
     */
    public static JsonResult failure(String msg, Object ex) {
        return new JsonResult(msg, false, ex);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "JsonResult{" +
            "msg='" + msg + '\'' +
            ", success=" + success +
            ", data=" + data +
            '}';
    }
}
