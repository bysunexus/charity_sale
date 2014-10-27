package com.quyeying.charity.goods.service;

import com.quyeying.charity.domain.Goods;
import com.quyeying.charity.goods.dto.SaleMoneyDto;
import com.quyeying.charity.goods.dto.ValueDto;
import com.quyeying.charity.report.dto.ReportDto;
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
@SuppressWarnings("UnusedDeclaration")
public class GoodsRepositoryImpl extends BaseRepository implements GoodsRepositoryCustom {

    public Page<Goods> findByDto(ReportDto dto) {

        Criteria criteria = new Criteria();

        if (null != dto.getSearch() && StringUtils.isNotBlank(dto.getSearch().getValue())) {
            criteria.andOperator(Criteria.where("goodsNum").regex("^" + dto.getGoodsType() + dto.getSearch().getValue().toUpperCase() + ".*"));
        }else{
            criteria.andOperator(Criteria.where("goodsNum").regex("^" + dto.getGoodsType()+".*"));
        }

        return super.baseQuery(Goods.class, criteria, dto);
    }

    @Override
    public SaleMoneyDto findSaleMoney(String... goodsType) {
        SaleMoneyDto dto = new SaleMoneyDto();

        if(0== mongo.count(new Query(),Goods.class)){
            dto.setTotalSaleMoney(0.0);
            dto.getGroupSaleMoney().put("A", 0.0);
            dto.getGroupSaleMoney().put("B", 0.0);
            dto.getGroupSaleMoney().put("C", 0.0);
            dto.getGroupSaleMoney().put("D", 0.0);
            dto.getGroupSaleMoney().put("E", 0.0);
            return dto;
        }
        Query query = new Query();
        if (goodsType.length > 0) query.addCriteria(Criteria.where("goodsType").in((Object[])goodsType));

        MapReduceResults<ValueDto> result = mongo.mapReduce(
            query,
            "goods",
            "classpath:mongo/salemoney/map.js",
            "classpath:mongo/salemoney/reduce.js",
            ValueDto.class
        );

        double total = 0.0;
        for (ValueDto valueDto : result) {
            dto.getGroupSaleMoney().put(valueDto.getId(), valueDto.getValue());
            total += valueDto.getValue();
        }

        dto.setTotalSaleMoney(total);

        return dto;
    }

    @Override
    @Autowired
    public void setMongo(MongoTemplate mongo) {
        this.mongo = mongo;
    }
}
