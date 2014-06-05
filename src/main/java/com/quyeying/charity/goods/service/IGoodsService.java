package com.quyeying.charity.goods.service;

import com.quyeying.charity.domain.Goods;

import java.io.Serializable;

/**
 * User: bysun
 * Date: 2014/5/28 0028
 * Time: 16:41
 */
public interface IGoodsService {

    /**
     * 保存捐品信息
     * @param goods 捐品
     * @return 捐品id
     */
    String save(Goods goods);
}
