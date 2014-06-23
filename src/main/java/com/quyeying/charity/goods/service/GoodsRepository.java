package com.quyeying.charity.goods.service;

import com.quyeying.charity.domain.Goods;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User: bysun
 * Date: 2014/6/21
 * Time: 21:15
 */
@Repository("goodsRepository")
public interface GoodsRepository extends MongoRepository<Goods,String> {

    @Query("{'goodsNum':?0}")
    Goods findByNum(String num);
}
