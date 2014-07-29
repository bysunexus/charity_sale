package com.quyeying.charity.goods.service;

import com.quyeying.charity.domain.Goods;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * User: bysun
 * Date: 2014/7/29
 * Time: 17:18
 */
public interface GoodsRepositoryCustom {

    /**
     * 根据dto参数查询
     * @param dto 查询参数
     * @param pageable 分页信息
     * @return 捐品列表
     */
    Page<Goods> findByDto(XxxDto dto, Pageable pageable);
}
