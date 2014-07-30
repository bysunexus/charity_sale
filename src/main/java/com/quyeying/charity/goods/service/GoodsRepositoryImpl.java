package com.quyeying.charity.goods.service;

import com.quyeying.charity.domain.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * User: bysun
 * Date: 2014/7/29
 * Time: 17:20
 */
public class GoodsRepositoryImpl implements GoodsRepositoryCustom {
    @Autowired
    protected MongoTemplate mongo;

//    Page<Goods> findByDto(XxxDto dto, Pageable pageable){
//
//        return null;
//    }

}
