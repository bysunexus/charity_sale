package com.quyeying.charity.goods.scheduler;

import com.quyeying.charity.goods.dto.SaleMoneyDto;
import com.quyeying.charity.goods.service.GoodsRepository;
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

    @Resource(name="goodsRepository")
    GoodsRepository repo;

    @PostConstruct
    public void run(){

        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                SaleMoneyPoster.getInstance().publish(repo.findSaleMoney());
            }
        },0,10000);

    }



}
