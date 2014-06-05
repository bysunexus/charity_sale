package com.quyeying.charity.goods.service;

import com.quyeying.charity.domain.Goods;
import com.quyeying.framework.utils.Identities;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;


/**
 * User: bysun
 * Date: 2014/5/28 0028
 * Time: 16:41
 */
@Service
public class GoodsService implements IGoodsService {

    @Autowired
    private MongoTemplate template;

    public String save(Goods goods){
        if(StringUtils.isBlank(goods.getPkid()))
            goods.setPkid(Identities.uuid2());

        template.save(goods);
        return goods.getPkid();
    }
}
