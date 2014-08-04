package com.quyeying.charity.goods.service;

import com.quyeying.charity.domain.Goods;
import com.quyeying.charity.report.dto.ReportDto;
import com.quyeying.framework.db.BaseRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;


/**
 * User: bysun
 * Date: 2014/7/29
 * Time: 17:20
 */
public class GoodsRepositoryImpl extends BaseRepository implements GoodsRepositoryCustom {

    public Page<Goods> findByDto(ReportDto dto) {

        Criteria criteria = new Criteria();

        if (StringUtils.isNotBlank(dto.getGoodsType())) {
            Criteria.where("goodsType").is(dto.getGoodsType());
        }

        if (null != dto.getSearch() && StringUtils.isNotBlank(dto.getSearch().getValue())) {
            criteria.and("goodsNum").regex("^" + dto.getGoodsType() + dto.getSearch().getValue().toUpperCase() + ".*");
        }

        return super.baseQuery(Goods.class, criteria, dto);
    }

    @Override
    @Autowired
    public void setMongo(MongoTemplate mongo) {
        super.mongo = mongo;
    }
}
