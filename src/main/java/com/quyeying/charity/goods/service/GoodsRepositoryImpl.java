package com.quyeying.charity.goods.service;

import com.quyeying.charity.domain.Goods;
import com.quyeying.charity.goods.dto.SaleMoneyDto;
import com.quyeying.charity.goods.dto.ValueDto;
import com.quyeying.charity.report.dto.GroupReportDto;
import com.quyeying.framework.db.BaseRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapreduce.MapReduceResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;


/**
 * User: bysun
 * Date: 2014/7/29
 * Time: 17:20
 */
public class GoodsRepositoryImpl extends BaseRepository implements GoodsRepositoryCustom {

    public Page<Goods> findByDto(GroupReportDto dto) {

        Criteria criteria = new Criteria();

        Criteria.where("goodsType").is(dto.getGoodsType());

        if (null != dto.getSearch() && StringUtils.isNotBlank(dto.getSearch().getValue())) {
            criteria.and("goodsNum").is(dto.getGoodsType() + dto.getSearch().getValue());
        }

        return super.baseQuery(Goods.class, criteria, dto);
    }

    @Override
    public SaleMoneyDto findSaleMoney(String... goodsType) {
        SaleMoneyDto dto = new SaleMoneyDto();

        Query query = new Query();
        if(null != goodsType){
            query.addCriteria(Criteria.where("goodsType").in(goodsType));
        }

        MapReduceResults<ValueDto> result = mongo.mapReduce(
            query,
            "goods",
            "classpath:mongo/salemoney/map.js",
            "classpath:mongo/salemoney/reduce.js",
            ValueDto.class
        );

        int total = 0;
        for (ValueDto valueDto : result) {
            dto.getGroupSaleMoney().put(valueDto.getId(),valueDto.getValue());
            total += valueDto.getValue();
        }

        dto.setTotalSaleMoney(total);

        return dto;
    }

    @Override
    @Autowired
    public void setMongo(MongoTemplate mongo) {
        super.mongo = mongo;
    }
}
