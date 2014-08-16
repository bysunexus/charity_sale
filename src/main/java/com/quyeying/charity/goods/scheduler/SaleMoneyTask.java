package com.quyeying.charity.goods.scheduler;

import com.quyeying.charity.goods.dto.SaleMoneyDto;
import com.quyeying.charity.goods.service.GoodsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Timer;
import java.util.TimerTask;

/**
 * User: bysun
 * Date: 2014/8/5
 * Time: 0:09
 */
@Component
public class SaleMoneyTask {
    protected final static Logger logger = LoggerFactory.getLogger(SaleMoneyTask.class);
    @Resource(name="goodsRepository")
    GoodsRepository repo;

    @PostConstruct
    public void run(){

        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    SaleMoneyPoster.getInstance().publish(repo.findSaleMoney());
                } catch (Exception e) {
                    logger.warn("执行总价查询的时候发生了错误",e);
                }
            }
        },0,10000);

    }



}
