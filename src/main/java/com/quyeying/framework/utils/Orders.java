package com.quyeying.framework.utils;

/**
 * User: bysun
 * Date: 2014/8/7
 * Time: 20:12
 */
public class Orders {

    public static long longOrder(String key) {
        long order = 0;
        if (null != key)
            for (char c : key.toCharArray()) {
                order += c;
            }
        return order;
    }
}
