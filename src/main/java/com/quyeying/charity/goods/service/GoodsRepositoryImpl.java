package com.quyeying.charity.goods.service;

import com.quyeying.charity.domain.Goods;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.geo.GeoPage;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;


/**
 * User: bysun
 * Date: 2014/7/29
 * Time: 17:20
 */
public class GoodsRepositoryImpl implements GoodsRepositoryCustom {

    @Autowired
    protected MongoTemplate mongo;

/*    Page<Goods> findByDto(XxxDto dto, Pageable pageable) {
        Query query = new Query();
        Criteria criteria = new Criteria();

        Criteria.where("goodsType").is("dto.getGoodsType");

        if (StringUtils.isNotEmpty(dto.getSearch())) {
            criteria.and("goodsNum").is("dto.getSearch()");
        }
        query.addCriteria(criteria);
        query.skip(pageable.getPageNumber());// skip相当于从那条记录开始
        query.limit(pageable.getPageSize());// 从skip开始,取多少条记录

        //noinspection unchecked
        return new GeoPage(new GeoResults(mongo.find(query, Goods.class)), pageable, mongo.count(query, Goods.class));
    }*/

}
