package com.quyeying.charity.commons;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * User: bysun
 * Date: 2014/6/23
 * Time: 20:53
 * 非线程安全对象
 */
public class ValidResultDto implements IResultDto<Map<String,Set<String>>> {

    // 描述信息
    private String msg;
    // 返回数据
    private Map<String,Set<String>> data = new HashMap<>();

    private ValidResultDto(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return Boolean.FALSE;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String,Set<String>> getData() {
        return data;
    }

    /**
     * 失败信息
     * @param msg 消息
     * @return ResultDto{success:false,msg:#msg,data:null}
     */
    public static ValidResultDto get(String msg){
        return new ValidResultDto(msg);
    }

    public ValidResultDto addValidMsg(String field,String msg){
        Set<String> msgs = data.get(field);
        if(null == msgs){
            msgs = new HashSet<>();
            data.put(field,msgs);
        }
        msgs.add(msg);
        return this;
    }

}
