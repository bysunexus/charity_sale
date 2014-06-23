package com.quyeying.charity.commons;

/**
 * User: bysun
 * Date: 2014/6/23
 * Time: 20:47
 */
public interface IResultDto<T> {

    boolean isSuccess();

    String getMsg();

    T getData();

}
