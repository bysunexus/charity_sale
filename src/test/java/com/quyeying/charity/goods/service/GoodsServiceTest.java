package com.quyeying.charity.goods.service;

import com.quyeying.charity.domain.Goods;
import com.quyeying.config.AppCtxCfg;
import com.quyeying.config.AppCtxCfgMongo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppCtxCfg.class, AppCtxCfgMongo.class},loader=AnnotationConfigContextLoader.class)
public class GoodsServiceTest {

    @Resource
    private GoodsRepository goodsRepository;

    @Test
    public void testSave() throws Exception {
        Goods goods = new Goods();
        goods.setGoodsCount(1);
        goods.setGoodsName("TTTT");
        goods.setGoodsNum("A001");
        goods.setGoodsPrice(10);
        goods.setPersonCode("admin");
        goods.setPersonCode("testPerson");
        goods.setPersonPhone("13000000000");
        goods.setRemark("test");
        goodsRepository.save(goods);
    }
}