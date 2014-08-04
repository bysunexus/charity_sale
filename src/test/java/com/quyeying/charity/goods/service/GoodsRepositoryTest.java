package com.quyeying.charity.goods.service;

import com.quyeying.charity.goods.dto.SaleMoneyDto;
import com.quyeying.config.AppCtxCfg;
import com.quyeying.config.AppCtxCfgMongo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.Map;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppCtxCfg.class, AppCtxCfgMongo.class},loader=AnnotationConfigContextLoader.class)
public class GoodsRepositoryTest {

    @Autowired
    private GoodsRepository repo;

    @Test
    public void test(){

        SaleMoneyDto sm = repo.findSaleMoney();
        System.out.println(sm.getTotalSaleMoney());

        for (Map.Entry<String, Integer> entry : sm.getGroupSaleMoney().entrySet()) {
            System.out.println(entry.getKey()+"    "+entry.getValue());
        }

    }

}