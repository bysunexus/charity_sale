package com.quyeying.charity.commons;

/**
 * User: bysun
 * Date: 2014/6/5 0005
 * Time: 16:29
 */
public class ResultDto<T> implements IResultDto<T> {
    //是否成功
    private boolean success;
    // 描述信息
    private String msg;
    // 返回数据
    private T data;

    private ResultDto(String msg) {
        this.msg = msg;
    }

    private ResultDto(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    private ResultDto( T data) {
        this.success = true;
        this.data = data;
    }

    private ResultDto(boolean success, String msg, T data) {
        this.success = success;
        this.msg = msg;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * 失败信息
     * @param msg 消息
     * @return ResultDto{success:false,msg:#msg,data:null}
     */
    public static ResultDto get(String msg){
        return new ResultDto(msg);
    }

    /**
     * 自定义信息
     * @param success 成功失败
     * @param msg 消息
     * @return ResultDto{success:#success,msg:#msg,data:null}
     */
    public static ResultDto get(boolean success,String msg){
        return new ResultDto(success,msg);
    }

    /**
     * 成功信息
     * @param data 返回数据
     * @return ResultDto{success:true,msg:null,data:#data}
     */
    public static <T> ResultDto<T> getSuccess(T data){
        return new ResultDto(data);
    }

    /**
     * 自定义信息
     * @param success 成功失败
     * @param msg 消息
     * @param data 数据
     * @return ResultDto{success:#success,msg:#msg,data:#data}
     */
    public static <T> ResultDto<T> get(boolean success,String msg,T data){
        return new ResultDto(success,msg,data);
    }

}
