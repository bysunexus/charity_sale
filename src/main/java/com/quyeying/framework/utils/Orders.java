package com.quyeying.framework.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * User: bysun
 * Date: 2014/8/7
 * Time: 20:12
 */
public class Orders {

    private final static Map<Character, Character> CHARS = new HashMap<Character, Character>() {{
        put('A', '1');
        put('B', '2');
        put('C', '3');
        put('D', '4');
        put('E', '5');
    }};

    public static long longOrder(String key) {

        long order = 0;
        if (null != key && key.length() < 5) {
            char[] chars = key.toCharArray();
            char[] tmp = new char[]{'0', '0', '0', '0'};
            tmp[0] = null == CHARS.get(chars[0]) ? '0' : CHARS.get(chars[0]);
            int idx = 3;
            for (int i = chars.length - 1; i >= 1; i--) {
                tmp[idx--] = chars[i];
            }
            order = Long.parseLong(new String(tmp));
        }
        return order;
    }
}
